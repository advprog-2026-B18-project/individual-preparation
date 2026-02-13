package id.ac.ui.cs.advprog.individualpreparation.controller;

import id.ac.ui.cs.advprog.individualpreparation.model.ScalarResponse;
import id.ac.ui.cs.advprog.individualpreparation.dto.VectorRequest;
import id.ac.ui.cs.advprog.individualpreparation.dto.VectorResponse;
import id.ac.ui.cs.advprog.individualpreparation.service.VectorUtilityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import java.util.List;

@RestController
@RequestMapping("/api/vector")
public class VectorUtilityController {
    @Autowired
    private VectorUtilityService service;

    @PostMapping("/subtract")
    public VectorResponse subtract(@RequestBody VectorRequest request) {
        return service.subtract(request.getV1(), request.getV2());
    }
  
    @PostMapping("dotProduct")
    public ScalarResponse dotproduct(@RequestBody VectorRequest request){
        List<Integer> v1 = request.getV1();
        List<Integer> v2 = request.getV2();

        return service.dotproduct(v1, v2);
    }
  
    @PostMapping("/add")
    public VectorResponse add(@RequestBody VectorRequest request){
        List<Integer> v1 = request.getV1();
        List<Integer> v2 = request.getV2();

        return service.add(v1, v2);
    }

    @PostMapping("/multiply")
    public VectorResponse multiply(@RequestBody VectorRequest request){
        List<Integer> v1 = request.getV1();
        List<Integer> v2 = request.getV2();

        return service.multiply(v1, v2);
    }
}
