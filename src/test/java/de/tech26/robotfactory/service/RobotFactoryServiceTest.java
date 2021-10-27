package de.tech26.robotfactory.service;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import de.tech26.robotfactory.dto.RobotRequest;
import de.tech26.robotfactory.dto.RobotResponse;
import de.tech26.robotfactory.exceptions.OutOfStockException;

@SpringBootTest
@TestMethodOrder(OrderAnnotation.class)
class RobotFactoryServiceTest {
	
	@Autowired
	private RobotFactoryService robotFactoryService;

	@Test
	@Order(1) 
	void orderRobotBioplasticTest() throws OutOfStockException {
		
		RobotRequest request=new RobotRequest();
		List<String> components=new ArrayList<>();
		components.add("I");
		components.add("A");
		components.add("E");
		components.add("F");
		request.setComponents(components);
	
		RobotResponse orderRobot = robotFactoryService.orderRobot(request);
		Assertions.assertEquals(143.56f, orderRobot.getTotal());
		Assertions.assertNotEquals(null, orderRobot.getOrder_id());
	}
	
	@Test
	@Order(2) 
	void orderRobotMetallicTest() throws OutOfStockException {
		
		RobotRequest request=new RobotRequest();
		List<String> components=new ArrayList<>();
		components.add("J");
		components.add("A");
		components.add("E");
		components.add("H");
		request.setComponents(components);
	
		RobotResponse orderRobot = robotFactoryService.orderRobot(request);
		Assertions.assertEquals(154.98f, orderRobot.getTotal());
		Assertions.assertNotEquals(null, orderRobot.getOrder_id());
	}
	

	@Test
	@Order(3) 
	void orderRobotGrippersArmsTest() throws OutOfStockException {
		
		RobotRequest request=new RobotRequest();
		List<String> components=new ArrayList<>();
		components.add("I");
		components.add("A");
		components.add("E");
		components.add("G");
		request.setComponents(components);
	
		RobotResponse orderRobot = robotFactoryService.orderRobot(request);
		Assertions.assertEquals(167.92f, orderRobot.getTotal());
		Assertions.assertNotEquals(null, orderRobot.getOrder_id());
	}
	
	@Test
	@Order(4) 
	void orderRobotOutOfStockTest() {
		
		RobotRequest request=new RobotRequest();
		List<String> components=new ArrayList<>();
		components.add("I");
		components.add("C");
		components.add("E");
		components.add("F");
		request.setComponents(components);
	
		Assertions.assertThrows(OutOfStockException.class, () -> robotFactoryService.orderRobot(request));
	}
	
	

}
