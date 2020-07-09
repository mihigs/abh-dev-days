package com.atlantbh.devdays.demo.abh.restaurants.web.controller.bootstrap.dto;

/** Bootstrap dto. */
public class BootstrapDto {
  private CurrentUserDto currentUser;
  private RestaurantsInfoDto restaurantsInfo;

  /**
   * Gets current user.
   *
   * @return the current user
   */
  public CurrentUserDto getCurrentUser() {
    return currentUser;
  }

  /**
   * Sets current user.
   *
   * @param currentUser the current user
   */
  public void setCurrentUser(CurrentUserDto currentUser) {
    this.currentUser = currentUser;
  }

  public RestaurantsInfoDto getRestaurantsInfo() {
    return restaurantsInfo;
  }

  public void setRestaurantsInfo(RestaurantsInfoDto restaurantsInfo) {
    this.restaurantsInfo = restaurantsInfo;
  }

  public static class RestaurantsInfoDto {
    private long numberOfRestaurants;

    public RestaurantsInfoDto(long numberOfRestaurants) {
      this.numberOfRestaurants = numberOfRestaurants;
    }

    public long getNumberOfRestaurants() {
      return numberOfRestaurants;
    }
  }
}
