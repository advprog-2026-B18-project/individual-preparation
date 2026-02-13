package id.ac.ui.cs.advprog.individualpreparation.controller;

import id.ac.ui.cs.advprog.individualpreparation.dto.ArithmeticDivideResponse;
import id.ac.ui.cs.advprog.individualpreparation.dto.ArithmeticDivideRequest;
import id.ac.ui.cs.advprog.individualpreparation.service.ArithmeticUtilityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/arithmetic")
public class ArithmeticUtilityController {
    @Autowired
    private ArithmeticUtilityService service;

    @PostMapping("/divide")
    public ArithmeticDivideResponse divide(@RequestBody ArithmeticDivideRequest request) {
        return service.divide(request.getOperand1(), request.getOperand2());
    }
}