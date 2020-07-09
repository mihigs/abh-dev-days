package com.atlantbh.devdays.demo.abh.restaurants.configuration.security.routes;

import static com.atlantbh.devdays.demo.abh.restaurants.configuration.security.RouteUtils.*;

import org.springframework.security.web.util.matcher.RequestMatcher;

/** For these routes user should be logged-in. */
public class UserProtectedRoutes {
  private static final RequestMatcher MY_RESERVATIONS_ROUTE = get("/api/v1/reservation/my");
  private static final RequestMatcher CONFIRM_RESERVATIONS_ROUTE =
      put("/api/v1/reservation/\\d+/confirm");

  public static final RequestMatcher ROUTES =
      any(MY_RESERVATIONS_ROUTE, CONFIRM_RESERVATIONS_ROUTE);
}
