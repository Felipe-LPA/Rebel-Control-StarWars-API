package com.letscode.unidosdebuggaremos.Rebel.Control.StarWars.config;

import com.letscode.unidosdebuggaremos.Rebel.Control.StarWars.exceptions.NotFoundException;
import com.letscode.unidosdebuggaremos.Rebel.Control.StarWars.exceptions.TradeException;
import com.letscode.unidosdebuggaremos.Rebel.Control.StarWars.exceptions.ValidationError;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.ArrayList;
import java.util.List;

@RestControllerAdvice
public class ErrorHandle {

    @Autowired
    private MessageSource messageSource;

    @ResponseStatus(code = HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public List<ValidationError> ValidationErrorHandler(MethodArgumentNotValidException exception){
        List<ValidationError> errors = new ArrayList<>();
        List<FieldError> errorFields = exception.getBindingResult().getFieldErrors();
        errorFields.forEach(e ->{
            String message =  messageSource.getMessage(e, LocaleContextHolder.getLocale());
            ValidationError error = new ValidationError(e.getField(), message);
            errors.add(error);
        });
        return  errors;
    }

    @ResponseStatus(code = HttpStatus.NOT_FOUND)
    @ExceptionHandler(NotFoundException.class)
    public String NotFoundHandler(NotFoundException exception){
        return exception.getMessage();
    }

    @ResponseStatus(code = HttpStatus.BAD_REQUEST)
    @ExceptionHandler(TradeException.class)
    public String TradeErrorHandler(TradeException exception){
        return exception.getMessage();
    }
}
