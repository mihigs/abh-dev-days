package com.atlantbh.devdays.demo.abh.restaurants.service.responses;

import com.atlantbh.devdays.demo.abh.restaurants.service.requests.ReservationRequest;
import java.util.Date;
import java.util.List;

/** Reservation inquiry response. */
public class ReservationInquiryResponse {
  private ReservationRequest inquiry;

  private long numberOfTablesLeft;
  private long numberOfReservationsToday;

  private List<Date> timeSuggestions;

  /**
   * Gets inquiry.
   *
   * @return the inquiry
   */
  public ReservationRequest getInquiry() {
    return inquiry;
  }

  /**
   * Gets number of tables left.
   *
   * @return the number of tables left
   */
  public long getNumberOfTablesLeft() {
    return numberOfTablesLeft;
  }

  /**
   * Gets number of reservations today.
   *
   * @return the number of reservations today
   */
  public long getNumberOfReservationsToday() {
    return numberOfReservationsToday;
  }

  /**
   * Gets time suggestions.
   *
   * @return the time suggestions
   */
  public List<Date> getTimeSuggestions() {
    return timeSuggestions;
  }

  /**
   * Builder reservation inquiry response builder.
   *
   * @return the reservation inquiry response builder
   */
  public static ReservationInquiryResponseBuilder builder() {
    return new ReservationInquiryResponseBuilder();
  }

  /** Builder pattern for reservation inquiry response. */
  public static class ReservationInquiryResponseBuilder {
    private ReservationInquiryResponse instance;

    private ReservationInquiryResponseBuilder() {
      this.instance = new ReservationInquiryResponse();
    }

    /**
     * With inquiry reservation inquiry response builder.
     *
     * @param request the request
     * @return the reservation inquiry response builder
     */
    public ReservationInquiryResponseBuilder withInquiry(ReservationRequest request) {
      this.instance.inquiry = request;
      return this;
    }

    /**
     * With number of tables left reservation inquiry response builder.
     *
     * @param count the count
     * @return the reservation inquiry response builder
     */
    public ReservationInquiryResponseBuilder withNumberOfTablesLeft(long count) {
      this.instance.numberOfTablesLeft = count;
      return this;
    }

    /**
     * With number of reservations today reservation inquiry response builder.
     *
     * @param count the count
     * @return the reservation inquiry response builder
     */
    public ReservationInquiryResponseBuilder withNumberOfReservationsToday(long count) {
      this.instance.numberOfReservationsToday = count;
      return this;
    }

    /**
     * With suggested times reservation inquiry response builder.
     *
     * @param suggestedTimes the suggested times
     * @return the reservation inquiry response builder
     */
    public ReservationInquiryResponseBuilder withSuggestedTimes(List<Date> suggestedTimes) {
      this.instance.timeSuggestions = suggestedTimes;
      return this;
    }

    /**
     * Build reservation inquiry response.
     *
     * @return the reservation inquiry response
     */
    public ReservationInquiryResponse build() {
      ReservationInquiryResponse result = this.instance;
      this.instance = new ReservationInquiryResponse();
      return result;
    }
  }
}
