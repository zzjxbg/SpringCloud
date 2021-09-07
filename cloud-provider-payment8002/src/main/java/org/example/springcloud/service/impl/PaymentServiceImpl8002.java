package org.example.springcloud.service.impl;

import org.example.springcloud.dao.PaymentDao8002;
import org.example.springcloud.entities.Payment;
import org.example.springcloud.service.PaymentService8002;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PaymentServiceImpl8002 implements PaymentService8002 {

    @Autowired
    private PaymentDao8002 paymentDao8002;

    public int create(Payment payment) {
        return paymentDao8002.create(payment);
    }

    public Payment getPaymentById(Long id) {
        return paymentDao8002.getPaymentById(id);
    }
}