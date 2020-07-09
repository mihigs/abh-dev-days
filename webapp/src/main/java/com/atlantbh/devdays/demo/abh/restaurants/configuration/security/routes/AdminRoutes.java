package com.atlantbh.devdays.demo.abh.restaurants.configuration.security.routes;

import static com.atlantbh.devdays.demo.abh.restaurants.configuration.security.RouteUtils.any;

import com.atlantbh.devdays.demo.abh.restaurants.configuration.security.RouteUtils;
import org.springframework.security.web.util.matcher.RequestMatcher;

/**
 * These are admin routes for the the application. They need authenticated admin user to be present.
 */
public final class AdminRoutes {

  public static final RequestMatcher ROUTES = any(RouteUtils.NONE_ROUTE);
}
