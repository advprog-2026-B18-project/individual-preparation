package id.ac.ui.cs.advprog.individualpreparation.controller;

import id.ac.ui.cs.advprog.individualpreparation.dto.ArithmeticDivideRequest;
import id.ac.ui.cs.advprog.individualpreparation.dto.ArithmeticDivideResponse;
import id.ac.ui.cs.advprog.individualpreparation.dto.ArithmeticRequest;
import id.ac.ui.cs.advprog.individualpreparation.dto.ArithmeticResponse;
import id.ac.ui.cs.advprog.individualpreparation.service.ArithmeticUtilityService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class ArithmeticUtilityControllerTest {

    @InjectMocks
    private ArithmeticUtilityController arithmeticUtilityController;

    @Mock
    private ArithmeticUtilityService arithmeticUtilityService;

    private ArithmeticDivideRequest divideRequest;
    private ArithmeticRequest arithmeticRequest;
    private ArithmeticDivideResponse divideResponse;
    private ArithmeticResponse arithmeticResponse;

    @BeforeEach
    void setUp() {
        divideRequest = new ArithmeticDivideRequest();
        arithmeticRequest = new ArithmeticRequest();
        divideResponse = new ArithmeticDivideResponse();
        arithmeticResponse = new ArithmeticResponse();
    }

    @Test
    void testDivide_shouldCallServiceAndReturnResponse() {
        divideRequest.setO1(10.0);
        divideRequest.setO2(2.0);
        divideResponse.setResult(5.0);

        when(arithmeticUtilityService.divide(10.0, 2.0)).thenReturn(divideResponse);

        ArithmeticDivideResponse result = arithmeticUtilityController.divide(divideRequest);

        assertNotNull(result);
        assertEquals(5.0, result.getResult());
        verify(arithmeticUtilityService, times(1)).divide(10.0, 2.0);
    }

    @Test
    void testDivide_withNegativeNumbers_shouldReturnCorrectResponse() {
        divideRequest.setO1(-10.0);
        divideRequest.setO2(2.0);
        divideResponse.setResult(-5.0);

        when(arithmeticUtilityService.divide(-10.0, 2.0)).thenReturn(divideResponse);

        ArithmeticDivideResponse result = arithmeticUtilityController.divide(divideRequest);

        assertEquals(-5.0, result.getResult());
        verify(arithmeticUtilityService, times(1)).divide(-10.0, 2.0);
    }

    @Test
    void testDivide_withDecimals_shouldReturnCorrectResponse() {
        divideRequest.setO1(7.5);
        divideRequest.setO2(2.5);
        divideResponse.setResult(3.0);

        when(arithmeticUtilityService.divide(7.5, 2.5)).thenReturn(divideResponse);

        ArithmeticDivideResponse result = arithmeticUtilityController.divide(divideRequest);

        assertEquals(3.0, result.getResult());
        verify(arithmeticUtilityService, times(1)).divide(7.5, 2.5);
    }

    @Test
    void testDivide_shouldNotReturnNull() {
        divideRequest.setO1(10.0);
        divideRequest.setO2(2.0);
        divideResponse.setResult(5.0);

        when(arithmeticUtilityService.divide(10.0, 2.0)).thenReturn(divideResponse);

        ArithmeticDivideResponse result = arithmeticUtilityController.divide(divideRequest);

        assertNotNull(result);
    }

    @Test
    void testDivide_byZero_shouldThrowException() {
        divideRequest.setO1(10.0);
        divideRequest.setO2(0.0);

        when(arithmeticUtilityService.divide(10.0, 0.0))
                .thenThrow(new ArithmeticException("Cannot divide by zero."));

        Exception exception = assertThrows(ArithmeticException.class, () -> {
            arithmeticUtilityController.divide(divideRequest);
        });

        assertEquals("Cannot divide by zero.", exception.getMessage());
        verify(arithmeticUtilityService, times(1)).divide(10.0, 0.0);
    }

    @Test
    void testDivide_shouldNotReturnWrongResult() {
        divideRequest.setO1(10.0);
        divideRequest.setO2(2.0);
        divideResponse.setResult(5.0);

        when(arithmeticUtilityService.divide(10.0, 2.0)).thenReturn(divideResponse);

        ArithmeticDivideResponse result = arithmeticUtilityController.divide(divideRequest);

        assertNotEquals(2.0, result.getResult());
        assertNotEquals(10.0, result.getResult());
    }

    @Test
    void testSubtract_shouldCallServiceAndReturnResponse() {
        arithmeticRequest.setO1(10L);
        arithmeticRequest.setO2(3L);
        arithmeticResponse.setResult(7L);

        when(arithmeticUtilityService.subtract(10L, 3L)).thenReturn(arithmeticResponse);

        ArithmeticResponse result = arithmeticUtilityController.subtract(arithmeticRequest);

        assertNotNull(result);
        assertEquals(7L, result.getResult());
        verify(arithmeticUtilityService, times(1)).subtract(10L, 3L);
    }

    @Test
    void testSubtract_withNegativeResult_shouldReturnCorrectResponse() {
        arithmeticRequest.setO1(5L);
        arithmeticRequest.setO2(10L);
        arithmeticResponse.setResult(-5L);

        when(arithmeticUtilityService.subtract(5L, 10L)).thenReturn(arithmeticResponse);

        ArithmeticResponse result = arithmeticUtilityController.subtract(arithmeticRequest);

        assertEquals(-5L, result.getResult());
        verify(arithmeticUtilityService, times(1)).subtract(5L, 10L);
    }

    @Test
    void testSubtract_withNegativeNumbers_shouldReturnCorrectResponse() {
        arithmeticRequest.setO1(-5L);
        arithmeticRequest.setO2(-3L);
        arithmeticResponse.setResult(-2L);

        when(arithmeticUtilityService.subtract(-5L, -3L)).thenReturn(arithmeticResponse);

        ArithmeticResponse result = arithmeticUtilityController.subtract(arithmeticRequest);

        assertEquals(-2L, result.getResult());
        verify(arithmeticUtilityService, times(1)).subtract(-5L, -3L);
    }

    @Test
    void testSubtract_shouldNotReturnNull() {
        arithmeticRequest.setO1(10L);
        arithmeticRequest.setO2(3L);
        arithmeticResponse.setResult(7L);

        when(arithmeticUtilityService.subtract(10L, 3L)).thenReturn(arithmeticResponse);

        ArithmeticResponse result = arithmeticUtilityController.subtract(arithmeticRequest);

        assertNotNull(result);
    }

    @Test
    void testSubtract_shouldNotReturnWrongResult() {
        arithmeticRequest.setO1(10L);
        arithmeticRequest.setO2(3L);
        arithmeticResponse.setResult(7L);

        when(arithmeticUtilityService.subtract(10L, 3L)).thenReturn(arithmeticResponse);

        ArithmeticResponse result = arithmeticUtilityController.subtract(arithmeticRequest);

        assertNotEquals(13L, result.getResult());
        assertNotEquals(3L, result.getResult());
    }

    @Test
    void testExponent_shouldCallServiceAndReturnResponse() {
        arithmeticRequest.setO1(2L);
        arithmeticRequest.setO2(3L);
        arithmeticResponse.setResult(8L);

        when(arithmeticUtilityService.exponent(2L, 3L)).thenReturn(arithmeticResponse);

        ArithmeticResponse result = arithmeticUtilityController.exponent(arithmeticRequest);

        assertNotNull(result);
        assertEquals(8L, result.getResult());
        verify(arithmeticUtilityService, times(1)).exponent(2L, 3L);
    }

    @Test
    void testExponent_withZeroExponent_shouldReturnOne() {
        arithmeticRequest.setO1(5L);
        arithmeticRequest.setO2(0L);
        arithmeticResponse.setResult(1L);

        when(arithmeticUtilityService.exponent(5L, 0L)).thenReturn(arithmeticResponse);

        ArithmeticResponse result = arithmeticUtilityController.exponent(arithmeticRequest);

        assertEquals(1L, result.getResult());
        verify(arithmeticUtilityService, times(1)).exponent(5L, 0L);
    }

    @Test
    void testExponent_withOneExponent_shouldReturnBase() {
        arithmeticRequest.setO1(7L);
        arithmeticRequest.setO2(1L);
        arithmeticResponse.setResult(7L);

        when(arithmeticUtilityService.exponent(7L, 1L)).thenReturn(arithmeticResponse);

        ArithmeticResponse result = arithmeticUtilityController.exponent(arithmeticRequest);

        assertEquals(7L, result.getResult());
        verify(arithmeticUtilityService, times(1)).exponent(7L, 1L);
    }

    @Test
    void testExponent_withNegativeBase_shouldReturnCorrectResponse() {
        arithmeticRequest.setO1(-2L);
        arithmeticRequest.setO2(3L);
        arithmeticResponse.setResult(-8L);

        when(arithmeticUtilityService.exponent(-2L, 3L)).thenReturn(arithmeticResponse);

        ArithmeticResponse result = arithmeticUtilityController.exponent(arithmeticRequest);

        assertEquals(-8L, result.getResult());
        verify(arithmeticUtilityService, times(1)).exponent(-2L, 3L);
    }

    @Test
    void testExponent_shouldNotReturnNull() {
        arithmeticRequest.setO1(2L);
        arithmeticRequest.setO2(3L);
        arithmeticResponse.setResult(8L);

        when(arithmeticUtilityService.exponent(2L, 3L)).thenReturn(arithmeticResponse);

        ArithmeticResponse result = arithmeticUtilityController.exponent(arithmeticRequest);

        assertNotNull(result);
    }

    @Test
    void testExponent_shouldNotReturnWrongResult() {
        arithmeticRequest.setO1(2L);
        arithmeticRequest.setO2(3L);
        arithmeticResponse.setResult(8L);

        when(arithmeticUtilityService.exponent(2L, 3L)).thenReturn(arithmeticResponse);

        ArithmeticResponse result = arithmeticUtilityController.exponent(arithmeticRequest);

        assertNotEquals(6L, result.getResult());
        assertNotEquals(2L, result.getResult());
    }

    @Test
    void testMultiply_shouldCallServiceAndReturnResponse() {
        arithmeticRequest.setO1(5L);
        arithmeticRequest.setO2(4L);
        arithmeticResponse.setResult(20L);

        when(arithmeticUtilityService.multiply(5L, 4L)).thenReturn(arithmeticResponse);

        ArithmeticResponse result = arithmeticUtilityController.multiply(arithmeticRequest);

        assertNotNull(result);
        assertEquals(20L, result.getResult());
        verify(arithmeticUtilityService, times(1)).multiply(5L, 4L);
    }

    @Test
    void testMultiply_withNegativeNumbers_shouldReturnCorrectResponse() {
        arithmeticRequest.setO1(-5L);
        arithmeticRequest.setO2(4L);
        arithmeticResponse.setResult(-20L);

        when(arithmeticUtilityService.multiply(-5L, 4L)).thenReturn(arithmeticResponse);

        ArithmeticResponse result = arithmeticUtilityController.multiply(arithmeticRequest);

        assertEquals(-20L, result.getResult());
        verify(arithmeticUtilityService, times(1)).multiply(-5L, 4L);
    }

    @Test
    void testMultiply_withBothNegative_shouldReturnPositive() {
        arithmeticRequest.setO1(-5L);
        arithmeticRequest.setO2(-4L);
        arithmeticResponse.setResult(20L);

        when(arithmeticUtilityService.multiply(-5L, -4L)).thenReturn(arithmeticResponse);

        ArithmeticResponse result = arithmeticUtilityController.multiply(arithmeticRequest);

        assertEquals(20L, result.getResult());
        verify(arithmeticUtilityService, times(1)).multiply(-5L, -4L);
    }

    @Test
    void testMultiply_withZero_shouldReturnZero() {
        arithmeticRequest.setO1(10L);
        arithmeticRequest.setO2(0L);
        arithmeticResponse.setResult(0L);

        when(arithmeticUtilityService.multiply(10L, 0L)).thenReturn(arithmeticResponse);

        ArithmeticResponse result = arithmeticUtilityController.multiply(arithmeticRequest);

        assertEquals(0L, result.getResult());
        verify(arithmeticUtilityService, times(1)).multiply(10L, 0L);
    }

    @Test
    void testMultiply_withOne_shouldReturnSameNumber() {
        arithmeticRequest.setO1(7L);
        arithmeticRequest.setO2(1L);
        arithmeticResponse.setResult(7L);

        when(arithmeticUtilityService.multiply(7L, 1L)).thenReturn(arithmeticResponse);

        ArithmeticResponse result = arithmeticUtilityController.multiply(arithmeticRequest);

        assertEquals(7L, result.getResult());
        verify(arithmeticUtilityService, times(1)).multiply(7L, 1L);
    }

    @Test
    void testMultiply_shouldNotReturnNull() {
        arithmeticRequest.setO1(5L);
        arithmeticRequest.setO2(4L);
        arithmeticResponse.setResult(20L);

        when(arithmeticUtilityService.multiply(5L, 4L)).thenReturn(arithmeticResponse);

        ArithmeticResponse result = arithmeticUtilityController.multiply(arithmeticRequest);

        assertNotNull(result);
    }

    @Test
    void testMultiply_shouldNotReturnWrongResult() {
        arithmeticRequest.setO1(5L);
        arithmeticRequest.setO2(4L);
        arithmeticResponse.setResult(20L);

        when(arithmeticUtilityService.multiply(5L, 4L)).thenReturn(arithmeticResponse);

        ArithmeticResponse result = arithmeticUtilityController.multiply(arithmeticRequest);

        assertNotEquals(9L, result.getResult());
        assertNotEquals(1L, result.getResult());
    }

    @Test
    void testDivide_shouldCallServiceExactlyOnce() {
        divideRequest.setO1(10.0);
        divideRequest.setO2(2.0);
        divideResponse.setResult(5.0);

        when(arithmeticUtilityService.divide(10.0, 2.0)).thenReturn(divideResponse);

        arithmeticUtilityController.divide(divideRequest);

        verify(arithmeticUtilityService, times(1)).divide(10.0, 2.0);
        verifyNoMoreInteractions(arithmeticUtilityService);
    }

    @Test
    void testSubtract_shouldCallServiceExactlyOnce() {
        arithmeticRequest.setO1(10L);
        arithmeticRequest.setO2(3L);
        arithmeticResponse.setResult(7L);

        when(arithmeticUtilityService.subtract(10L, 3L)).thenReturn(arithmeticResponse);

        arithmeticUtilityController.subtract(arithmeticRequest);

        verify(arithmeticUtilityService, times(1)).subtract(10L, 3L);
        verifyNoMoreInteractions(arithmeticUtilityService);
    }

    @Test
    void testExponent_shouldCallServiceExactlyOnce() {
        arithmeticRequest.setO1(2L);
        arithmeticRequest.setO2(3L);
        arithmeticResponse.setResult(8L);

        when(arithmeticUtilityService.exponent(2L, 3L)).thenReturn(arithmeticResponse);

        arithmeticUtilityController.exponent(arithmeticRequest);

        verify(arithmeticUtilityService, times(1)).exponent(2L, 3L);
        verifyNoMoreInteractions(arithmeticUtilityService);
    }

    @Test
    void testMultiply_shouldCallServiceExactlyOnce() {
        arithmeticRequest.setO1(5L);
        arithmeticRequest.setO2(4L);
        arithmeticResponse.setResult(20L);

        when(arithmeticUtilityService.multiply(5L, 4L)).thenReturn(arithmeticResponse);

        arithmeticUtilityController.multiply(arithmeticRequest);

        verify(arithmeticUtilityService, times(1)).multiply(5L, 4L);
        verifyNoMoreInteractions(arithmeticUtilityService);
    }

    @Test
    void testDivide_withLargeNumbers_shouldReturnCorrectResponse() {
        divideRequest.setO1(1000000.0);
        divideRequest.setO2(1000.0);
        divideResponse.setResult(1000.0);

        when(arithmeticUtilityService.divide(1000000.0, 1000.0)).thenReturn(divideResponse);

        ArithmeticDivideResponse result = arithmeticUtilityController.divide(divideRequest);

        assertEquals(1000.0, result.getResult());
        verify(arithmeticUtilityService, times(1)).divide(1000000.0, 1000.0);
    }

    @Test
    void testSubtract_withLargeNumbers_shouldReturnCorrectResponse() {
        arithmeticRequest.setO1(1000000L);
        arithmeticRequest.setO2(999999L);
        arithmeticResponse.setResult(1L);

        when(arithmeticUtilityService.subtract(1000000L, 999999L)).thenReturn(arithmeticResponse);

        ArithmeticResponse result = arithmeticUtilityController.subtract(arithmeticRequest);

        assertEquals(1L, result.getResult());
        verify(arithmeticUtilityService, times(1)).subtract(1000000L, 999999L);
    }

    @Test
    void testExponent_withLargeExponent_shouldReturnCorrectResponse() {
        arithmeticRequest.setO1(2L);
        arithmeticRequest.setO2(10L);
        arithmeticResponse.setResult(1024L);

        when(arithmeticUtilityService.exponent(2L, 10L)).thenReturn(arithmeticResponse);

        ArithmeticResponse result = arithmeticUtilityController.exponent(arithmeticRequest);

        assertEquals(1024L, result.getResult());
        verify(arithmeticUtilityService, times(1)).exponent(2L, 10L);
    }

    @Test
    void testMultiply_withLargeNumbers_shouldReturnCorrectResponse() {
        arithmeticRequest.setO1(1000L);
        arithmeticRequest.setO2(1000L);
        arithmeticResponse.setResult(1000000L);

        when(arithmeticUtilityService.multiply(1000L, 1000L)).thenReturn(arithmeticResponse);

        ArithmeticResponse result = arithmeticUtilityController.multiply(arithmeticRequest);

        assertEquals(1000000L, result.getResult());
        verify(arithmeticUtilityService, times(1)).multiply(1000L, 1000L);
    }
}