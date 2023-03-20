package com.spice.chotacredit.response;
import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Generated("jsonschema2pojo")
public class MetaInfoResponse {

@SerializedName("RouteInfo")
@Expose
private RouteInfo routeInfo;
@SerializedName("Correlation")
@Expose
private Correlation correlation;
@SerializedName("Source")
@Expose
private Source source;
@SerializedName("Destination")
@Expose
private Destination destination;
@SerializedName("ResultStatus")
@Expose
private ResultStatus resultStatus;

public RouteInfo getRouteInfo() {
return routeInfo;
}

public void setRouteInfo(RouteInfo routeInfo) {
this.routeInfo = routeInfo;
}

public Correlation getCorrelation() {
return correlation;
}

public void setCorrelation(Correlation correlation) {
this.correlation = correlation;
}

public Source getSource() {
return source;
}

public void setSource(Source source) {
this.source = source;
}

public Destination getDestination() {
return destination;
}

public void setDestination(Destination destination) {
this.destination = destination;
}

public ResultStatus getResultStatus() {
return resultStatus;
}

public void setResultStatus(ResultStatus resultStatus) {
this.resultStatus = resultStatus;
}

}