package id.ac.ui.cs.advprog.individualpreparation.dto;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class VectorResponseTest {

    @Test
    void testGetterAndSetter() {
        VectorResponse response = new VectorResponse();
        List<Integer> result = Arrays.asList(5, 7, 9);

        response.setResult(result);

        assertEquals(result, response.getResult());
        assertEquals(3, response.getResult().size());
    }

    @Test
    void testSetWithNegativeValues() {
        VectorResponse response = new VectorResponse();
        List<Integer> result = Arrays.asList(-3, -7, -10);

        response.setResult(result);

        assertEquals(result, response.getResult());
        assertEquals(-3, response.getResult().get(0));
    }

    @Test
    void testSetWithEmptyList() {
        VectorResponse response = new VectorResponse();
        List<Integer> result = Arrays.asList();

        response.setResult(result);

        assertEquals(0, response.getResult().size());
        assertTrue(response.getResult().isEmpty());
    }

    @Test
    void testSetWithLargeValues() {
        VectorResponse response = new VectorResponse();
        List<Integer> result = Arrays.asList(1000, 2000, 3000);

        response.setResult(result);

        assertEquals(3, response.getResult().size());
        assertEquals(1000, response.getResult().get(0));
        assertEquals(3000, response.getResult().get(2));
    }
}