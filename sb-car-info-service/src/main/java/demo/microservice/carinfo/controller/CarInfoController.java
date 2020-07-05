package demo.microservice.carinfo.controller;

import java.util.Arrays;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import demo.microservice.carinfo.dto.CarInfoDto;
import demo.microservice.carinfo.dto.ResponseDto;
import demo.microservice.carinfo.service.CarInfoService;

@RestController
@RequestMapping(value = "/cars")
public class CarInfoController {
	
	@Autowired
	CarInfoService carInfoService;
	
	@RequestMapping(value = "", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ResponseDto<CarInfoDto>> manufacturers() {
		
		ResponseDto<CarInfoDto> response = new ResponseDto<CarInfoDto>();

		response.setData(carInfoService.cars());
		
		return new ResponseEntity<>(response, HttpStatus.OK);
		
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ResponseDto<CarInfoDto>> manufacturer(@PathVariable(name = "id") String id) {
		
		ResponseDto<CarInfoDto> response = new ResponseDto<CarInfoDto>();
		
		Integer itemId = StringUtils.isNumeric(id) ? Integer.parseInt(id) : 0;
		
		CarInfoDto car = carInfoService.car(itemId);

		response.setData(Arrays.asList(car));
		
		return new ResponseEntity<>(response, HttpStatus.OK);
		
	}
	
	@RequestMapping(value = "/applicationName", method = RequestMethod.GET)
	public ResponseEntity<String> applicationName() {
		
		return new ResponseEntity<>(carInfoService.applicationName(), HttpStatus.OK);
		
	}
	
	@RequestMapping(value = "/client", method = RequestMethod.GET)
	public ResponseEntity<String> client() {
		
		return new ResponseEntity<>(carInfoService.client(), HttpStatus.OK);
		
	}

}
