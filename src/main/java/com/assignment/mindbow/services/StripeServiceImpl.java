package com.assignment.mindbow.services;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.assignment.mindbow.entities.ChargeRequest;
import com.assignment.mindbow.exceptions.StripeExcetionCustom;
import com.stripe.Stripe;
import com.stripe.exception.StripeException;
import com.stripe.model.Charge;
import com.stripe.model.Coupon;
import com.stripe.model.Customer;
import com.stripe.model.Subscription;

@Service
public class StripeServiceImpl implements StripeService {
	
	@Value("${STRIPE_SECRET_KEY}")
	private String API_SECET_KEY;

	
	@Override
	public Charge createCharge(ChargeRequest chargeRequest) throws StripeExcetionCustom {
		Charge charge=null;
		
		try {
			Stripe.apiKey = API_SECET_KEY;
			
			Map<String, Object> chargeParams = new HashMap<>();
			chargeParams.put("description","Charge for "+chargeRequest.getStripeEmail());
			chargeParams.put("currency","usd");
			chargeParams.put("amount",chargeRequest.getAmount());
			chargeParams.put("source",chargeRequest.getStripeToken());
			
			 charge = Charge.create(chargeParams);
			
		  
		} catch (StripeException e) {
			throw new StripeExcetionCustom("Payment failed because of " +e.getMessage());
		}
		return charge;
	}

}
