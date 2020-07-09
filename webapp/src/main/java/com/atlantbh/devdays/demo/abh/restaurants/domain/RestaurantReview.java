package com.atlantbh.devdays.demo.abh.restaurants.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.util.Date;
import javax.persistence.*;

/** Restaurant review domain model. */
@Entity
@Table(name = "restaurant_review")
public class RestaurantReview {

  @Id
  @GeneratedValue
  @Column(name = "id")
  private Long id;

  @JsonIgnore
  @ManyToOne
  @JoinColumn(name = "restaurant_id")
  private Restaurant restaurant;

  @JsonIgnore
  @ManyToOne
  @JoinColumn(name = "user_id")
  private User user;

  @Column(name = "rating")
  private int rating;

  @Column(name = "review")
  private String review;

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
   * Gets user.
   *
   * @return the user
   */
  public User getUser() {
    return user;
  }

  /**
   * Sets user.
   *
   * @param user the user
   */
  public void setUser(User user) {
    this.user = user;
  }

  /**
   * Gets rating.
   *
   * @return the rating
   */
  public int getRating() {
    return rating;
  }

  /**
   * Sets rating.
   *
   * @param rating the rating
   */
  public void setRating(int rating) {
    this.rating = rating;
  }

  /**
   * Gets review.
   *
   * @return the review
   */
  public String getReview() {
    return review;
  }

  /**
   * Sets review.
   *
   * @param review the review
   */
  public void setReview(String review) {
    this.review = review;
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
