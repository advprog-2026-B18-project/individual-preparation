package id.ac.ui.cs.advprog.individualpreparation.service;

import id.ac.ui.cs.advprog.individualpreparation.dto.ArithmeticResponse;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ArithmeticMultiplyTest {

    private ArithmeticUtilityService service;

    @BeforeEach
    void setUp() {
        service = new ArithmeticUtilityService();
    }

    @Test
    void testMultiply_PositiveNumbers() {
        ArithmeticResponse response = service.multiply(4, 5);
        assertEquals(20, response.getResult());
    }

    @Test
    void testMultiply_WithZero() {
        ArithmeticResponse response = service.multiply(10, 0);
        assertEquals(0, response.getResult());
    }

    @Test
    void testMultiply_NegativeNumbers() {
        ArithmeticResponse response = service.multiply(-3, 6);
        assertEquals(-18, response.getResult());
    }

    @Test
    void testMultiply_BothNegative() {
        ArithmeticResponse response = service.multiply(-4, -5);
        assertEquals(20, response.getResult());
    }

    @Test
    void testMultiply_LargeNumbers() {
        ArithmeticResponse response = service.multiply(1000000, 3);
        assertEquals(3000000, response.getResult());
    }
}
