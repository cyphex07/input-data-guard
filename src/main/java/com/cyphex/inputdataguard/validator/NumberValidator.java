package com.cyphex.inputdataguard.validator;

import com.cyphex.inputdataguard.validation.AbstractValidator;
import com.cyphex.inputdataguard.validation.ValidationType;

public class NumberValidator extends AbstractValidator {

  @Override
  public boolean validate(final String value) {

    if (value == null) {
      return false;
    }
    try {
      int number = Integer.parseInt(value);
    } catch (NumberFormatException nfe) {
      return false;
    }
    return true;
  }

  @Override
  public ValidationType getValidationType() {
    return ValidationType.IS_NUMBER;
  }

  @Override
  public String getErrorMessage() {
    return "Value provided is not a number";
  }

  @Override
  public String getErrorMessage(String fieldId) {
    return String.format("The value provided for fieldId %s is not a number", fieldId);
  }

}
