package com.cyphex.inputdataguard.validator;

import com.cyphex.inputdataguard.validation.AbstractValidator;
import com.cyphex.inputdataguard.validation.ValidationType;

public class RequiredValidator extends AbstractValidator  {

  @Override
  public boolean validate(String value) {
    return value != null && !value.trim().isEmpty();
  }

  @Override
  public ValidationType getValidationType() {
    return ValidationType.REQUIRED;
  }

  @Override
  public String getErrorMessage() {
    return "Value is required";
  }

  @Override
  public String getErrorMessage(String fieldId) {
    return String.format("Value is required for field %s", fieldId);
  }
}
