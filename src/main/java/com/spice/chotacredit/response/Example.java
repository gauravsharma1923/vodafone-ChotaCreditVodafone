package com.spice.chotacredit.response;
import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Generated("jsonschema2pojo")
public class Example {

/**
*
* (Required)
*
*/
@SerializedName("GetCustomerEligibilityVBMResponse")
@Expose
private GetCustomerEligibilityVBMResponse getCustomerEligibilityVBMResponse;

/**
*
* (Required)
*
*/
public GetCustomerEligibilityVBMResponse getGetCustomerEligibilityVBMResponse() {
return getCustomerEligibilityVBMResponse;
}

/**
*
* (Required)
*
*/
public void setGetCustomerEligibilityVBMResponse(GetCustomerEligibilityVBMResponse getCustomerEligibilityVBMResponse) {
this.getCustomerEligibilityVBMResponse = getCustomerEligibilityVBMResponse;
}

}
