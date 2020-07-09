package com.atlantbh.devdays.demo.abh.restaurants.service.requests;

import com.atlantbh.devdays.demo.abh.restaurants.domain.Cuisine;
import com.atlantbh.devdays.demo.abh.restaurants.domain.RestaurantTable;
import java.util.Date;
import java.util.List;

/** Restaurant request. */
public class RestaurantRequest {
  private String name;

  private Long cityId;

  private String address;

  private Date openTime;

  private Date closeTime;

  private String phone;

  private Integer priceRange;

  private String coverImagePath;

  private String profileImagePath;

  private String description;

  private String menu;

  private Float latitude;

  private Float longitude;

  private List<Cuisine> cuisines;

  private List<RestaurantTable> tables;

  /**
   * Gets cuisines.
   *
   * @return the cuisines
   */
  public List<Cuisine> getCuisines() {
    return cuisines;
  }

  /**
   * Sets cuisines.
   *
   * @param cuisines the cuisines
   */
  public void setCuisines(List<Cuisine> cuisines) {
    this.cuisines = cuisines;
  }

  /**
   * Gets tables.
   *
   * @return the tables
   */
  public List<RestaurantTable> getTables() {
    return tables;
  }

  /**
   * Sets tables.
   *
   * @param tables the tables
   */
  public void setTables(List<RestaurantTable> tables) {
    this.tables = tables;
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
   * Gets address.
   *
   * @return the address
   */
  public String getAddress() {
    return address;
  }

  /**
   * Sets address.
   *
   * @param address the address
   */
  public void setAddress(String address) {
    this.address = address;
  }

  /**
   * Gets open time.
   *
   * @return the open time
   */
  public Date getOpenTime() {
    return openTime;
  }

  /**
   * Sets open time.
   *
   * @param openTime the open time
   */
  public void setOpenTime(Date openTime) {
    this.openTime = openTime;
  }

  /**
   * Gets close time.
   *
   * @return the close time
   */
  public Date getCloseTime() {
    return closeTime;
  }

  /**
   * Sets close time.
   *
   * @param closeTime the close time
   */
  public void setCloseTime(Date closeTime) {
    this.closeTime = closeTime;
  }

  /**
   * Gets phone.
   *
   * @return the phone
   */
  public String getPhone() {
    return phone;
  }

  /**
   * Sets phone.
   *
   * @param phone the phone
   */
  public void setPhone(String phone) {
    this.phone = phone;
  }

  /**
   * Gets price range.
   *
   * @return the price range
   */
  public Integer getPriceRange() {
    return priceRange;
  }

  /**
   * Sets price range.
   *
   * @param priceRange the price range
   */
  public void setPriceRange(Integer priceRange) {
    this.priceRange = priceRange;
  }

  /**
   * Gets cover image path.
   *
   * @return the cover image path
   */
  public String getCoverImagePath() {
    return coverImagePath;
  }

  /**
   * Sets cover image path.
   *
   * @param coverImagePath the cover image path
   */
  public void setCoverImagePath(String coverImagePath) {
    this.coverImagePath = coverImagePath;
  }

  /**
   * Gets profile image path.
   *
   * @return the profile image path
   */
  public String getProfileImagePath() {
    return profileImagePath;
  }

  /**
   * Sets profile image path.
   *
   * @param profileImagePath the profile image path
   */
  public void setProfileImagePath(String profileImagePath) {
    this.profileImagePath = profileImagePath;
  }

  /**
   * Gets description.
   *
   * @return the description
   */
  public String getDescription() {
    return description;
  }

  /**
   * Sets description.
   *
   * @param description the description
   */
  public void setDescription(String description) {
    this.description = description;
  }

  /**
   * Gets menu.
   *
   * @return the menu
   */
  public String getMenu() {
    return menu;
  }

  /**
   * Sets menu.
   *
   * @param menu the menu
   */
  public void setMenu(String menu) {
    this.menu = menu;
  }

  /**
   * Gets latitude.
   *
   * @return the latitude
   */
  public Float getLatitude() {
    return latitude;
  }

  /**
   * Sets latitude.
   *
   * @param latitude the latitude
   */
  public void setLatitude(Float latitude) {
    this.latitude = latitude;
  }

  /**
   * Gets longitude.
   *
   * @return the longitude
   */
  public Float getLongitude() {
    return longitude;
  }

  /**
   * Sets longitude.
   *
   * @param longitude the longitude
   */
  public void setLongitude(Float longitude) {
    this.longitude = longitude;
  }
}
