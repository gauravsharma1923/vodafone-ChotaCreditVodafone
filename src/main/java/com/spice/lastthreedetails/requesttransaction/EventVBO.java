package com.spice.lastthreedetails.requesttransaction;

import lombok.Data;

@Data
public class EventVBO {
	StartIndex startIndex;
	IndexPerPage indexPerPage;
	Criteria criteria;
}
