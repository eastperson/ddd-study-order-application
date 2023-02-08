package com.ddd.dddstudyapplication.aggregate.order.presentation.dto;

import lombok.Getter;

@Getter
public class OrderRequest {
    private Long productId;
    private Long quantity;

    public void validate() {
        if (productId == null) {
            throw new RuntimeException();
        }
        if (this.quantity == null) {
            throw new RuntimeException();
        }
    }
}
