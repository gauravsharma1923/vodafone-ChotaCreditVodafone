package com.spice.chotacredit.request;

import lombok.Data;

@Data
public class MetaInfoRequest {
	private RouteInfo RouteInfo;
	private Correlation Correlation;
	private Source Source;
	private Destination Destination;
}
