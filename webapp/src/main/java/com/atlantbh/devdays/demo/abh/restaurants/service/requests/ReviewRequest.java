package com.atlantbh.devdays.demo.abh.restaurants.service.requests;

/** Review request. */
public class ReviewRequest {
  private String reviewText;

  private int reviewScore;

  /**
   * Gets review text.
   *
   * @return the review text
   */
  public String getReviewText() {
    return reviewText;
  }

  /**
   * Sets review text.
   *
   * @param reviewText the review text
   */
  public void setReviewText(String reviewText) {
    this.reviewText = reviewText;
  }

  /**
   * Gets review score.
   *
   * @return the review score
   */
  public int getReviewScore() {
    return reviewScore;
  }

  /**
   * Sets review score.
   *
   * @param reviewScore the review score
   */
  public void setReviewScore(int reviewScore) {
    this.reviewScore = reviewScore;
  }
}
