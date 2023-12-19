package com.workintech.s18d2.controller;

import com.workintech.s18d2.entity.Fruit;
import com.workintech.s18d2.services.FruitService;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Validated
@RestController
@RequestMapping("/fruits")
public class FruitController {
    private FruitService fruitService;

    @Autowired
    public FruitController(FruitService fruitService) {
        this.fruitService = fruitService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Fruit save(@Validated @RequestBody Fruit fruit){
        return fruitService.save(fruit);
    }

    @GetMapping
    public List<Fruit> findAll(){
        return fruitService.ascSortByPrice();
    }

    @GetMapping("/{id}")
    public Fruit findById(@Positive @PathVariable long id){
        return fruitService.findById(id);
    }

    @GetMapping("/desc")
    public List<Fruit> descFindAll(){
        return fruitService.descSortByPrice();
    }

    @GetMapping("/{name}")
    public List<Fruit> searchByName(@Size(min=2,max=45) @PathVariable String name){
        return fruitService.searchByName(name);
    }

    @DeleteMapping("/{id}")
    public Fruit delete(@Positive @PathVariable long id){
        return fruitService.delete(id);
    }

}
