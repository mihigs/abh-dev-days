package com.atlantbh.devdays.demo.abh.restaurants.service.exceptions;

import org.springframework.http.HttpStatus;

/** Access denied service exception. */
public class AccessDeniedServiceException extends ServiceException {
  /** Instantiates exception. */
  public AccessDeniedServiceException() {
    super(HttpStatus.UNAUTHORIZED, "Access denied.");
  }
}
