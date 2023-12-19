package com.workintech.s18d2.services;

import com.workintech.s18d2.entity.Vegetable;

import java.util.List;

public interface VegetableService {
    Vegetable save(Vegetable Vegetable);
    Vegetable findById(long id);
    List<Vegetable> searchByName(String name);
    List<Vegetable> ascSortByPrice();
    List<Vegetable> descSortByPrice();
    Vegetable delete(long id);
}
