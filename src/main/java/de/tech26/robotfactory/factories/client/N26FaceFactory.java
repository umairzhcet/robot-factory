package de.tech26.robotfactory.factories.client;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;

import de.tech26.robotfactory.face.Face;
import de.tech26.robotfactory.face.FaceType;
import de.tech26.robotfactory.face.HumanoidFace;
import de.tech26.robotfactory.face.LCDFace;
import de.tech26.robotfactory.face.SteamPunkFace;
import de.tech26.robotfactory.factories.FaceFactory;

public class N26FaceFactory implements FaceFactory {

	@Value("#{${robot.faces.map}}")
	Map<String, FaceType> typeMap = new HashMap<String, FaceType>();

	@Override
	public Face getFace(String type) {
		Face face = null;
		if (typeMap.get(type).equals(FaceType.HUMANOID))
			face = new HumanoidFace();
		if (typeMap.get(type).equals(FaceType.LCD))
			face = new LCDFace();
		if (typeMap.get(type).equals(FaceType.STEAMPUNK))
			face = new SteamPunkFace();
		return face;
	}

}
