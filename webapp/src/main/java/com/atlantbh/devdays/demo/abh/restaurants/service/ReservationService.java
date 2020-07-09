package com.atlantbh.devdays.demo.abh.restaurants.service;

import static com.atlantbh.devdays.demo.abh.restaurants.utils.time.DateTimeUtils.*;

import com.atlantbh.devdays.demo.abh.restaurants.domain.Reservation;
import com.atlantbh.devdays.demo.abh.restaurants.domain.RestaurantTable;
import com.atlantbh.devdays.demo.abh.restaurants.domain.User;
import com.atlantbh.devdays.demo.abh.restaurants.repository.ReservationRepository;
import com.atlantbh.devdays.demo.abh.restaurants.repository.RestaurantRepository;
import com.atlantbh.devdays.demo.abh.restaurants.service.exceptions.EntityNotFoundServiceException;
import com.atlantbh.devdays.demo.abh.restaurants.service.exceptions.NoTablesAvailableServiceException;
import com.atlantbh.devdays.demo.abh.restaurants.service.requests.ReservationRequest;
import com.atlantbh.devdays.demo.abh.restaurants.service.responses.ReservationInquiryResponse;
import com.atlantbh.devdays.demo.abh.restaurants.service.responses.UserReservations;
import com.atlantbh.devdays.demo.abh.restaurants.service.users.UsersService;
import com.atlantbh.devdays.demo.abh.restaurants.utils.java.PredicateUtils;
import com.atlantbh.devdays.demo.abh.restaurants.web.controller.response.ReservationInfo;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

/** Reservation service manages restaurant reservations. */
@Service
public class ReservationService extends BaseCrudService<Reservation, Long, ReservationRepository> {
  private RestaurantRepository restaurantRepository;
  private RestaurantService restaurantService;
  private UsersService usersService;

  /**
   * Instantiates a new reservation service.
   *
   * @param restaurantRepository Restaurant repository.
   * @param repository Reservation repository.
   */
  @Autowired
  public ReservationService(
      RestaurantRepository restaurantRepository, ReservationRepository repository) {
    super(repository);
    this.restaurantRepository = restaurantRepository;
  }

  @Autowired
  public void setRestaurantService(RestaurantService restaurantService) {
    this.restaurantService = restaurantService;
  }

  @Autowired
  public void setUsersService(UsersService usersService) {
    this.usersService = usersService;
  }

  /**
   * An inquiry service method that checks if there are available reservations, given an inquiry
   * request. Inquiry request contains a date on which reservation should occur and for how many
   * people (we need this to find an appropriate table).
   *
   * @param restaurantId Restaurant id.
   * @param request Inquiry request.
   * @return Inquiry response.
   */
  public ReservationInquiryResponse reservationInquiry(
      Long restaurantId, ReservationRequest request) {
    final ReservationInquiryResponse.ReservationInquiryResponseBuilder builder =
        ReservationInquiryResponse.builder().withInquiry(request);

    builder.withNumberOfReservationsToday(repository.numberOfReservationsToday(restaurantId));

    final int numberOfPeople = request.getNumberOfPeople();
    final Date desiredDateTime = advanceDateTime(request.getDate(), Calendar.HOUR_OF_DAY, 1);

    final List<RestaurantTable> freeTables =
        getFreeTables(restaurantId, desiredDateTime, numberOfPeople);
    builder.withNumberOfTablesLeft(freeTables.size());

    if (freeTables.isEmpty()) {
      final List<Date> suggestedTimes =
          suggestedDateTimes(desiredDateTime)
              .filter(date -> hasFreeTables(restaurantId, date, numberOfPeople))
              .collect(Collectors.toList());

      builder.withSuggestedTimes(suggestedTimes);
    } else {
      builder.withSuggestedTimes(Collections.singletonList(request.getDate()));
    }

    return builder.build();
  }

  /**
   * Given a base time return a suggested times. Suggested times are range of times in increment of
   * 15 minutes. Ranges are from -90 minutes to +90 minutes from the base time.
   *
   * @param baseTime Base time.
   * @return Suggested times.
   */
  private static Stream<Date> suggestedDateTimes(Date baseTime) {
    return IntStream.rangeClosed(-6, 6)
        .boxed()
        .map(i -> advanceDateTime(baseTime, Calendar.MINUTE, i * 15));
  }

  private boolean hasFreeTables(Long restaurantId, Date dateTime, int numberOfPeople) {
    return !getFreeTables(restaurantId, dateTime, numberOfPeople).isEmpty();
  }

  /**
   * Returns a list of free tables for a given restaurant and reservation info. Reservation info
   * includes datetime for reservation and number of reservation seats.
   *
   * @param restaurantId Restaurant id for which to find free tables.
   * @param dateTime Date/time for a reservation.
   * @param numberOfPeople Number of people/seats for a reservation.
   * @return List of free tables.
   */
  private List<RestaurantTable> getFreeTables(
      Long restaurantId, Date dateTime, int numberOfPeople) {
    final Date fortyFiveMinutesBefore = advanceDateTime(dateTime, Calendar.MINUTE, -45);

    final Date oneHourAfter = advanceDateTime(dateTime, Calendar.HOUR_OF_DAY, 1);

    List<RestaurantTable> tables = getTablesInRestaurant(restaurantId, numberOfPeople);

    if (!tables.isEmpty()) {
      final List<Reservation> reservations =
          getRestaurantReservations(tables, fortyFiveMinutesBefore, oneHourAfter);

      final List<RestaurantTable> usedTables =
          reservations.stream().map(Reservation::getTable).collect(Collectors.toList());

      final List<RestaurantTable> freeTables =
          tables
              .stream()
              .filter(PredicateUtils.not(usedTables::contains))
              .collect(Collectors.toList());

      return freeTables;
    }

    return Collections.emptyList();
  }

