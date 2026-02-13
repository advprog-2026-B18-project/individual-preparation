package id.ac.ui.cs.advprog.individualpreparation.service;

import id.ac.ui.cs.advprog.individualpreparation.dto.VectorResponse;
import id.ac.ui.cs.advprog.individualpreparation.dto.ScalarResponse;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class VectorUtilityServiceTest {

    @InjectMocks
    private VectorUtilityService vectorUtilityService;

    @BeforeEach
    void setUp() {
        vectorUtilityService = new VectorUtilityService();
    }

    @Test
    void testSubtract_shouldReturnCorrectResult() {
        List<Integer> v1 = Arrays.asList(5, 10, 15);
        List<Integer> v2 = Arrays.asList(2, 3, 5);

        VectorResponse result = vectorUtilityService.subtract(v1, v2);

        assertNotNull(result);
        assertNotNull(result.getResult());
        assertEquals(3, result.getResult().size());
        assertEquals(3, result.getResult().get(0));
        assertEquals(7, result.getResult().get(1));
        assertEquals(10, result.getResult().get(2));
    }

    @Test
    void testSubtract_withNegativeResult_shouldReturnCorrectResult() {
        List<Integer> v1 = Arrays.asList(1, 2, 3);
        List<Integer> v2 = Arrays.asList(5, 6, 7);

        VectorResponse result = vectorUtilityService.subtract(v1, v2);

        assertEquals(-4, result.getResult().get(0));
        assertEquals(-4, result.getResult().get(1));
        assertEquals(-4, result.getResult().get(2));
    }

    @Test
    void testSubtract_withNegativeNumbers_shouldReturnCorrectResult() {
        List<Integer> v1 = Arrays.asList(-5, -10, -15);
        List<Integer> v2 = Arrays.asList(-2, -3, -5);

        VectorResponse result = vectorUtilityService.subtract(v1, v2);

        assertEquals(-3, result.getResult().get(0));
        assertEquals(-7, result.getResult().get(1));
        assertEquals(-10, result.getResult().get(2));
    }

    @Test
    void testSubtract_withZeroVector_shouldReturnOriginalVector() {
        List<Integer> v1 = Arrays.asList(5, 10, 15);
        List<Integer> v2 = Arrays.asList(0, 0, 0);

        VectorResponse result = vectorUtilityService.subtract(v1, v2);

        assertEquals(5, result.getResult().get(0));
        assertEquals(10, result.getResult().get(1));
        assertEquals(15, result.getResult().get(2));
    }

    @Test
    void testSubtract_withSingleElement_shouldReturnCorrectResult() {
        List<Integer> v1 = Arrays.asList(10);
        List<Integer> v2 = Arrays.asList(3);

        VectorResponse result = vectorUtilityService.subtract(v1, v2);

        assertEquals(1, result.getResult().size());
        assertEquals(7, result.getResult().get(0));
    }

    @Test
    void testSubtract_shouldNotReturnNull() {
        List<Integer> v1 = Arrays.asList(5, 10);
        List<Integer> v2 = Arrays.asList(2, 3);

        VectorResponse result = vectorUtilityService.subtract(v1, v2);

        assertNotNull(result);
        assertNotNull(result.getResult());
    }

    @Test
    void testSubtract_withDifferentSizes_shouldThrowException() {
        List<Integer> v1 = Arrays.asList(1, 2, 3);
        List<Integer> v2 = Arrays.asList(1, 2);

        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            vectorUtilityService.subtract(v1, v2);
        });

        assertEquals("Vectors must have the same length.", exception.getMessage());
    }

    @Test
    void testSubtract_withEmptyFirstVector_shouldThrowException() {
        List<Integer> v1 = new ArrayList<>();
        List<Integer> v2 = Arrays.asList(1, 2, 3);

        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            vectorUtilityService.subtract(v1, v2);
        });

        assertEquals("Vectors must have the same length.", exception.getMessage());
    }

    @Test
    void testSubtract_shouldNotReturnWrongResult() {
        List<Integer> v1 = Arrays.asList(5, 10);
        List<Integer> v2 = Arrays.asList(2, 3);

        VectorResponse result = vectorUtilityService.subtract(v1, v2);

        assertNotEquals(7, result.getResult().get(0));
        assertNotEquals(13, result.getResult().get(1));
    }

    @Test
    void testDotProduct_shouldReturnCorrectResult() {
        List<Integer> v1 = Arrays.asList(1, 2, 3);
        List<Integer> v2 = Arrays.asList(4, 5, 6);

        ScalarResponse result = vectorUtilityService.dotproduct(v1, v2);

        assertNotNull(result);
        assertEquals(32, result.getResult()); // 1*4 + 2*5 + 3*6 = 4 + 10 + 18 = 32
    }

    @Test
    void testDotProduct_withNegativeNumbers_shouldReturnCorrectResult() {
        List<Integer> v1 = Arrays.asList(-1, -2, -3);
        List<Integer> v2 = Arrays.asList(4, 5, 6);

        ScalarResponse result = vectorUtilityService.dotproduct(v1, v2);

        assertEquals(-32, result.getResult()); // -1*4 + -2*5 + -3*6 = -4 + -10 + -18 = -32
    }

    @Test
    void testDotProduct_withZeroVector_shouldReturnZero() {
        List<Integer> v1 = Arrays.asList(1, 2, 3);
        List<Integer> v2 = Arrays.asList(0, 0, 0);

        ScalarResponse result = vectorUtilityService.dotproduct(v1, v2);

        assertEquals(0, result.getResult());
    }

    @Test
    void testDotProduct_withSingleElement_shouldReturnCorrectResult() {
        List<Integer> v1 = Arrays.asList(5);
        List<Integer> v2 = Arrays.asList(3);

        ScalarResponse result = vectorUtilityService.dotproduct(v1, v2);

        assertEquals(15, result.getResult());
    }

    @Test
    void testDotProduct_shouldNotReturnNull() {
        List<Integer> v1 = Arrays.asList(1, 2, 3);
        List<Integer> v2 = Arrays.asList(4, 5, 6);

        ScalarResponse result = vectorUtilityService.dotproduct(v1, v2);

        assertNotNull(result);
    }

    @Test
    void testDotProduct_withDifferentSizes_shouldThrowException() {
        List<Integer> v1 = Arrays.asList(1, 2, 3);
        List<Integer> v2 = Arrays.asList(1, 2);

        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            vectorUtilityService.dotproduct(v1, v2);
        });

        assertEquals("Vectors must have the same length", exception.getMessage());
    }

    @Test
    void testDotProduct_shouldNotReturnWrongResult() {
        List<Integer> v1 = Arrays.asList(1, 2, 3);
        List<Integer> v2 = Arrays.asList(4, 5, 6);

        ScalarResponse result = vectorUtilityService.dotproduct(v1, v2);

        assertNotEquals(15, result.getResult());
        assertNotEquals(0, result.getResult());
    }

    @Test
    void testAdd_shouldReturnCorrectResult() {
        List<Integer> v1 = Arrays.asList(1, 2, 3);
        List<Integer> v2 = Arrays.asList(4, 5, 6);

        VectorResponse result = vectorUtilityService.add(v1, v2);

        assertNotNull(result);
        assertNotNull(result.getResult());
        assertEquals(3, result.getResult().size());
        assertEquals(5, result.getResult().get(0));
        assertEquals(7, result.getResult().get(1));
        assertEquals(9, result.getResult().get(2));
    }

    @Test
    void testAdd_withNegativeNumbers_shouldReturnCorrectResult() {
        List<Integer> v1 = Arrays.asList(-1, -2, -3);
        List<Integer> v2 = Arrays.asList(4, 5, 6);

        VectorResponse result = vectorUtilityService.add(v1, v2);

        assertEquals(3, result.getResult().get(0));
        assertEquals(3, result.getResult().get(1));
        assertEquals(3, result.getResult().get(2));
    }

    @Test
    void testAdd_withZeroVector_shouldReturnOriginalVector() {
        List<Integer> v1 = Arrays.asList(5, 10, 15);
        List<Integer> v2 = Arrays.asList(0, 0, 0);

        VectorResponse result = vectorUtilityService.add(v1, v2);

        assertEquals(5, result.getResult().get(0));
        assertEquals(10, result.getResult().get(1));
        assertEquals(15, result.getResult().get(2));
    }

    @Test
    void testAdd_withSingleElement_shouldReturnCorrectResult() {
        List<Integer> v1 = Arrays.asList(10);
        List<Integer> v2 = Arrays.asList(3);

        VectorResponse result = vectorUtilityService.add(v1, v2);

        assertEquals(1, result.getResult().size());
        assertEquals(13, result.getResult().get(0));
    }

    @Test
    void testAdd_shouldNotReturnNull() {
        List<Integer> v1 = Arrays.asList(1, 2, 3);
        List<Integer> v2 = Arrays.asList(4, 5, 6);

        VectorResponse result = vectorUtilityService.add(v1, v2);

        assertNotNull(result);
        assertNotNull(result.getResult());
    }

    @Test
    void testAdd_withDifferentSizes_shouldThrowException() {
        List<Integer> v1 = Arrays.asList(1, 2, 3);
        List<Integer> v2 = Arrays.asList(1, 2);

        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            vectorUtilityService.add(v1, v2);
        });

        assertEquals("v1 and v2 should have the same size!", exception.getMessage());
    }

    @Test
    void testAdd_shouldNotReturnWrongResult() {
        List<Integer> v1 = Arrays.asList(1, 2, 3);
        List<Integer> v2 = Arrays.asList(4, 5, 6);

        VectorResponse result = vectorUtilityService.add(v1, v2);

        assertNotEquals(3, result.getResult().get(0));
        assertNotEquals(10, result.getResult().get(1));
    }

    @Test
    void testMultiply_shouldReturnCorrectResult() {
        List<Integer> v1 = Arrays.asList(1, 2, 3);
        List<Integer> v2 = Arrays.asList(5);

        VectorResponse result = vectorUtilityService.multiply(v1, v2);

        assertNotNull(result);
        assertNotNull(result.getResult());
        assertEquals(3, result.getResult().size());
        assertEquals(5, result.getResult().get(0));
        assertEquals(10, result.getResult().get(1));
        assertEquals(15, result.getResult().get(2));
    }

    @Test
    void testMultiply_withNegativeScalar_shouldReturnCorrectResult() {
        List<Integer> v1 = Arrays.asList(2, 4, 6);
        List<Integer> v2 = Arrays.asList(-3);

        VectorResponse result = vectorUtilityService.multiply(v1, v2);

        assertEquals(-6, result.getResult().get(0));
        assertEquals(-12, result.getResult().get(1));
        assertEquals(-18, result.getResult().get(2));
    }

    @Test
    void testMultiply_withZeroScalar_shouldReturnZeroVector() {
        List<Integer> v1 = Arrays.asList(5, 10, 15);
        List<Integer> v2 = Arrays.asList(0);

        VectorResponse result = vectorUtilityService.multiply(v1, v2);

        assertEquals(0, result.getResult().get(0));
        assertEquals(0, result.getResult().get(1));
        assertEquals(0, result.getResult().get(2));
    }

    @Test
    void testMultiply_withOneScalar_shouldReturnOriginalVector() {
        List<Integer> v1 = Arrays.asList(7, 8, 9);
        List<Integer> v2 = Arrays.asList(1);

        VectorResponse result = vectorUtilityService.multiply(v1, v2);

        assertEquals(7, result.getResult().get(0));
        assertEquals(8, result.getResult().get(1));
        assertEquals(9, result.getResult().get(2));
    }

    @Test
    void testMultiply_withSingleElementVector_shouldReturnCorrectResult() {
        List<Integer> v1 = Arrays.asList(10);
        List<Integer> v2 = Arrays.asList(3);

        VectorResponse result = vectorUtilityService.multiply(v1, v2);

        assertEquals(1, result.getResult().size());
        assertEquals(30, result.getResult().get(0));
    }

    @Test
    void testMultiply_shouldNotReturnNull() {
        List<Integer> v1 = Arrays.asList(1, 2, 3);
        List<Integer> v2 = Arrays.asList(5);

        VectorResponse result = vectorUtilityService.multiply(v1, v2);

        assertNotNull(result);
        assertNotNull(result.getResult());
    }

    @Test
    void testMultiply_shouldNotReturnWrongResult() {
        List<Integer> v1 = Arrays.asList(1, 2, 3);
        List<Integer> v2 = Arrays.asList(5);

        VectorResponse result = vectorUtilityService.multiply(v1, v2);

        assertNotEquals(1, result.getResult().get(0));
        assertNotEquals(7, result.getResult().get(1));
    }

    @Test
    void testValidateVectorSize_withSameSizes_shouldNotThrowException() {
        List<Integer> v1 = Arrays.asList(1, 2, 3);
        List<Integer> v2 = Arrays.asList(4, 5, 6);

        assertDoesNotThrow(() -> {
            vectorUtilityService.validateVectorSize(v1, v2);
        });
    }

    @Test
    void testValidateVectorSize_withEmptyVectors_shouldNotThrowException() {
        List<Integer> v1 = new ArrayList<>();
        List<Integer> v2 = new ArrayList<>();

        assertDoesNotThrow(() -> {
            vectorUtilityService.validateVectorSize(v1, v2);
        });
    }

    @Test
    void testValidateVectorSize_withDifferentSizes_shouldThrowException() {
        List<Integer> v1 = Arrays.asList(1, 2, 3);
        List<Integer> v2 = Arrays.asList(1, 2);

        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            vectorUtilityService.validateVectorSize(v1, v2);
        });

        assertEquals("v1 and v2 should have the same size!", exception.getMessage());
    }

    @Test
    void testValidateVectorSize_withFirstVectorEmpty_shouldThrowException() {
        List<Integer> v1 = new ArrayList<>();
        List<Integer> v2 = Arrays.asList(1, 2, 3);

        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            vectorUtilityService.validateVectorSize(v1, v2);
        });

        assertEquals("v1 and v2 should have the same size!", exception.getMessage());
    }

    @Test
    void testValidateVectorSize_withSecondVectorEmpty_shouldThrowException() {
        List<Integer> v1 = Arrays.asList(1, 2, 3);
        List<Integer> v2 = new ArrayList<>();

        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            vectorUtilityService.validateVectorSize(v1, v2);
        });

        assertEquals("v1 and v2 should have the same size!", exception.getMessage());
    }

    @Test
    void testSubtract_withLargeVectors_shouldReturnCorrectResult() {
        List<Integer> v1 = Arrays.asList(1000, 2000, 3000, 4000, 5000);
        List<Integer> v2 = Arrays.asList(100, 200, 300, 400, 500);

        VectorResponse result = vectorUtilityService.subtract(v1, v2);

        assertEquals(5, result.getResult().size());
        assertEquals(900, result.getResult().get(0));
        assertEquals(4500, result.getResult().get(4));
    }

    @Test
    void testDotProduct_withLargeNumbers_shouldReturnCorrectResult() {
        List<Integer> v1 = Arrays.asList(1000, 2000);
        List<Integer> v2 = Arrays.asList(3000, 4000);

        ScalarResponse result = vectorUtilityService.dotproduct(v1, v2);

        assertEquals(11000000, result.getResult()); // 1000*3000 + 2000*4000 = 3000000 + 8000000
    }

    @Test
    void testAdd_withLargeVectors_shouldReturnCorrectResult() {
        List<Integer> v1 = Arrays.asList(1000, 2000, 3000);
        List<Integer> v2 = Arrays.asList(4000, 5000, 6000);

        VectorResponse result = vectorUtilityService.add(v1, v2);

        assertEquals(5000, result.getResult().get(0));
        assertEquals(7000, result.getResult().get(1));
        assertEquals(9000, result.getResult().get(2));
    }

    @Test
    void testMultiply_withLargeNumbers_shouldReturnCorrectResult() {
        List<Integer> v1 = Arrays.asList(100, 200, 300);
        List<Integer> v2 = Arrays.asList(10);

        VectorResponse result = vectorUtilityService.multiply(v1, v2);

        assertEquals(1000, result.getResult().get(0));
        assertEquals(2000, result.getResult().get(1));
        assertEquals(3000, result.getResult().get(2));
    }
}