package com.ddd.dddstudyapplication.aggregate.order.domain.entity;

import com.ddd.dddstudyapplication.aggregate.order.domain.service.CalculateDeliveryFeeService;
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
@Table(name = "order_info")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Long productId;
    private Long quantity;
    private Double totalPrice;

    public Order(Long productId, Long quantity, Double productPrice) {
        this.productId = productId;
        this.quantity = quantity;
        this.totalPrice = CalculateDeliveryFeeService.calculateDeliveryFee(productPrice, quantity);
    }

    public static Order of(Long productId, Long quantity, Double productPrice) {
        return new Order(productId, quantity, productPrice);
    }
}
