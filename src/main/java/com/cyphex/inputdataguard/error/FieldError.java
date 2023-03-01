package com.cyphex.inputdataguard.error;

import java.util.List;

public class FieldError {

  String fieldId;
  List<ValidationError> validationErrors;

  public FieldError(final String fieldId, final List<ValidationError> validationErrors) {
    this.fieldId = fieldId;
    this.validationErrors = validationErrors;
  }

  public FieldError() {
  }

  public String getFieldId() {
    return fieldId;
  }

  public void setFieldId(final String fieldId) {
    this.fieldId = fieldId;
  }

  public List<ValidationError> getValidationErrors() {
    return validationErrors;
  }

  public void setValidationErrors(final List<ValidationError> validationErrors) {
    this.validationErrors = validationErrors;
  }
}
