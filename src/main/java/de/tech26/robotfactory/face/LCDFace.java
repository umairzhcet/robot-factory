package de.tech26.robotfactory.face;

public class LCDFace implements Face {

	private static int itemsCount = 7;

	private final float price = 24.07f;

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
