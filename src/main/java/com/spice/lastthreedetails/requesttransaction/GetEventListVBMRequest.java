package com.spice.lastthreedetails.requesttransaction;

import lombok.Data;

@Data
public class GetEventListVBMRequest {
	MetaInfoRequest MetaInfoRequest;
	EventVBO EventVBO;
}
