package demo.microservice.config.client.home;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(value = "my.db.connection")
public class DbConnectionProperties {
	
	private String host;
	private String name;
	private Integer port;
	public String getHost() {
		return host;
	}
	public void setHost(String host) {
		this.host = host;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getPort() {
		return port;
	}
	public void setPort(Integer port) {
		this.port = port;
	}
	
	@Override
	public String toString() {
		return "DbConnectionProperties [host=" + host + ", name=" + name + ", port=" + port + "]";
	}
	
}
