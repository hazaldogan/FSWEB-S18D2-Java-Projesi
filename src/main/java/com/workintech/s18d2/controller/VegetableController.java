package com.workintech.s18d2.controller;

import com.workintech.s18d2.entity.Vegetable;
import com.workintech.s18d2.services.VegetableService;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Validated
@RestController
@RequestMapping("/vegetables")
public class VegetableController {
    private VegetableService vegetableService;

    @Autowired
    public VegetableController(VegetableService vegetableService) {
        this.vegetableService = vegetableService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Vegetable save(@Validated @RequestBody Vegetable vegetable){
        return vegetableService.save(vegetable);
    }

    @GetMapping
    public List<Vegetable> findAll(){
        return vegetableService.ascSortByPrice();
    }

    @GetMapping("/{id}")
    public Vegetable findById(@Positive @PathVariable long id){
        return vegetableService.findById(id);
    }

    @GetMapping("/desc")
    public List<Vegetable> descFindAll(){
        return vegetableService.descSortByPrice();
    }

    @GetMapping("/{name}")
    public List<Vegetable> searchByName(@Size(min=2,max=45) @PathVariable String name){
        return vegetableService.searchByName(name);
    }

    @DeleteMapping("/{id}")
    public Vegetable delete(@Positive @PathVariable long id){
        return vegetableService.delete(id);
    }
}
