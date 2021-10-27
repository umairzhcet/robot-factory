package de.tech26.robotfactory.factories;

import de.tech26.robotfactory.mobility.Mobility;

public interface MobilityFactory {

	public Mobility getMobility(String type);

}
