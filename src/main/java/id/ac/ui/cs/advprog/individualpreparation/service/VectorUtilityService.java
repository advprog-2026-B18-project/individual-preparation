package id.ac.ui.cs.advprog.individualpreparation.service;

import id.ac.ui.cs.advprog.individualpreparation.model.ScalarResponse;
import org.springframework.stereotype.Service;

import id.ac.ui.cs.advprog.individualpreparation.dto.VectorResponse;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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
  
    public VectorResponse add(List<Integer> v1, List<Integer> v2) {
        List<Integer> result = new ArrayList<>();
        int maximumSize = Math.max(v1.size(), v2.size());
        for(int index = 0; index < maximumSize; index++) {
            result.add(v1.get(index) + v2.get(index));
        }
        VectorResponse vectorResponse = new VectorResponse();
        vectorResponse.setResult(result);
        return vectorResponse;
    }
}
