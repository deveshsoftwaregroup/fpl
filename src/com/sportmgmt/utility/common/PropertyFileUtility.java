package com.sportmgmt.utility.common;

import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import com.sportmgmt.utility.constrant.SportConstrant;

public class PropertyFileUtility {
	public static ResourceBundle getEnvProperty() throws Exception {		
		//ResourceBundle.getBundle(SportConstrant.ENV_FILE_NAME_COMMON);
		return ResourceBundle.getBundle(SportConstrant.ENV_FILE_NAME_LOCAL);
		//return ResourceBundle.getBundle(SportConstrant.ENV_FILE_NAME_STAGE);
		//return ResourceBundle.getBundle(SportConstrant.ENV_FILE_NAME_LIVE);
	}
	/*public static ResourceBundle getDBProperty() throws Exception {
		return ResourceBundle.getBundle("environmentLocal");
	}*/	
}
