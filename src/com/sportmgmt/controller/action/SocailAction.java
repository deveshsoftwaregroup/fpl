package com.sportmgmt.controller.action;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import org.apache.log4j.Logger;
import org.scribe.builder.api.FacebookApi;
import org.scribe.model.Verifier;
import org.scribe.oauth.OAuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.social.connect.UserProfile;
import org.springframework.social.connect.support.ConnectionFactoryRegistry;
import org.springframework.social.facebook.api.FacebookProfile;
import org.springframework.social.facebook.api.impl.FacebookTemplate;
import org.springframework.social.facebook.connect.FacebookConnectionFactory;
import org.springframework.social.oauth2.GrantType;
import org.springframework.social.oauth2.OAuth2Operations;
import org.springframework.social.oauth2.OAuth2Parameters;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;
import org.springframework.core.env.PropertyResolver;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sportmgmt.model.manager.PlanManager;
import com.sportmgmt.model.manager.UserManager;
import com.sportmgmt.utility.common.FacebookUtil;
import com.sportmgmt.utility.common.OAuthServiceProvider;
import org.scribe.model.Token;

@Controller
@RequestMapping(value = "/social")
public class SocailAction {
	
	/*private static final Logger LOGGER = Logger.
			.getLogger(FacebookController.class);*/
	private Logger logger = Logger.getLogger(SocailAction.class);
	private static final String FACEBOOK = "facebook";
	private static final String PUBLISH_SUCCESS = "facebookSuccess";
	private static final String PUBLISH_ERROR = "error";
    @Value("${app.config.oauth.facebook.apikey}")
	private  String clientID ;
    @Value("${app.config.oauth.facebook.apisecret}")
    private   String clientSecret ;
    @Value("${app.config.oauth.facebook.callback}")
    private   String redirectURI; 

    
	public  String getClientid() {
		return clientID;
	}

	public  String getClientsecret() {
		return clientSecret;
	}

	public  String getRedirecturi() {
		return redirectURI;
	}

	public String getClientID() {
		return clientID;
	}

	public void setClientID(String clientID) {
		this.clientID = clientID;
	}

	public String getClientSecret() {
		return clientSecret;
	}

	public void setClientSecret(String clientSecret) {
		this.clientSecret = clientSecret;
	}

	public String getRedirectURI() {
		return redirectURI;
	}

	public void setRedirectURI(String redirectURI) {
		this.redirectURI = redirectURI;
	}

	@Autowired
	private ConnectionFactoryRegistry connectionFactoryRegistry;

	@Autowired
	private OAuth2Parameters oAuth2Parameters;

	@Autowired
	FacebookUtil facebookUtil;

	@Autowired
	@Qualifier("facebookServiceProvider")
	private OAuthServiceProvider<FacebookApi> facebookServiceProvider;

	@RequestMapping(value = "/facebook/signin", method = RequestMethod.GET)
	public ModelAndView signin(HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		FacebookConnectionFactory facebookConnectionFactory = (FacebookConnectionFactory) connectionFactoryRegistry
				.getConnectionFactory(FACEBOOK);
		
		OAuth2Operations oauthOperations = facebookConnectionFactory
				.getOAuthOperations();
		
		
		String authorizeUrl = oauthOperations.buildAuthorizeUrl(
				GrantType.AUTHORIZATION_CODE, oAuth2Parameters);
		oAuth2Parameters.setScope("public_profile,email");
		logger.info("Authorization URL: "+authorizeUrl);
		System.out.println("authorizeUrl: "+authorizeUrl);
	    
		
		RedirectView redirectView = new RedirectView(authorizeUrl, true, true,
				true);

		return new ModelAndView(redirectView);
	}

	@RequestMapping(value = "facebook/callback", method = RequestMethod.GET)
	public String postOnWall(@RequestParam("code") String code,
			HttpServletRequest request,
			HttpServletResponse response,ModelMap modelMap) throws Exception {

		logger.info("----------------- Started call back method:");
		OAuthService oAuthService = facebookServiceProvider.getService();

		Verifier verifier = new Verifier(code);
		Token accessToken = oAuthService
				.getAccessToken(Token.empty(), verifier);

		/*FacebookTemplate template = new FacebookTemplate(accessToken.getToken());
		
		template.userOperations().G

		FacebookProfile facebookProfile = template.userOperations()
				.getUserProfile();

		String userId = facebookProfile.getId();*/

		//LOGGER.info("Logged in User Id : {}", userId);
		
		
		URL url = new URL("https://graph.facebook.com/me?access_token="
                + accessToken.getToken());
        System.out.println(url);
        URLConnection conn1 = url.openConnection();
        String outputString = "", line="";
        BufferedReader reader = new BufferedReader(new InputStreamReader(
                conn1.getInputStream()));
        while ((line = reader.readLine()) != null) {
            outputString += line;
        }
        reader.close();

		logger.info("logged in user: "+outputString);
		modelMap.put("userId", outputString);

		/*MultiValueMap<String, Object> map = facebookUtil
				.publishLinkWithVisiblityRestriction(state);
		try {
			template.publish(facebookProfile.getId(), "feed", map);
		} catch (Exception ex) {
			
			return PUBLISH_ERROR;
		}*/

		return PUBLISH_SUCCESS;
	}

