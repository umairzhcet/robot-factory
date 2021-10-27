package de.tech26.robotfactory.material;

public class MetallicMaterial implements Material {

	private static int itemsCount = 15;

	private final float price = 82.31f;

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
