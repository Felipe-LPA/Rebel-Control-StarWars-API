package com.letscode.unidosdebuggaremos.Rebel.Control.StarWars.utils.notduplicateditems;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Target({FIELD})
@Retention(RUNTIME)
@Constraint(validatedBy =  NotDuplicatedItemsValidator.class)
public @interface NotDuplicatedItems {

    String message() default "cannot the same item more than once";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
    String value() default "";
}
