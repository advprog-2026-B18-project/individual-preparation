package id.ac.ui.cs.advprog.individualpreparation.controller;

import id.ac.ui.cs.advprog.individualpreparation.dto.ErrorResponse;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class GlobalExceptionHandlerTest {

    @InjectMocks
    private GlobalExceptionHandler globalExceptionHandler;

    @BeforeEach
    void setUp() {
        globalExceptionHandler = new GlobalExceptionHandler();
    }

    @Test
    void testHandleIllegalArgument_shouldReturnErrorResponse() {
        IllegalArgumentException exception = new IllegalArgumentException("Vectors must have the same length.");

        ResponseEntity<ErrorResponse> response = globalExceptionHandler.handleIllegalArgument(exception);

        assertNotNull(response);
        assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
        assertNotNull(response.getBody());
        assertEquals("Vectors must have the same length.", response.getBody().getMessage());
        assertEquals("error", response.getBody().getStatus());
    }

    @Test
    void testHandleIllegalArgument_withDifferentMessage_shouldReturnCorrectErrorResponse() {
        IllegalArgumentException exception = new IllegalArgumentException("v1 and v2 should have the same size!");

        ResponseEntity<ErrorResponse> response = globalExceptionHandler.handleIllegalArgument(exception);

        assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
        assertEquals("v1 and v2 should have the same size!", response.getBody().getMessage());
        assertEquals("error", response.getBody().getStatus());
    }

    @Test
    void testHandleIllegalArgument_shouldNotReturnNull() {
        IllegalArgumentException exception = new IllegalArgumentException("Test error message");

        ResponseEntity<ErrorResponse> response = globalExceptionHandler.handleIllegalArgument(exception);

        assertNotNull(response);
        assertNotNull(response.getBody());
    }

    @Test
    void testHandleIllegalArgument_shouldReturnBadRequestStatus() {
        IllegalArgumentException exception = new IllegalArgumentException("Error");

        ResponseEntity<ErrorResponse> response = globalExceptionHandler.handleIllegalArgument(exception);

        assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
        assertEquals(400, response.getStatusCode().value());
    }

    @Test
    void testHandleIllegalArgument_withEmptyMessage_shouldReturnErrorResponse() {
        IllegalArgumentException exception = new IllegalArgumentException("");

        ResponseEntity<ErrorResponse> response = globalExceptionHandler.handleIllegalArgument(exception);

        assertNotNull(response);
        assertEquals("", response.getBody().getMessage());
        assertEquals("error", response.getBody().getStatus());
    }

    @Test
    void testHandleIllegalArgument_shouldNotReturnOkStatus() {
        IllegalArgumentException exception = new IllegalArgumentException("Error");

        ResponseEntity<ErrorResponse> response = globalExceptionHandler.handleIllegalArgument(exception);

        assertNotEquals(HttpStatus.OK, response.getStatusCode());
        assertNotEquals(HttpStatus.INTERNAL_SERVER_ERROR, response.getStatusCode());
    }

    @Test
    void testHandleIllegalArgument_shouldNotReturnWrongMessage() {
        IllegalArgumentException exception = new IllegalArgumentException("Vectors must have the same length.");

        ResponseEntity<ErrorResponse> response = globalExceptionHandler.handleIllegalArgument(exception);

        assertNotEquals("Different error message", response.getBody().getMessage());
    }

    @Test
    void testHandleIllegalArgument_shouldNotReturnSuccessStatus() {
        IllegalArgumentException exception = new IllegalArgumentException("Error");

        ResponseEntity<ErrorResponse> response = globalExceptionHandler.handleIllegalArgument(exception);

        assertNotEquals("success", response.getBody().getStatus());
    }

    @Test
    void testHandleInvalidRequestBody_withHttpMessageNotReadableException_shouldReturnErrorResponse() {
        HttpMessageNotReadableException exception =
                new HttpMessageNotReadableException("JSON parse error", (Throwable) null);

        ResponseEntity<ErrorResponse> response = globalExceptionHandler.handleInvalidRequestBody(exception);

        assertNotNull(response);
        assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
        assertNotNull(response.getBody());
        assertEquals("Invalid request body, input should be integer/vector of integer", response.getBody().getMessage());
        assertEquals("error", response.getBody().getStatus());
    }

    @Test
    void testHandleInvalidRequestBody_withHttpMessageNotReadableException_shouldNotReturnNull() {
        HttpMessageNotReadableException exception =
                new HttpMessageNotReadableException("Error", (Throwable) null);

        ResponseEntity<ErrorResponse> response = globalExceptionHandler.handleInvalidRequestBody(exception);

        assertNotNull(response);
        assertNotNull(response.getBody());
    }

    @Test
    void testHandleInvalidRequestBody_withHttpMessageNotReadableException_shouldReturnBadRequestStatus() {
        HttpMessageNotReadableException exception =
                new HttpMessageNotReadableException("Error", (Throwable) null);

        ResponseEntity<ErrorResponse> response = globalExceptionHandler.handleInvalidRequestBody(exception);

        assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
        assertEquals(400, response.getStatusCode().value());
    }

    @Test
    void testHandleInvalidRequestBody_withHttpMessageNotReadableException_shouldReturnFixedMessage() {
        HttpMessageNotReadableException exception1 =
                new HttpMessageNotReadableException("Different error 1", (Throwable) null);
        HttpMessageNotReadableException exception2 =
                new HttpMessageNotReadableException("Different error 2", (Throwable) null);

        ResponseEntity<ErrorResponse> response1 = globalExceptionHandler.handleInvalidRequestBody(exception1);
        ResponseEntity<ErrorResponse> response2 = globalExceptionHandler.handleInvalidRequestBody(exception2);

        assertEquals(response1.getBody().getMessage(), response2.getBody().getMessage());
        assertEquals("Invalid request body, input should be integer/vector of integer", response1.getBody().getMessage());
    }

    @Test
    void testHandleInvalidRequestBody_withHttpMessageNotReadableException_shouldNotReturnOkStatus() {
        HttpMessageNotReadableException exception =
                new HttpMessageNotReadableException("Error", (Throwable) null);

        ResponseEntity<ErrorResponse> response = globalExceptionHandler.handleInvalidRequestBody(exception);

        assertNotEquals(HttpStatus.OK, response.getStatusCode());
        assertNotEquals(HttpStatus.INTERNAL_SERVER_ERROR, response.getStatusCode());
    }

    @Test
    void testHandleInvalidRequestBody_withHttpMessageNotReadableException_shouldNotReturnWrongMessage() {
        HttpMessageNotReadableException exception =
                new HttpMessageNotReadableException("Error", (Throwable) null);

        ResponseEntity<ErrorResponse> response = globalExceptionHandler.handleInvalidRequestBody(exception);

        assertNotEquals("Different error message", response.getBody().getMessage());
        assertNotEquals("JSON parse error", response.getBody().getMessage());
    }

    @Test
    void testHandleInvalidRequestBody_withHttpMessageNotReadableException_shouldNotReturnSuccessStatus() {
        HttpMessageNotReadableException exception =
                new HttpMessageNotReadableException("Error", (Throwable) null);

        ResponseEntity<ErrorResponse> response = globalExceptionHandler.handleInvalidRequestBody(exception);

        assertNotEquals("success", response.getBody().getStatus());
    }

    @Test
    void testHandleInvalidRequestBody_withNullPointerException_shouldReturnErrorResponse() {
        NullPointerException exception = new NullPointerException("Null value encountered");

        ResponseEntity<ErrorResponse> response = globalExceptionHandler.handleInvalidRequestBody(exception);

        assertNotNull(response);
        assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
        assertNotNull(response.getBody());
        assertEquals("Invalid request body, use v1 and v2 for /vector endpoint, o1 and o2 for /arithmetic endpoint",
                response.getBody().getMessage());
        assertEquals("error", response.getBody().getStatus());
    }

    @Test
    void testHandleInvalidRequestBody_withNullPointerException_shouldNotReturnNull() {
        NullPointerException exception = new NullPointerException();

        ResponseEntity<ErrorResponse> response = globalExceptionHandler.handleInvalidRequestBody(exception);

        assertNotNull(response);
        assertNotNull(response.getBody());
    }

    @Test
    void testHandleInvalidRequestBody_withNullPointerException_shouldReturnBadRequestStatus() {
        NullPointerException exception = new NullPointerException();

        ResponseEntity<ErrorResponse> response = globalExceptionHandler.handleInvalidRequestBody(exception);

        assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
        assertEquals(400, response.getStatusCode().value());
    }

    @Test
    void testHandleInvalidRequestBody_withNullPointerException_shouldReturnFixedMessage() {
        NullPointerException exception1 = new NullPointerException("Error 1");
        NullPointerException exception2 = new NullPointerException("Error 2");

        ResponseEntity<ErrorResponse> response1 = globalExceptionHandler.handleInvalidRequestBody(exception1);
        ResponseEntity<ErrorResponse> response2 = globalExceptionHandler.handleInvalidRequestBody(exception2);

        assertEquals(response1.getBody().getMessage(), response2.getBody().getMessage());
        assertEquals("Invalid request body, use v1 and v2 for /vector endpoint, o1 and o2 for /arithmetic endpoint",
                response1.getBody().getMessage());
    }

    @Test
    void testHandleInvalidRequestBody_withNullPointerException_withoutMessage_shouldReturnErrorResponse() {
        NullPointerException exception = new NullPointerException();

        ResponseEntity<ErrorResponse> response = globalExceptionHandler.handleInvalidRequestBody(exception);

        assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
        assertEquals("Invalid request body, use v1 and v2 for /vector endpoint, o1 and o2 for /arithmetic endpoint",
                response.getBody().getMessage());
        assertEquals("error", response.getBody().getStatus());
    }

    @Test
    void testHandleInvalidRequestBody_withNullPointerException_shouldNotReturnOkStatus() {
        NullPointerException exception = new NullPointerException();

        ResponseEntity<ErrorResponse> response = globalExceptionHandler.handleInvalidRequestBody(exception);

        assertNotEquals(HttpStatus.OK, response.getStatusCode());
        assertNotEquals(HttpStatus.INTERNAL_SERVER_ERROR, response.getStatusCode());
    }

    @Test
    void testHandleInvalidRequestBody_withNullPointerException_shouldNotReturnWrongMessage() {
        NullPointerException exception = new NullPointerException();

        ResponseEntity<ErrorResponse> response = globalExceptionHandler.handleInvalidRequestBody(exception);

        assertNotEquals("Different error message", response.getBody().getMessage());
        assertNotEquals("Null value encountered", response.getBody().getMessage());
    }

    @Test
    void testHandleInvalidRequestBody_withNullPointerException_shouldNotReturnSuccessStatus() {
        NullPointerException exception = new NullPointerException();

        ResponseEntity<ErrorResponse> response = globalExceptionHandler.handleInvalidRequestBody(exception);

        assertNotEquals("success", response.getBody().getStatus());
    }

    @Test
    void testDifferentExceptions_shouldReturnDifferentMessages() {
        IllegalArgumentException illegalArgException =
                new IllegalArgumentException("Vectors must have the same length.");
        HttpMessageNotReadableException httpMessageException =
                new HttpMessageNotReadableException("Error", (Throwable) null);
        NullPointerException nullPointerException = new NullPointerException();

        ResponseEntity<ErrorResponse> response1 = globalExceptionHandler.handleIllegalArgument(illegalArgException);
        ResponseEntity<ErrorResponse> response2 = globalExceptionHandler.handleInvalidRequestBody(httpMessageException);
        ResponseEntity<ErrorResponse> response3 = globalExceptionHandler.handleInvalidRequestBody(nullPointerException);

        assertNotEquals(response1.getBody().getMessage(), response2.getBody().getMessage());
        assertNotEquals(response1.getBody().getMessage(), response3.getBody().getMessage());
        assertNotEquals(response2.getBody().getMessage(), response3.getBody().getMessage());
    }

    @Test
    void testDifferentExceptions_shouldAllReturnBadRequest() {
        IllegalArgumentException illegalArgException = new IllegalArgumentException("Error");
        HttpMessageNotReadableException httpMessageException =
                new HttpMessageNotReadableException("Error", (Throwable) null);
        NullPointerException nullPointerException = new NullPointerException();

        ResponseEntity<ErrorResponse> response1 = globalExceptionHandler.handleIllegalArgument(illegalArgException);
        ResponseEntity<ErrorResponse> response2 = globalExceptionHandler.handleInvalidRequestBody(httpMessageException);
        ResponseEntity<ErrorResponse> response3 = globalExceptionHandler.handleInvalidRequestBody(nullPointerException);

        assertEquals(HttpStatus.BAD_REQUEST, response1.getStatusCode());
        assertEquals(HttpStatus.BAD_REQUEST, response2.getStatusCode());
        assertEquals(HttpStatus.BAD_REQUEST, response3.getStatusCode());
    }

    @Test
    void testDifferentExceptions_shouldAllReturnErrorStatus() {
        IllegalArgumentException illegalArgException = new IllegalArgumentException("Error");
        HttpMessageNotReadableException httpMessageException =
                new HttpMessageNotReadableException("Error", (Throwable) null);
        NullPointerException nullPointerException = new NullPointerException();

        ResponseEntity<ErrorResponse> response1 = globalExceptionHandler.handleIllegalArgument(illegalArgException);
        ResponseEntity<ErrorResponse> response2 = globalExceptionHandler.handleInvalidRequestBody(httpMessageException);
        ResponseEntity<ErrorResponse> response3 = globalExceptionHandler.handleInvalidRequestBody(nullPointerException);

        assertEquals("error", response1.getBody().getStatus());
        assertEquals("error", response2.getBody().getStatus());
        assertEquals("error", response3.getBody().getStatus());
    }

    @Test
    void testHandleIllegalArgument_withLongMessage_shouldReturnCorrectErrorResponse() {
        String longMessage = "This is a very long error message that contains a lot of details about what went wrong " +
                "in the application and provides comprehensive information to help debug the issue.";
        IllegalArgumentException exception = new IllegalArgumentException(longMessage);

        ResponseEntity<ErrorResponse> response = globalExceptionHandler.handleIllegalArgument(exception);

        assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
        assertEquals(longMessage, response.getBody().getMessage());
        assertEquals("error", response.getBody().getStatus());
    }

    @Test
    void testHandleIllegalArgument_withSpecialCharacters_shouldReturnCorrectErrorResponse() {
        IllegalArgumentException exception = new IllegalArgumentException("Error: v1=[1,2,3] v2=[4,5]");

        ResponseEntity<ErrorResponse> response = globalExceptionHandler.handleIllegalArgument(exception);

        assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
        assertEquals("Error: v1=[1,2,3] v2=[4,5]", response.getBody().getMessage());
    }

    @Test
    void testAllHandlers_shouldConsistentlyReturnErrorResponseType() {
        IllegalArgumentException illegalArgException = new IllegalArgumentException("Error");
        HttpMessageNotReadableException httpMessageException =
                new HttpMessageNotReadableException("Error", (Throwable) null);
        NullPointerException nullPointerException = new NullPointerException();

        ResponseEntity<ErrorResponse> response1 = globalExceptionHandler.handleIllegalArgument(illegalArgException);
        ResponseEntity<ErrorResponse> response2 = globalExceptionHandler.handleInvalidRequestBody(httpMessageException);
        ResponseEntity<ErrorResponse> response3 = globalExceptionHandler.handleInvalidRequestBody(nullPointerException);

        assertTrue(response1.getBody() instanceof ErrorResponse);
        assertTrue(response2.getBody() instanceof ErrorResponse);
        assertTrue(response3.getBody() instanceof ErrorResponse);
    }
}