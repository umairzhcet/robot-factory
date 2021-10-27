package de.tech26.robotfactory.controller;

import java.util.*;

import javax.validation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.validation.*;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import de.tech26.robotfactory.dto.*;
import de.tech26.robotfactory.exceptions.OutOfStockException;
import de.tech26.robotfactory.service.RobotFactoryService;
import de.tech26.robotfactory.validation.RobotRequestConstraint;

@Validated
@RestController
public class RobotFactoryController extends ResponseEntityExceptionHandler {

	@Autowired
	RobotFactoryService robotFactoryService;

	@PostMapping("/orders")
	public ResponseEntity<?> orderRobot(@RequestBody @Valid @RobotRequestConstraint RobotRequest request) {
		RobotResponse response;
		try {
			response = robotFactoryService.orderRobot(request);
		} catch (OutOfStockException e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.UNPROCESSABLE_ENTITY);
		}

		return new ResponseEntity<>(response, HttpStatus.CREATED);
	}

	@ExceptionHandler(ConstraintViolationException.class)
	public ResponseEntity<String> handle(ConstraintViolationException constraintViolationException) {
		Set<ConstraintViolation<?>> violations = constraintViolationException.getConstraintViolations();
		String errorMessage = "";
		if (!violations.isEmpty()) {
			StringBuilder builder = new StringBuilder();
			violations.forEach(violation -> builder.append(" " + violation.getMessage()));
			errorMessage = builder.toString();
		} else {
			errorMessage = "ConstraintViolationException occured.";
		}
		return new ResponseEntity<>(errorMessage, HttpStatus.UNPROCESSABLE_ENTITY);
	}

	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {

		List<String> errors = new ArrayList<String>();
		for (FieldError error : ex.getBindingResult().getFieldErrors()) {
			errors.add(error.getField() + ": " + error.getDefaultMessage());
		}

		return new ResponseEntity<>(errors, headers, status);

	}

}
