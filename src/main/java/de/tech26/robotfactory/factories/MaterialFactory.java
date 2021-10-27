package de.tech26.robotfactory.factories;

import de.tech26.robotfactory.material.Material;

public interface MaterialFactory {

	public Material getMaterial(String type);

}
