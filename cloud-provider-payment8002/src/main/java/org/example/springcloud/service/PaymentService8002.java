package org.example.springcloud.service;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.example.springcloud.entities.Payment;

@Mapper
public interface PaymentService8002 {
    public int create(Payment payment);

    public Payment getPaymentById(@Param("id") Long id);
}