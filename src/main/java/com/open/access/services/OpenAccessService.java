package com.open.access.services;

import static com.open.access.utils.common.Constants.KEY_OAW_OPENACCESSWINDOW;
import static com.open.access.utils.common.Constants.KEY_OA_ARTICLEGROUP;
import static com.open.access.utils.common.Constants.KEY_OA_HASOPENACCESSWINDOW;
import static com.open.access.utils.common.Constants.KEY_OA_ISSUEGROUP;
import static com.open.access.utils.common.Constants.KEY_OA_JOURNALGROUP;
import static com.open.access.utils.common.Constants.KEY_OA_OPENACCESSGROUP;
import static com.open.access.utils.common.Service.openConnectionAndFetchDetails;
import static com.open.access.utils.common.Utilities.getCriteriaURL;
import static com.open.access.utils.common.Utilities.hasInnerURL;
import static com.open.access.utils.common.Utilities.getInnerURL;
import static com.open.access.utils.common.Service.saveData;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class OpenAccessService {

	public static void main(String[] args) throws Exception {
		
		OpenAccessService oas = new OpenAccessService();
		oas.getCategoriesDetails("issn", "0735-1097");
	}
	
	/**
	 * This method is used for getting category details using issn number or pii number
	 * @param identifier_prefix
	 * @param identifier_id
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	public void getCategoriesDetails(String identifier_prefix, String identifier_id) throws Exception{

		JSONObject jObj = null, finalJsonObject = null;
		JSONParser parser = new JSONParser();
		JSONObject jsonObject = new JSONObject();
		
		System.out.println("Process Started...");
		jObj = (JSONObject)parser.parse(openConnectionAndFetchDetails(getCriteriaURL(identifier_prefix, identifier_id, KEY_OA_JOURNALGROUP)));
		
		if(hasInnerURL(jObj) == 1){
			
			/*	String[] urls = getInnerURL(jObj);
			for (String url : urls) {
				jObj = (JSONObject)parser.parse(openConnectionAndFetchDetails(url));
				finalJsonObject.p
			}*/
			
		} else
			jsonObject.put(KEY_OA_JOURNALGROUP, "jObj");

		jsonObject.put(KEY_OA_ISSUEGROUP, (JSONObject)parser.parse(openConnectionAndFetchDetails(getCriteriaURL(identifier_prefix, identifier_id, KEY_OA_ISSUEGROUP))));
		jsonObject.put(KEY_OA_ARTICLEGROUP, (JSONObject)parser.parse(openConnectionAndFetchDetails(getCriteriaURL(identifier_prefix, identifier_id, KEY_OA_ARTICLEGROUP))));
		jsonObject.put(KEY_OAW_OPENACCESSWINDOW, (JSONObject)parser.parse(openConnectionAndFetchDetails(getCriteriaURL(identifier_prefix, identifier_id, KEY_OAW_OPENACCESSWINDOW))));
		jsonObject.put(KEY_OA_OPENACCESSGROUP, (JSONObject)parser.parse(openConnectionAndFetchDetails(getCriteriaURL(identifier_prefix, identifier_id, KEY_OA_OPENACCESSGROUP))));
		System.out.println("Process End...");
		
		saveData(jsonObject.toString());
	}
}
