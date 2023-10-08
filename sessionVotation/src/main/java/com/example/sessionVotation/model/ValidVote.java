package com.example.sessionVotation.model;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.FIELD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = VoteValidator.class)
public @interface ValidVote {
    String message() default "O voto deve ser 'Sim ou 'Não";
    Class<?>[] groups() default  {};
    Class<? extends Payload>[] payload() default {};
}
