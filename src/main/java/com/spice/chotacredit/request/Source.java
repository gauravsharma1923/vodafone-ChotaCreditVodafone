package com.spice.chotacredit.request;
import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Generated("jsonschema2pojo")
public class Source {

/**
*
* (Required)
*
*/
@SerializedName("division")
@Expose
private String division;
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
public String getDivision() {
return division;
}

/**
*
* (Required)
*
*/
public void setDivision(String division) {
this.division = division;
}

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