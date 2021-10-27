package de.tech26.robotfactory.factories.client;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;

import de.tech26.robotfactory.factories.MaterialFactory;
import de.tech26.robotfactory.material.BioplasticMaterial;
import de.tech26.robotfactory.material.Material;
import de.tech26.robotfactory.material.MaterialType;
import de.tech26.robotfactory.material.MetallicMaterial;

public class N26MaterialFactory implements MaterialFactory {

	@Value("#{${robot.material.map}}")
	Map<String, MaterialType> typeMap = new HashMap<String, MaterialType>();

	@Override
	public Material getMaterial(String type) {
		Material material = null;
		if (typeMap.get(type).equals(MaterialType.BIOPLASTIC))
			material = new BioplasticMaterial();
		if (typeMap.get(type).equals(MaterialType.METALLIC))
			material = new MetallicMaterial();

		return material;
	}

}
