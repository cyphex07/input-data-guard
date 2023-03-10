package com.cyphex.inputdataguard.validation;

import com.cyphex.inputdataguard.validator.EmailValidator;
import com.cyphex.inputdataguard.validator.RequiredValidator;
import com.cyphex.inputdataguard.validator.NumberValidator;

public class ValidatorFactory {

  public static AbstractValidator getValidator(ValidationType validationType) {
    return
        switch (validationType) {
          case REQUIRED -> new RequiredValidator();
          case EMAIL -> new EmailValidator();
          case IS_NUMBER -> new NumberValidator();
          default -> throw new IllegalStateException("Validation type invalid");
        };
  }
}
