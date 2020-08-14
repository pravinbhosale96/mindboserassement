package com.assignment.mindbow.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.assignment.mindbow.entities.ChargeRequest;
import com.assignment.mindbow.exceptions.StripeExcetionCustom;
import com.assignment.mindbow.services.ManagerServiceImpl;
import com.assignment.mindbow.services.StripeService;
import com.assignment.mindbow.services.StripeServiceImpl;
import com.assignment.mindbow.utility.Response;
import com.stripe.model.Charge;
import com.stripe.model.Coupon;


@Controller
@RequestMapping("/api")
public class ControllerCheckout {


	Logger logger = LoggerFactory.getLogger(ManagerServiceImpl.class);
	//All APIs under '/api' path are secured
	 @Value("${STRIPE_PUBLIC_KEY}")
	 private String stripePublicKey;

	@Autowired
	private StripeService stripeService;

	 @RequestMapping("/checkout")
	 public String checkout(Model model,@RequestParam(value = "access_token", required = true) String access_token ) {
		 model.addAttribute("access_token",access_token);
	        model.addAttribute("amount", 50 * 100); // in cents
	        model.addAttribute("stripePublicKey", stripePublicKey);
	        model.addAttribute("currency", ChargeRequest.Currency.EUR);
	        return "checkout";
	    }

	@PostMapping("/charge")
	public String createCharge(@RequestBody ChargeRequest chargeRequest,Model model) throws StripeExcetionCustom {
		
		chargeRequest.setDescription("Example charge");
        chargeRequest.setCurrency(ChargeRequest.Currency.EUR);
        Charge charge = stripeService.createCharge(chargeRequest);
        model.addAttribute("id", charge.getId());
       
        model.addAttribute("status", charge.getStatus());
        model.addAttribute("chargeId", charge.getId());
        model.addAttribute("balance_transaction", charge.getBalanceTransaction());
        return "result";
		
	}
	
}
