package de.tech26.robotfactory.dto;

import java.util.List;

import javax.validation.constraints.NotEmpty;

public class RobotRequest {
	
	@NotEmpty(message="Request List cannot be empty")
	private List<String> components;

	public List<String> getComponents() {
		return components;
	}

	public void setComponents(List<String> components) {
		this.components = components;
	}
	

}
