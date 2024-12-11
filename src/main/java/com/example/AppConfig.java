package com.example;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.OkHttp3ClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

import okhttp3.OkHttpClient;

@Configuration
public class AppConfig {

	    @Bean
	    public RestTemplate restTemplate() {
	        OkHttpClient okHttpClient = new OkHttpClient.Builder().build();
	        return new RestTemplate(new OkHttp3ClientHttpRequestFactory(okHttpClient));
	    }
}
