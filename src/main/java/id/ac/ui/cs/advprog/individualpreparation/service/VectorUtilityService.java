package id.ac.ui.cs.advprog.individualpreparation.service;

import id.ac.ui.cs.advprog.individualpreparation.dto.VectorResponse;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class VectorUtilityService {
    public VectorResponse subtract(List<Integer> vector1, List<Integer> vector2) {
        List<Integer> result = new ArrayList<>();
        for (int index = 0; index < vector1.size(); index++) {
            result.add(vector1.get(index) - vector2.get(index));
        }
        VectorResponse response = new VectorResponse();
        response.setResult(result);
        return response;
    }
}