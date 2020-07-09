package com.atlantbh.devdays.demo.abh.restaurants.repository;

import com.atlantbh.devdays.demo.abh.restaurants.domain.Restaurant;
import com.atlantbh.devdays.demo.abh.restaurants.domain.RestaurantTable;
import java.util.List;
import org.springframework.data.repository.CrudRepository;

/** Restaurant table repository. */
public interface RestaurantTableRepository extends CrudRepository<RestaurantTable, Long> {
  /**
   * Finds table in a restaurant.
   *
   * @param restaurant Restaurant.
   * @return List of tables.
   */
  List<RestaurantTable> findByRestaurant(Restaurant restaurant);
}
