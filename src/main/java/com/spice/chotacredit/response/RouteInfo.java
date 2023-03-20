package com.spice.chotacredit.response;
import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Generated("jsonschema2pojo")
public class RouteInfo {

/**
*
* (Required)
*
*/
@SerializedName("route")
@Expose
private Route route;

/**
*
* (Required)
*
*/
public Route getRoute() {
return route;
}

/**
*
* (Required)
*
*/
public void setRoute(Route route) {
this.route = route;
}

}