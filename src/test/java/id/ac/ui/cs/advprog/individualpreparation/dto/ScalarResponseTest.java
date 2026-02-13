package id.ac.ui.cs.advprog.individualpreparation.dto;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ScalarResponseTest {

    @Test
    void testGetterAndSetter() {
        ScalarResponse response = new ScalarResponse();

        response.setResult(32);

        assertEquals(32, response.getResult());
    }

    @Test
    void testSetNegativeResult() {
        ScalarResponse response = new ScalarResponse();

        response.setResult(-32);

        assertEquals(-32, response.getResult());
    }

    @Test
    void testSetZeroResult() {
        ScalarResponse response = new ScalarResponse();

        response.setResult(0);

        assertEquals(0, response.getResult());
    }

    @Test
    void testSetLargeResult() {
        ScalarResponse response = new ScalarResponse();

        response.setResult(11000000);

        assertEquals(11000000, response.getResult());
    }
}