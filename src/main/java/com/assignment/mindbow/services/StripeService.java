package com.assignment.mindbow.services;


import com.assignment.mindbow.entities.ChargeRequest;
import com.assignment.mindbow.exceptions.StripeExcetionCustom;
import com.stripe.model.Charge;



public interface StripeService {

	public Charge createCharge(ChargeRequest chargeRequest) throws StripeExcetionCustom ;
	
}
