package de.tech26.robotfactory.factories.client;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import de.tech26.robotfactory.Robot;
import de.tech26.robotfactory.arms.Arms;
import de.tech26.robotfactory.exceptions.OutOfStockException;
import de.tech26.robotfactory.face.Face;
import de.tech26.robotfactory.factories.ArmsFactory;
import de.tech26.robotfactory.factories.FaceFactory;
import de.tech26.robotfactory.factories.MaterialFactory;
import de.tech26.robotfactory.factories.MobilityFactory;
import de.tech26.robotfactory.factories.RobotFactory;
import de.tech26.robotfactory.material.Material;
import de.tech26.robotfactory.mobility.Mobility;

public class N26RobotFactory implements RobotFactory {

	@Value("${robot.faces}")
	private String typeFace;

	@Value("${robot.arms}")
	private String typeArms;

	@Value("${robot.mobility}")
	private String typeMobility;

	@Value("${robot.material}")
	private String typeMaterial;

	@Autowired
	FaceFactory faceFactory;

	@Autowired
	ArmsFactory armsFactory;

	@Autowired
	MobilityFactory mobilityFactory;

	@Autowired
	MaterialFactory materialFactory;

	@Override
	public Robot getRobot(List<String> request) throws OutOfStockException {
		Face face = null;
		Arms arms = null;
		Mobility mobility = null;
		Material material = null;
		for (String type : request) {
			if (typeFace.contains(type)) {
				face = faceFactory.getFace(type);
			} else if (typeArms.contains(type)) {
				arms = armsFactory.getArm(type);
			} else if (typeMobility.contains(type)) {
				mobility = mobilityFactory.getMobility(type);
			} else if (typeMaterial.contains(type)) {
				material = materialFactory.getMaterial(type);
			}

		}
		return new Robot(face, arms, mobility, material);

	}

}
