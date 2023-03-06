package com.cyphex.inputdataguard;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

import com.cyphex.inputdataguard.error.FieldError;
import com.cyphex.inputdataguard.field.Field;
import com.cyphex.inputdataguard.field.FieldConfiguration;
import com.cyphex.inputdataguard.field.FieldValidation;

public class DataGuardValidation {

  public List<FieldError> validateFieldsWithConfiguration(List<Field> fields, List<FieldConfiguration> configurations) {

    // match fields
    List<FieldValidation> fieldValidations = matchFields(fields, configurations)
        .orElseThrow(() -> new RuntimeException("Fields don't match with current configuration"));

    return fieldValidations.stream()
        .map(FieldValidation::getFieldErrors)
        .flatMap(Collection::stream)
        .toList();
  }

  Optional<List<FieldValidation>> matchFields(List<Field> fields, List<FieldConfiguration> configurations) {
    if (fields.size() != configurations.size())
        return Optional.empty();

    Map<String, Field> fieldMap = fields.stream()
        .collect(Collectors.toMap(Field::getFieldId, Function.identity()));

    List<FieldValidation> fieldValidations = configurations.stream()
        .map(configField -> mapFieldValidation(configField, fieldMap))
        .flatMap(Optional::stream)
        .collect(Collectors.toList());

    boolean fieldsUnmatched = fieldValidations.stream().anyMatch(fv -> fv.getField() == null);
    return fieldsUnmatched ? Optional.empty() : Optional.of(fieldValidations);
  }

  private Optional<FieldValidation> mapFieldValidation(FieldConfiguration configuration, Map<String, Field> fieldMap) {
    return Optional.ofNullable(fieldMap.get(configuration.getFieldId()))
        .map(field -> new FieldValidation(configuration, field));
  }

}
