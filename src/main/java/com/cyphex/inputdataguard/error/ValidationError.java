package com.cyphex.inputdataguard.error;

import com.cyphex.inputdataguard.validation.ValidationType;

public class ValidationError {
  ValidationType validationType;
  String message;

  public ValidationError(final ValidationType validationType, final String message) {
    this.validationType = validationType;
    this.message = message;
  }

  public ValidationType getValidationType() {
    return validationType;
  }

  public void setValidationType(final ValidationType validationType) {
    this.validationType = validationType;
  }

  public String getMessage() {
    return message;
  }

  public void setMessage(final String message) {
    this.message = message;
  }
}
