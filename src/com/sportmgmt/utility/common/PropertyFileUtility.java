package com.sportmgmt.utility.common;

import java.util.ResourceBundle;

import com.sportmgmt.utility.constrant.SportConstrant;

public class PropertyFileUtility {
	public ResourceBundle getEnvProperty() throws Exception {
		return ResourceBundle.getBundle(SportConstrant.ENV_FILE_NAME);
	}		
}
