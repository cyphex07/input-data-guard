package com.cyphex.inputdataguard.validation;

public abstract class AbstractValidator {

  public abstract boolean validate(String value);
  public abstract ValidationType getValidationType();
  public abstract String getErrorMessage();

  public String getErrorMessage(String fieldId) {
    return getValidationType() + " validation failed for field " + fieldId + ": " + getErrorMessage();
  }
}
