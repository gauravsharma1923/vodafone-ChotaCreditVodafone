package com.spice.chotacredit.service;

import java.lang.reflect.Type;
import java.util.Iterator;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonPrimitive;
import com.google.gson.reflect.TypeToken;
//import com.spice.chotacredit.utility.SetJsonEligibility;
//import com.spice.chotacredit.response.CharacteristicsValue;
//import com.spice.chotacredit.response.ResponseEligibiity;

import com.spice.chotacredit.utility.SetJsonEligibility;
import com.spice.chotacredit.response.CharacteristicsValue;
import com.spice.chotacredit.response.ResponseEligibiity;


@Component
@Service
public class ChotaCreditService {
	private static final Logger logger = LogManager.getLogger("reqresp");
	private RestTemplate restTemplate;

	@Value("${api.eligibilityUrl}")
	private String eligibilityUrl;

	@Value("${api.activationUrl}")
	private String activationUrl;

	public ChotaCreditService(RestTemplate restTemplate) {
		this.restTemplate = restTemplate;
	}

	public String eligibility(long uniqueId, String msisdn, String circleId, String type,String IMSIID) {	
		HttpEntity<String> entity = SetJsonEligibility.setElementJson(msisdn, circleId, type,IMSIID);
		String responseUser = "";
		String response = "";
		try {
			response = restTemplate.postForObject(eligibilityUrl, entity, String.class);
			//response="{ \"GetCustomerEligibilityVBMResponse\":{ \"MetaInfoResponse\":{ \"RouteInfo\":{ \"route\":{ \"id\":\"CustomerEligibility.Get\", \"keys\":{ \"key\":[ { \"value\":\"Prepaid\" } ] } } }, \"Correlation\":{ \"conversationID\":\"USSD1234\" }, \"Destination\":{ \"system\":\"UPSS.LoanEligibility\" }, \"Source\":{ \"division\":\"0022\", \"system\":\"USSD\" }, \"ResultStatus\":{ \"errorCode\":\"VEAI31003E\", \"description\":[ \"1\", \"SUCCESS: Balance greater than threshold balance\" ] } }, \"GetCustomerEligibilityVBMResponse\":{ \"CustomerEligibilityVBO\":[  ] } } }";;
			//response="{ \"GetCustomerEligibilityVBMResponse\":{ \"MetaInfoResponse\":{ \"RouteInfo\":{ \"route\":{ \"id\":\"CustomerEligibility.Get\", \"keys\":{ \"key\":[ { \"value\":\"Prepaid\" } ] } } }, \"Correlation\":{ \"conversationID\":\"USSD1234\" }, \"Destination\":{ \"system\":\"UPSS.LoanEligibility\" }, \"Source\":{ \"division\":\"0022\", \"system\":\"USSD\" }, \"ResultStatus\":{ \"errorCode\":\"VEAI31003E\", \"description\":[ \"1\", \"\" ] } }, \"GetCustomerEligibilityVBMResponse\":{ \"CustomerEligibilityVBO\":[  ] } } }";			;
			System.out.println("response-->" + response.toString());
			JsonObject jobj = new Gson().fromJson(response, JsonObject.class);
			JsonObject jo = jobj.get("GetCustomerEligibilityVBMResponse").getAsJsonObject();
			JsonObject jo1=jo.get("MetaInfoResponse").getAsJsonObject();
			JsonObject ja=jo1.get("ResultStatus").getAsJsonObject();

			
			String description = "";
			String Errorcode = "";
			description=	ja.get("description").toString();
			 
			Errorcode=ja.get("errorCode").toString();
		
			description=description.replaceAll("]", "");
			description=description.replaceAll(",", "#");
			description=description.replaceAll("\\[","");
			description=description.replaceAll("\"", "");
			String[] desc_final=description.split("#");
			String desc_code=desc_final[0];
			String desc_description=desc_final[1];
			Errorcode=Errorcode.replaceAll("\"", "");
			
			if (desc_code != "" || desc_description != "") {
				responseUser="msg="+desc_code+"#5.0#6.5#"+Errorcode+"#"+desc_description;
				logger.info("Response-eligibility|{}|{}|{}|{}", uniqueId, msisdn, circleId, responseUser);
				//responseUser = description +"#"+ Errorcode ;
				}
			else {
				responseUser="msg=1#NA#NA#NA#NA";
			};
			
		    //System.out.println(ja.toString());
		   

		} catch (Exception ex) {
			ex.printStackTrace();
			responseUser = "respcode=-1|Error while hitting eligibility Api| " + ex.getMessage();
			logger.info("Response-eligibility|{}|{}|{}|{}", uniqueId, msisdn, circleId, responseUser);
			responseUser="msg=1#NA#NA#NA#NA";
			return responseUser;
		}
		
		return responseUser;
	}

	

