package com.example.paymentservice.Service;

import com.example.paymentservice.Dto.PaymentReqDto;
import org.springframework.stereotype.Service;

@Service
public class StripePaymentService implements IPaymentService{
    @Override
    public String sendPaymentLink(String orderId) {
        return null;
    }

    @Override
    public PaymentReqDto handelWebHookEvent() {
        return null;

    }
}
