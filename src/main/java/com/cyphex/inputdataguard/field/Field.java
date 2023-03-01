package com.cyphex.inputdataguard.field;

import java.util.List;

import com.cyphex.inputdataguard.validation.ValidationType;

public class Field {
  String fieldId;

  public String getFieldId() {
    return fieldId;
  }

  public void setFieldId(final String fieldId) {
    this.fieldId = fieldId;
  }

  String value;
  List<ValidationType> validations;

  public void setValue(final String value) {
    this.value = value;
  }

  public void setValidations(final List<ValidationType> validations) {
    this.validations = validations;
  }

  public String getValue() {
    return value;
  }

  public List<ValidationType> getValidations() {
    return validations;
  }
}
