package demo.microservice.carinfo.dto;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonUnwrapped;

public class ResponseDto<T> implements Serializable {

	private static final long serialVersionUID = 7188212026393848152L;

	@JsonUnwrapped
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
