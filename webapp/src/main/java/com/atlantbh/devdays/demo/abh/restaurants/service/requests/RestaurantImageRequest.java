package com.atlantbh.devdays.demo.abh.restaurants.service.requests;

/** Restaurant image request. */
public class RestaurantImageRequest {
  /** The enum Image type. */
  public enum ImageType {
    /** Profile image type. */
    PROFILE,
    /** Cover image type. */
    COVER
  };

  private ImageType imageType;
  private String extension;

  /**
   * Gets image type.
   *
   * @return the image type
   */
  public ImageType getImageType() {
    return imageType;
  }

  /**
   * Sets image type.
   *
   * @param imageType the image type
   */
  public void setImageType(ImageType imageType) {
    this.imageType = imageType;
  }

  /**
   * Gets extension.
   *
   * @return the extension
   */
  public String getExtension() {
    return extension;
  }

  /**
   * Sets extension.
   *
   * @param extension the extension
   */
  public void setExtension(String extension) {
    this.extension = extension;
  }
}
