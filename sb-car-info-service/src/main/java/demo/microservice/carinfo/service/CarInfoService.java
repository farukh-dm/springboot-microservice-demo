package demo.microservice.carinfo.service;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.shared.Application;

import demo.microservice.carinfo.dto.CarInfoDto;
import demo.microservice.carinfo.dto.ManufacturerDto;
import demo.microservice.carinfo.manufacturer.microservice.ManufacturerMicroService;
import demo.microservice.carinfo.util.AppUtils;

@Service(value="carInfoService")
public class CarInfoService {
	
	@Autowired
	AppUtils appUtils;
	
	@Autowired
	ManufacturerMicroService manufacturerMicroService;
	
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
	
	public List<CarInfoDto> cars() {
			
		carInfoList = carInfoList.stream().map(car -> {
			
			ManufacturerDto dto = manufacturerMicroService.get(car.getManufacturerId());
			
			car.setManufacturer(dto);
		
			return car;
		})
		.collect(Collectors.toList());
		
		return carInfoList;
		
	}
	
	public CarInfoDto car(Integer id) {
		
		Optional<CarInfoDto> findFirst = carInfoList.stream().filter(item -> item.getId().equals(id)).findFirst();
		
		return findFirst.isPresent() ? findFirst.get() : null;
		
	}
	
	public String applicationName() {
		return String.format("Hello from '%s'!", appUtils.getApplication(appName).getName());
	}
    
    // Used for testing
    public String client() {
    	
    	String returnStr = "";
    	
    	Application application = appUtils.getApplication("SB-CAR-MANUFACTURER-SERVICE");
    	if(application != null) {
    		
    		InstanceInfo instanceInfo = application.getInstances().get(0);
    		returnStr = "http://" + instanceInfo.getHostName() + ":" + instanceInfo.getPort() + "/" +instanceInfo.getVIPAddress()+"/";

    	}
    	
    	returnStr = returnStr + "<br/>" + appUtils.getServiceUri("SB-CAR-MANUFACTURER-SERVICE");
		
		return returnStr;
	}
	
}
