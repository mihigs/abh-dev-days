package com.atlantbh.devdays.demo.abh.restaurants.service;

import com.atlantbh.devdays.demo.abh.restaurants.domain.City;
import com.atlantbh.devdays.demo.abh.restaurants.repository.CityRepository;
import com.atlantbh.devdays.demo.abh.restaurants.service.exceptions.EntityNotFoundServiceException;
import com.atlantbh.devdays.demo.abh.restaurants.service.requests.CityRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

/** City service manages city-related operations: create, deletion and update. */
@Service
public class CityService extends BaseCrudService<City, Long, CityRepository> {
  private static final String DEFAULT_SORT_PROPERTY = "name";

  /**
   * Instantiates a new city service.
   *
   * @param repository Repository which manages city db interaction.
   */
  @Autowired
  public CityService(CityRepository repository) {
    super(repository);
  }

  /**
   * Returns all cities sorted by {@link #DEFAULT_SORT_PROPERTY}.
   *
   * @param pageable Page request.
   * @return All cities sorted.
   */
  @Override
  public Page<City> findAll(Pageable pageable) {
    return super.findAll(pageable, DEFAULT_SORT_PROPERTY, Sort.Direction.ASC);
  }

  /**
   * Creates a new city given a city request.
   *
   * @param request Request for creation containing all attributes for creation.
   * @return Newly created city.
   */
  public City create(CityRequest request) {
    City city = new City();

    city.setName(request.getName());
    city.setBounds(request.getBounds());

    return repository.save(city);
  }

  /**
   * Update a city given a city id and city request containing attributes to update.
   *
   * @param id Id of the existing city.
   * @param request Request for update containing all attributes for creation.
   * @return Updated city.
   * @throws EntityNotFoundServiceException If the existing city is not found.
   */
  public City update(Long id, CityRequest request) throws EntityNotFoundServiceException {
    City city = get(id);

    city.setName(request.getName());
    city.setBounds(request.getBounds());

    return repository.save(city);
  }
}
