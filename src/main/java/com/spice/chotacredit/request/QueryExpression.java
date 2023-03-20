package com.spice.chotacredit.request;

import java.util.List;


import lombok.Data;

@Data
public class QueryExpression {
	private List<ValueExpression> valueExpression = null;
}
