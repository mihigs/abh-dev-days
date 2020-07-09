package com.atlantbh.devdays.demo.abh.restaurants.repository;

import com.atlantbh.devdays.demo.abh.restaurants.domain.Restaurant;
import com.atlantbh.devdays.demo.abh.restaurants.domain.RestaurantReview;
import com.atlantbh.devdays.demo.abh.restaurants.domain.User;
import java.util.List;
import java.util.Optional;
import org.springframework.data.repository.CrudRepository;

/** Restaurant review repository. */
public interface RestaurantReviewRepository extends CrudRepository<RestaurantReview, Long> {

  /**
   * Find reviews of restaurant.
   *
   * @param restaurant Restaurant.
   * @return Review list.
   */
  List<RestaurantReview> findByRestaurant(Restaurant restaurant);

  /**
   * Find user restaurant reviews.
   *
   * @param restaurant Restaurant.
   * @param user User.
   * @return User reviews.
   */
  Optional<RestaurantReview> findByRestaurantAndUser(Restaurant restaurant, User user);
}
