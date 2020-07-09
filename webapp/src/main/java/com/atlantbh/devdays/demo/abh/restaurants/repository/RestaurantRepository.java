package com.atlantbh.devdays.demo.abh.restaurants.repository;

import com.atlantbh.devdays.demo.abh.restaurants.domain.Restaurant;
import com.atlantbh.devdays.demo.abh.restaurants.domain.RestaurantTable;
import com.atlantbh.devdays.demo.abh.restaurants.service.responses.PopularLocation;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/** Restaurant repository. */
public interface RestaurantRepository extends BaseCrudRepository<Restaurant, Long> {
  /**
   * Find accommodating restaurant tables list.
   *
   * @param restaurantId Id of a restaurant.
   * @param minNumberOfChairs Minimum number of chairs.
   * @param maxNumberOfChairs Max number of chairs.
   * @return List of restaurant tables that can accommodate these people.
   */
  @Query(
      "SELECT tables FROM RestaurantTable tables WHERE tables.restaurant.id = :restaurantId AND "
          + "tables.numberOfChairs >= :minNumberOfChairs AND "
          + "tables.numberOfChairs <= :maxNumberOfChairs")
  List<RestaurantTable> findAccommodatingRestaurantTables(
      @Param("restaurantId") Long restaurantId,
      @Param("minNumberOfChairs") int minNumberOfChairs,
      @Param("maxNumberOfChairs") int maxNumberOfChairs);

  /**
   * Returns near-by restaurants.
   *
   * @param latitude Lat.
   * @param longitude Lng
   * @return List of nearby restaurants.
   */
  @Query(
    value =
        "SELECT * FROM restaurant WHERE restaurant.longitude <> 0 AND restaurant.latitude <> 0 ORDER BY public.ST_Distance(public.ST_GeomFromText('POINT(' || restaurant.longitude || ' ' || restaurant.latitude || ')' ,4326), public.ST_GeomFromText('POINT(' || :longitude || ' ' || :latitude || ')',4326)) ASC LIMIT 3",
    nativeQuery = true
  )
  List<Restaurant> findNearBy(
      @Param("latitude") float latitude, @Param("longitude") float longitude);

  /**
   * Find popular restaurant list.
   *
   * @return The list of restaurants.
   */
  @Query(
    value =
        "WITH tmp AS (SELECT t.restaurant_id, count(*) AS table_count\n"
            + "FROM reservation r, restaurant_table t\n"
            + "WHERE r.table_id = t.id GROUP BY t.restaurant_id\n"
            + "ORDER BY table_count DESC\n"
            + "LIMIT 6)\n"
            + "SELECT * FROM restaurant r, tmp t\n"
            + "WHERE r.id = t.restaurant_id\n"
            + "ORDER BY r.name ASC",
    nativeQuery = true
  )
  List<Restaurant> findPopular();

  /**
   * Find popular locations list.
   *
   * @return Popular locations.
   */
  @Query(name = "findPopularLocations", nativeQuery = true)
  List<PopularLocation> findPopularLocations();
}
