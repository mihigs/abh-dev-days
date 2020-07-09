package com.atlantbh.devdays.demo.abh.restaurants.service.users.exception;

import com.atlantbh.devdays.demo.abh.restaurants.service.exceptions.ServiceException;
import org.springframework.http.HttpStatus;

/** Password mismatch service exception. */
public class PasswordMismatchServiceException extends ServiceException {
  /** Instantiates a new Password mismatch service exception. */
  public PasswordMismatchServiceException() {
    super(HttpStatus.UNAUTHORIZED, "Bad password.");
  }
}
