package demo.microservice.carinfo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

@Configuration
public class AppConfiguration {
	
	@Bean
	//@LoadBalanced
	public RestTemplate getRestTemplate() {
		
		// 1. HttpComponentsClientHttpRequestFactory
		HttpComponentsClientHttpRequestFactory clientHttpRequestFactory = getClientHttpRequestFactory();
	    
	    // 2. SimpleClientHttpRequestFactory
		@SuppressWarnings("unused")
		SimpleClientHttpRequestFactory clientHttpRequestFactory_V2 = getClientHttpRequestFactory_V2();
	    
		return new RestTemplate(clientHttpRequestFactory); // or clientHttpRequestFactory_V2
	}
	
	// 1. HttpComponentsClientHttpRequestFactory
	// Add timeout for fault tolerance
	private HttpComponentsClientHttpRequestFactory getClientHttpRequestFactory() {
		
		
		HttpComponentsClientHttpRequestFactory clientHttpRequestFactory = new HttpComponentsClientHttpRequestFactory();
		
		//Connect timeout
	    clientHttpRequestFactory.setConnectTimeout(5000);
	     
	    //Read timeout
	    clientHttpRequestFactory.setReadTimeout(5000);
	    
		return clientHttpRequestFactory;
	}
	
	// 1. HttpComponentsClientHttpRequestFactory
	private SimpleClientHttpRequestFactory getClientHttpRequestFactory_V2() {
		
		SimpleClientHttpRequestFactory clientHttpRequestFactory = new SimpleClientHttpRequestFactory();
		
		//Connect timeout
	    clientHttpRequestFactory.setConnectTimeout(5000);
	     
	    //Read timeout
	    clientHttpRequestFactory.setReadTimeout(5000);
	    
		return clientHttpRequestFactory;
	}

}