	@RequestMapping(value = "/callback", params = "error_reason", method = RequestMethod.GET)
	@ResponseBody
	public void error(@RequestParam("error_reason") String errorReason,
			@RequestParam("error") String error,
			@RequestParam("error_description") String description,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		try {
			/*LOGGER.error(
					"Error occurred while validating user, reason is : {}",
					errorReason);*/
			response.sendError(HttpServletResponse.SC_UNAUTHORIZED, description);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@RequestMapping(value = "/facebook/login", method = RequestMethod.GET)
	public ModelAndView loginin(HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		String authorizeUrl = "https://www.facebook.com/dialog/oauth?client_id="+ clientID + "&redirect_uri=" + redirectURI +"&scope=public_profile"+"&scope=email";
		logger.info("Authorization URL: "+authorizeUrl);
		System.out.println("authorizeUrl: "+authorizeUrl);
		RedirectView redirectView = new RedirectView(authorizeUrl, true, true,
				true);

		return new ModelAndView(redirectView);
	}
		

	@RequestMapping(value = "facebook/recall", method = RequestMethod.GET)
	public String callBack(@RequestParam("code") String code,
			HttpServletRequest request,
			HttpServletResponse response,ModelMap modelMap) throws Exception {
		System.out.println("code=" + code);
		URL url = new URL(
                "https://graph.facebook.com/oauth/access_token?client_id="
                        + clientID + "&redirect_uri=" + redirectURI
                        + "&client_secret=" + clientSecret
                        + "&code=" + code);
        System.out.println("url===="+url);
        // request for Access Token
        HttpURLConnection conn = (HttpURLConnection) url
                .openConnection();
        
        
        conn.setRequestMethod("GET");
       
      
        String line, outputString = "";
        BufferedReader reader = new BufferedReader(
                new InputStreamReader(conn.getInputStream()));
        while ((line = reader.readLine()) != null) {
            outputString += line;
        }
        System.out.println(outputString);
        
        // extract access token from response
        String accessToken = null;
        
        if(outputString.indexOf("access_token")!=-1) {
        	
           try
           {
        	   accessToken = outputString.substring(13,outputString.indexOf("&"));
           }
           catch(Exception ex)
           {
        	   ObjectMapper mapperObj = new ObjectMapper();
   			   Map<String, String> facebookMap = new HashMap<String, String>();
   			   facebookMap = mapperObj.readValue(outputString, new TypeReference<Map<String, String>>(){});
   			   accessToken = facebookMap.get("access_token");
           }
        	
        }
				
		
		url = new URL("https://graph.facebook.com/me?fields=id,name,email&access_token="
                + accessToken);
		
		
        System.out.println(url);
        URLConnection conn1 = url.openConnection();
       

        
        
        outputString = ""; line="";
        reader = new BufferedReader(new InputStreamReader(
                conn1.getInputStream()));
        System.out.println("hjhhhhhhhh"+conn1.getInputStream());
        while ((line = reader.readLine()) != null) {
            outputString += line;
        }
        reader.close();
        System.out.println("logged in user: "+outputString);
		logger.info("logged in user: "+outputString);
		modelMap.put("userId", outputString);
		String redirectAction = getRedirectURL(outputString);
		if(redirectAction == null)
		redirectAction = PUBLISH_SUCCESS;
		return redirectAction;
	}
	private String getRedirectURL(String facebookJson)
	{
		String facebookUserId = "";
		String facebookName = "";
		String facebookEmail ="";
		try
		{
			ObjectMapper mapperObj = new ObjectMapper();
			Map<String, String> facebookMap = new HashMap<String, String>();

			facebookMap = mapperObj.readValue(facebookJson, new TypeReference<Map<String, String>>(){});
			facebookUserId = facebookMap.get("id");
			facebookName = facebookMap.get("name");
			facebookEmail = facebookMap.get("email");
			
					  
		}
		catch(Exception ex)
		{
			logger.error("Error occure during parsing facebook response",ex);
		}
		
		logger.info("------- facebookUserId: "+facebookUserId+" , facebookName: "+facebookName+",facebookEmailId:"+facebookEmail);
		if(facebookUserId != null && !facebookUserId.equals(""))
		{
			String userId = getUserId(facebookUserId,facebookName,facebookEmail);
			logger.info("---------- userId: "+userId);
			if(userId != null && !userId.equals(""))
			{
				logger.info("Going to redirect to application first pagee");
				return "redirect:/mvc/user11/login11/"+userId;
			}
		}
		return null;

	}
	private String getUserId(String facebookUserId,String facebookName, String facebookEmail )
	
	{
		
		logger.info("Checking user is first time or logined before to this site");
		String userId = UserManager.getUserIdByLogonId(facebookUserId);
		if(userId == null || userId.equals(""))
		{
			logger.info("User is first timmer, going to create user Id");
			Map<String,String> userMap = new HashMap<String,String>();
			userMap.put("logonId", facebookUserId);
			userMap.put("emailId", facebookEmail);
			userMap.put("logonPassword", facebookUserId);
			userMap.put("displayName", facebookName);
			userMap.put("userType", "F");
			if(UserManager.saveUser(userMap))
			{
				userId = UserManager.getUserId();
				PlanManager.addDefaultPlanToUser(userId);
				
			}
			else
			logger.error("Error occured to create userid in our database, error code: "+UserManager.getErrorCode()+" , message: "+UserManager.getErrorMessage());
			
		}
		return userId;
	}
	
	@RequestMapping(value = "/facebook/userLoginTest", method = RequestMethod.GET)
	public ModelAndView userLoginTest(HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		String redirectURL = getRedirectURL("{\"name\":\"Ravi Paagal\",\"id\":\"1342129129185745\"} ");
		if(redirectURL == null)
		redirectURL	= PUBLISH_SUCCESS;
		RedirectView redirectView = new RedirectView(redirectURL, true, true,
				true);

		return new ModelAndView(redirectView);
	}
	
	@RequestMapping(value = "/facebook/userLoginTest1", method = RequestMethod.GET)
	public String userLoginTest1(HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		String redirectURL = getRedirectURL("{\"name\":\"Ravi Paagal\",\"id\":\"1342129129185745\"} ");
		if(redirectURL == null)
		redirectURL	= PUBLISH_SUCCESS;
		return redirectURL;
	}



/*@RequestMapping(value = "facebook/Post", method = RequestMethod.POST)
public String post(@RequestParam("code") String code,
		HttpServletRequest request,
		HttpServletResponse response,ModelMap modelMap) throws Exception {
	System.out.println("code=" + code);
	URL url = new URL(
            "https://graph.facebook.com/oauth/access_token?client_id="
                    + clientID + "&redirect_uri=" + redirectURI
                    + "&client_secret=" + clientSecret
                    + "&code=" + code);
    System.out.println("url===="+url);
    // request for Access Token
    HttpURLConnection conn = (HttpURLConnection) url
            .openConnection();
    
    
    conn.setRequestMethod("GET");
    String line, outputString = "";
    BufferedReader reader = new BufferedReader(
            new InputStreamReader(conn.getInputStream()));
    while ((line = reader.readLine()) != null) {
        outputString += line;
    }
    System.out.println(outputString);
    
    // extract access token from response
    String accessToken = null;
    
    if(outputString.indexOf("access_token")!=-1) {
    	
       try
       {
    	   accessToken = outputString.substring(13,outputString.indexOf("&"));
       }
       catch(Exception ex)
       {
    	   ObjectMapper mapperObj = new ObjectMapper();
			   Map<String, String> facebookMap = new HashMap<String, String>();
			   facebookMap = mapperObj.readValue(outputString, new TypeReference<Map<String, String>>(){});
			   accessToken = facebookMap.get("access_token");
       }
    	
    }

	url = new URL("https://graph.facebook.com/me?feeds&access_token="
            + accessToken);
	
	
    System.out.println(url);
    URLConnection conn1 = url.openConnection();
    conn1.setDoOutput(true);
    OutputStreamWriter streamWriter = new OutputStreamWriter(conn1.getOutputStream());
    streamWriter.write(response.toString());
    streamWriter.flush();

    
    
    
    System.out.println("logged in user: "+outputString);
	logger.info("logged in user: "+outputString);
    

	return null;
}*/
}
