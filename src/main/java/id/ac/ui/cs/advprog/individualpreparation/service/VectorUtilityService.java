package id.ac.ui.cs.advprog.individualpreparation.service;

import id.ac.ui.cs.advprog.individualpreparation.dto.VectorResponse;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class VectorUtilityService {
    public VectorResponse subtract(List<Integer> v1, List<Integer> v2) {
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < v1.size(); i++) {
            result.add(v1.get(i) - v2.get(i));
        }
        VectorResponse response = new VectorResponse();
        response.setResult(result);
        return response;
    }
}