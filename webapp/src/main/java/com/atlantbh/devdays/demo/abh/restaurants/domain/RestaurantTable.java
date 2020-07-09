package com.atlantbh.devdays.demo.abh.restaurants.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.util.Date;
import javax.persistence.*;

/** Restaurant table domain model. */
@Entity
@Table(name = "restaurant_table")
public class RestaurantTable {

  @Id
  @GeneratedValue
  @Column(name = "id")
  private Long id;

  @JsonIgnore
  @ManyToOne
  @JoinColumn(name = "restaurant_id")
  private Restaurant restaurant;

  @Column(name = "number_of_chairs")
  private int numberOfChairs;

  @Column(name = "created_at", updatable = false, insertable = false)
  private Date createdAt;

  @Column(name = "updated_at", updatable = false, insertable = false)
  private Date updatedAt;

  /**
   * Gets id.
   *
   * @return the id
   */
  public Long getId() {
    return id;
  }

  /**
   * Sets id.
   *
   * @param id the id
   */
  public void setId(Long id) {
    this.id = id;
  }

  /**
   * Gets restaurant.
   *
   * @return the restaurant
   */
  public Restaurant getRestaurant() {
    return restaurant;
  }

  /**
   * Sets restaurant.
   *
   * @param restaurant the restaurant
   */
  public void setRestaurant(Restaurant restaurant) {
    this.restaurant = restaurant;
  }

  /**
   * Gets number of chairs.
   *
   * @return the number of chairs
   */
  public int getNumberOfChairs() {
    return numberOfChairs;
  }

  /**
   * Sets number of chairs.
   *
   * @param numberOfChairs the number of chairs
   */
  public void setNumberOfChairs(int numberOfChairs) {
    this.numberOfChairs = numberOfChairs;
  }

  /**
   * Gets created at.
   *
   * @return the created at
   */
  public Date getCreatedAt() {
    return createdAt;
  }

  /**
   * Gets updated at.
   *
   * @return the updated at
   */
  public Date getUpdatedAt() {
    return updatedAt;
  }
}
