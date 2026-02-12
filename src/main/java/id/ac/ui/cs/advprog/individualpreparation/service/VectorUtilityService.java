package id.ac.ui.cs.advprog.individualpreparation.service;

import id.ac.ui.cs.advprog.individualpreparation.dto.VectorResponse;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class VectorUtilityService {

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
