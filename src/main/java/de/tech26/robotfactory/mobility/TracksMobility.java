package de.tech26.robotfactory.mobility;

public class TracksMobility implements Mobility {

	private static int itemsCount = 7;

	private final float price = 50.00f;

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
