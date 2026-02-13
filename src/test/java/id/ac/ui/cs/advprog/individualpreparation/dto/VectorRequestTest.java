package id.ac.ui.cs.advprog.individualpreparation.dto;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class VectorRequestTest {

    @Test
    void testGetterAndSetter() {
        VectorRequest request = new VectorRequest();
        List<Integer> v1 = Arrays.asList(1, 2, 3);
        List<Integer> v2 = Arrays.asList(4, 5, 6);

        request.setV1(v1);
        request.setV2(v2);

        assertEquals(v1, request.getV1());
        assertEquals(v2, request.getV2());
    }

    @Test
    void testSetWithNegativeValues() {
        VectorRequest request = new VectorRequest();
        List<Integer> v1 = Arrays.asList(-1, -2, -3);
        List<Integer> v2 = Arrays.asList(-4, -5, -6);

        request.setV1(v1);
        request.setV2(v2);

        assertEquals(v1, request.getV1());
        assertEquals(v2, request.getV2());
    }

    @Test
    void testSetWithEmptyLists() {
        VectorRequest request = new VectorRequest();
        List<Integer> v1 = Arrays.asList();
        List<Integer> v2 = Arrays.asList();

        request.setV1(v1);
        request.setV2(v2);

        assertEquals(0, request.getV1().size());
        assertEquals(0, request.getV2().size());
    }

    @Test
    void testSetWithSingleElement() {
        VectorRequest request = new VectorRequest();
        List<Integer> v1 = Arrays.asList(10);
        List<Integer> v2 = Arrays.asList(5);

        request.setV1(v1);
        request.setV2(v2);

        assertEquals(1, request.getV1().size());
        assertEquals(10, request.getV1().get(0));
        assertEquals(5, request.getV2().get(0));
    }
}