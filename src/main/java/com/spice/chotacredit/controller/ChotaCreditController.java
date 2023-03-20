package com.spice.chotacredit.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.spice.chotacredit.service.ChotaCreditService;

@RestController
@RequestMapping("/ChotaCredit")
public class ChotaCreditController {
	private static final Logger logger = LogManager.getLogger("reqresp");
	
	@Autowired
	private ChotaCreditService chotaCreditService;
	
	

	

	@GetMapping(value = "/CreditEligibility")
	public String eligibility(@RequestParam String msisdn,@RequestParam String circleid,@RequestParam String requestType,@RequestParam String sessionid) throws Exception {		
		String type = "Prepaid";
		String IMSIID = "";
		long uniqueId = System.currentTimeMillis();
		logger.info("Request-eligibility|{}|{}|{}|{}|{}",uniqueId,msisdn,circleid,sessionid,requestType,IMSIID);
		return chotaCreditService.eligibility(uniqueId,msisdn,circleid,type,IMSIID);	
	}
	

	@GetMapping(value = "/activation")
	public String activation(@RequestParam String msisdn,@RequestParam String circleId,@RequestParam String type, @RequestParam String systemId) throws Exception {
		long uniqueId = System.currentTimeMillis();
		logger.info("Request-activation|{}|{}|{}|{}",uniqueId,msisdn,circleId,systemId);
		return chotaCreditService.activation(uniqueId,msisdn,circleId,type,systemId);
	}
}
