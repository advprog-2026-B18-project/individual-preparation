package id.ac.ui.cs.advprog.individualpreparation.dto;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ArithmeticDivideResponseTest {

    @Test
    void testGetterAndSetter() {
        ArithmeticDivideResponse response = new ArithmeticDivideResponse();

        response.setResult(5.0);

        assertEquals(5.0, response.getResult());
    }

    @Test
    void testSetNegativeResult() {
        ArithmeticDivideResponse response = new ArithmeticDivideResponse();

        response.setResult(-5.0);

        assertEquals(-5.0, response.getResult());
    }

    @Test
    void testSetZeroResult() {
        ArithmeticDivideResponse response = new ArithmeticDivideResponse();

        response.setResult(0.0);

        assertEquals(0.0, response.getResult());
    }

    @Test
    void testSetDecimalResult() {
        ArithmeticDivideResponse response = new ArithmeticDivideResponse();

        response.setResult(3.5);

        assertEquals(3.5, response.getResult());
    }
}