  /**
   * Returns a list of restaurants reservations that are in between two specified dates.
   *
   * @param tables Interested tables.
   * @param minTime Min date.
   * @param maxTime Max date.
   * @return List of restaurant reservations.
   */
  private List<Reservation> getRestaurantReservations(
      List<RestaurantTable> tables, Date minTime, Date maxTime) {
    return repository.findTableReservations(tables, minTime, maxTime);
  }

  /**
   * Returns a list of tables in a restaurant that can accommodate specific number of people.
   *
   * @param restaurantId Restaurant to check.
   * @param numberOfPeople Number of people to accommodate.
   * @return List of tables.
   */
  private List<RestaurantTable> getTablesInRestaurant(Long restaurantId, int numberOfPeople) {
    return restaurantRepository.findAccommodatingRestaurantTables(
        restaurantId, numberOfPeople, numberOfPeople + 2);
  }

  private Optional<RestaurantTable> getFreeTable(
      Long restaurantId, Date dateTime, int numberOfPeople) {
    final List<RestaurantTable> tables = getFreeTables(restaurantId, dateTime, numberOfPeople);
    if (tables.isEmpty()) {
      return Optional.empty();
    }

    return Optional.of(tables.get(0));
  }

  public Reservation create(Long restaurantId, ReservationRequest request, UserDetails userDetails)
      throws NoTablesAvailableServiceException, EntityNotFoundServiceException {
    Reservation reservation = new Reservation();

    if (userDetails != null) {
      reservation.setUser(usersService.get(userDetails));
    }
    reservation.setStartTime(advanceDateTime(request.getDate(), Calendar.HOUR_OF_DAY, 1));
    reservation.setReservedOn(new Date());
    reservation.setConfirmed(false);

    final Optional<RestaurantTable> table =
        getFreeTable(restaurantId, reservation.getStartTime(), request.getNumberOfPeople());
    if (!table.isPresent()) {
      throw new NoTablesAvailableServiceException();
    }

    reservation.setTable(table.get());

    return repository.save(reservation);
  }

  /**
   * Confirms a reservation.
   *
   * @param reservationId Reservation id.
   * @param userDetails Current user details.
   * @throws EntityNotFoundServiceException If no reservation can be found.
   */
  public void confirmReservation(Long reservationId, UserDetails userDetails)
      throws EntityNotFoundServiceException {
    Reservation reservation = get(reservationId);

    final User currentUser = usersService.get(userDetails);

    if (reservation.getUser() != null
        && !currentUser.getId().equals(reservation.getUser().getId())) {
      throw new EntityNotFoundServiceException();
    }

    reservation.setUser(currentUser);
    reservation.setConfirmed(true);

    repository.save(reservation);
  }

  /**
   * Returns user reservations.
   *
   * @param userDetails User.
   * @return List of reservations.
   */
  public UserReservations findUserReservations(UserDetails userDetails)
      throws EntityNotFoundServiceException {
    final List<Reservation> userReservations =
        repository.findUserReservations(usersService.get(userDetails));
    final List<ReservationInfo> reservationInfos =
        mapReservationToReservationInfo(userReservations);
    return new UserReservations(reservationInfos);
  }

  /**
   * Returns confirmed reservation for a restaurant.
   *
   * @param restaurantId Restaurant id.
   * @param date Date on which to find confirmed reservations.
   * @return List of confirmed reservations.
   */
  public List<Reservation> findConfirmedReservations(Long restaurantId, Date date) {
    Date startOfDay = startOfDay(date);
    Date endOfDay = endOfDay(date);

    return repository.findConfirmedReservations(restaurantId, startOfDay, endOfDay);
  }

  /**
   * Finds a reservation.
   *
   * @param id Reservation id.
   * @return Reservation info.
   * @throws EntityNotFoundServiceException If no reservation is found.
   */
  public ReservationInfo getReservation(Long id) throws EntityNotFoundServiceException {
    Reservation reservation = get(id);
    return mapReservationToReservationInfo(reservation);
  }

  private List<ReservationInfo> mapReservationToReservationInfo(List<Reservation> reservations)
      throws EntityNotFoundServiceException {
    List<ReservationInfo> result = new ArrayList<>(reservations.size());
    for (Reservation reservation : reservations) {
      result.add(mapReservationToReservationInfo(reservation));
    }
    return result;
  }

  private ReservationInfo mapReservationToReservationInfo(Reservation reservation)
      throws EntityNotFoundServiceException {
    ReservationInfo reservationInfo = new ReservationInfo(reservation);
    reservationInfo.setRestaurant(
        restaurantService.get(reservation.getTable().getRestaurant().getId()));
    return reservationInfo;
  }
}
