package com.adifier.handler;

import com.adifier.exception.InvalidRequestException;
import com.adifier.exception.NotFoundException;
import com.adifier.exception.ProductInfoNotFoundException;
import com.adifier.resource.ErrorResource;
import com.adifier.resource.FieldResource;
import com.adifier.resource.InvalidErrorResource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.ArrayList;
import java.util.List;

/**
 * 描述:
 * create API goble exception
 *
 * @author StevenWu
 * @create 2019-02-06-23:52
 */
@RestControllerAdvice
public class ApiExceptionHandler {

    /**
     * handle not found exception
     * @param e
     * @return
     */
    @ExceptionHandler(NotFoundException.class)
    @ResponseBody
    public ResponseEntity<?> handleNotFound(RuntimeException e){
        ErrorResource errorResource=new ErrorResource(e.getMessage());
        return new ResponseEntity<Object>(errorResource, HttpStatus.NOT_FOUND);
    }

    /**
     * handle Request parameter Invalid
     * @param e
     * @return
     */
    @ExceptionHandler(InvalidRequestException.class)
    @ResponseBody
    public ResponseEntity<?> handleInvalidRequest(InvalidRequestException e){
        Errors errors=e.getErrors();
        List<FieldResource> fieldResources=new ArrayList<>();
        List<FieldError> fieldErrors=errors.getFieldErrors();
        for(FieldError fieldError: fieldErrors){
            FieldResource fieldResource=new FieldResource(fieldError.getObjectName(),
                    fieldError.getField(),
                    fieldError.getCode(),
                    fieldError.getDefaultMessage());
            fieldResources.add(fieldResource);
        }
        InvalidErrorResource ier=new InvalidErrorResource(e.getMessage(), fieldResources);
        return new ResponseEntity<Object>(ier, HttpStatus.BAD_REQUEST);
    }

    /**
     * handel global errors
     * @param e
     * @return
     */
    @ExceptionHandler(Exception.class)
    @ResponseBody
    public ResponseEntity<?> handleException(Exception e){
        return new ResponseEntity<Object>(HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
