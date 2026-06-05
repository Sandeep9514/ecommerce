package com.example.paymentservice.service;


import com.example.paymentservice.entity.paymentData;
import com.example.paymentservice.entity.sessiondetails;
import com.example.paymentservice.entity.stripeResponse;
import com.example.paymentservice.repository.sessionrepo;
import com.stripe.Stripe;
import com.stripe.exception.StripeException;
import com.stripe.model.checkout.Session;
import com.stripe.param.checkout.SessionCreateParams;
import org.springframework.stereotype.Service;

@Service
public class stripeService {

    private sessiondetails sess;
    private sessionrepo sessrepo;

    public stripeService(sessionrepo sessrepo, sessiondetails sess) {
        this.sessrepo = sessrepo;
        this.sess = sess;
    }

    public stripeResponse payment(paymentData event) {
        long quantity = 10;
        Stripe.apiKey = "secretkey";

        SessionCreateParams.LineItem.PriceData.ProductData.builder()
                .setName(String.valueOf(event.getOrderId())).build();

        SessionCreateParams.LineItem.PriceData pricedata =
                SessionCreateParams.LineItem.PriceData.builder()
                .setCurrency("USD")
                .setUnitAmount((long)event.getAmount()).build();

        SessionCreateParams.LineItem lineitem =
                SessionCreateParams.LineItem.builder()
                .setQuantity(quantity)
                .setPriceData(pricedata)
                .build();

        SessionCreateParams params =
                SessionCreateParams.builder()
                .setMode(SessionCreateParams.Mode.PAYMENT)
                .setSuccessUrl("https://localhost:8081/order/success")
                .setCancelUrl("http://localhost:8081:/order/fail")
                .addLineItem(lineitem)
                .build();

        Session session = null;
        try{
            session = Session.create(params);
            sess.setOrderId(event.getOrderId());
            sess.setUserId(event.getUserId());
            sess.setEmail("abc@gmail.com");
            sess.setStatus("PENDING");
            sess.setSessionId(session.getId());
            sessrepo.save(sess);

        }catch (StripeException ex){
            System.out.println(ex.getMessage());
        }

        return stripeResponse.builder()
                .status("SUCCESS")
                .message("Payment session created")
                .sessionId(session.getId())
                .sessionUrl(session.getUrl())
                .build();



    }
}
