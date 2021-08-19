package com.luciano.os.resources.exception;

import java.util.List;

import org.apache.tomcat.util.digester.ArrayStack;

public class ValidationError extends StandardError {
	private static final long serialVersionUID = 1L;

	private List<FieldMessage> errors = new ArrayStack<>();

	public ValidationError() {
		super();
	}

	public ValidationError(Long timestamp, Integer status, String error) {
		super(timestamp, status, error);
	}

	public List<FieldMessage> getErrors() {
		return errors;
	}

	public void addError(String fieldName, String message) {
		this.errors.add(new FieldMessage(fieldName, message));
	}

}
