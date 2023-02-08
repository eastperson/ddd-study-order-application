package com.ddd.dddstudyapplication.aggregate.order.persistence;

import com.ddd.dddstudyapplication.aggregate.order.domain.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
