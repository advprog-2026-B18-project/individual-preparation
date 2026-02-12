package id.ac.ui.cs.advprog.individualpreparation.service;

import id.ac.ui.cs.advprog.individualpreparation.model.ScalarResponse;
import id.ac.ui.cs.advprog.individualpreparation.model.VectorResponse;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VectorUtilityService {

    public ScalarResponse dotproduct(List<Integer> v1, List<Integer> v2){
        Integer result = 0;

        if (v1.size() != v2.size()) {
            throw new IllegalArgumentException("Vectors must have the same length");
        }

        for (int idx = 0; idx < v1.size(); idx++){
            result += v1.get(idx) * v2.get(idx);
        }

        ScalarResponse response = new ScalarResponse();
        response.setResult(result);
        return response;
    }
}
