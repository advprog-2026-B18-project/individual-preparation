package id.ac.ui.cs.advprog.individualpreparation.controller;

import id.ac.ui.cs.advprog.individualpreparation.dto.VectorRequest;
import id.ac.ui.cs.advprog.individualpreparation.dto.VectorResponse;
import id.ac.ui.cs.advprog.individualpreparation.service.VectorUtilityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/vector")
public class VectorUtilityController {
    @Autowired
    private VectorUtilityService service;

    @PostMapping("/subtract")
    public VectorResponse subtract(@RequestBody VectorRequest request) {
        return service.subtract(request.getVector1(), request.getVector2());
    }
}