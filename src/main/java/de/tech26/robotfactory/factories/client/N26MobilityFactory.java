package de.tech26.robotfactory.factories.client;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;

import de.tech26.robotfactory.factories.MobilityFactory;
import de.tech26.robotfactory.mobility.LegsMobility;
import de.tech26.robotfactory.mobility.Mobility;
import de.tech26.robotfactory.mobility.MobilityType;
import de.tech26.robotfactory.mobility.TracksMobility;
import de.tech26.robotfactory.mobility.WheelsMobility;

public class N26MobilityFactory implements MobilityFactory {

	@Value("#{${robot.mobility.map}}")
	Map<String, MobilityType> typeMap = new HashMap<String, MobilityType>();

	@Override
	public Mobility getMobility(String type) {
		Mobility mobility = null;
		if (typeMap.get(type).equals(MobilityType.WHEELS))
			mobility = new WheelsMobility();
		if (typeMap.get(type).equals(MobilityType.LEGS))
			mobility = new LegsMobility();
		if (typeMap.get(type).equals(MobilityType.TRACKS))
			mobility = new TracksMobility();

		return mobility;
	}

}
