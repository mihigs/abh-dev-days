package com.atlantbh.devdays.demo.abh.restaurants.utils.java;

import java.util.function.Predicate;

/** Simple predicate utils. */
public class PredicateUtils {

  public static <T> Predicate<T> not(Predicate<T> t) {
    return t.negate();
  }
}
