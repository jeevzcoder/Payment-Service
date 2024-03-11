package com.example.paymentservice.Controller;

import com.example.paymentservice.Dto.PaymentReqDto;
import com.example.paymentservice.Service.IPaymentService;
import com.razorpay.RazorpayException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/payment")
public class PaymentController {

    @Autowired
    IPaymentService paymentService;

    public PaymentController(IPaymentService paymentService){
        this.paymentService=paymentService;
    }

    @PostMapping("/link")
    public String sendPaymentLink(@RequestBody PaymentReqDto dto) throws RazorpayException {
        return paymentService.sendPaymentLink(dto.getOrderId());
    }


    @PostMapping("/webhook")
    public PaymentReqDto handelWebhookEvent(@RequestBody Object webHook){
        System.out.print(webHook);
        return null;

    }

}
