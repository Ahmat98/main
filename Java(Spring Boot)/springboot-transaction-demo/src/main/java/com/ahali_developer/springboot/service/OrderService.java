package com.ahali_developer.springboot.service;

import com.ahali_developer.springboot.dto.OrderRequest;
import com.ahali_developer.springboot.dto.OrderResponse;
import org.springframework.stereotype.Service;


public interface OrderService {

    OrderResponse placeOrder(OrderRequest orderRequest);
}
