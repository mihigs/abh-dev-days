package com.atlantbh.devdays.demo.abh.restaurants.service.exceptions;

import org.springframework.http.HttpStatus;

/** This exception is raised when there are no tables available on reservation. */
public class NoTablesAvailableServiceException extends ServiceException {
  /** Instantiates a new Service exception. */
  public NoTablesAvailableServiceException() {
    super(HttpStatus.BAD_REQUEST);
  }
}
