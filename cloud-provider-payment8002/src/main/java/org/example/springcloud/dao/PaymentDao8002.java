package org.example.springcloud.dao;
import org.example.springcloud.entities.Payment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface PaymentDao8002 {
    int create(Payment payment);

    Payment getPaymentById(@Param("id") Long id);
}
