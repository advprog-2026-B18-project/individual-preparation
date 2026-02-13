package id.ac.ui.cs.advprog.individualpreparation.service;

import id.ac.ui.cs.advprog.individualpreparation.dto.ArithmeticDivideResponse;
import id.ac.ui.cs.advprog.individualpreparation.dto.ArithmeticResponse;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class ArithmeticUtilityServiceTest {

    @InjectMocks
    private ArithmeticUtilityService arithmeticUtilityService;

    @BeforeEach
    void setUp() {
        arithmeticUtilityService = new ArithmeticUtilityService();
    }

    @Test
    void testDivide_shouldReturnCorrectResult() {
        ArithmeticDivideResponse result = arithmeticUtilityService.divide(10.0, 2.0);

        assertNotNull(result);
        assertEquals(5.0, result.getResult());
    }

    @Test
    void testDivide_withNegativeNumbers_shouldReturnCorrectResult() {
        ArithmeticDivideResponse result = arithmeticUtilityService.divide(-10.0, 2.0);

        assertEquals(-5.0, result.getResult());
    }

    @Test
    void testDivide_withDecimals_shouldReturnCorrectResult() {
        ArithmeticDivideResponse result = arithmeticUtilityService.divide(7.5, 2.5);

        assertEquals(3.0, result.getResult());
    }

    @Test
    void testDivide_withZeroDividend_shouldReturnZero() {
        ArithmeticDivideResponse result = arithmeticUtilityService.divide(0.0, 5.0);

        assertEquals(0.0, result.getResult());
    }

    @Test
    void testDivide_shouldNotReturnNull() {
        ArithmeticDivideResponse result = arithmeticUtilityService.divide(10.0, 2.0);

        assertNotNull(result);
    }

    @Test
    void testDivide_byZero_shouldThrowArithmeticException() {
        Exception exception = assertThrows(ArithmeticException.class, () -> {
            arithmeticUtilityService.divide(10.0, 0.0);
        });

        assertEquals("Cannot divide by zero.", exception.getMessage());
    }

    @Test
    void testDivide_shouldNotReturnWrongResult() {
        ArithmeticDivideResponse result = arithmeticUtilityService.divide(10.0, 2.0);

        assertNotEquals(2.0, result.getResult());
        assertNotEquals(10.0, result.getResult());
    }

    // Positive Tests - Subtract
    @Test
    void testSubtract_shouldReturnCorrectResult() {
        ArithmeticResponse result = arithmeticUtilityService.subtract(10, 3);

        assertNotNull(result);
        assertEquals(7, result.getResult());
    }

    @Test
    void testSubtract_withNegativeResult_shouldReturnCorrectResult() {
        ArithmeticResponse result = arithmeticUtilityService.subtract(5, 10);

        assertEquals(-5, result.getResult());
    }

    @Test
    void testSubtract_withNegativeNumbers_shouldReturnCorrectResult() {
        ArithmeticResponse result = arithmeticUtilityService.subtract(-5, -3);

        assertEquals(-2, result.getResult());
    }

    @Test
    void testSubtract_withZero_shouldReturnCorrectResult() {
        ArithmeticResponse result = arithmeticUtilityService.subtract(10, 0);

        assertEquals(10, result.getResult());
    }

    @Test
    void testSubtract_shouldNotReturnNull() {
        ArithmeticResponse result = arithmeticUtilityService.subtract(10, 3);

        assertNotNull(result);
    }

    @Test
    void testSubtract_shouldNotReturnWrongResult() {
        ArithmeticResponse result = arithmeticUtilityService.subtract(10, 3);

        assertNotEquals(13, result.getResult());
        assertNotEquals(3, result.getResult());
    }

    @Test
    void testExponent_shouldReturnCorrectResult() {
        ArithmeticResponse result = arithmeticUtilityService.exponent(2, 3);

        assertNotNull(result);
        assertEquals(8, result.getResult());
    }

    @Test
    void testExponent_withZeroExponent_shouldReturnOne() {
        ArithmeticResponse result = arithmeticUtilityService.exponent(5, 0);

        assertEquals(1, result.getResult());
    }

    @Test
    void testExponent_withOneExponent_shouldReturnBase() {
        ArithmeticResponse result = arithmeticUtilityService.exponent(7, 1);

        assertEquals(7, result.getResult());
    }

    @Test
    void testExponent_withNegativeBase_shouldReturnCorrectResult() {
        ArithmeticResponse result = arithmeticUtilityService.exponent(-2, 3);

        assertEquals(-8, result.getResult());
    }

    @Test
    void testExponent_withNegativeBaseEvenExponent_shouldReturnPositive() {
        ArithmeticResponse result = arithmeticUtilityService.exponent(-2, 2);

        assertEquals(4, result.getResult());
    }

    @Test
    void testExponent_shouldNotReturnNull() {
        ArithmeticResponse result = arithmeticUtilityService.exponent(2, 3);

        assertNotNull(result);
    }

    @Test
    void testExponent_shouldNotReturnWrongResult() {
        ArithmeticResponse result = arithmeticUtilityService.exponent(2, 3);

        assertNotEquals(6, result.getResult());
        assertNotEquals(2, result.getResult());
    }

    @Test
    void testMultiply_shouldReturnCorrectResult() {
        ArithmeticResponse result = arithmeticUtilityService.multiply(5, 4);

        assertNotNull(result);
        assertEquals(20, result.getResult());
    }

    @Test
    void testMultiply_withNegativeNumbers_shouldReturnCorrectResult() {
        ArithmeticResponse result = arithmeticUtilityService.multiply(-5, 4);

        assertEquals(-20, result.getResult());
    }

    @Test
    void testMultiply_withBothNegative_shouldReturnPositive() {
        ArithmeticResponse result = arithmeticUtilityService.multiply(-5, -4);

        assertEquals(20, result.getResult());
    }

    @Test
    void testMultiply_withZero_shouldReturnZero() {
        ArithmeticResponse result = arithmeticUtilityService.multiply(10, 0);

        assertEquals(0, result.getResult());
    }

    @Test
    void testMultiply_withOne_shouldReturnSameNumber() {
        ArithmeticResponse result = arithmeticUtilityService.multiply(7, 1);

        assertEquals(7, result.getResult());
    }

    @Test
    void testMultiply_shouldNotReturnNull() {
        ArithmeticResponse result = arithmeticUtilityService.multiply(5, 4);

        assertNotNull(result);
    }

    @Test
    void testMultiply_shouldNotReturnWrongResult() {
        ArithmeticResponse result = arithmeticUtilityService.multiply(5, 4);

        assertNotEquals(9, result.getResult());
        assertNotEquals(1, result.getResult());
    }

    @Test
    void testDivide_withLargeNumbers_shouldReturnCorrectResult() {
        ArithmeticDivideResponse result = arithmeticUtilityService.divide(1000000.0, 1000.0);

        assertEquals(1000.0, result.getResult());
    }

    @Test
    void testSubtract_withLargeNumbers_shouldReturnCorrectResult() {
        ArithmeticResponse result = arithmeticUtilityService.subtract(1000000, 999999);

        assertEquals(1, result.getResult());
    }

    @Test
    void testExponent_withLargeExponent_shouldReturnCorrectResult() {
        ArithmeticResponse result = arithmeticUtilityService.exponent(2, 10);

        assertEquals(1024, result.getResult());
    }

    @Test
    void testMultiply_withLargeNumbers_shouldReturnCorrectResult() {
        ArithmeticResponse result = arithmeticUtilityService.multiply(1000, 1000);

        assertEquals(1000000, result.getResult());
    }
}