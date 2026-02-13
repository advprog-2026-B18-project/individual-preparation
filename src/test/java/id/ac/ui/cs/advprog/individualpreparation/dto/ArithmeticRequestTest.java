package id.ac.ui.cs.advprog.individualpreparation.dto;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ArithmeticRequestTest {

    @Test
    void testGetterAndSetter() {
        ArithmeticRequest request = new ArithmeticRequest();

        request.setO1(10L);
        request.setO2(2L);

        assertEquals(10L, request.getO1());
        assertEquals(2L, request.getO2());
    }

    @Test
    void testSetNegativeValues() {
        ArithmeticRequest request = new ArithmeticRequest();

        request.setO1(-10L);
        request.setO2(-2L);

        assertEquals(-10L, request.getO1());
        assertEquals(-2L, request.getO2());
    }

    @Test
    void testSetZeroValues() {
        ArithmeticRequest request = new ArithmeticRequest();

        request.setO1(0L);
        request.setO2(0L);

        assertEquals(0L, request.getO1());
        assertEquals(0L, request.getO2());
    }

    @Test
    void testSetLargeValues() {
        ArithmeticRequest request = new ArithmeticRequest();

        request.setO1(1000000L);
        request.setO2(999999L);

        assertEquals(1000000L, request.getO1());
        assertEquals(999999L, request.getO2());
    }
}