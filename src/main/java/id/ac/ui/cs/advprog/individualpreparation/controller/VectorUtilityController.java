package id.ac.ui.cs.advprog.individualpreparation.controller;

import id.ac.ui.cs.advprog.individualpreparation.dto.VectorRequest;
import id.ac.ui.cs.advprog.individualpreparation.dto.VectorResponse;
import id.ac.ui.cs.advprog.individualpreparation.service.VectorUtilityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/vector")
public class VectorUtilityController {

    @Autowired
    private VectorUtilityService service;

    @PostMapping("/add")
    public VectorResponse add(@RequestBody VectorRequest request){
        List<Integer> v1 = request.getV1();
        List<Integer> v2 = request.getV2();

        return service.add(v1, v2);
    }
}
