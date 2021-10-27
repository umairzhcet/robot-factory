package de.tech26.robotfactory.factories.client;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;

import de.tech26.robotfactory.arms.Arms;
import de.tech26.robotfactory.arms.ArmsType;
import de.tech26.robotfactory.arms.GripperArms;
import de.tech26.robotfactory.arms.HandArms;
import de.tech26.robotfactory.factories.ArmsFactory;

public class N26ArmsFactory implements ArmsFactory {

	@Value("#{${robot.arms.map}}")
	Map<String, ArmsType> typeMap = new HashMap<String, ArmsType>();

	@Override
	public Arms getArm(String type) {
		Arms arms = null;
		if (typeMap.get(type).equals(ArmsType.HANDS))
			arms = new HandArms();
		if (typeMap.get(type).equals(ArmsType.GRIPPERS))
			arms = new GripperArms();

		return arms;
	}

}
