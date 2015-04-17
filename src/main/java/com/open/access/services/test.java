package com.open.access.services;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class test {

	public static void main(String[] args) throws ParseException {
		
		JSONObject jObj = null;
		JSONParser parser = new JSONParser();
		JSONObject jsonObject = new JSONObject();
		JSONArray jArray = new JSONArray();
		
		String str = "{\"cat1\":{\"cat2\":[\"cat3\",\"cat4\"]}}";
		jObj = (JSONObject) parser.parse(str);
		jsonObject = (JSONObject) jObj.get("cat1");
		System.out.println(jsonObject);
		jArray = (JSONArray) jsonObject.get("cat2");
		System.out.println(jArray);
		String[] url = new String[jArray.size()];
		
		for (int i = 0; i < jArray.size(); i++) {
			url[0] = (String)jArray.get(i);
			
		}
		System.out.println(url[0] + " = " );
	}

}
