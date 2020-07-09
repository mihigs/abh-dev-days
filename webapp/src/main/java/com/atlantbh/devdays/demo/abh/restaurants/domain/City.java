package com.atlantbh.devdays.demo.abh.restaurants.domain;

import java.util.Date;
import javax.persistence.*;

/** City domain model. */
@Entity
@Table(name = "city")
public class City {
  @Id
  @GeneratedValue
  @Column(name = "id")
  private Long id;

  @Column(name = "name")
  private String name;

  @Column(name = "bounds")
  private String bounds;

  @Column(name = "created_at", updatable = false, insertable = false)
  private Date createdAt;

  @Column(name = "updated_at", updatable = false, insertable = false)
  private Date updatedAt;

  /** Instantiates a new City. */
  public City() {}

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
   * Gets name.
   *
   * @return the name
   */
  public String getName() {
    return name;
  }

  /**
   * Sets name.
   *
   * @param name the name
   */
  public void setName(String name) {
    this.name = name;
  }

  /**
   * Gets bounds.
   *
   * @return the bounds
   */
  public String getBounds() {
    return bounds;
  }

  /**
   * Sets bounds.
   *
   * @param bounds the bounds
   */
  public void setBounds(String bounds) {
    this.bounds = bounds;
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
