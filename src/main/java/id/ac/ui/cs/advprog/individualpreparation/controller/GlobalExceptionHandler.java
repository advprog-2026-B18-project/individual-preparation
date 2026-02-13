package id.ac.ui.cs.advprog.individualpreparation.controller;

import id.ac.ui.cs.advprog.individualpreparation.dto.ErrorResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    // handle vector size yang berbeda
    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<ErrorResponse> handleIllegalArgument(
            IllegalArgumentException ex){

        ErrorResponse error =
                new ErrorResponse(ex.getMessage(), "error");

        return ResponseEntity.badRequest().body(error);
    }

    // handle input tipe data yang salah (harusnya integer)
    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<ErrorResponse> handleInvalidRequestBody(HttpMessageNotReadableException ex) {

        ErrorResponse error =
                new ErrorResponse("Invalid request body, input should be integer/vector of integer", "error");

        return ResponseEntity.badRequest().body(error);
    }

    // handle format input yang salah
    @ExceptionHandler(NullPointerException.class)
    public ResponseEntity<ErrorResponse> handleInvalidRequestBody(NullPointerException ex) {

        ErrorResponse error =
                new ErrorResponse("Invalid request body, use v1 and v2 for /vector endpoint, o1 and o2 for /arithmetic endpoint", "error");

        return ResponseEntity.badRequest().body(error);
    }
}