package com.atguigu.springcloud.dao;

import com.atguigu.springcloud.entities.Payment;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface PaymentDao {

    int insert(Payment payment);

    Payment queryById(Long id);
}
