package com.letscode.unidosdebuggaremos.Rebel.Control.StarWars.utils.nottraitor;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Target({FIELD})
@Retention(RUNTIME)
@Constraint(validatedBy =  NotTraitorValidator.class)
public @interface NotTraitor {

        String message() default "Traitor cannot do trades, you bastard";
        Class<?>[] groups() default {};
        Class<? extends Payload>[] payload() default {};
        String value() default "";

}
