package com.workintech.s18d2.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="fruit",schema="fsweb")
public class Fruit extends Plant{

    @Column(name="fruit_type")
    @Enumerated(EnumType.STRING)
    private FruitType fruitType;
}
