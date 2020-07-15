package demo.microservice.config.client.home;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/home")
@RefreshScope
public class HomeController {
	
	@Value("${app.name}")
	private String appName;
	
	@Value("${app.description}")
	private String appDesc;
	
	@Value("${app.title:my default title}")
	private String appTitle;
	
	@Value("#{${app.map}}")
	public Map<String, String> appMap;
	
	@Value("${app.items}")
	public List<String> appItems;
	
	@Value("${app.item1}")
	public String appItem1;
	
	@Value("${app.item2}")
	public String appItem2;
	
	@Value("${app.item3}")
	public String appItem3;
	
	@Autowired
	DbConnectionProperties dbConnectionProperties;
	
	//@Autowired
	//DbConnectionForTest dbConnectionForTest;
	
	@Autowired
	Environment environment;
	
	@GetMapping(value = "")
	public String home() {
		
		StringBuilder sb = new StringBuilder();
		sb.append(appName).append("-").append(appDesc).append("-").append(appTitle)
		.append("-").append(appMap).append("-").append(appItems)
		.append("<br/>dbConnectionProperties: <br/>").append(dbConnectionProperties);
		
		sb.append("<br/><br/>app.description: ").append(environment.getProperty("app.description"));
		
		sb.append("<br/><br/>nvironment: <br/><br/>").append(environment.toString());
		
		sb.append("<br/><br/>");
		
		sb.append("Item 1 : ").append(appItem1).append("<br/>");
		sb.append("Item 2 : ").append(appItem2).append("<br/>");
		sb.append("Item 3 : ").append(appItem3);
		
		
		return sb.toString();
		
	}

}
