package com.atguigu.springcloud.service;

import com.atguigu.springcloud.entities.Payment;
import org.springframework.stereotype.Service;


public interface PaymentService {

    int insert(Payment payment);

    Payment queryById(Long id);
}
