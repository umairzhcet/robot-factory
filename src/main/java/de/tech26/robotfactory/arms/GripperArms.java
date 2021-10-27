package de.tech26.robotfactory.arms;

public class GripperArms implements Arms {

	private static int itemsCount = 3;

	private final float price = 12.39f;

	@Override
	public float getPrice() {

		return this.price;
	}

	@Override
	public void takeItem() {
		itemsCount--;
	}

	@Override
	public int getItemCount() {
		return itemsCount;
	}

}
