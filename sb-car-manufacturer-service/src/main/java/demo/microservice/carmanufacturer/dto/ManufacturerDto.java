package demo.microservice.carmanufacturer.dto;

import java.io.Serializable;

public class ManufacturerDto implements Serializable {

	private static final long serialVersionUID = -525768567323948972L;
	
	public ManufacturerDto() {
		super();
	}
	
	public ManufacturerDto(Integer id, String name) {
		super();
		Id = id;
		this.name = name;
	}

	private Integer Id;
	private String name;
	
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
	
	@Override
	public String toString() {
		return "ManufacturerDto [Id=" + Id + ", name=" + name + "]";
	}
	
}
