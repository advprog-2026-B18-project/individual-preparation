package id.ac.ui.cs.advprog.individualpreparation.controller;

import id.ac.ui.cs.advprog.individualpreparation.dto.ArithmeticDivideResponse;
import id.ac.ui.cs.advprog.individualpreparation.dto.ArithmeticDivideRequest;
import id.ac.ui.cs.advprog.individualpreparation.dto.ArithmeticResponse;
import id.ac.ui.cs.advprog.individualpreparation.dto.ArithmeticRequest;
import id.ac.ui.cs.advprog.individualpreparation.service.ArithmeticUtilityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/api/arithmetic")
public class ArithmeticUtilityController {
    @Autowired
    private ArithmeticUtilityService service;

    @PostMapping("/divide")
    public ArithmeticDivideResponse divide(@RequestBody ArithmeticDivideRequest request) {
        return service.divide(request.getO1(), request.getO2());
    }

    @PostMapping("/subtract")
    public ArithmeticResponse subtract(@RequestBody ArithmeticRequest request){
        long o1 = request.getO1();
        long o2 = request.getO2();

        return service.subtract(o1, o2);
    }
  
    @PostMapping("/exponent")
    public ArithmeticResponse exponent(@RequestBody ArithmeticRequest request){
        long o1 = request.getO1();
        long n = request.getO2();

        return service.exponent(o1, n);
    }

    @PostMapping("/multiply")
    public ArithmeticResponse multiply(@RequestBody ArithmeticRequest request){
        long o1 = request.getO1();
        long o2 = request.getO2();

        return service.multiply(o1, o2);
    }

}
