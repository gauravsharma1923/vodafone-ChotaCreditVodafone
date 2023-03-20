package com.spice.chotacredit.utility;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.spice.chotacredit.request.Correlation;
import com.spice.chotacredit.request.Criteria;
import com.spice.chotacredit.request.CustomerEligibilityVBO;
import com.spice.chotacredit.request.Destination;
import com.spice.chotacredit.request.EligibilityRequest;
import com.spice.chotacredit.request.GetCustomerEligibilityVBMRequest;
import com.spice.chotacredit.request.Key;
import com.spice.chotacredit.request.Keys;
import com.spice.chotacredit.request.MetaInfoRequest;
import com.spice.chotacredit.request.QueryExpression;
import com.spice.chotacredit.request.Route1;
import com.spice.chotacredit.request.RouteInfo;
import com.spice.chotacredit.request.Source;
import com.spice.chotacredit.request.Value;
import com.spice.chotacredit.request.ValueExpression;



public class SetJsonEligibility {
	public static HttpEntity<String> setElementJson(String msisdn, String circleId, String type,String IMSI) {
		EligibilityRequest obj = new EligibilityRequest();
		GetCustomerEligibilityVBMRequest getEventListVBMRequest = new GetCustomerEligibilityVBMRequest();
		MetaInfoRequest metaInfoRequest = new MetaInfoRequest();
		CustomerEligibilityVBO eventVBO = new CustomerEligibilityVBO();

		RouteInfo RouteInfo = new RouteInfo();
		List<Key> key = new ArrayList();
		Key keyObj = new Key();
		keyObj.setValue(type);
		key.add(keyObj);
		Keys keysObj = new Keys();
		keysObj.setKey(key);
		List<Route1> route = new ArrayList();
		Route1 rout = new Route1();
		rout.setId("CustomerEligibility.Get");
		rout.setKeys(keysObj);
		route.add(rout);
		RouteInfo.setRoute(route);

		Correlation Correlation = new Correlation();
		Correlation.setConversationID("USSD1234");

		Destination destination = new Destination();
		destination.setSystem("UPSS.LoanEligibility");

		Source srcObj = new Source();
		srcObj.setDivision(circleId); // from backend
		srcObj.setSystem("USSD");

		metaInfoRequest.setRouteInfo(RouteInfo);
		metaInfoRequest.setCorrelation(Correlation);
		metaInfoRequest.setDestination(destination);
		metaInfoRequest.setSource(srcObj);

	
		Criteria criteriaObj = new Criteria();
		QueryExpression queryObj = new QueryExpression();

		List<ValueExpression> valueExpressionList = new ArrayList();
		ValueExpression valueExpressionObj = new ValueExpression();
		ValueExpression valueExpressionObj2 = new ValueExpression();
		ValueExpression valueExpressionObj3 = new ValueExpression();
		ValueExpression valueExpressionObj4 = new ValueExpression();
		ValueExpression valueExpressionObj5 = new ValueExpression();

		List<Value> valueList = new ArrayList();
		Value value = new Value();
		value.setValue(IMSI);
		valueList.add(value);

		valueExpressionObj.setValue(valueList);
		valueExpressionObj.setPath("id/schemeName/IMSI");
		valueExpressionObj.setQueryOperatorCode("EQUALS");

		List<Value> valueList2 = new ArrayList();
		Value value2 = new Value();
		value2.setValue(msisdn);
		valueList2.add(value2);

		valueExpressionObj2.setValue(valueList2);
		valueExpressionObj2.setPath("id/schemeName/MSISDN");
		valueExpressionObj2.setQueryOperatorCode("EQUALS");
		
		List<Value> valueList3 = new ArrayList();
		Value value3 = new Value();
		value3.setValue("USSD");
		valueList3.add(value3);

		valueExpressionObj3.setValue(valueList3);
		valueExpressionObj3.setPath("id/schemeName/applicationID");
		valueExpressionObj3.setQueryOperatorCode("EQUALS");
		
		
		List<Value> valueList4 = new ArrayList();
		Value value4 = new Value();
		value4.setValue("test");
		valueList4.add(value4);

		valueExpressionObj4.setValue(valueList4);
		valueExpressionObj4.setPath("/name");
		valueExpressionObj4.setQueryOperatorCode("EQUALS");
		
		
		List<Value> valueList5 = new ArrayList();
		Value value5 = new Value();
		value5.setValue("LoanEligibilityCheck");
		valueList5.add(value5);

		valueExpressionObj5.setValue(valueList5);
		valueExpressionObj5.setPath("/type");
		valueExpressionObj5.setQueryOperatorCode("EQUALS");
		
		

		valueExpressionList.add(valueExpressionObj);
		valueExpressionList.add(valueExpressionObj2);
		valueExpressionList.add(valueExpressionObj3);
		valueExpressionList.add(valueExpressionObj4);
		valueExpressionList.add(valueExpressionObj5);

		queryObj.setValueExpression(valueExpressionList);
		criteriaObj.setQueryExpression(queryObj);

		eventVBO.setCriteria(criteriaObj);

		getEventListVBMRequest.setMetaInfoRequest(metaInfoRequest);
		getEventListVBMRequest.setCustomerEligibilityVBO(eventVBO);
		obj.setGetCustomerEligibilityVBMRequest(getEventListVBMRequest);

		ObjectMapper mapper = new ObjectMapper();

		// Java objects to JSON string - pretty-print
		/*
		 * String jsonInString2; try { jsonInString2 =
		 * mapper.writerWithDefaultPrettyPrinter().writeValueAsString(obj);
		 * System.out.println(jsonInString2);
		 * 
		 * } catch (JsonProcessingException e) { // TODO Auto-generated catch block
		 * e.printStackTrace(); }
		 */

		Gson gson = new Gson();

		// Java object to JSON string
		String requestJson = gson.toJson(obj);
		System.out.println("Request for Eligibility Json-> " + requestJson.toString());
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		//headers.setBasicAuth("");
		//headers.add("Authorization","Basic "+"RUFJU1RBR0lOR1VTRVI6RUFJMjAxOCM=");
		headers.add("Authorization","Basic "+"SVZSVXNlcjo0OGJmMjMwMzBiNjExNjRkNDUxNzkzYzBiMTgzZjBlZA==");

		HttpEntity<String> entity = new HttpEntity<String>(requestJson, headers);
		return entity;
	}
}
