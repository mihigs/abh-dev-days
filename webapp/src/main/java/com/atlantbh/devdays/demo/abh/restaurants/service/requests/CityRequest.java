package com.atlantbh.devdays.demo.abh.restaurants.service.requests;

/** City related request. */
public class CityRequest {
  private String name;

  private String bounds;

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getBounds() {
    return bounds;
  }

  public void setBounds(String bounds) {
    this.bounds = bounds;
  }
}
