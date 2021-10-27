package de.tech26.robotfactory.mobility;

public class LegsMobility implements Mobility {

	private static int itemsCount = 15;

	private final float price = 55.13f;

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
