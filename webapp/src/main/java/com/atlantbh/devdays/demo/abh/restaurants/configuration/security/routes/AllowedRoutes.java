package com.atlantbh.devdays.demo.abh.restaurants.configuration.security.routes;

import static com.atlantbh.devdays.demo.abh.restaurants.configuration.security.RouteUtils.any;
import static com.atlantbh.devdays.demo.abh.restaurants.configuration.security.RouteUtils.post;

import com.atlantbh.devdays.demo.abh.restaurants.configuration.security.RouteUtils;
import org.springframework.security.web.util.matcher.RequestMatcher;

/**
 * These are allowed routes for the the application. They do not need authenticated user to be
 * present.
 */
public class AllowedRoutes {
  public static final RequestMatcher LOGIN_ROUTE = post("/api/v1/login");
  public static final RequestMatcher LOGOUT_ROUTE = post("/api/v1/logout");

  public static final RequestMatcher ROUTES = any(RouteUtils.NONE_ROUTE);
}
