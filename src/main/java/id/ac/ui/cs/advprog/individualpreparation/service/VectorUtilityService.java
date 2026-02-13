package id.ac.ui.cs.advprog.individualpreparation.service;

import id.ac.ui.cs.advprog.individualpreparation.dto.VectorResponse;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class VectorUtilityService {
    public VectorResponse subtract(List<Integer> v1, List<Integer> v2) {
        List<Integer> result = new ArrayList<>();
        if (v1.size() != v2.size()) {
            throw new IllegalArgumentException("Vectors must have the same length.");
        }
        for (int index = 0; index < v1.size(); index++) {
            result.add(v1.get(index) - v2.get(index));
        }
        VectorResponse response = new VectorResponse();
        response.setResult(result);
        return response;
    }
}