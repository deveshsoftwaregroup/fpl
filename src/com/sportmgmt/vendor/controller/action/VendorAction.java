package com.sportmgmt.vendor.controller.action;

import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.ravij.crypto.EncodeDecoder;
import com.sportmgmt.model.manager.UserManager;
import com.sportmgmt.utility.constrant.SportConstrant;
import com.sportmgmt.vendor.model.manager.VendorManager;

@Controller
@RequestMapping("/vendor")

public class VendorAction {
private Logger logger = Logger.getLogger(VendorAction.class);

@RequestMapping(value = "vendorregister", method = RequestMethod.POST)
public String userRegister(ModelMap modeMap,@RequestParam Map<String,String> vendorMap)
{
	logger.info("Entry in register method model Map: "+modeMap);
	if(vendorMap.get("emailId") == null || vendorMap.get("emailId").equals(SportConstrant.NULL))
	{
		modeMap.put("emailIdError", "emailId is required");
	}
	if(vendorMap.get("displayName") == null || vendorMap.get("displayName").equals(SportConstrant.NULL))
	{
		modeMap.put("displayName", "name is required");
}
	if(vendorMap.get("logonId") == null || vendorMap.get("logonId").equals(SportConstrant.NULL))
	{
		vendorMap.put("logonId", vendorMap.get("emailId"));
	}
	if(vendorMap.get("logonPassword") == null || vendorMap.get("logonPassword").equals(SportConstrant.NULL))
	{
		modeMap.put("logonPasswordError", "User Password is required");
	}
	else
	{
		logger.info("--------- password: "+vendorMap.get("logonPassword"));
		try
		{
			vendorMap.put("logonPassword", EncodeDecoder.encrypt(vendorMap.get("logonPassword")));
			logger.info("--------- password: After Encoding:  "+vendorMap.get("logonPassword"));
		}
		catch(Exception ex)
		{
			logger.error("--------- Error in encoding password: "+ex);
		}
	}
	logger.info("------------ Error Map: "+modeMap);
	if(modeMap.isEmpty())
	{
		boolean isRegistered = VendorManager.saveVendor(vendorMap);
		modeMap.put("isRegistered",isRegistered);
		if(isRegistered)
		{
			modeMap.put("message","Congrats ! You are registered successfully!");
		}
		else
		{
			modeMap.put("message","Your Registration is failed as :  "+UserManager.getErrorMessage());
		}
	}
	else
	{
		modeMap.put("isRegistered",false);
		modeMap.put("message","Your Registration is failed due to incomplete info");
	}
	return "redirect:/mvc/VendorHome";
}
	
}

	
	
	
	