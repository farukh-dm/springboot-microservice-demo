package demo.microservice.carmanufacturer.service;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

import org.springframework.stereotype.Service;

import demo.microservice.carmanufacturer.dto.ManufacturerDto;

@Service(value="manufacturerService")
public class ManufacturerService {
	
	static List<ManufacturerDto> manufacturerList;

	static {
		
		manufacturerList = Arrays.asList(
		
			new ManufacturerDto(1, "Toyota"),
			new ManufacturerDto(2, "Nissan"),
			new ManufacturerDto(3, "Honda")
		
		);
		
	}
	
	public List<ManufacturerDto> manufacturers() {
		
		return manufacturerList;
		
	}
	
	public ManufacturerDto manufacturer(Integer id) {
		
		Optional<ManufacturerDto> findFirst = manufacturerList.stream().filter(item -> item.getId().equals(id)).findFirst();
		
		return findFirst.isPresent() ? findFirst.get() : null;
		
	}

}
