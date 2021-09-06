package org.example.springcloud.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.example.springcloud.entities.Payment;

@Mapper
public interface PaymentDao8002 {
    public int create(Payment payment);

    public Payment getPaymentById(@Param("id") Long id);
}
