package id.ac.ui.cs.advprog.individualpreparation.service;

import id.ac.ui.cs.advprog.individualpreparation.dto.ArithmeticDivideResponse;
import org.springframework.stereotype.Service;

@Service
public class ArithmeticUtilityService {
    public ArithmeticDivideResponse divide(double o1, double o2) {
        if (o2 == 0) {
            throw new ArithmeticException("Cannot divide by zero.");
        }
        double result = o1 / o2;
        ArithmeticDivideResponse response = new ArithmeticDivideResponse();
        response.setResult(result);
        return response;
    }
}