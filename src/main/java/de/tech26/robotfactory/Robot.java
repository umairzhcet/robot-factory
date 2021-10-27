package de.tech26.robotfactory;

import java.math.BigDecimal;
import java.math.RoundingMode;

import de.tech26.robotfactory.arms.Arms;
import de.tech26.robotfactory.exceptions.OutOfStockException;
import de.tech26.robotfactory.face.Face;
import de.tech26.robotfactory.material.Material;
import de.tech26.robotfactory.mobility.Mobility;

public class Robot {

	private float price;

	private Face face;

	private Arms arms;

	private Mobility mobility;

	private Material material;

	public Robot(Face face, Arms arms, Mobility mobility, Material material) throws OutOfStockException {

		String message = processRequest(face, arms, mobility, material);
		if (message == null) {
			this.face = face;
			this.arms = arms;
			this.mobility = mobility;
			this.material = material;
			setRobotPrice();
		} else {
			throw new OutOfStockException(message);
		}

	}

	private synchronized String processRequest(Face face, Arms arms, Mobility mobility, Material material) {

		if (face.getItemCount() <= 0)
			return "Sorry.The requested face type is out of stock";
		else if (arms.getItemCount() <= 0)
			return "Sorry.The requested arm type is out of stock";
		else if (mobility.getItemCount() <= 0)
			return "Sorry.The requested mobility type is out of stock";
		else if (material.getItemCount() <= 0)
			return "Sorry.The requested material type is out of stock";

		else {
			face.takeItem();
			arms.takeItem();
			mobility.takeItem();
			material.takeItem();

			return null;
		}

	}

	private void setRobotPrice() {
		float total = this.face.getPrice() + this.arms.getPrice() + this.mobility.getPrice() + this.material.getPrice();
		BigDecimal bigDecimal = new BigDecimal(Float.toString(total));
		bigDecimal = bigDecimal.setScale(2, RoundingMode.HALF_UP);
		this.price = bigDecimal.floatValue();

	}

	public float getPrice() {
		return this.price;
	}

}
