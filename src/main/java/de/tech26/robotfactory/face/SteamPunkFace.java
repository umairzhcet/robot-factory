package de.tech26.robotfactory.face;

public class SteamPunkFace implements Face {

	private static int itemsCount = 0;

	private final float price = 13.30f;

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
