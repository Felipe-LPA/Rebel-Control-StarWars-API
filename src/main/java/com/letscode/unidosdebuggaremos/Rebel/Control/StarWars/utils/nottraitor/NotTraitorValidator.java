package com.letscode.unidosdebuggaremos.Rebel.Control.StarWars.utils.nottraitor;


import com.letscode.unidosdebuggaremos.Rebel.Control.StarWars.RebelControlStarWarsApplication;
import com.letscode.unidosdebuggaremos.Rebel.Control.StarWars.model.Rebel;
import lombok.SneakyThrows;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.UUID;

public class NotTraitorValidator implements ConstraintValidator<NotTraitor, UUID>{
    @Override
    public void initialize(NotTraitor constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }


    @Override
    public boolean isValid(UUID rebelId, ConstraintValidatorContext context) {
        Rebel rebel = null;
        try {
            rebel = RebelControlStarWarsApplication.bancoRebel.getDetailsRebel(rebelId);
            if (rebel.isTraitor()){
                return false;
            }
        } catch (Exception e) {
            return false;
        }

        return true;
    }
}
