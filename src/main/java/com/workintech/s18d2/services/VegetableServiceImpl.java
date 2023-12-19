package com.workintech.s18d2.services;

import com.workintech.s18d2.dao.VegetableRepository;
import com.workintech.s18d2.entity.Vegetable;
import com.workintech.s18d2.exceptions.PlantException;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VegetableServiceImpl implements VegetableService{
    private  final VegetableRepository vegetableRepository;

    @Autowired
    public VegetableServiceImpl(VegetableRepository vegetableRepository) {
        this.vegetableRepository = vegetableRepository;
    }

    @Transactional
    @Override
    public Vegetable save(Vegetable vegetable) {
        return vegetableRepository.save(vegetable);
    }

    @Override
    public Vegetable findById(long id) {
        Optional<Vegetable> vegetableOptional = vegetableRepository.findById(id);
        if(vegetableOptional.isPresent()){
            return vegetableOptional.get();
        }
        throw new PlantException("Vegetable with given id is not exist: " + id, HttpStatus.NOT_FOUND);
    }

    @Override
    public List<Vegetable> searchByName(String name) {
        return vegetableRepository.searchByName(name.toLowerCase());
    }

    @Override
    public List<Vegetable> ascSortByPrice() {
        return vegetableRepository.ascSortByPrice();
    }

    @Override
    public List<Vegetable> descSortByPrice() {
        return vegetableRepository.descSortByPrice();
    }

    @Transactional
    @Override
    public Vegetable delete(long id) {
        Vegetable vegetable = findById(id);
        vegetableRepository.delete(vegetable);
        return vegetable;
    }
}