	public String activation(long uniqueId, String msisdn, String circleId, String type, String systemId) {

		/*
		 * HttpEntity<String> entity = SetJsonLastThreeRechage.setElementJson(uniqueId,
		 * msisdn, circleId, type, systemId); String response = ""; String responseUser
		 * = ""; try {
		 * 
		 * response = restTemplate.postForObject(activationUrl, entity, String.class);
		 * 
		 * //response =
		 * "{\"GetBalanceTopupRequestListVBMResponse\":{\"balanceTopupRequestVBO\":[{\"created\":{\"value\":\"31/05/2021 11:56:30\"},\"details\":{\"amount\":{\"value\":\"10\"}},\"ids\":{\"id\":[{\"value\":\"BRH2105311156300038\"}]},\"parts\":{\"product\":{\"name\":\"7.47\",\"type\":\"talkTime\"},\"serviceBalance\":{\"desc\":\"11.47\"}},\"validityPeriod\":{\"toDate\":{\"value\":\"01/08/2021 00:00:00\"}}},{\"created\":{\"value\":\"28/05/2021 13:39:41\"},\"details\":{\"amount\":{\"value\":\"49\"}},\"ids\":{\"id\":[{\"value\":\"BRH2105281339220023\"}]},\"parts\":{\"product\":{\"name\":\"null\",\"type\":\"talkTime\"},\"serviceBalance\":{\"desc\":\"\"}},\"validityPeriod\":{\"toDate\":{\"value\":\"01/08/2021 00:00:00\"}}},{\"created\":{\"value\":\"18/05/2021 11:14:28\"},\"details\":{\"amount\":{\"value\":\"49\"}},\"ids\":{\"id\":[{\"value\":\"BRH2105181114230020\"}]},\"parts\":{\"product\":{\"name\":\"null\",\"type\":\"talkTime\"},\"serviceBalance\":{\"desc\":\"\"}},\"validityPeriod\":{\"toDate\":{\"value\":\"04/07/2021 00:00:00\"}}},{\"created\":{\"value\":\"17/05/2021 13:20:30\"},\"details\":{\"amount\":{\"value\":\"10\"}},\"ids\":{\"id\":[{\"value\":\"BRH2105171320230014\"}]},\"parts\":{\"product\":{\"name\":\"7.47\",\"type\":\"talkTime\"},\"serviceBalance\":{\"desc\":\"136.47\"}},\"validityPeriod\":{\"toDate\":{\"value\":\"06/06/2021 00:00:00\"}}}],\"MetaInfoResponse\":{\"Correlation\":{\"conversationID\":\"12345\"},\"Destination\":{\"system\":\"UPSS.RetriveLastFiveRecharge\"},\"ResultStatus\":{\"description\":[\"0\",\"The message has processed successfully\"],\"errorCode\":\"VEAI00000I\"},\"RouteInfo\":{\"route\":[{\"id\":\"BalanceTopup.GetList\",\"keys\":{\"key\":[{\"value\":\"Prepaid\"}]}}]},\"Source\":{\"division\":\"0020\",\"system\":\"USSD\"}}}}"
		 * ; System.out.println(uniqueId + ": Response retriveLastFiveRecharge json-> "
		 * + response.toString());
		 * 
		 * JsonObject jobj = new Gson().fromJson(response, JsonObject.class); JsonObject
		 * jo = jobj.get("GetBalanceTopupRequestListVBMResponse").getAsJsonObject();
		 * JsonArray ja = jo.get("balanceTopupRequestVBO").getAsJsonArray();
		 * //System.out.println(ja.toString());
		 * 
		 * if (ja.size() == 0) { System.out.println(uniqueId +
		 * ": No recharge details exist"); responseUser =
		 * "respcode=-1|Sorry! No Data available|";
		 * 
		 * } else { //System.out.println(ja.size()); responseUser =
		 * "respcode=0|Last Five Recharges are \n S.No-Type-Amt-DtTime \n"; int counter
		 * = 0;
		 * 
		 * for (int i = 0; i < ja.size(); i++) { //JsonArray jobj2 =
		 * ja.get(i).getAsJsonArray(); JsonObject data = ja.get(i).getAsJsonObject();
		 * JsonPrimitive amount =
		 * data.getAsJsonObject("details").getAsJsonObject("amount")
		 * .getAsJsonPrimitive("value"); JsonPrimitive productType =
		 * data.getAsJsonObject("parts").getAsJsonObject("product")
		 * .getAsJsonPrimitive("type"); JsonPrimitive created =
		 * data.getAsJsonObject("created").getAsJsonPrimitive("value"); //
		 * System.out.println(++counter + "-"+productType.getAsString()+"-"+ //
		 * amount.getAsString()+"-"+created.getAsString()); responseUser = responseUser
		 * + ++counter + "-" + productType.getAsString() + "-" + amount.getAsString() +
		 * "-" + created.getAsString() + "\n"; } } } catch (Exception ex) {
		 * ex.printStackTrace(); responseUser =
		 * "respcode=-1|Error while hitting retriveLastFiveRecharge Api |" +
		 * ex.getMessage(); } logger.info("Response-recharges|{}|{}|{}|{}|{}", uniqueId,
		 * msisdn, circleId, systemId, responseUser.replace("\n","|")); return
		 * responseUser;
		 */
		
		return null;
	}
}
