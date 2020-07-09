package com.atlantbh.devdays.demo.abh.restaurants.web.controller.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import java.util.Date;
import java.util.List;
import org.springframework.http.HttpStatus;

/** Response returned by controllers. */
public class Response {
  private long timestamp;

  private int status;
  private String reason;

  private String message;

  private String path;

  @JsonInclude(Include.NON_NULL)
  private List<AdditionalResponseInfo> additional;

  private Response(HttpStatus status) {
    this.status = status.value();
    this.reason = status.getReasonPhrase();
    this.timestamp = new Date().getTime();
  }

  /**
   * Instantiates a new Response.
   *
   * @param status the status
   * @param path the path
   */
  public Response(HttpStatus status, String path) {
    this(status);
    this.path = path;
    this.message = "Unexpected reason";
  }

  /**
   * Instantiates a new Response.
   *
   * @param status the status
   * @param message the message
   * @param path the path
   */
  public Response(HttpStatus status, String message, String path) {
    this(status);
    this.reason = status.getReasonPhrase();
    this.message = message;
    this.path = path;
  }

  /**
   * Gets status.
   *
   * @return the status
   */
  public int getStatus() {
    return status;
  }

  /**
   * Gets reason.
   *
   * @return the reason
   */
  public String getReason() {
    return reason;
  }

  /**
   * Gets timestamp.
   *
   * @return the timestamp
   */
  public long getTimestamp() {
    return timestamp;
  }

  /**
   * Gets message.
   *
   * @return the message
   */
  public String getMessage() {
    return message;
  }

  /**
   * Gets additional.
   *
   * @return the additional
   */
  public List<AdditionalResponseInfo> getAdditional() {
    return additional;
  }

  /**
   * Sets additional.
   *
   * @param additional the additional
   */
  public void setAdditional(List<AdditionalResponseInfo> additional) {
    this.additional = additional;
  }

  /**
   * Gets path.
   *
   * @return the path
   */
  public String getPath() {
    return path;
  }
}
