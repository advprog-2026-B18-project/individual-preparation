package id.ac.ui.cs.advprog.individualpreparation.service;

import id.ac.ui.cs.advprog.individualpreparation.dto.ArithmeticDivideResponse;
import org.springframework.stereotype.Service;

@Service
public class ArithmeticUtilityService {
    public ArithmeticDivideResponse divide(long operand1, long operand2) {
        if (operand2 == 0) {
            throw new ArithmeticException("Cannot divide by zero.");
        }
        double result = (double) operand1 / operand2;
        ArithmeticDivideResponse response = new ArithmeticDivideResponse();
        response.setResult(result);
        return response;
    }
}