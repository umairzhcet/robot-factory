package de.tech26.robotfactory.service;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import de.tech26.robotfactory.Robot;
import de.tech26.robotfactory.dto.RobotRequest;
import de.tech26.robotfactory.dto.RobotResponse;
import de.tech26.robotfactory.exceptions.OutOfStockException;
import de.tech26.robotfactory.factories.RobotFactory;

@Service
public class RobotFactoryService {

	@Autowired
	RobotFactory robotFactory;

	public RobotResponse orderRobot(RobotRequest request) throws OutOfStockException {

		Robot robot = robotFactory.getRobot(request.getComponents());
		UUID uuid = UUID.randomUUID();
		RobotResponse response = new RobotResponse();
		response.setOrder_id(uuid.toString());
		response.setTotal(robot.getPrice());

		return response;
	}

}
