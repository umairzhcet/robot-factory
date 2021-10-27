package de.tech26.robotfactory.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import de.tech26.robotfactory.factories.*;
import de.tech26.robotfactory.factories.client.*;

@Configuration
public class FactoryConfiguration {

	@Bean
	public RobotFactory robotFactory() {
		return new N26RobotFactory();
	}

	@Bean
	public ArmsFactory armsFactory() {
		return new N26ArmsFactory();
	}

	@Bean
	public FaceFactory faceFactory() {
		return new N26FaceFactory();
	}

	@Bean
	public MobilityFactory mobilityFactory() {
		return new N26MobilityFactory();
	}

	@Bean
	public MaterialFactory materialFactory() {
		return new N26MaterialFactory();
	}

}
