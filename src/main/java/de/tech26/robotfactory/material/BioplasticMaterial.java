package de.tech26.robotfactory.material;

public class BioplasticMaterial implements Material {

	private static int itemsCount = 92;

	private final float price = 90.12f;

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
