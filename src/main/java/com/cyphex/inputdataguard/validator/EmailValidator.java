package com.cyphex.inputdataguard.validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.cyphex.inputdataguard.validation.AbstractValidator;
import com.cyphex.inputdataguard.validation.ValidationType;

public class EmailValidator extends AbstractValidator {

  private static final String EMAIL_PATTERN = "^(?=.{1,64}@)[A-Za-z0-9_-]+(\\.[A-Za-z0-9_-]+)*@"
      + "[^-][A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,})$";
  private static final Pattern pattern = Pattern.compile(EMAIL_PATTERN);

  @Override
  public boolean validate(final String value) {
    if (value == null)
      return false;
    Matcher matcher = pattern.matcher(value);
    return matcher.matches();
  }

  @Override
  public ValidationType getValidationType() {
    return ValidationType.EMAIL;
  }

  @Override
  public String getErrorMessage() {
    return "Invalid email address format";
  }

  @Override
  public String getErrorMessage(String fieldId) {
    return "Invalid email address format for field " + fieldId;
  }
}
