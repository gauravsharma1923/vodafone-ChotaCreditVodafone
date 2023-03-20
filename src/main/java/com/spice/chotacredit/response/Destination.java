package com.spice.chotacredit.response;
import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Generated("jsonschema2pojo")
public class Destination {

/**
*
* (Required)
*
*/
@SerializedName("system")
@Expose
private String system;

/**
*
* (Required)
*
*/
public String getSystem() {
return system;
}

/**
*
* (Required)
*
*/
public void setSystem(String system) {
this.system = system;
}

}