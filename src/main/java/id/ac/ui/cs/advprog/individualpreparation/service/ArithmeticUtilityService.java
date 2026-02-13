package id.ac.ui.cs.advprog.individualpreparation.service;

import id.ac.ui.cs.advprog.individualpreparation.dto.ArithmeticDivideResponse;
import id.ac.ui.cs.advprog.individualpreparation.dto.ArithmeticResponse;
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

    public ArithmeticResponse subtract(long o1, long o2){
        long result = o1 - o2;
        ArithmeticResponse arithmeticResponse = new ArithmeticResponse();
        arithmeticResponse.setResult(result);
        return arithmeticResponse;
    }

    public ArithmeticResponse exponent(long o1, long n){
        long result = 1;
        for(int i = 0; i < n; i++){
            result *= o1;
        }
        ArithmeticResponse arithmeticResponse = new ArithmeticResponse();
        arithmeticResponse.setResult(result);
        return arithmeticResponse;
    }
}
