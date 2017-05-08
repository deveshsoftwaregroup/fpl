package com.sportmgmt.api.football.client;

import java.util.List;

import org.springframework.web.client.RestTemplate;

import com.sportmgmt.api.football.response.MatchDetail;

public class FootBallAPIClient {
	
	public void getFootBallAPIForLeagues()
	{
		final String uri = "https://apifootball.com/api/?action=get_events&from=2016-10-30&to=2016-11-01&league_id=62&APIkey=04c7cae70bc2fa8d65973ea3808985c5e4c1b1bebcca634c52880a2e2d0fe80d";
	     
	    RestTemplate restTemplate = new RestTemplate();
	    //String result = restTemplate.getForObject(uri, String.class);
	    //List<MatchDetail> matchDetailList = restTemplate.getForObject(uri, List.class);
	    MatchDetail[] matchDetailList = restTemplate.getForObject(uri, MatchDetail[].class); 
	   // System.out.println(result);
	    //System.out.println(((MatchDetail)matchDetailList.get(0)).getMatchId());
	    //System.out.println(matchDetailList.get(0));
	    System.out.println("Object: "+matchDetailList[0]);
	    System.out.println("Match ID: "+matchDetailList[0].getMatchId());
	    
	}
	
	public static void main(String... str)
	{
		new FootBallAPIClient().getFootBallAPIForLeagues();
	}

}
