package demo.microservice.carinfo.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;
import com.netflix.discovery.shared.Application;

@Component(value="appUtils")
public class AppUtils {
	
	@Autowired
	@Lazy
	private EurekaClient eurekaClient;
	
	public String getServiceUri(String appName) {
    	
    	StringBuilder serviceUriBuilder = new StringBuilder();
    		
		InstanceInfo instance = eurekaClient.getNextServerFromEureka(appName, false);
		if(instance != null) {
			serviceUriBuilder.append(instance.getHomePageUrl()).append("manufacturer-service");
		}
    	
    	return serviceUriBuilder.toString();
    	
	}
	
	public Application getApplication(String appName) {
		return eurekaClient.getApplication(appName);
	}
	
}
