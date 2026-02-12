package id.ac.ui.cs.advprog.individualpreparation.controller;

import id.ac.ui.cs.advprog.individualpreparation.model.ScalarResponse;
import id.ac.ui.cs.advprog.individualpreparation.model.VectorRequest;
import id.ac.ui.cs.advprog.individualpreparation.model.VectorResponse;
import id.ac.ui.cs.advprog.individualpreparation.service.VectorUtilityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@RestController
@RequestMapping("/api/arithmetic")
public class VectorUtilityController {

    @Autowired
    private VectorUtilityService service;

    @PostMapping("dotProduct")
    public ScalarResponse dotproduct(@RequestBody VectorRequest request){
        List<Integer> v1 = request.getV1();
        List<Integer> v2 = request.getV2();

        return service.dotproduct(v1, v2);
    }

}
