package com.letscode.unidosdebuggaremos.Rebel.Control.StarWars.utils.notduplicateditems;

import com.letscode.unidosdebuggaremos.Rebel.Control.StarWars.dto.RequestItem;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.atomic.AtomicBoolean;

public class NotDuplicatedItemsValidator  implements ConstraintValidator<NotDuplicatedItems, List<RequestItem>> {
    @Override
    public void initialize(NotDuplicatedItems constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }


    @Override
    public boolean isValid(List<RequestItem> requestItems, ConstraintValidatorContext context) {
        List<String> items = new ArrayList<>();
        AtomicBoolean notDuplicated = new AtomicBoolean(true);
        requestItems.forEach(requestItem -> {
            if(items.contains(requestItem.getItemName().toLowerCase(Locale.ROOT))){
                notDuplicated.set(false);
            }
            items.add(requestItem.getItemName().toLowerCase(Locale.ROOT));
        });
        return notDuplicated.get();
    }
}
