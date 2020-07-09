package com.atlantbh.devdays.demo.abh.restaurants.repository.utils;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Predicate;

/** Simple predicate utility functions. */
public final class PredicateUtils {

  /**
   * And predicate.
   *
   * @param criteriaBuilder Criteria builder
   * @param one First predicate.
   * @param two Second predicate.
   * @return And predicate.
   */
  public static Predicate and(CriteriaBuilder criteriaBuilder, Predicate one, Predicate two) {
    if (one == null) {
      return two;
    }

    if (two == null) {
      return one;
    }

    return criteriaBuilder.and(one, two);
  }
}
