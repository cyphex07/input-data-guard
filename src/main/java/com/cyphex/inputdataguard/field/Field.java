package com.cyphex.inputdataguard.field;

public class Field {

  String value;
  String fieldId;

  public Field(final String fieldId, final String value) {
    this.value = value;
    this.fieldId = fieldId;
  }

  public String getValue() {
    return value;
  }

  public void setValue(final String value) {
    this.value = value;
  }

  public String getFieldId() {
    return fieldId;
  }

  public void setFieldId(final String fieldId) {
    this.fieldId = fieldId;
  }
}
