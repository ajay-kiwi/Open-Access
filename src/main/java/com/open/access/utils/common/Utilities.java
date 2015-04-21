package com.open.access.utils.common;

import static com.open.access.utils.common.Constants.KEY_OA_HASOPENACCESSWINDOW;
import static com.open.access.utils.common.Constants.KEY_OA_OPENACCESSINHERITEDFROM;

import java.util.logging.Level;

import org.glassfish.jersey.client.authentication.HttpAuthenticationFeature;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class Utilities {

	/**
	 * This method is used to creating criteria url
	 * @param identifier_prefix
	 * @param identifier_id
	 * @param key
	 * @return
	 */
	public static String getCriteriaURL(String identifier_prefix, String identifier_id, String key) {
		
		Log.logger.log(Level.INFO, "getCriteriaURL method called...");
		
		return Constants.OA_BASE_URL + "/" + identifier_prefix + "/" + identifier_id + "?category=" + key;
	}
	
	/**
	 * This method is used to creating property url
	 * @param identifier_prefix
	 * @param identifier_id
	 * @param key
	 * @return
	 */
	public static String getPropertyURL(String identifier_prefix, String identifier_id, String key) {
		
		Log.logger.log(Level.INFO, "getPropertyURL method called...");
		
		return Constants.OA_BASE_URL + "/" + identifier_prefix + "/" + identifier_id + "?key=" + key;
	}
	
	/**
	 * This method is used to setting up acc credentials that are used for authentications
	 * @return
	 */
	public static HttpAuthenticationFeature provideAuthenticationForPs() {
		
		Log.logger.log(Level.INFO, "provideAuthenticationForPs method called...");
		
		String authString = wsAuthCode();
		HttpAuthenticationFeature authenticationFeature = HttpAuthenticationFeature
    			.universalBuilder()
    			.credentialsForDigest(authString.split("#")[0], authString.split("#")[1])
    			.build();
		return authenticationFeature;
	}

	/**
	 * This method is used to arranging and setting up credentials using '#' delimeter
	 * @return
	 */
	public static String wsAuthCode() {
		
		Log.logger.log(Level.INFO, "wsAuthCode method called...");
		
		return Constants.usernameForPS+"#"+Constants.passwordForPS;
	}
	
    public StringBuffer removeStringFromStringBuffer(StringBuffer stringBuffer, String stringToRemove) {
    	
    	Log.logger.log(Level.INFO, "removeStringFromStringBuffer method called...");
    	
    	String[] tempArray = stringBuffer.toString().split(Constants.DELIMITER_STRINGBUFFER_HASH);
    	String[] tempArray2 = new String[tempArray.length];
    	for (int i = 0; i < tempArray.length; i++) {
			if(!tempArray[i].equals(stringToRemove))
				tempArray2[i] = tempArray[i];
		}
    	
    	StringBuffer newBuffer = new StringBuffer();	
    	for (int i = 0; i < tempArray2.length; i++) {
			if(null != tempArray2[i] || !"".equals(tempArray2[i]))
				newBuffer.append(tempArray2[i]+"#");
		}
    	return newBuffer;
    }
    
    /**
     * This method is used to check input string is null or blank.
     * @param toCheck
     * @return
     */
    public static boolean checkIfStringIsNullOrBlank(String toCheck) {
    	
    	Log.logger.log(Level.INFO, "checkIfStringIsNullOrBlank method called...");
    	
    	boolean resultToReturn = false;
    	if(null == toCheck || !"".equals(toCheck))
    		resultToReturn = true;
    	return resultToReturn;
    }
    
    /**
     * This method will check that the json key has inner url or not
     * @param response
     * @return
     */
    public static int hasInnerURL(JSONObject response){
    	
    	Log.logger.log(Level.INFO, "hasInnerURL method called...");
    	
    	JSONArray jArray = null;
    	String jObject = null;
    	
    	String obj = (String) response.get(KEY_OA_HASOPENACCESSWINDOW);
    	if(obj != null && !obj.equals(""))
    		jArray = (JSONArray) response.get(KEY_OA_HASOPENACCESSWINDOW);
    	
    	String obj1 = (String) response.get(KEY_OA_OPENACCESSINHERITEDFROM);
    	if(obj1 != null && !obj1.equals(""))
    		jObject = (String) response.get(KEY_OA_OPENACCESSINHERITEDFROM);
    	
    	if(jArray != null)
    		return 1;
    	if(jObject != null)
    		return 2;
    	
    	return 3;
	}
    
    /**
     * This method is used for getting inner url
     * @param response
     * @return
     */
    public static String[] getInnerURLDetails(JSONObject response){
    	
    	Log.logger.log(Level.INFO, "getInnerURLDetails method called...");
    	
    	String[] urls = null;
    	String jObject = null;
    	JSONArray jArray = null;
    	
    	jObject = (String) response.get(KEY_OA_OPENACCESSINHERITEDFROM);
    	jArray = (JSONArray) response.get(KEY_OA_HASOPENACCESSWINDOW);
    	
    	if(jObject != null){
    		urls = new String[jObject.length()];
    		urls[0] = jObject.toString();
    	} else{
    		urls = new String[jArray.size()];
    		for (int i = 0; i < jArray.size(); i++) {
    			jArray.get(i);
			}
    	}
    	return urls;
	}
}
