package id.ac.ui.cs.advprog.individualpreparation.dto;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ErrorResponseTest {

    @Test
    void testConstructorAndGetter() {
        ErrorResponse errorResponse = new ErrorResponse("Error message", "error");

        assertEquals("Error message", errorResponse.getMessage());
        assertEquals("error", errorResponse.getStatus());
    }

    @Test
    void testSetter() {
        ErrorResponse errorResponse = new ErrorResponse("Initial message", "error");

        errorResponse.setMessage("Updated message");
        errorResponse.setStatus("success");

        assertEquals("Updated message", errorResponse.getMessage());
        assertEquals("success", errorResponse.getStatus());
    }

    @Test
    void testConstructorWithEmptyStrings() {
        ErrorResponse errorResponse = new ErrorResponse("", "");

        assertEquals("", errorResponse.getMessage());
        assertEquals("", errorResponse.getStatus());
    }

    @Test
    void testConstructorWithLongMessage() {
        String longMessage = "This is a very long error message with detailed information";
        ErrorResponse errorResponse = new ErrorResponse(longMessage, "error");

        assertEquals(longMessage, errorResponse.getMessage());
        assertEquals("error", errorResponse.getStatus());
    }
}