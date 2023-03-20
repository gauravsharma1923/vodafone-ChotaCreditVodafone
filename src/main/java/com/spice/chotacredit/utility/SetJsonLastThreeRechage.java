/*
 * package com.spice.chotacredit.utility;
 * 
 * import java.util.ArrayList; import java.util.List;
 * 
 * import org.springframework.http.HttpEntity; import
 * org.springframework.http.HttpHeaders; import
 * org.springframework.http.MediaType;
 * 
 * import com.google.gson.Gson; import
 * com.spice.chotacredit.request.Correlation; import
 * com.spice.chotacredit.request.Criteria; import
 * com.spice.chotacredit.request.Destination; import
 * com.spice.chotacredit.request.GetBalanceTopupRequestListVBMRequest; import
 * com.spice.chotacredit.request.GetBalanceTopupRequestListVBO; import
 * com.spice.chotacredit.request.IndexPerPage; import
 * com.spice.chotacredit.request.Key; import com.spice.chotacredit.request.Keys;
 * import com.spice.chotacredit.request.MetaInfoRechargeRequest; import
 * com.spice.chotacredit.request.QueryExpression; import
 * com.spice.chotacredit.request.RechargeRequestDetails; import
 * com.spice.chotacredit.request.Route1; import
 * com.spice.chotacredit.request.RouteInfo; import
 * com.spice.chotacredit.request.Source; import
 * com.spice.chotacredit.request.StartIndex; import
 * com.spice.chotacredit.request.Value; import
 * com.spice.chotacredit.request.ValueExpression;
 * 
 * public class SetJsonLastThreeRechage { public static HttpEntity<String>
 * setElementJson(long uniqueId,String msisdn, String circleId, String
 * type,String systemId){ RechargeRequestDetails obj =new
 * RechargeRequestDetails(); GetBalanceTopupRequestListVBMRequest getBalanceObj
 * = new GetBalanceTopupRequestListVBMRequest(); MetaInfoRechargeRequest
 * metaInfoRechargeObj = new MetaInfoRechargeRequest();
 * GetBalanceTopupRequestListVBO getBalanceTopupObj = new
 * GetBalanceTopupRequestListVBO();
 * 
 * RouteInfo routeInfo = new RouteInfo(); List<Key> key = new ArrayList(); Key
 * keyObj = new Key(); keyObj.setValue(type); key.add(keyObj); Keys keysObj =
 * new Keys(); keysObj.setKey(key); List<Route1> route = new ArrayList(); Route1
 * rout = new Route1(); rout.setId("BalanceTopup.GetList");
 * rout.setKeys(keysObj); route.add(rout); routeInfo.setRoute(route);
 * 
 * Correlation correlation = new Correlation();
 * correlation.setConversationID("12345");
 * 
 * Destination destination = new Destination();
 * destination.setSystem("UPSS.RetriveLastFiveRecharge");
 * 
 * Source srcObj = new Source(); srcObj.setDivision(circleId); // from backend
 * srcObj.setSystem(systemId);
 * 
 * metaInfoRechargeObj.setRouteInfo(routeInfo);
 * metaInfoRechargeObj.setCorrelation(correlation);
 * metaInfoRechargeObj.setDestination(destination);
 * metaInfoRechargeObj.setSource(srcObj);
 * 
 * StartIndex startIndex = new StartIndex(); startIndex.setValue("1");
 * IndexPerPage indexPerPage = new IndexPerPage(); indexPerPage.setValue("4");
 * Criteria criteriaObj = new Criteria();
 * 
 * QueryExpression queryObj = new QueryExpression();
 * 
 * List<ValueExpression> valueExpressionList = new ArrayList(); ValueExpression
 * valueExpressionObj = new ValueExpression(); ValueExpression
 * valueExpressionObj2 = new ValueExpression();
 * 
 * List<Value> valueList = new ArrayList(); Value value = new Value();
 * value.setValue(msisdn); valueList.add(value);
 * 
 * valueExpressionObj.setValue(valueList);
 * valueExpressionObj.setPath("/id/value");
 * valueExpressionObj.setQueryOperatorCode("EQUALS");
 * 
 * List<Value> valueList2 = new ArrayList(); Value value2 = new Value();
 * value2.setValue("90"); valueList2.add(value2);
 * 
 * valueExpressionObj2.setValue(valueList2);
 * valueExpressionObj2.setPath("/parts/product/category/value");
 * valueExpressionObj2.setQueryOperatorCode("EQUALS");
 * 
 * valueExpressionList.add(valueExpressionObj);
 * valueExpressionList.add(valueExpressionObj2);
 * 
 * queryObj.setValueExpression(valueExpressionList);
 * criteriaObj.setQueryExpression(queryObj);
 * 
 * getBalanceTopupObj.setStartIndex(startIndex);
 * getBalanceTopupObj.setIndexPerPage(indexPerPage);
 * getBalanceTopupObj.setCriteria(criteriaObj);
 * 
 * 
 * getBalanceObj.setGetBalanceTopupRequestListVBO(getBalanceTopupObj);
 * getBalanceObj.setMetaInfoRequest(metaInfoRechargeObj);
 * obj.setGetBalanceTopupRequestListVBMRequest(getBalanceObj);
 * 
 * 
 * Gson gson = new Gson(); // Java object to JSON string String requestJson =
 * gson.toJson(obj);
 * System.out.println(uniqueId+": Request for retriveLastFiveRecharge Json-> " +
 * requestJson.toString()); HttpHeaders headers = new HttpHeaders();
 * headers.setContentType(MediaType.APPLICATION_JSON); HttpEntity<String> entity
 * = new HttpEntity<String>(requestJson, headers); return entity; } }
 */