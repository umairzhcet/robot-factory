package de.tech26.robotfactory.factories;

import java.util.List;

import de.tech26.robotfactory.Robot;
import de.tech26.robotfactory.exceptions.OutOfStockException;

public interface RobotFactory {

	public abstract Robot getRobot(List<String> request) throws OutOfStockException;

}
