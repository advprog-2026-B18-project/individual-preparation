package id.ac.ui.cs.advprog.individualpreparation.dto;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ArithmeticResponseTest {

    @Test
    void testGetterAndSetter() {
        ArithmeticResponse response = new ArithmeticResponse();

        response.setResult(7L);

        assertEquals(7L, response.getResult());
    }

    @Test
    void testSetNegativeResult() {
        ArithmeticResponse response = new ArithmeticResponse();

        response.setResult(-5L);

        assertEquals(-5L, response.getResult());
    }

    @Test
    void testSetZeroResult() {
        ArithmeticResponse response = new ArithmeticResponse();

        response.setResult(0L);

        assertEquals(0L, response.getResult());
    }

    @Test
    void testSetLargeResult() {
        ArithmeticResponse response = new ArithmeticResponse();

        response.setResult(1000000L);

        assertEquals(1000000L, response.getResult());
    }
}