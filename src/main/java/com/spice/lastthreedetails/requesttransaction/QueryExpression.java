package com.spice.lastthreedetails.requesttransaction;

import java.util.ArrayList;
import java.util.List;

import lombok.Data;

@Data
public class QueryExpression {
	private List<ValueExpression> valueExpression = null;
}
