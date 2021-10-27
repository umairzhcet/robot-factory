package de.tech26.robotfactory.mobility;

public class WheelsMobility implements Mobility {

	private static int itemsCount = 2;

	private final float price = 30.77f;

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
