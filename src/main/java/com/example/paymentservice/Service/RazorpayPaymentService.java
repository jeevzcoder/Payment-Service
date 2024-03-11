package com.example.paymentservice.Service;

import com.example.paymentservice.Configuration.RazorpayConfiguration;
import com.example.paymentservice.Dto.PaymentReqDto;
import com.razorpay.PaymentLink;
import com.razorpay.RazorpayClient;
import com.razorpay.RazorpayException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

@Service
@Primary
public class RazorpayPaymentService implements IPaymentService{
    @Autowired
    RazorpayClient razorpayClient;
    public RazorpayPaymentService(   RazorpayClient razorpayClient) {
        this.razorpayClient = razorpayClient;
    }


    @Override
    public String sendPaymentLink(String orderId) throws RazorpayException {


        JSONObject paymentLinkRequest = new JSONObject();

        //order price or amount and name etc etxc
        paymentLinkRequest.put("amount",1000);
        paymentLinkRequest.put("currency","INR");
        paymentLinkRequest.put("accept_partial",false);
        //paymentLinkRequest.put("first_min_partial_amount",100);
        paymentLinkRequest.put("expire_by",System.currentTimeMillis()+15*60*100);
        paymentLinkRequest.put("reference_id",orderId);
        paymentLinkRequest.put("description","Payment for policy no #23456");
        JSONObject customer = new JSONObject();
        customer.put("name","+918095575083");
        customer.put("contact","Abhijeeva");
        customer.put("email","avbhijeeva@gmail.com");
        paymentLinkRequest.put("customer",customer);
        JSONObject notify = new JSONObject();
        notify.put("sms",false);
        notify.put("email",false);
        paymentLinkRequest.put("reminder_enable",true);
        JSONObject notes = new JSONObject();
        notes.put("policy_name","Trial req");
        paymentLinkRequest.put("notes",notes);
        paymentLinkRequest.put("callback_url","https://callBackUrl.com");
        paymentLinkRequest.put("callback_method","get");

        //RazorpayClient razorpayClient;
        PaymentLink payment = razorpayClient.paymentLink.create(paymentLinkRequest);
         return payment.get("short_url");
    }

    @Override
    public PaymentReqDto handelWebHookEvent() {
        return null;

    }
}
