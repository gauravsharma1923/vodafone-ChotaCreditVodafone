package com.spice.chotacredit.request;

import lombok.Data;

@Data
public class GetCustomerEligibilityVBMRequest {
	private MetaInfoRequest MetaInfoRequest;
	private CustomerEligibilityVBO CustomerEligibilityVBO;
}
