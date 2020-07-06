package demo.microservice.carinfo.manufacturer.microservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;

import demo.microservice.carinfo.dto.ManufacturerDto;
import demo.microservice.carinfo.util.AppUtils;

@Service(value="manufacturerMicroService")
public class ManufacturerMicroService {
	
	@Autowired
	AppUtils appUtils;
	
	@Autowired
	RestTemplate restTemplate;
	
	@HystrixCommand(
		fallbackMethod = "getFallback",
		commandProperties = {
			@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "500"),
			//@HystrixProperty(name = "metrics.rollingStats.timeInMilliseconds", value = "500"),
			@HystrixProperty(name = "circuitBreaker.requestVolumeThreshold", value = "5"),
			@HystrixProperty(name = "circuitBreaker.errorThresholdPercentage", value = "50"),
			@HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds", value = "10000")
		}
	)
	public ManufacturerDto get(Integer manufacturerid) {
		
		ManufacturerDto dto = null;
		
		StringBuilder serviceUriBuilder = new StringBuilder(appUtils.getServiceUri("SB-CAR-MANUFACTURER-SERVICE"));
		serviceUriBuilder.append("/manufacturers/").append(manufacturerid.toString());
		
		// Make call to manufacturer service for each car manufacturer's id
		dto = restTemplate.getForObject(serviceUriBuilder.toString(), ManufacturerDto.class);
		
		return dto;
		
	}
	
	public ManufacturerDto getFallback(Integer manufacturerid) {
		
		return new ManufacturerDto(manufacturerid, "NA");
		
	}
	
	@HystrixCommand(
		fallbackMethod = "getFallback",
		threadPoolKey = "manufacturerServicePool",
		threadPoolProperties = {
			@HystrixProperty(name = "coreSize", value = "5"),
			@HystrixProperty(name = "maxQueued", value = "2")
		}
	)
	public ManufacturerDto anotherGet(Integer manufacturerid) {
		
		ManufacturerDto dto = null;
		
		StringBuilder serviceUriBuilder = new StringBuilder(appUtils.getServiceUri("SB-CAR-MANUFACTURER-SERVICE"));
		serviceUriBuilder.append("/manufacturers/").append(manufacturerid.toString());
		
		// Make call to manufacturer service for each car manufacturer's id
		dto = restTemplate.getForObject(serviceUriBuilder.toString(), ManufacturerDto.class);
		
		return dto;
		
	}

}
