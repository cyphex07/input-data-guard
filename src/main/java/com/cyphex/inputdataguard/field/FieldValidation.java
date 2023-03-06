package com.cyphex.inputdataguard.field;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.cyphex.inputdataguard.error.FieldError;
import com.cyphex.inputdataguard.error.ValidationError;
import com.cyphex.inputdataguard.validation.AbstractValidator;
import com.cyphex.inputdataguard.validation.ValidatorFactory;

public class FieldValidation {

  private FieldConfiguration configuration;
  private Field field;

  public FieldValidation(final FieldConfiguration configuration, final Field field) {
    this.configuration = configuration;
    this.field = field;
  }

  public List<FieldError> getFieldErrors() {
    return getValidators().stream()
        .map(this::executeValidator)
        .flatMap(Optional::stream)
        .map(this::mapToFieldError)
        .toList();
  }

  private FieldError mapToFieldError(ValidationError validationError) {
    return new FieldError(field.getFieldId(), List.of(validationError));
  }

  public List<AbstractValidator> getValidators() {
    return this.configuration.getValidationTypes().stream()
        .map(ValidatorFactory::getValidator)
        .collect(Collectors.toList());
  }

  public Optional<ValidationError> executeValidator(AbstractValidator validator) {
    return !validator.validate(field.getValue())
        ? Optional.of(new ValidationError(validator.getValidationType(), validator.getErrorMessage(field.getFieldId())))
        : Optional.empty();
  }
  public FieldConfiguration getConfiguration() {
    return configuration;
  }

  public void setConfiguration(final FieldConfiguration configuration) {
    this.configuration = configuration;
  }

  public Field getField() {
    return field;
  }

  public void setField(final Field field) {
    this.field = field;
  }
}
