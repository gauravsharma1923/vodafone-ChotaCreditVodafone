package com.spice.chotacredit.request;
import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Generated("jsonschema2pojo")
public class Correlation {

/**
*
* (Required)
*
*/
@SerializedName("conversationID")
@Expose
private String conversationID;

/**
*
* (Required)
*
*/
public String getConversationID() {
return conversationID;
}

/**
*
* (Required)
*
*/
public void setConversationID(String conversationID) {
this.conversationID = conversationID;
}

}