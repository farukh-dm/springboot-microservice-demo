package demo.microservice.carmanufacturer.dto;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class ResponseDto<T> implements Serializable {

	private static final long serialVersionUID = 1069029164086582615L;

	private List<T> data;
	
	private Date timestamp = new Date();

	public List<T> getData() {
		return data;
	}

	public void setData(List<T> data) {
		this.data = data;
	}

	public Date getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}

	@Override
	public String toString() {
		return "ResponseDto [data=" + data + ", timestamp=" + timestamp + "]";
	}
	
}
