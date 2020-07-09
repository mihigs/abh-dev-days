package com.atlantbh.devdays.demo.abh.restaurants.service.requests;

import com.atlantbh.devdays.demo.abh.restaurants.domain.Restaurant_;
import org.apache.commons.lang3.StringUtils;

/** Restaurant filter. */
public class RestaurantFilter {
  /** The enum Sort. */
  public enum Sort {
    /** Name sort. */
    NAME(Restaurant_.NAME, org.springframework.data.domain.Sort.Direction.ASC, "name"),
    /** Rating sort. */
    RATING(
        Restaurant_.AVERAGE_RATING, org.springframework.data.domain.Sort.Direction.DESC, "rating"),
    /** Price sort. */
    PRICE(Restaurant_.PRICE_RANGE, org.springframework.data.domain.Sort.Direction.DESC, "price");

    private final String queryValue;
    private final String propertyName;
    private org.springframework.data.domain.Sort.Direction direction;

    Sort(
        String propertyName,
        org.springframework.data.domain.Sort.Direction direction,
        String queryValue) {
      this.propertyName = propertyName;
      this.queryValue = queryValue;
      this.direction = direction;
    }

    /**
     * Gets query value.
     *
     * @return the query value
     */
    public String getQueryValue() {
      return queryValue;
    }

    /**
     * Gets property name.
     *
     * @return the property name
     */
    public String getPropertyName() {
      return propertyName;
    }

    /**
     * From query sort.
     *
     * @param queryValue the query value
     * @param defaultValue the default value
     * @return the sort
     */
    public static Sort fromQuery(String queryValue, Sort defaultValue) {
      if (StringUtils.isEmpty(queryValue)) {
        return defaultValue;
      }

      for (Sort sort : Sort.values()) {
        if (sort.getQueryValue().equalsIgnoreCase(queryValue)) {
          return sort;
        }
      }

      return defaultValue;
    }

    /**
     * Gets direction.
     *
     * @return the direction
     */
    public org.springframework.data.domain.Sort.Direction getDirection() {
      return direction;
    }
  };

  private int page = 1;

  private int pageSize = 9;

  private String name;

  private Long cityId;

  private Long price;
  private Long rating;

  private String cuisine;

  private Sort sortBy;

  /**
   * Gets page.
   *
   * @return the page
   */
  public int getPage() {
    return page;
  }

  /**
   * Sets page.
   *
   * @param page the page
   */
  public void setPage(int page) {
    this.page = page;
  }

  /**
   * Gets page size.
   *
   * @return the page size
   */
  public int getPageSize() {
    return pageSize;
  }

  /**
   * Sets page size.
   *
   * @param pageSize the page size
   */
  public void setPageSize(int pageSize) {
    this.pageSize = pageSize;
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
   * Gets sort by.
   *
   * @return the sort by
   */
  public Sort getSortBy() {
    if (sortBy == null) {
      sortBy = Sort.NAME;
    }
    return sortBy;
  }

  /**
   * Sets sort by.
   *
   * @param sortBy the sort by
   */
  public void setSortBy(String sortBy) {
    this.sortBy = Sort.fromQuery(sortBy, Sort.NAME);
  }

  /**
   * Gets price.
   *
   * @return the price
   */
  public Long getPrice() {
    return price;
  }

  /**
   * Sets price.
   *
   * @param price the price
   */
  public void setPrice(Long price) {
    this.price = price;
  }

  /**
   * Gets rating.
   *
   * @return the rating
   */
  public Long getRating() {
    return rating;
  }

  /**
   * Sets rating.
   *
   * @param rating the rating
   */
  public void setRating(Long rating) {
    this.rating = rating;
  }

  /**
   * Gets cuisine.
   *
   * @return the cuisine
   */
  public String getCuisine() {
    return cuisine;
  }

  /**
   * Sets cuisine.
   *
   * @param cuisine the cuisine
   */
  public void setCuisine(String cuisine) {
    this.cuisine = cuisine;
  }
}
