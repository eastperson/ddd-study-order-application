package com.ddd.dddstudyapplication.aggregate.order.presentation;

import com.ddd.dddstudyapplication.aggregate.order.application.CreateOrderService;
import com.ddd.dddstudyapplication.aggregate.order.presentation.dto.OrderRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/order")
public class OrderApi {

    private final CreateOrderService createOrderService;

    @PostMapping
    public ResponseEntity<Long> create(@RequestBody final OrderRequest orderRequest) {
        orderRequest.validate();
        Long createdOrderId = createOrderService.create(orderRequest);
        return ResponseEntity.ok(createdOrderId);
    }
}
