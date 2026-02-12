package id.ac.ui.cs.advprog.individualpreparation.controller;

import id.ac.ui.cs.advprog.individualpreparation.model.ArithmeticRequest;
import id.ac.ui.cs.advprog.individualpreparation.model.ArithmeticResponse;
import id.ac.ui.cs.advprog.individualpreparation.service.ArithmeticUtilityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@RestController
@RequestMapping("/api/arithmetic")
public class ArithmeticUtilityController {

    @Autowired
    private ArithmeticUtilityService service;

    @PostMapping("/subtract")
    public ArithmeticResponse subtract(@RequestBody ArithmeticRequest request){
        long o1 = request.getO1();
        long o2 = request.getO2();

        return service.subtract(o1, o2);
    }

}
