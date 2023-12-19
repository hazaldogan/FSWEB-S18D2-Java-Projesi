package com.workintech.s18d2.dao;

import com.workintech.s18d2.entity.Fruit;
import com.workintech.s18d2.entity.Vegetable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface VegetableRepository extends JpaRepository<Vegetable,Long> {
    @Query(value = "SELECT v FROM Vegetable v ORDER BY v.price ASC")
    List<Vegetable> ascSortByPrice();

    @Query(value = "SELECT v FROM Vegetable v ORDER BY v.price DESC")
    List<Vegetable> descSortByPrice();

    @Query(value = "SELECT v FROM Vegetable v WHERE v.name ILIKE %:name%")
    List<Vegetable> searchByName(String name);
}
