package com.atlantbh.devdays.demo.abh.restaurants.service.requests;

import java.util.Date;

/** Reservation request. */
public class ReservationRequest {
  private int numberOfPeople;

  private Date date;

  public int getNumberOfPeople() {
    return numberOfPeople;
  }

  public void setNumberOfPeople(int numberOfPeople) {
    this.numberOfPeople = numberOfPeople;
  }

  public Date getDate() {
    return date;
  }

  public void setDate(Date date) {
    this.date = date;
  }
}
