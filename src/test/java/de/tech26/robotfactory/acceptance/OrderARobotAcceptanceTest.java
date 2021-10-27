package de.tech26.robotfactory.acceptance;

import static org.assertj.core.api.Assertions.assertThat;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import de.tech26.robotfactory.RobotFactoryApplication;
import de.tech26.robotfactory.dto.RobotRequest;
import de.tech26.robotfactory.dto.RobotResponse;

import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@SpringBootTest(classes =RobotFactoryApplication.class, webEnvironment = WebEnvironment.RANDOM_PORT)
public class OrderARobotAcceptanceTest {
	 
	@LocalServerPort
    private int port;
 
    @Autowired
    private TestRestTemplate restTemplate;
    
    @Test
    public void testOrderARobot() 
    {
    	RobotRequest request=new RobotRequest();
		List<String> components=new ArrayList<>();
		components.add("I");
		components.add("A");
		components.add("D");
		components.add("F");
		request.setComponents(components);
    	ResponseEntity<RobotResponse> responseEntity = this.restTemplate
    			.withBasicAuth("user", "password")
                .postForEntity("http://localhost:" + port + "/orders", request, RobotResponse.class);
    	assertThat(responseEntity.getBody().getTotal()==160.11f);
            
    }
    
    @Test
    public void testInvalidBody() 
    {
		assertThat(this.restTemplate
				.withBasicAuth("user", "password")
                .postForEntity("http://localhost:" + port + "/orders", "", String.class).getStatusCode().equals(HttpStatus.BAD_REQUEST));
            
    }
    
    @Test
    public void testInvalidRobotConfiguration() 
    {
    	RobotRequest request=new RobotRequest();
		List<String> components=new ArrayList<>();
		components.add("A");
		components.add("C");
		components.add("I");
		components.add("D");
		request.setComponents(components);
		assertThat(this.restTemplate
				.withBasicAuth("user", "password")
                .postForEntity("http://localhost:" + port + "/orders", request, String.class).getStatusCode().equals(HttpStatus.UNPROCESSABLE_ENTITY));
            
    }
    

}