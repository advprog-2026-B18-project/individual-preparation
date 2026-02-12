package id.ac.ui.cs.advprog.individualpreparation.controller;

import id.ac.ui.cs.advprog.individualpreparation.dto.ArithmeticResponse;
import id.ac.ui.cs.advprog.individualpreparation.dto.ArithmeticRequest;
import id.ac.ui.cs.advprog.individualpreparation.service.ArithmeticUtilityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@RestController
@RequestMapping("/api/arithmetic")
public class ArithmeticUtilityController {

    @Autowired
    private ArithmeticUtilityService service;

    @PostMapping("/exponent")
    public ArithmeticResponse exponent(@RequestBody ArithmeticRequest request){
        long o1 = request.getO1();
        long n = request.getO2();

        return service.exponent(o1, n);
    }

}
