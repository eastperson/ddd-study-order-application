package com.ddd.dddstudyapplication.aggregate.order.application;

import com.ddd.dddstudyapplication.aggregate.order.domain.entity.Order;
import com.ddd.dddstudyapplication.aggregate.order.domain.entity.Product;
import com.ddd.dddstudyapplication.aggregate.order.persistence.OrderRepository;
import com.ddd.dddstudyapplication.aggregate.order.persistence.ProductRepository;
import com.ddd.dddstudyapplication.aggregate.order.presentation.dto.OrderRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class CreateOrderService {

    private final OrderRepository orderRepository;
    private final ProductRepository productRepository;

    @Transactional
    public Long create(final OrderRequest orderRequest) {
        // 애플리케이션에서 유효성 검사
        if (orderRequest.getQuantity() < 1) {
            throw new RuntimeException();
        }
        Product product = productRepository.findById(orderRequest.getProductId()).orElseThrow(RuntimeException::new);
        product.checkInventory(orderRequest.getQuantity());
        Order order = Order.of(product.getId(), orderRequest.getQuantity(), product.getPrice());
        return orderRepository.save(order).getId();
    }
}
