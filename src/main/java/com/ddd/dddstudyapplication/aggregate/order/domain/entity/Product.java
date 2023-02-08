package com.ddd.dddstudyapplication.aggregate.order.domain.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@Getter
@Table(name = "product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String serialNumber;
    private String name;
    private Double price;
    private Long inventoryCount;

    public Product(final String serialNumber, final String name, final Double price) {
        this.serialNumber = serialNumber;
        this.name = name;
        this.price = price;
    }

    public void checkInventory(Long quantity) {
        if (inventoryCount < quantity) {
            throw new RuntimeException();
        }
    }
}
