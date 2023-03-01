package com.cyphex.inputdataguard;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.cyphex.inputdataguard.error.FieldError;
import com.cyphex.inputdataguard.error.ValidationError;
import com.cyphex.inputdataguard.field.Field;
import com.cyphex.inputdataguard.validation.AbstractValidator;
import com.cyphex.inputdataguard.validation.ValidationType;
import com.cyphex.inputdataguard.validation.ValidatorFactory;

public class DataGuardValidation {

  public List<FieldError> validate(List<Field> fields) {

    List<FieldError> errors = new ArrayList<>();
    for (Field field : fields) {
      List<AbstractValidator> validators = new ArrayList<>();
      for (ValidationType validationType: field.getValidations()) {
        AbstractValidator validator = ValidatorFactory.getValidator(validationType);
        validators.add(validator);
      }
      List<ValidationError> validationErrors = new ArrayList<>();
      for (AbstractValidator validator : validators) {
        if (!validator.validate(field.getValue())) {
          ValidationError validationError = new ValidationError(validator.getValidationType(), validator.getErrorMessage(field.getFieldId()));
          validationErrors.add(validationError);
        }
      }
      if (!validationErrors.isEmpty()) {
        FieldError fieldError =  new FieldError();
        fieldError.setFieldId(field.getFieldId());
        fieldError.setValidationErrors(validationErrors);
        errors.add(fieldError);
      }

    }

    return errors;
  }

  public List<FieldError> validateFunctional(List<Field> fields) {
    return fields.stream()
        .flatMap(field -> {
          List<AbstractValidator> validators = field.getValidations().stream()
              .map(ValidatorFactory::getValidator)
              .collect(Collectors.toList());

          List<ValidationError> validationErrors = validators.stream()
              .map(validator -> {
                if (!validator.validate(field.getValue())) {
                  return new ValidationError(validator.getValidationType(), validator.getErrorMessage(field.getFieldId()));
                }
                return null;
              })
              .filter(Objects::nonNull)
              .collect(Collectors.toList());

          return validationErrors.isEmpty() ? Stream.empty() :
              Stream.of(new FieldError(field.getFieldId(), validationErrors));
        })
        .collect(Collectors.toList());
  }
}
