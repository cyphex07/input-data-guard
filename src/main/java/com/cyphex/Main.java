package com.cyphex;

import java.util.List;

import com.cyphex.inputdataguard.DataGuardValidation;
import com.cyphex.inputdataguard.error.FieldError;
import com.cyphex.inputdataguard.error.ValidationError;
import com.cyphex.inputdataguard.field.Field;
import com.cyphex.inputdataguard.field.FieldConfiguration;
import com.cyphex.inputdataguard.validation.ValidationType;

public class Main {

  public static void main(String[] args) {

    List<Field> fields = List.of(
        new Field("firstName", "213"),
        new Field("lastName", "123"),
        new Field("email", "john.doe@example.com"),
        new Field("age", "30"),
        new Field("address", "21")
    );

    List<FieldConfiguration> configurations = List.of(
        new FieldConfiguration("firstName", List.of(ValidationType.REQUIRED)),
        new FieldConfiguration("lastName", List.of(ValidationType.REQUIRED)),
        new FieldConfiguration("email", List.of(ValidationType.EMAIL, ValidationType.REQUIRED)),
        new FieldConfiguration("age", List.of(ValidationType.IS_NUMBER)),
        new FieldConfiguration("address", List.of(ValidationType.REQUIRED))
    );

    DataGuardValidation dataGuardValidation = new DataGuardValidation();
    List<FieldError> errors = dataGuardValidation.validateFieldsWithConfiguration(fields, configurations);
    if (!errors.isEmpty()) {
      for (FieldError fieldError : errors) {
        System.out.println("Field ID: " + fieldError.getFieldId());
        for (ValidationError validationError : fieldError.getValidationErrors()) {
          System.out.println("Validation Type: " + validationError.getValidationType());
          System.out.println("Message: " + validationError.getMessage());
        }
      }
    } else {
      System.out.println("Validation correct");
    }
  }
}
