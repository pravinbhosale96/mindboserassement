package com.assignment.mindbow.exceptionadvice;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.assignment.mindbow.exceptions.DataNotValidException;
import com.assignment.mindbow.exceptions.StripeExcetionCustom;
import com.assignment.mindbow.utility.Response;

@ControllerAdvice
public class ExceptionAdvice {


    @ExceptionHandler(value = DataNotValidException.class)
     public ResponseEntity<Response> handleGenericNotValidException(DataNotValidException e) {

        Response error = new Response();

        error.setTimeStamp(LocalDateTime.now());
        error.setStatus((HttpStatus.NOT_FOUND.value()));
        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }   
    
    @ExceptionHandler(value = StripeExcetionCustom.class)
    public ResponseEntity<Response> handleStripeExcetionCustom(StripeExcetionCustom e) {

       Response error = new Response();

        error.setTimeStamp(LocalDateTime.now());
       error.setStatus((HttpStatus.NOT_FOUND.value()));
       return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
   }   
}