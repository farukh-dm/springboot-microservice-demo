package demo.microservice.carinfo.dto;

import java.io.Serializable;

public class CarInfoDto implements Serializable {

	private static final long serialVersionUID = 4121956910260028523L;
	
	private Integer Id;
	private String name;
	private Integer manufacturerId;
	private ManufacturerDto manufacturer;
	
	public CarInfoDto() {
		super();
	}
	
	public CarInfoDto(Integer id, String name, Integer manufacturerId) {
		super();
		Id = id;
		this.name = name;
		this.manufacturerId = manufacturerId;
	}

	public Integer getId() {
		return Id;
	}
	
	public void setId(Integer id) {
		Id = id;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public Integer getManufacturerId() {
		return manufacturerId;
	}

	public void setManufacturerId(Integer manufacturerId) {
		this.manufacturerId = manufacturerId;
	}

	public ManufacturerDto getManufacturer() {
		return manufacturer;
	}

	public void setManufacturer(ManufacturerDto manufacturer) {
		this.manufacturer = manufacturer;
	}

	@Override
	public String toString() {
		return "CarInfoDto [Id=" + Id + ", name=" + name + ", manufacturerId=" + manufacturerId + ", manufacturer="
				+ manufacturer + "]";
	}

}
