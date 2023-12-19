package com.workintech.s18d2.services;

import com.workintech.s18d2.dao.FruitRepository;
import com.workintech.s18d2.entity.Fruit;
import com.workintech.s18d2.exceptions.PlantException;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FruitServiceImpl implements FruitService{
    private  final FruitRepository fruitRepository;

    @Autowired
    public FruitServiceImpl(FruitRepository fruitRepository) {
        this.fruitRepository = fruitRepository;
    }

    @Transactional
    @Override
    public Fruit save(Fruit fruit) {
        return fruitRepository.save(fruit);
    }

    @Override
    public Fruit findById(long id) {
        Optional<Fruit> fruitOptional = fruitRepository.findById(id);
        if(fruitOptional.isPresent()){
            return fruitOptional.get();
        }
        throw new PlantException("Fruit with given id is not exist: " + id, HttpStatus.NOT_FOUND);
    }

    @Override
    public List<Fruit> searchByName(String name) {
        return fruitRepository.searchByName(name.toLowerCase());
    }

    @Override
    public List<Fruit> ascSortByPrice() {
        return fruitRepository.ascSortByPrice();
    }

    @Override
    public List<Fruit> descSortByPrice() {
        return fruitRepository.descSortByPrice();
    }

    @Transactional
    @Override
    public Fruit delete(long id) {
        Fruit fruit = findById(id);
        fruitRepository.delete(fruit);
        return fruit;
    }
}
