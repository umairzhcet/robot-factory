package de.tech26.robotfactory.factories;

import de.tech26.robotfactory.arms.Arms;

public interface ArmsFactory {

	public Arms getArm(String type);
}
