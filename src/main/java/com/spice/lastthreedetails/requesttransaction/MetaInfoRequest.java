package com.spice.lastthreedetails.requesttransaction;

import lombok.Data;

@Data
public class MetaInfoRequest {
	RouteInfo RouteInfo;
	Correlation Correlation;
	Destination Destination;
	Source Source;
}
