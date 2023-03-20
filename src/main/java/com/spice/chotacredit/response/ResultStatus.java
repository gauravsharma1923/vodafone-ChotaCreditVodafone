package com.spice.chotacredit.response;
import java.util.List;
import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Generated("jsonschema2pojo")
public class ResultStatus {

/**
*
* (Required)
*
*/
@SerializedName("errorCode")
@Expose
private String errorCode;
/**
*
* (Required)
*
*/
@SerializedName("description")
@Expose
private List<Object> description = null;
/**
*
* (Required)
*
*/
@SerializedName("category")
@Expose
private String category;

/**
*
* (Required)
*
*/
public String getErrorCode() {
return errorCode;
}

/**
*
* (Required)
*
*/
public void setErrorCode(String errorCode) {
this.errorCode = errorCode;
}

/**
*
* (Required)
*
*/
public List<Object> getDescription() {
return description;
}

/**
*
* (Required)
*
*/
public void setDescription(List<Object> description) {
this.description = description;
}

/**
*
* (Required)
*
*/
public String getCategory() {
return category;
}

/**
*
* (Required)
*
*/
public void setCategory(String category) {
this.category = category;
}

}