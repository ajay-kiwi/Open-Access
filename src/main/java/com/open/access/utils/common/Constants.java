/**
 * 
 */
package com.open.access.utils.common;

import java.io.File;
import java.util.HashMap;

/**
 * @author kiwitech
 *
 */
public class Constants {

	public static String OA_BASE_URL = "https://acc.vtw.elsevier.com/property";
	public static String PATH_STRING_PII = "pii";
	public static String PATH_STRING_ISSN = "issn";

	//Category Per Class for OA
	public static String KEY_OA_JOURNALGROUP = "oa:journalGroup";
	public static String KEY_OA_ISSUEGROUP = "oa:issueGroup";
	public static String KEY_OA_ARTICLEGROUP = "oa:articleGroup";
	public static String KEY_OAW_OPENACCESSWINDOW = "oaw:openAccessWindow";
	public static String KEY_OA_OPENACCESSGROUP = "oa:openAccessGroup";

	//Properties Per Class for OA
	public static String KEY_OA_OPENACCESSINHERITEDFROM = "oa:openAccessInheritedFrom";
	public static String KEY_OA_HASOPENACCESSWINDOW = "oa:hasOpenAccessWindow";
	
	public static String KEY_OA_OPENACCESSSTATUS = "oa:openAccessStatus";
	public static String KEY_OA_OPENACCESSEFFECTIVE = "oa:openAccessEffective";
	public static String KEY_OA_SPONSOR = "oa:sponsor";
	public static String KEY_OA_USERLICENSE = "oa:userLicense";
	public static String KEY_OA_ALLOWSUSERLICENSE = "oa:allowsUserLicense";
	public static String KEY_OA_WINDOWTYPE = "oa:windowType";
	public static String KEY_OA_ALLOWSAUTHORPAID = "oa:allowsAuthorPaid";
	public static String KEY_OA_SPONSORTYPE = "oa:sponsorType";
	public static String KEY_OA_SPONSORNAME = "oa:sponsorName";
	public static String KEY_OA_ECM_TIMEWINDOW = "ecm:timeWindow";
	public static String KEY_OA_ECM_WINDOWSTARTTYPE = "ecm:windowStartType";
	public static String KEY_OA_ECM_WINDOWENDTYPE = "ecm:windowEndType";
	public static String KEY_OA_ECM_WINDOWSTARTUPDATEFREQUENCY = "ecm:windowStartUpdateFrequency";
	public static String KEY_OA_ECM_WINDOWENDUPDATEFREQUENCY = "ecm:windowEndUpdateFrequency";
	public static String KEY_OA_ECM_ENDOFFSET = "ecm:windowEndOffset";
	public static String KEY_OA_ECM_STARTTIME = "ecm:windowStartTime";
	public static String KEY_OA_ECM_ENDTIME = "ecm:windowEndTime";
		
	public static String usernameForPS = "ha_consumer";
	public static String passwordForPS = "Welcome2VTW";
	
	public static String ATOMXML_PATH = System.getProperty("user.home") + File.separator + "temp";
	
	public static String URL_CONDITION_CATEGORY="category";
	public static String URL_CONDITION_PROPERTY="property";
	
	public static String URL_CONDITION_GT="gt";
	public static String URL_CONDITION_LT="lt";
	
	public static String DELIMITER_STRINGBUFFER_HASH = "#";
	public static String DELIMITER_STRINGBUFFER_QUAMA = ",";
	
	public static HashMap<String, String> PROPERTY_KEY_MAP = new HashMap<String, String>();
	static{
		PROPERTY_KEY_MAP.put("KEY_OA_OPENACCESSSTATUS", KEY_OA_OPENACCESSSTATUS);
		PROPERTY_KEY_MAP.put("KEY_OA_OPENACCESSEFFECTIVE", KEY_OA_OPENACCESSEFFECTIVE);
		PROPERTY_KEY_MAP.put("KEY_OA_OPENACCESSINHERITEDFROM", KEY_OA_OPENACCESSINHERITEDFROM);
		PROPERTY_KEY_MAP.put("KEY_OA_SPONSOR", KEY_OA_SPONSOR);
		PROPERTY_KEY_MAP.put("KEY_OA_USERLICENSE", KEY_OA_USERLICENSE);
		PROPERTY_KEY_MAP.put("KEY_OA_ALLOWSUSERLICENSE", KEY_OA_ALLOWSUSERLICENSE);
		PROPERTY_KEY_MAP.put("KEY_OA_WINDOWTYPE", KEY_OA_WINDOWTYPE);
		PROPERTY_KEY_MAP.put("KEY_OA_ALLOWSAUTHORPAID", KEY_OA_ALLOWSAUTHORPAID);
		PROPERTY_KEY_MAP.put("KEY_OA_HASOPENACCESSWINDOW", KEY_OA_HASOPENACCESSWINDOW);
		PROPERTY_KEY_MAP.put("KEY_OA_SPONSORTYPE", KEY_OA_SPONSORTYPE);
		PROPERTY_KEY_MAP.put("KEY_OA_SPONSORNAME", KEY_OA_SPONSORNAME);
		PROPERTY_KEY_MAP.put("KEY_OA_ECM_TIMEWINDOW", KEY_OA_ECM_TIMEWINDOW);
		PROPERTY_KEY_MAP.put("KEY_OA_ECM_WINDOWSTARTTYPE", KEY_OA_ECM_WINDOWSTARTTYPE);
		PROPERTY_KEY_MAP.put("KEY_OA_ECM_WINDOWENDTYPE", KEY_OA_ECM_WINDOWENDTYPE);
		PROPERTY_KEY_MAP.put("KEY_OA_ECM_WINDOWSTARTUPDATEFREQUENCY", KEY_OA_ECM_WINDOWSTARTUPDATEFREQUENCY);
		PROPERTY_KEY_MAP.put("KEY_OA_ECM_WINDOWENDUPDATEFREQUENCY", KEY_OA_ECM_WINDOWENDUPDATEFREQUENCY);
		PROPERTY_KEY_MAP.put("KEY_OA_ECM_ENDOFFSET", KEY_OA_ECM_ENDOFFSET);
		PROPERTY_KEY_MAP.put("KEY_OA_ECM_STARTTIME", KEY_OA_ECM_STARTTIME);
		PROPERTY_KEY_MAP.put("KEY_OA_ECM_ENDTIME", KEY_OA_ECM_ENDTIME);
	}
}