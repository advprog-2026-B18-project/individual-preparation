package id.ac.ui.cs.advprog.individualpreparation.service;

import id.ac.ui.cs.advprog.individualpreparation.model.ArithmeticResponse;
import org.springframework.stereotype.Service;

@Service
public class ArithmeticUtilityService {

    public ArithmeticResponse subtract(long o1, long o2){
        long result = o1 - o2;

        ArithmeticResponse arithmeticResponse = new ArithmeticResponse();
        arithmeticResponse.setResult(result);
        return arithmeticResponse;
    }
}
