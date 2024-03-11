package com.example.paymentservice.Service;

import com.example.paymentservice.Dto.PaymentReqDto;
import com.razorpay.RazorpayException;

public interface IPaymentService {
    String sendPaymentLink(String orderId) throws RazorpayException;
    PaymentReqDto handelWebHookEvent();
}
