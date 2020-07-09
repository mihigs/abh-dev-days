package com.atlantbh.devdays.demo.abh.restaurants.configuration.security;

import org.springframework.http.HttpMethod;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.security.web.util.matcher.OrRequestMatcher;
import org.springframework.security.web.util.matcher.RequestMatcher;

/** Roles related utility functions. */
public class RouteUtils {
  public static final RequestMatcher NONE_ROUTE = request -> false;

  /**
   * Matches post request on a given path.
   *
   * @param path Path
   * @return POST request matcher.
   */
  public static RequestMatcher post(String path) {
    return new AntPathRequestMatcher(path, HttpMethod.POST.name());
  }

  /**
   * Matches get request on a given path.
   *
   * @param path Path
   * @return GET request matcher.
   */
  public static RequestMatcher get(String path) {
    return new AntPathRequestMatcher(path, HttpMethod.GET.name());
  }

  public static RequestMatcher put(String path) {
    return new AntPathRequestMatcher(path, HttpMethod.PUT.name());
  }

  /**
   * Matches any request on a given path.
   *
   * @param path Path
   * @return Any request matcher.
   */
  public static RequestMatcher any(String path) {
    return new AntPathRequestMatcher(path);
  }

  public static RequestMatcher any(RequestMatcher... requestMatchers) {
    for (int i = 0; i < requestMatchers.length; i++) {
      final RequestMatcher requestMatcher = requestMatchers[i];
      if (requestMatcher != null) {
        requestMatchers[i] = requestMatcher;
      }
    }

    return new OrRequestMatcher(requestMatchers);
  }
}
