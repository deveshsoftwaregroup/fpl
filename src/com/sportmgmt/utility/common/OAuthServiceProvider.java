package com.sportmgmt.utility.common;

import org.scribe.builder.ServiceBuilder;
import org.scribe.builder.api.Api;
import org.scribe.oauth.OAuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.social.oauth2.OAuth2Parameters;

public class OAuthServiceProvider<T> {

	private OAuthServiceConfig<? extends Api> config;

	public OAuthServiceProvider() {
	}
    
	@Autowired
	private OAuth2Parameters oAuth2Parameters;
	
	public OAuthServiceProvider(OAuthServiceConfig<? extends Api> config) {
		this.config = config;
	}

	public OAuthService getService() {
		return new ServiceBuilder().provider(config.getApiClass())
				.apiKey(config.getApiKey()).apiSecret(config.getApiSecret())
				.callback(config.getCallback()).scope(oAuth2Parameters.getScope()).build();
	}

}
