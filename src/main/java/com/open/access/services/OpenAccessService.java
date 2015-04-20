package com.open.access.services;

import static com.open.access.utils.common.Constants.KEY_OA_JOURNALGROUP;
import static com.open.access.utils.common.Constants.KEY_OAW_OPENACCESSWINDOW;
import static com.open.access.utils.common.Constants.KEY_OA_ARTICLEGROUP;
import static com.open.access.utils.common.Constants.KEY_OA_ISSUEGROUP;
import static com.open.access.utils.common.Constants.KEY_OA_OPENACCESSGROUP;

import static com.open.access.utils.common.Constants.KEY_OA_HASOPENACCESSWINDOW;
import static com.open.access.utils.common.Constants.KEY_OA_OPENACCESSINHERITEDFROM;

import static com.open.access.utils.common.Service.openConnectionAndFetchDetails;
import static com.open.access.utils.common.Service.saveData;
import static com.open.access.utils.common.Service.getData;
import static com.open.access.utils.common.Utilities.getCriteriaURL;
import static com.open.access.utils.common.Utilities.hasInnerURL;
import static com.open.access.utils.common.Utilities.getInnerURLDetails;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class OpenAccessService {

	public static void main(String[] args) throws Exception {
		
		OpenAccessService oas = new OpenAccessService();
		oas.getCategoriesDetails("issn", "1873-0418");
		
		oas.settingupLabels();
	}
	
	/**
	 * This method is used for getting category details using issn number or pii number
	 * @param identifier_prefix
	 * @param identifier_id
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	public void getCategoriesDetails(String identifier_prefix, String identifier_id) throws Exception{

		JSONArray jArray = new JSONArray();
		JSONArray jArray1 = new JSONArray();
		JSONParser parser = new JSONParser();
		JSONObject jObj = null, jsonObject = null, finalJsonObject = new JSONObject();
		
		String[] str = {KEY_OA_JOURNALGROUP, KEY_OA_ISSUEGROUP, KEY_OA_ARTICLEGROUP, KEY_OAW_OPENACCESSWINDOW, KEY_OA_OPENACCESSGROUP}; 
		
		for (int i = 0; i < str.length; i++) {
			
			System.out.println("Process Started..."+ i);

			jObj = (JSONObject)parser.parse(openConnectionAndFetchDetails(getCriteriaURL(identifier_prefix, identifier_id, str[i])));
			jsonObject = new JSONObject();
			jsonObject.put(str[i], jObj);

			System.out.println("Process End...");
			int result = hasInnerURL(jObj);
			if(result == 1){
				String[] urls = getInnerURLDetails(jObj);
				for (String url : urls) {
					System.out.println("inner url..."+ url);
					jObj = (JSONObject)parser.parse(openConnectionAndFetchDetails(url));
					jArray1.add(jObj);
				}

				jsonObject.put(KEY_OA_HASOPENACCESSWINDOW, jArray1);
			} else if(result == 2){
				String[] urls = getInnerURLDetails(jObj);
				jObj = (JSONObject)parser.parse(openConnectionAndFetchDetails(urls[0]));

				jsonObject.put(KEY_OA_OPENACCESSINHERITEDFROM, jObj);
			}

			jArray.add(jsonObject);
		}
		
		finalJsonObject.put(identifier_id, jArray);
		saveData(finalJsonObject.toString());
	}
	

	/**
	 * This method is used for setting up labels on the basis of different cases
	 * @throws Exception
	 */
	public void settingupLabels() throws Exception{

		getData();
	}
}
