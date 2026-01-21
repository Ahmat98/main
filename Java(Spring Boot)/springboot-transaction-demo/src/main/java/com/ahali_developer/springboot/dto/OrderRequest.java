package com.ahali_developer.springboot.dto;

import com.ahali_developer.springboot.entity.Order;
import com.ahali_developer.springboot.entity.Payment;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OrderRequest {
    private Order order;
    private Payment payment;
}
