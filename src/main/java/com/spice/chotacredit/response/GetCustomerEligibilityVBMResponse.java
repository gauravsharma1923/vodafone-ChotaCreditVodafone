package com.spice.chotacredit.response;
import java.util.List;
import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Generated("jsonschema2pojo")
public class GetCustomerEligibilityVBMResponse {

/**
*
* (Required)
*
*/
@SerializedName("MetaInfoResponse")
@Expose
private MetaInfoResponse metaInfoResponse;
/**
*
* (Required)
*
*/
@SerializedName("CustomerEligibilityVBO")
@Expose
private List<Object> customerEligibilityVBO = null;

/**
*
* (Required)
*
*/
public MetaInfoResponse getMetaInfoResponse() {
return metaInfoResponse;
}

/**
*
* (Required)
*
*/
public void setMetaInfoResponse(MetaInfoResponse metaInfoResponse) {
this.metaInfoResponse = metaInfoResponse;
}

/**
*
* (Required)
*
*/
public List<Object> getCustomerEligibilityVBO() {
return customerEligibilityVBO;
}

/**
*
* (Required)
*
*/
public void setCustomerEligibilityVBO(List<Object> customerEligibilityVBO) {
this.customerEligibilityVBO = customerEligibilityVBO;
}

}
