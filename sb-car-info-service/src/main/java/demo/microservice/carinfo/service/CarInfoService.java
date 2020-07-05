package demo.microservice.carinfo.service;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;
import com.netflix.discovery.shared.Application;

import demo.microservice.carinfo.dto.CarInfoDto;
import demo.microservice.carinfo.dto.ManufacturerDto;

@Service(value="carInfoService")
public class CarInfoService {
	
	@Autowired
	RestTemplate restTemplate;
	
	@Autowired
	@Lazy
	private EurekaClient eurekaClient;
	
	@Value("${spring.application.name}")
    private String appName;
	
	static List<CarInfoDto> carInfoList;

	static {
		
		carInfoList = Arrays.asList(
		
			new CarInfoDto(11, "Camry", 1),
			new CarInfoDto(22, "Altima", 2),
			new CarInfoDto(33, "Accord", 3),
			new CarInfoDto(44, "Fusion", 4)
		
		);
		
	}
	
    public String applicationName() {
		return String.format("Hello from '%s'!", eurekaClient.getApplication(appName).getName());
	}
    
    // Used for testing
    public String client() {
    	
    	Application application = eurekaClient.getApplication("SB-CAR-MANUFACTURER-SERVICE");
    	if(application != null) {
    		
    		InstanceInfo instanceInfo = application.getInstances().get(0);
    		String a = "http://" + instanceInfo.getHostName() + ":" + instanceInfo.getPort() + "/" +instanceInfo.getVIPAddress()+"/";

    		InstanceInfo instance = eurekaClient.getNextServerFromEureka("SB-CAR-MANUFACTURER-SERVICE", false);
    		String b = instance.getHomePageUrl() + instance.getVIPAddress()+"/";
    		
    		return a + "<br/>" + b;
    	
    	}
    	
    	return "NULL";
	}
    
    private String getServiceUri(String appName) {
    	
    	StringBuilder serviceUriBuilder = new StringBuilder();
    		
		InstanceInfo instance = eurekaClient.getNextServerFromEureka(appName, false);
		if(instance != null) {
			serviceUriBuilder.append(instance.getHomePageUrl()).append("manufacturer-service");
		}
    	
    	return serviceUriBuilder.toString();
    	
	}
    
	
	public List<CarInfoDto> cars() {
		
		if(carInfoList != null) {
			
			carInfoList = carInfoList.stream().map(car -> {
				
				StringBuilder serviceUriBuilder = new StringBuilder(this.getServiceUri("SB-CAR-MANUFACTURER-SERVICE"));
				serviceUriBuilder.append("/manufacturers/").append(car.getManufacturerId().toString());
				
				// Make call to manufacturer service for each car manufacturer's id
				ManufacturerDto manufacturerDto = restTemplate.getForObject(serviceUriBuilder.toString(), ManufacturerDto.class);
				
				car.setManufacturer(manufacturerDto);
			
				return car;
			})
			.collect(Collectors.toList());
		}
		
		return carInfoList;
		
	}
	
	public CarInfoDto car(Integer id) {
		
		Optional<CarInfoDto> findFirst = carInfoList.stream().filter(item -> item.getId().equals(id)).findFirst();
		
		return findFirst.isPresent() ? findFirst.get() : null;
		
	}
	
}
