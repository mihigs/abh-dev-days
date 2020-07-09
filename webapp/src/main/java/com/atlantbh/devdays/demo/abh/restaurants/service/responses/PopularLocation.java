package com.atlantbh.devdays.demo.abh.restaurants.service.responses;

import com.atlantbh.devdays.demo.abh.restaurants.domain.City;
import com.fasterxml.jackson.annotation.JsonIgnore;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Transient;

/** Popular locations. */
@Entity
public class PopularLocation {
  @Id
  @Column(name = "city_id")
  @JsonIgnore
  private Long cityId;

  @Transient private City city;

  @Column(name = "restaurant_count")
  private int numberOfRestaurants;

  /**
   * Gets city id.
   *
   * @return the city id
   */
  public Long getCityId() {
    return cityId;
  }

  /**
   * Sets city id.
   *
   * @param cityId the city id
   */
  public void setCityId(Long cityId) {
    this.cityId = cityId;
  }

  /**
   * Gets city.
   *
   * @return the city
   */
  public City getCity() {
    return city;
  }

  /**
   * Sets city.
   *
   * @param city the city
   */
  public void setCity(City city) {
    this.city = city;
  }

  /**
   * Gets number of restaurants.
   *
   * @return the number of restaurants
   */
  public int getNumberOfRestaurants() {
    return numberOfRestaurants;
  }

  /**
   * Sets number of restaurants.
   *
   * @param numberOfRestaurants the number of restaurants
   */
  public void setNumberOfRestaurants(int numberOfRestaurants) {
    this.numberOfRestaurants = numberOfRestaurants;
  }

  /**
   * Is plural boolean.
   *
   * @return the boolean
   */
  public boolean isPlural() {
    return numberOfRestaurants > 0;
  }
}
