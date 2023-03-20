package com.spice.chotacredit.response;
import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Generated("jsonschema2pojo")
public class Route {

/**
*
* (Required)
*
*/
@SerializedName("id")
@Expose
private String id;
/**
*
* (Required)
*
*/
@SerializedName("keys")
@Expose
private Keys keys;

/**
*
* (Required)
*
*/
public String getId() {
return id;
}

/**
*
* (Required)
*
*/
public void setId(String id) {
this.id = id;
}

/**
*
* (Required)
*
*/
public Keys getKeys() {
return keys;
}

/**
*
* (Required)
*
*/
public void setKeys(Keys keys) {
this.keys = keys;
}

}