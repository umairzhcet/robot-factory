package de.tech26.robotfactory.validation;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Retention;

import javax.validation.Constraint;
import javax.validation.Payload;

@Constraint(validatedBy = RobotRequestConstraintValidator.class)
@Retention(RUNTIME)
public @interface RobotRequestConstraint {
	String message() default "The given configuration is invalid.Please configure exactly one type for each of face, arms,mobility and material";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
