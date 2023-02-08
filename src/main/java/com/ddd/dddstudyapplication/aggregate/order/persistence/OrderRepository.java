package com.ddd.dddstudyapplication.aggregate.order.persistence;

import com.ddd.dddstudyapplication.aggregate.order.domain.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
