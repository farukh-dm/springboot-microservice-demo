package demo.microservice.carmanufacturer.controller;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import demo.microservice.carmanufacturer.dto.ManufacturerDto;
import demo.microservice.carmanufacturer.dto.ResponseDto;
import demo.microservice.carmanufacturer.service.ManufacturerService;

@RestController
@RequestMapping(value = "/manufacturers")
public class ManufacturerController {
	
	@Autowired
	ManufacturerService manufacturerService;
	
	@RequestMapping(value = "", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ResponseDto<ManufacturerDto>> manufacturers() {
		
		ResponseDto<ManufacturerDto> response = new ResponseDto<ManufacturerDto>();

		response.setData(manufacturerService.manufacturers());
		
		//return new ResponseEntity<ResponseDto<ManufacturerDto>>(response, HttpStatus.OK);
		return new ResponseEntity<>(response, HttpStatus.OK);
		
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ManufacturerDto> manufacturer(@PathVariable(name = "id") String id) {
		
		Integer itemId = StringUtils.isNumeric(id) ? Integer.parseInt(id) : 0;
		
		ManufacturerDto manufacturer = manufacturerService.manufacturer(itemId);

		return new ResponseEntity<>(manufacturer, HttpStatus.OK);
		
	}

}
