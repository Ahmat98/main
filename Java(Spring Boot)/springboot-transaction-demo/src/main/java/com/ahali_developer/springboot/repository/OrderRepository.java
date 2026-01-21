package com.ahali_developer.springboot.repository;

import com.ahali_developer.springboot.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
