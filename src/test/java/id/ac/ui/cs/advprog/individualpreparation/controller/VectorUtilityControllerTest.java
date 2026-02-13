package id.ac.ui.cs.advprog.individualpreparation.controller;

import id.ac.ui.cs.advprog.individualpreparation.dto.ScalarResponse;
import id.ac.ui.cs.advprog.individualpreparation.dto.VectorRequest;
import id.ac.ui.cs.advprog.individualpreparation.dto.VectorResponse;
import id.ac.ui.cs.advprog.individualpreparation.service.VectorUtilityService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class VectorUtilityControllerTest {

    @InjectMocks
    private VectorUtilityController vectorUtilityController;

    @Mock
    private VectorUtilityService vectorUtilityService;

    private VectorRequest vectorRequest;
    private VectorResponse vectorResponse;
    private ScalarResponse scalarResponse;

    @BeforeEach
    void setUp() {
        vectorRequest = new VectorRequest();
        vectorResponse = new VectorResponse();
        scalarResponse = new ScalarResponse();
    }

    @Test
    void testSubtract_shouldCallServiceAndReturnResponse() {
        List<Integer> v1 = Arrays.asList(5, 10, 15);
        List<Integer> v2 = Arrays.asList(2, 3, 5);
        List<Integer> expectedResult = Arrays.asList(3, 7, 10);

        vectorRequest.setV1(v1);
        vectorRequest.setV2(v2);
        vectorResponse.setResult(expectedResult);

        when(vectorUtilityService.subtract(v1, v2)).thenReturn(vectorResponse);

        VectorResponse result = vectorUtilityController.subtract(vectorRequest);

        assertNotNull(result);
        assertEquals(expectedResult, result.getResult());
        assertEquals(3, result.getResult().get(0));
        assertEquals(7, result.getResult().get(1));
        assertEquals(10, result.getResult().get(2));
        verify(vectorUtilityService, times(1)).subtract(v1, v2);
    }

    @Test
    void testSubtract_withNegativeResult_shouldReturnCorrectResponse() {
        List<Integer> v1 = Arrays.asList(1, 2, 3);
        List<Integer> v2 = Arrays.asList(5, 6, 7);
        List<Integer> expectedResult = Arrays.asList(-4, -4, -4);

        vectorRequest.setV1(v1);
        vectorRequest.setV2(v2);
        vectorResponse.setResult(expectedResult);

        when(vectorUtilityService.subtract(v1, v2)).thenReturn(vectorResponse);

        VectorResponse result = vectorUtilityController.subtract(vectorRequest);

        assertEquals(expectedResult, result.getResult());
        verify(vectorUtilityService, times(1)).subtract(v1, v2);
    }

    @Test
    void testSubtract_withNegativeNumbers_shouldReturnCorrectResponse() {
        List<Integer> v1 = Arrays.asList(-5, -10, -15);
        List<Integer> v2 = Arrays.asList(-2, -3, -5);
        List<Integer> expectedResult = Arrays.asList(-3, -7, -10);

        vectorRequest.setV1(v1);
        vectorRequest.setV2(v2);
        vectorResponse.setResult(expectedResult);

        when(vectorUtilityService.subtract(v1, v2)).thenReturn(vectorResponse);

        VectorResponse result = vectorUtilityController.subtract(vectorRequest);

        assertEquals(expectedResult, result.getResult());
        verify(vectorUtilityService, times(1)).subtract(v1, v2);
    }

    @Test
    void testSubtract_withSingleElement_shouldReturnCorrectResponse() {
        List<Integer> v1 = Arrays.asList(10);
        List<Integer> v2 = Arrays.asList(3);
        List<Integer> expectedResult = Arrays.asList(7);

        vectorRequest.setV1(v1);
        vectorRequest.setV2(v2);
        vectorResponse.setResult(expectedResult);

        when(vectorUtilityService.subtract(v1, v2)).thenReturn(vectorResponse);

        VectorResponse result = vectorUtilityController.subtract(vectorRequest);

        assertEquals(1, result.getResult().size());
        assertEquals(7, result.getResult().get(0));
        verify(vectorUtilityService, times(1)).subtract(v1, v2);
    }

    @Test
    void testSubtract_shouldNotReturnNull() {
        List<Integer> v1 = Arrays.asList(5, 10);
        List<Integer> v2 = Arrays.asList(2, 3);
        List<Integer> expectedResult = Arrays.asList(3, 7);

        vectorRequest.setV1(v1);
        vectorRequest.setV2(v2);
        vectorResponse.setResult(expectedResult);

        when(vectorUtilityService.subtract(v1, v2)).thenReturn(vectorResponse);

        VectorResponse result = vectorUtilityController.subtract(vectorRequest);

        assertNotNull(result);
        assertNotNull(result.getResult());
    }

    @Test
    void testSubtract_withDifferentSizes_shouldThrowException() {
        List<Integer> v1 = Arrays.asList(1, 2, 3);
        List<Integer> v2 = Arrays.asList(1, 2);

        vectorRequest.setV1(v1);
        vectorRequest.setV2(v2);

        when(vectorUtilityService.subtract(v1, v2))
                .thenThrow(new IllegalArgumentException("Vectors must have the same length."));

        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            vectorUtilityController.subtract(vectorRequest);
        });

        assertEquals("Vectors must have the same length.", exception.getMessage());
        verify(vectorUtilityService, times(1)).subtract(v1, v2);
    }

    @Test
    void testSubtract_shouldNotReturnWrongResult() {
        List<Integer> v1 = Arrays.asList(5, 10);
        List<Integer> v2 = Arrays.asList(2, 3);
        List<Integer> expectedResult = Arrays.asList(3, 7);

        vectorRequest.setV1(v1);
        vectorRequest.setV2(v2);
        vectorResponse.setResult(expectedResult);

        when(vectorUtilityService.subtract(v1, v2)).thenReturn(vectorResponse);

        VectorResponse result = vectorUtilityController.subtract(vectorRequest);

        assertNotEquals(7, result.getResult().get(0));
        assertNotEquals(13, result.getResult().get(1));
    }

    @Test
    void testDotProduct_shouldCallServiceAndReturnResponse() {
        List<Integer> v1 = Arrays.asList(1, 2, 3);
        List<Integer> v2 = Arrays.asList(4, 5, 6);
        Integer expectedResult = 32; // 1*4 + 2*5 + 3*6 = 32

        vectorRequest.setV1(v1);
        vectorRequest.setV2(v2);
        scalarResponse.setResult(expectedResult);

        when(vectorUtilityService.dotproduct(v1, v2)).thenReturn(scalarResponse);

        ScalarResponse result = vectorUtilityController.dotproduct(vectorRequest);

        assertNotNull(result);
        assertEquals(32, result.getResult());
        verify(vectorUtilityService, times(1)).dotproduct(v1, v2);
    }

    @Test
    void testDotProduct_withNegativeNumbers_shouldReturnCorrectResponse() {
        List<Integer> v1 = Arrays.asList(-1, -2, -3);
        List<Integer> v2 = Arrays.asList(4, 5, 6);
        Integer expectedResult = -32;

        vectorRequest.setV1(v1);
        vectorRequest.setV2(v2);
        scalarResponse.setResult(expectedResult);

        when(vectorUtilityService.dotproduct(v1, v2)).thenReturn(scalarResponse);

        ScalarResponse result = vectorUtilityController.dotproduct(vectorRequest);

        assertEquals(-32, result.getResult());
        verify(vectorUtilityService, times(1)).dotproduct(v1, v2);
    }

    @Test
    void testDotProduct_withZeroVector_shouldReturnZero() {
        List<Integer> v1 = Arrays.asList(1, 2, 3);
        List<Integer> v2 = Arrays.asList(0, 0, 0);
        Integer expectedResult = 0;

        vectorRequest.setV1(v1);
        vectorRequest.setV2(v2);
        scalarResponse.setResult(expectedResult);

        when(vectorUtilityService.dotproduct(v1, v2)).thenReturn(scalarResponse);

        ScalarResponse result = vectorUtilityController.dotproduct(vectorRequest);

        assertEquals(0, result.getResult());
        verify(vectorUtilityService, times(1)).dotproduct(v1, v2);
    }

    @Test
    void testDotProduct_withSingleElement_shouldReturnCorrectResponse() {
        List<Integer> v1 = Arrays.asList(5);
        List<Integer> v2 = Arrays.asList(3);
        Integer expectedResult = 15;

        vectorRequest.setV1(v1);
        vectorRequest.setV2(v2);
        scalarResponse.setResult(expectedResult);

        when(vectorUtilityService.dotproduct(v1, v2)).thenReturn(scalarResponse);

        ScalarResponse result = vectorUtilityController.dotproduct(vectorRequest);

        assertEquals(15, result.getResult());
        verify(vectorUtilityService, times(1)).dotproduct(v1, v2);
    }

    @Test
    void testDotProduct_shouldNotReturnNull() {
        List<Integer> v1 = Arrays.asList(1, 2, 3);
        List<Integer> v2 = Arrays.asList(4, 5, 6);
        Integer expectedResult = 32;

        vectorRequest.setV1(v1);
        vectorRequest.setV2(v2);
        scalarResponse.setResult(expectedResult);

        when(vectorUtilityService.dotproduct(v1, v2)).thenReturn(scalarResponse);

        ScalarResponse result = vectorUtilityController.dotproduct(vectorRequest);

        assertNotNull(result);
    }

    @Test
    void testDotProduct_withDifferentSizes_shouldThrowException() {
        List<Integer> v1 = Arrays.asList(1, 2, 3);
        List<Integer> v2 = Arrays.asList(1, 2);

        vectorRequest.setV1(v1);
        vectorRequest.setV2(v2);

        when(vectorUtilityService.dotproduct(v1, v2))
                .thenThrow(new IllegalArgumentException("Vectors must have the same length"));

        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            vectorUtilityController.dotproduct(vectorRequest);
        });

        assertEquals("Vectors must have the same length", exception.getMessage());
        verify(vectorUtilityService, times(1)).dotproduct(v1, v2);
    }

    @Test
    void testDotProduct_shouldNotReturnWrongResult() {
        List<Integer> v1 = Arrays.asList(1, 2, 3);
        List<Integer> v2 = Arrays.asList(4, 5, 6);
        Integer expectedResult = 32;

        vectorRequest.setV1(v1);
        vectorRequest.setV2(v2);
        scalarResponse.setResult(expectedResult);

        when(vectorUtilityService.dotproduct(v1, v2)).thenReturn(scalarResponse);

        ScalarResponse result = vectorUtilityController.dotproduct(vectorRequest);

        assertNotEquals(15, result.getResult());
        assertNotEquals(0, result.getResult());
    }

    @Test
    void testAdd_shouldCallServiceAndReturnResponse() {
        List<Integer> v1 = Arrays.asList(1, 2, 3);
        List<Integer> v2 = Arrays.asList(4, 5, 6);
        List<Integer> expectedResult = Arrays.asList(5, 7, 9);

        vectorRequest.setV1(v1);
        vectorRequest.setV2(v2);
        vectorResponse.setResult(expectedResult);

        when(vectorUtilityService.add(v1, v2)).thenReturn(vectorResponse);

        VectorResponse result = vectorUtilityController.add(vectorRequest);

        assertNotNull(result);
        assertEquals(expectedResult, result.getResult());
        assertEquals(5, result.getResult().get(0));
        assertEquals(7, result.getResult().get(1));
        assertEquals(9, result.getResult().get(2));
        verify(vectorUtilityService, times(1)).add(v1, v2);
    }

    @Test
    void testAdd_withNegativeNumbers_shouldReturnCorrectResponse() {
        List<Integer> v1 = Arrays.asList(-1, -2, -3);
        List<Integer> v2 = Arrays.asList(4, 5, 6);
        List<Integer> expectedResult = Arrays.asList(3, 3, 3);

        vectorRequest.setV1(v1);
        vectorRequest.setV2(v2);
        vectorResponse.setResult(expectedResult);

        when(vectorUtilityService.add(v1, v2)).thenReturn(vectorResponse);

        VectorResponse result = vectorUtilityController.add(vectorRequest);

        assertEquals(expectedResult, result.getResult());
        verify(vectorUtilityService, times(1)).add(v1, v2);
    }

    @Test
    void testAdd_withZeroVector_shouldReturnOriginalVector() {
        List<Integer> v1 = Arrays.asList(5, 10, 15);
        List<Integer> v2 = Arrays.asList(0, 0, 0);
        List<Integer> expectedResult = Arrays.asList(5, 10, 15);

        vectorRequest.setV1(v1);
        vectorRequest.setV2(v2);
        vectorResponse.setResult(expectedResult);

        when(vectorUtilityService.add(v1, v2)).thenReturn(vectorResponse);

        VectorResponse result = vectorUtilityController.add(vectorRequest);

        assertEquals(expectedResult, result.getResult());
        verify(vectorUtilityService, times(1)).add(v1, v2);
    }

    @Test
    void testAdd_withSingleElement_shouldReturnCorrectResponse() {
        List<Integer> v1 = Arrays.asList(10);
        List<Integer> v2 = Arrays.asList(3);
        List<Integer> expectedResult = Arrays.asList(13);

        vectorRequest.setV1(v1);
        vectorRequest.setV2(v2);
        vectorResponse.setResult(expectedResult);

        when(vectorUtilityService.add(v1, v2)).thenReturn(vectorResponse);

        VectorResponse result = vectorUtilityController.add(vectorRequest);

        assertEquals(1, result.getResult().size());
        assertEquals(13, result.getResult().get(0));
        verify(vectorUtilityService, times(1)).add(v1, v2);
    }

    @Test
    void testAdd_shouldNotReturnNull() {
        List<Integer> v1 = Arrays.asList(1, 2, 3);
        List<Integer> v2 = Arrays.asList(4, 5, 6);
        List<Integer> expectedResult = Arrays.asList(5, 7, 9);

        vectorRequest.setV1(v1);
        vectorRequest.setV2(v2);
        vectorResponse.setResult(expectedResult);

        when(vectorUtilityService.add(v1, v2)).thenReturn(vectorResponse);

        VectorResponse result = vectorUtilityController.add(vectorRequest);

        assertNotNull(result);
        assertNotNull(result.getResult());
    }

    @Test
    void testAdd_withDifferentSizes_shouldThrowException() {
        List<Integer> v1 = Arrays.asList(1, 2, 3);
        List<Integer> v2 = Arrays.asList(1, 2);

        vectorRequest.setV1(v1);
        vectorRequest.setV2(v2);

        when(vectorUtilityService.add(v1, v2))
                .thenThrow(new IllegalArgumentException("v1 and v2 should have the same size!"));

        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            vectorUtilityController.add(vectorRequest);
        });

        assertEquals("v1 and v2 should have the same size!", exception.getMessage());
        verify(vectorUtilityService, times(1)).add(v1, v2);
    }

    @Test
    void testAdd_shouldNotReturnWrongResult() {
        List<Integer> v1 = Arrays.asList(1, 2, 3);
        List<Integer> v2 = Arrays.asList(4, 5, 6);
        List<Integer> expectedResult = Arrays.asList(5, 7, 9);

        vectorRequest.setV1(v1);
        vectorRequest.setV2(v2);
        vectorResponse.setResult(expectedResult);

        when(vectorUtilityService.add(v1, v2)).thenReturn(vectorResponse);

        VectorResponse result = vectorUtilityController.add(vectorRequest);

        assertNotEquals(3, result.getResult().get(0));
        assertNotEquals(10, result.getResult().get(1));
    }

    @Test
    void testMultiply_shouldCallServiceAndReturnResponse() {
        List<Integer> v1 = Arrays.asList(1, 2, 3);
        List<Integer> v2 = Arrays.asList(5);
        List<Integer> expectedResult = Arrays.asList(5, 10, 15);

        vectorRequest.setV1(v1);
        vectorRequest.setV2(v2);
        vectorResponse.setResult(expectedResult);

        when(vectorUtilityService.multiply(v1, v2)).thenReturn(vectorResponse);

        VectorResponse result = vectorUtilityController.multiply(vectorRequest);

        assertNotNull(result);
        assertEquals(expectedResult, result.getResult());
        assertEquals(5, result.getResult().get(0));
        assertEquals(10, result.getResult().get(1));
        assertEquals(15, result.getResult().get(2));
        verify(vectorUtilityService, times(1)).multiply(v1, v2);
    }

    @Test
    void testMultiply_withNegativeScalar_shouldReturnCorrectResponse() {
        List<Integer> v1 = Arrays.asList(2, 4, 6);
        List<Integer> v2 = Arrays.asList(-3);
        List<Integer> expectedResult = Arrays.asList(-6, -12, -18);

        vectorRequest.setV1(v1);
        vectorRequest.setV2(v2);
        vectorResponse.setResult(expectedResult);

        when(vectorUtilityService.multiply(v1, v2)).thenReturn(vectorResponse);

        VectorResponse result = vectorUtilityController.multiply(vectorRequest);

        assertEquals(expectedResult, result.getResult());
        verify(vectorUtilityService, times(1)).multiply(v1, v2);
    }

    @Test
    void testMultiply_withZeroScalar_shouldReturnZeroVector() {
        List<Integer> v1 = Arrays.asList(5, 10, 15);
        List<Integer> v2 = Arrays.asList(0);
        List<Integer> expectedResult = Arrays.asList(0, 0, 0);

        vectorRequest.setV1(v1);
        vectorRequest.setV2(v2);
        vectorResponse.setResult(expectedResult);

        when(vectorUtilityService.multiply(v1, v2)).thenReturn(vectorResponse);

        VectorResponse result = vectorUtilityController.multiply(vectorRequest);

        assertEquals(expectedResult, result.getResult());
        verify(vectorUtilityService, times(1)).multiply(v1, v2);
    }

    @Test
    void testMultiply_withOneScalar_shouldReturnOriginalVector() {
        List<Integer> v1 = Arrays.asList(7, 8, 9);
        List<Integer> v2 = Arrays.asList(1);
        List<Integer> expectedResult = Arrays.asList(7, 8, 9);

        vectorRequest.setV1(v1);
        vectorRequest.setV2(v2);
        vectorResponse.setResult(expectedResult);

        when(vectorUtilityService.multiply(v1, v2)).thenReturn(vectorResponse);

        VectorResponse result = vectorUtilityController.multiply(vectorRequest);

        assertEquals(expectedResult, result.getResult());
        verify(vectorUtilityService, times(1)).multiply(v1, v2);
    }

    @Test
    void testMultiply_withSingleElement_shouldReturnCorrectResponse() {
        List<Integer> v1 = Arrays.asList(10);
        List<Integer> v2 = Arrays.asList(3);
        List<Integer> expectedResult = Arrays.asList(30);

        vectorRequest.setV1(v1);
        vectorRequest.setV2(v2);
        vectorResponse.setResult(expectedResult);

        when(vectorUtilityService.multiply(v1, v2)).thenReturn(vectorResponse);

        VectorResponse result = vectorUtilityController.multiply(vectorRequest);

        assertEquals(1, result.getResult().size());
        assertEquals(30, result.getResult().get(0));
        verify(vectorUtilityService, times(1)).multiply(v1, v2);
    }

    @Test
    void testMultiply_shouldNotReturnNull() {
        List<Integer> v1 = Arrays.asList(1, 2, 3);
        List<Integer> v2 = Arrays.asList(5);
        List<Integer> expectedResult = Arrays.asList(5, 10, 15);

        vectorRequest.setV1(v1);
        vectorRequest.setV2(v2);
        vectorResponse.setResult(expectedResult);

        when(vectorUtilityService.multiply(v1, v2)).thenReturn(vectorResponse);

        VectorResponse result = vectorUtilityController.multiply(vectorRequest);

        assertNotNull(result);
        assertNotNull(result.getResult());
    }

    @Test
    void testMultiply_shouldNotReturnWrongResult() {
        List<Integer> v1 = Arrays.asList(1, 2, 3);
        List<Integer> v2 = Arrays.asList(5);
        List<Integer> expectedResult = Arrays.asList(5, 10, 15);

        vectorRequest.setV1(v1);
        vectorRequest.setV2(v2);
        vectorResponse.setResult(expectedResult);

        when(vectorUtilityService.multiply(v1, v2)).thenReturn(vectorResponse);

        VectorResponse result = vectorUtilityController.multiply(vectorRequest);

        assertNotEquals(1, result.getResult().get(0));
        assertNotEquals(7, result.getResult().get(1));
    }

    @Test
    void testSubtract_shouldCallServiceExactlyOnce() {
        List<Integer> v1 = Arrays.asList(5, 10);
        List<Integer> v2 = Arrays.asList(2, 3);
        List<Integer> expectedResult = Arrays.asList(3, 7);

        vectorRequest.setV1(v1);
        vectorRequest.setV2(v2);
        vectorResponse.setResult(expectedResult);

        when(vectorUtilityService.subtract(v1, v2)).thenReturn(vectorResponse);

        vectorUtilityController.subtract(vectorRequest);

        verify(vectorUtilityService, times(1)).subtract(v1, v2);
        verifyNoMoreInteractions(vectorUtilityService);
    }

    @Test
    void testDotProduct_shouldCallServiceExactlyOnce() {
        List<Integer> v1 = Arrays.asList(1, 2, 3);
        List<Integer> v2 = Arrays.asList(4, 5, 6);
        Integer expectedResult = 32;

        vectorRequest.setV1(v1);
        vectorRequest.setV2(v2);
        scalarResponse.setResult(expectedResult);

        when(vectorUtilityService.dotproduct(v1, v2)).thenReturn(scalarResponse);

        vectorUtilityController.dotproduct(vectorRequest);

        verify(vectorUtilityService, times(1)).dotproduct(v1, v2);
        verifyNoMoreInteractions(vectorUtilityService);
    }

    @Test
    void testAdd_shouldCallServiceExactlyOnce() {
        List<Integer> v1 = Arrays.asList(1, 2, 3);
        List<Integer> v2 = Arrays.asList(4, 5, 6);
        List<Integer> expectedResult = Arrays.asList(5, 7, 9);

        vectorRequest.setV1(v1);
        vectorRequest.setV2(v2);
        vectorResponse.setResult(expectedResult);

        when(vectorUtilityService.add(v1, v2)).thenReturn(vectorResponse);

        vectorUtilityController.add(vectorRequest);

        verify(vectorUtilityService, times(1)).add(v1, v2);
        verifyNoMoreInteractions(vectorUtilityService);
    }

    @Test
    void testMultiply_shouldCallServiceExactlyOnce() {
        List<Integer> v1 = Arrays.asList(1, 2, 3);
        List<Integer> v2 = Arrays.asList(5);
        List<Integer> expectedResult = Arrays.asList(5, 10, 15);

        vectorRequest.setV1(v1);
        vectorRequest.setV2(v2);
        vectorResponse.setResult(expectedResult);

        when(vectorUtilityService.multiply(v1, v2)).thenReturn(vectorResponse);

        vectorUtilityController.multiply(vectorRequest);

        verify(vectorUtilityService, times(1)).multiply(v1, v2);
        verifyNoMoreInteractions(vectorUtilityService);
    }

    @Test
    void testSubtract_withLargeVectors_shouldReturnCorrectResponse() {
        List<Integer> v1 = Arrays.asList(1000, 2000, 3000, 4000, 5000);
        List<Integer> v2 = Arrays.asList(100, 200, 300, 400, 500);
        List<Integer> expectedResult = Arrays.asList(900, 1800, 2700, 3600, 4500);

        vectorRequest.setV1(v1);
        vectorRequest.setV2(v2);
        vectorResponse.setResult(expectedResult);

        when(vectorUtilityService.subtract(v1, v2)).thenReturn(vectorResponse);

        VectorResponse result = vectorUtilityController.subtract(vectorRequest);

        assertEquals(5, result.getResult().size());
        assertEquals(900, result.getResult().get(0));
        verify(vectorUtilityService, times(1)).subtract(v1, v2);
    }

    @Test
    void testDotProduct_withLargeNumbers_shouldReturnCorrectResponse() {
        List<Integer> v1 = Arrays.asList(1000, 2000);
        List<Integer> v2 = Arrays.asList(3000, 4000);
        Integer expectedResult = 11000000;

        vectorRequest.setV1(v1);
        vectorRequest.setV2(v2);
        scalarResponse.setResult(expectedResult);

        when(vectorUtilityService.dotproduct(v1, v2)).thenReturn(scalarResponse);

        ScalarResponse result = vectorUtilityController.dotproduct(vectorRequest);

        assertEquals(11000000, result.getResult());
        verify(vectorUtilityService, times(1)).dotproduct(v1, v2);
    }

    @Test
    void testAdd_withLargeVectors_shouldReturnCorrectResponse() {
        List<Integer> v1 = Arrays.asList(1000, 2000, 3000);
        List<Integer> v2 = Arrays.asList(4000, 5000, 6000);
        List<Integer> expectedResult = Arrays.asList(5000, 7000, 9000);

        vectorRequest.setV1(v1);
        vectorRequest.setV2(v2);
        vectorResponse.setResult(expectedResult);

        when(vectorUtilityService.add(v1, v2)).thenReturn(vectorResponse);

        VectorResponse result = vectorUtilityController.add(vectorRequest);

        assertEquals(expectedResult, result.getResult());
        verify(vectorUtilityService, times(1)).add(v1, v2);
    }

    @Test
    void testMultiply_withLargeNumbers_shouldReturnCorrectResponse() {
        List<Integer> v1 = Arrays.asList(100, 200, 300);
        List<Integer> v2 = Arrays.asList(10);
        List<Integer> expectedResult = Arrays.asList(1000, 2000, 3000);

        vectorRequest.setV1(v1);
        vectorRequest.setV2(v2);
        vectorResponse.setResult(expectedResult);

        when(vectorUtilityService.multiply(v1, v2)).thenReturn(vectorResponse);

        VectorResponse result = vectorUtilityController.multiply(vectorRequest);

        assertEquals(expectedResult, result.getResult());
        verify(vectorUtilityService, times(1)).multiply(v1, v2);
    }
}