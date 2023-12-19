package com.workintech.s18d2.services;

import com.workintech.s18d2.entity.Fruit;

import java.util.List;

public interface FruitService {
    Fruit save(Fruit fruit);
    Fruit findById(long id);
    List<Fruit> searchByName(String name);
    List<Fruit> ascSortByPrice();
    List<Fruit> descSortByPrice();
    Fruit delete(long id);
}
