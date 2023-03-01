package com.cyphex.inputdataguard.validator;

import java.util.Objects;

import com.cyphex.inputdataguard.validation.AbstractValidator;
import com.cyphex.inputdataguard.validation.ValidationType;

public class NullValidator extends AbstractValidator  {

  @Override
  public boolean validate(final String value) {
    return !Objects.isNull(value);
  }

  @Override
  public ValidationType getValidationType() {
    return ValidationType.NULL;
  }

  @Override
  public String getErrorMessage() {
    return "Value cannot be null";
  }

  @Override
  public String getErrorMessage(String fieldId) {
    return String.format("Value cannot be null for fieldId %s", fieldId);
  }
}
