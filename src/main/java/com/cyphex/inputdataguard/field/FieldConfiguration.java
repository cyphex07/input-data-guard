package com.cyphex.inputdataguard.field;

import java.util.List;

import com.cyphex.inputdataguard.validation.ValidationType;

public class FieldConfiguration {

  private String fieldId;
  private List<ValidationType> validationTypes;

  public FieldConfiguration(final String fieldId, final List<ValidationType> validationTypes) {
    this.fieldId = fieldId;
    this.validationTypes = validationTypes;
  }

  public String getFieldId() {
    return fieldId;
  }

  public void setFieldId(final String fieldId) {
    this.fieldId = fieldId;
  }

  public List<ValidationType> getValidationTypes() {
    return validationTypes;
  }

  public void setValidationTypes(final List<ValidationType> validationTypes) {
    this.validationTypes = validationTypes;
  }
}
