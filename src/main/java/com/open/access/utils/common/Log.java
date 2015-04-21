package com.open.access.utils.common;

import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Log {
	public static Logger logger = Logger.getLogger("com.kiwi.spring");
	private static FileHandler fh;
	
	static{
		 try {
			 //fh = new FileHandler("CNEN_log.txt");
			 //fh = new FileHandler("D:\\loging.log");
			 //logger.addHandler(fh);
		} catch (Exception e) {
			 logger.log(Level.INFO, "Log file couldn't be created.");
			e.printStackTrace();
		}
	 }
}
