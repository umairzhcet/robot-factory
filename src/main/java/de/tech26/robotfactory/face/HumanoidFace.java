package de.tech26.robotfactory.face;

public class HumanoidFace implements Face {

	private static int itemsCount = 9;

	private final float price = 10.28f;

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
