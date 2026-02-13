package id.ac.ui.cs.advprog.individualpreparation.dto;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ArithmeticDivideRequestTest {

    @Test
    void testGetterAndSetter() {
        ArithmeticDivideRequest request = new ArithmeticDivideRequest();

        request.setO1(10.0);
        request.setO2(2.0);

        assertEquals(10.0, request.getO1());
        assertEquals(2.0, request.getO2());
    }

    @Test
    void testSetNegativeValues() {
        ArithmeticDivideRequest request = new ArithmeticDivideRequest();

        request.setO1(-10.0);
        request.setO2(-2.0);

        assertEquals(-10.0, request.getO1());
        assertEquals(-2.0, request.getO2());
    }

    @Test
    void testSetZeroValues() {
        ArithmeticDivideRequest request = new ArithmeticDivideRequest();

        request.setO1(0.0);
        request.setO2(0.0);

        assertEquals(0.0, request.getO1());
        assertEquals(0.0, request.getO2());
    }

    @Test
    void testSetDecimalValues() {
        ArithmeticDivideRequest request = new ArithmeticDivideRequest();

        request.setO1(10.5);
        request.setO2(2.5);

        assertEquals(10.5, request.getO1());
        assertEquals(2.5, request.getO2());
    }
}