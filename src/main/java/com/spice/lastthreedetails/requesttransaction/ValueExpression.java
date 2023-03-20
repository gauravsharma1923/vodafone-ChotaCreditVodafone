package com.spice.lastthreedetails.requesttransaction;

import java.util.List;

import lombok.Data;

@Data
public class ValueExpression {
	private List<Value> value = null;
	private String path;
	private String queryOperatorCode;
}
