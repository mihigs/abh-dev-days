package com.atlantbh.devdays.demo.abh.restaurants.repository;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.NoRepositoryBean;

/** Base repository. */
@NoRepositoryBean
public interface BaseCrudRepository<T, ID>
    extends CrudRepository<T, ID>, JpaSpecificationExecutor<T> {}
