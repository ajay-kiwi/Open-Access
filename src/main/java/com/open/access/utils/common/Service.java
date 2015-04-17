package com.open.access.utils.common;

import static com.open.access.utils.common.Utilities.provideAuthenticationForPs;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;

public class Service {

	/**
	 * This method is used to open acc connection and fetch json detail
	 * @param targetURL
	 * @return json string
	 */
	public static String openConnectionAndFetchDetails(String targetURL) {

		
		Client client = ClientBuilder.newClient();
		
		/******* registering vtw credentials here that are used to authentication ********/
		client.register(provideAuthenticationForPs());

		WebTarget target = client.target(targetURL);
		Invocation.Builder invocationBuilder = target.request();

		/******* getting json response as string ********/
		String response = invocationBuilder.get(String.class);
		
		return response.toString();
	}
	
	/**
	 * This method is used to saving json data in a temp.txt file that is created in temp folder of user's home directory
	 * @param response
	 */
	public static void saveData(String response){
		
		File path = new File(Constants.ATOMXML_PATH);
		File file = new File(Constants.ATOMXML_PATH + File.separator + "temp.txt");

		try {
			if(!path.exists())
				path.mkdirs();

			if (file.exists()) {
				file.delete();
				file.createNewFile();
			}
			else if(!file.exists())
				file.createNewFile();

			FileWriter fw = new FileWriter(file.getAbsoluteFile());
			BufferedWriter bw = new BufferedWriter(fw);
			bw.write(response);
			bw.close();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}
