package de.tech26.robotfactory.arms;

public class HandArms implements Arms {

	private static int itemsCount = 1;

	private final float price = 28.94f;

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
