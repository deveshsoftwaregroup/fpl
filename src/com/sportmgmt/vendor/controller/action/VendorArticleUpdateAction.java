package com.sportmgmt.vendor.controller.action;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sportmgmt.model.manager.GameWeeKManager;
import com.sportmgmt.model.manager.PointRankManager;
import com.sportmgmt.utility.constrant.SportConstrant;
import com.sportmgmt.vendor.model.manager.VendorArticleUpdateManager;
import com.sportmgmt.vendor.model.manager.VendorManager;
import com.sportmgmt.vendor.model.entity.V_Article;

@Controller
@RequestMapping("/game")

public class VendorArticleUpdateAction {
	Logger logger = Logger.getLogger(VendorArticleUpdateAction.class);
	
	@RequestMapping(value = " updateVendorArticle/{articleId}/{vendorId}/{positionId}", method = RequestMethod.GET)
	public  String updateVendorArticle(ModelMap modeMap,@PathVariable String articleId,@PathVariable String vendorId,@PathVariable String positionId,HttpServletRequest request) throws Exception
	{
		try
		{
		modeMap.put("articleId", articleId);
		//System.out.println(modeMap);
		modeMap.put("vendorId", vendorId);
		//modeMap.put("Category", Category);
		modeMap.put("positionId", positionId);
		modeMap.put("isSuccess", true);
		}
		catch(Exception ex)
		{
			logger.error("Error to execute updateVendorArticle Action: "+ex);
			modeMap.put("isSuccess", false);
			modeMap.put("message", "Something went wrong");
		}
		return SportConstrant.VENDOR_HOME_PAGE;
	}
	@RequestMapping(value = "VendorHome", method = RequestMethod.POST)
	public  @ResponseBody Map<String, String> updateVendorArticle(ModelMap modeMap, @RequestParam Map<String,String>requestParam, HttpServletRequest request) 
	
	{
		Map<String,String> result = new java.util.HashMap<>();
		try
		{
			Integer vendorId = Integer.valueOf(requestParam.get("vendorId"));
			logger.info("------- vendorId-"+vendorId);
			List positionIdList = VendorArticleUpdateManager.fetchPositionIdByVendorId(String.valueOf(vendorId));
			Integer positionId = (Integer) positionIdList.get(0);
			logger.info("------- positionId-"+positionId);
			/*List positionPriceIdList = VendorManager.fetchPositionPriceIdByPositionId(String.valueOf(positionId));
			Integer positionPriceId =(Integer) positionPriceIdList.get(0);*/
			Integer positionPriceID = Integer.valueOf(requestParam.get("positionPriceID"));
			logger.info("------- positionPriceID-"+positionPriceID);
			//List articleIdList =  VendorArticleUpdateManager.fetchArticleIdByVendorId(String.valueOf(vendorId));
			//Integer articleId =(Integer) articleIdList.get(0);
			//logger.info("------- articleId-"+articleId);
			
			
			
			
			String category = requestParam.get("category");
			String heading = requestParam.get("heading");
			String content = requestParam.get("content");
			String link = requestParam.get("link");
	        System.out.println(category.toString());
			logger.info("------- gooing to insert article for vendor-");
			
			result.put("isSuccess", "true");
		
			//Integer gameId = GameWeeKManager.getGameIdByGameWeeKId(gameWeekId);
			java.util.List<Integer> vendorArticleToUpdateList = VendorArticleUpdateManager.insertVendorArticle(vendorId,positionId,positionPriceID,category,heading,content,link);
             System.out.println("jjjjjjjjjjj");
             
	}
		catch(Exception ex)
		{
			logger.error("---- Error occurs: "+ex);
			result.put("isSuccess", "false");
			result.put("errorMsg", "Technical error");
		}
		logger.info("result=="+result);
	   return result;
		
}
}
	


