package de.tech26.robotfactory.controller;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;

import de.tech26.robotfactory.dto.RobotRequest;
import de.tech26.robotfactory.dto.RobotResponse;
import de.tech26.robotfactory.service.RobotFactoryService;

@SpringBootTest
@AutoConfigureMockMvc
class RobotFactoryControllerTest {
	
	@MockBean
	private RobotFactoryService robotFactoryService;
	
	
	@Autowired
    private MockMvc mockMvc;

	
	@WithMockUser(value = "test")
	@Test
	void orderRobotEmptyRequestTest() throws Exception {
		RobotRequest request=new RobotRequest();
		List<String> components=new ArrayList<>();
		request.setComponents(components);
		
		mockMvc.perform(post("/orders")
		.contentType(MediaType.APPLICATION_JSON)
        .content(asJsonString(request)))
        .andExpect(status().isBadRequest());
	}
	
	
	@WithMockUser(value = "test")
	@Test
	void orderRobotInvalidRequestTest() throws Exception {
		RobotRequest request=new RobotRequest();
		List<String> components=new ArrayList<>();
		components.add("A");
		components.add("C");
		components.add("I");
		components.add("D");
		request.setComponents(components);
		
		mockMvc.perform(post("/orders")
		.contentType(MediaType.APPLICATION_JSON)
        .content(asJsonString(request)))
        .andExpect(status().isUnprocessableEntity());
	}
	
	
	@WithMockUser(value = "test")
	@Test
	void orderRobotTest() throws Exception {
		RobotRequest request=new RobotRequest();
		List<String> components=new ArrayList<>();
		components.add("I");
		components.add("A");
		components.add("D");
		components.add("F");
		request.setComponents(components);
		
		RobotResponse response=new RobotResponse();
		response.setOrder_id(UUID.randomUUID().toString());
		response.setTotal(160.11f);
		when(robotFactoryService.orderRobot(request)).thenReturn(response);
		mockMvc.perform(post("/orders")
		.contentType(MediaType.APPLICATION_JSON)
        .content(asJsonString(request)))
        .andExpect(status().isCreated());
	}
	
	static String asJsonString(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }	

}
