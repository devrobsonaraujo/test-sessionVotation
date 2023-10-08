package com.example.sessionVotation.model;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class VoteValidator implements ConstraintValidator<ValidVote, String> {

    @Override
    public void initialize(ValidVote constraintAnnotation) {

    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext contex) {
        return value != null && (value.equals("sim") || value.equals("não"));
    }
}
