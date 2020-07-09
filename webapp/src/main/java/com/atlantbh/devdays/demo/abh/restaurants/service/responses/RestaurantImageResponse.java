package com.atlantbh.devdays.demo.abh.restaurants.service.responses;

import com.atlantbh.devdays.demo.abh.restaurants.service.requests.RestaurantImageRequest;

/** Restaurant image response. */
public class RestaurantImageResponse {
  private RestaurantImageRequest.ImageType imageType;
  private String url;

  /**
   * Instantiates a new Restaurant image response.
   *
   * @param imageType the image type
   * @param url the url
   */
  public RestaurantImageResponse(RestaurantImageRequest.ImageType imageType, String url) {
    this.imageType = imageType;
    this.url = url;
  }

  /**
   * Gets image type.
   *
   * @return the image type
   */
  public RestaurantImageRequest.ImageType getImageType() {
    return imageType;
  }

  /**
   * Gets url.
   *
   * @return the url
   */
  public String getUrl() {
    return url;
  }
}
