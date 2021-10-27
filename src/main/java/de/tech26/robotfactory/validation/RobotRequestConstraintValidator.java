package de.tech26.robotfactory.validation;

import java.util.List;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import de.tech26.robotfactory.dto.RobotRequest;

public class RobotRequestConstraintValidator implements ConstraintValidator<RobotRequestConstraint, RobotRequest> {
	
	static String typeFace = "ABC";
	static String typeArms = "DE";
	static String typeMobility = "FGH";
	static String typeMaterial = "IJ";
	
	 @Override
	    public boolean isValid(RobotRequest request, ConstraintValidatorContext context) {
		 
		    List<String> values=request.getComponents();
		    if(values.size()!=4)
		    	return false;
	        int facesCount=0;
	        int armsCount=0;
	        int mobilityCount=0;
	        int materialCount=0;
	        		
		    for(String value:values) {
		    	if(typeFace.contains(value))
		    		facesCount++;
		    	if(typeArms.contains(value))
		    		armsCount++;
		    	if(typeMobility.contains(value))
		    		mobilityCount++;
		    	if(typeMaterial.contains(value))
		    		materialCount++;
		    }
		    if(facesCount!=1 || armsCount!=1 || mobilityCount!=1 || materialCount!=1)
		        return false;
		    
		    return true;
	    }

}
