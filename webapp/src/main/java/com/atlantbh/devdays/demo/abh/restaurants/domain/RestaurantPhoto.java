package com.atlantbh.devdays.demo.abh.restaurants.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.util.Date;
import javax.persistence.*;

/** Restaurant photo domain model. */
@Entity
@Table(name = "restaurant_photo")
public class RestaurantPhoto {

  @Id
  @GeneratedValue
  @Column(name = "id")
  private Long id;

  @JsonIgnore
  @ManyToOne
  @JoinColumn(name = "restaurant_id")
  private Restaurant restaurant;

  @Column(name = "photo_path")
  private String path;

  @Column(name = "created_at", updatable = false, insertable = false)
  private Date createdAt;

  @Column(name = "updated_at", updatable = false, insertable = false)
  private Date updatedAt;

  /** Instantiates a new Restaurant photo. */
  public RestaurantPhoto() {}

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
   * Gets path.
   *
   * @return the path
   */
  public String getPath() {
    return path;
  }

  /**
   * Sets path.
   *
   * @param path the path
   */
  public void setPath(String path) {
    this.path = path;
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
