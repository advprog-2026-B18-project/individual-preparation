package id.ac.ui.cs.advprog.individualpreparation.controller;

import id.ac.ui.cs.advprog.individualpreparation.dto.ErrorResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
    private static final String ERROR_STATUS = "error";

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<ErrorResponse> handleIllegalArgument(
            IllegalArgumentException ex){

        ErrorResponse error = new ErrorResponse(ex.getMessage(), ERROR_STATUS);

        return ResponseEntity.badRequest().body(error);
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<ErrorResponse> handleInvalidRequestBody(
            HttpMessageNotReadableException ex) {

        ErrorResponse error = new ErrorResponse(
                "Invalid request body, input should be integer/vector of integer"
                , ERROR_STATUS);

        return ResponseEntity.badRequest().body(error);
    }

    @ExceptionHandler(NullPointerException.class)
    public ResponseEntity<ErrorResponse> handleInvalidRequestBody(
            NullPointerException ex) {

        ErrorResponse error = new ErrorResponse(
                "Invalid request body, use v1 and v2 for /vector " +
                        "endpoint, o1 and o2 for /arithmetic endpoint",
                ERROR_STATUS);

        return ResponseEntity.badRequest().body(error);
    }
}