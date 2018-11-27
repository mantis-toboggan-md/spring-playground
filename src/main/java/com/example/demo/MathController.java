package com.example.demo;

import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/math")
public class MathController {

    @GetMapping("/pi")
    public String givePi(){
        return "3.141592653589793";
    }

    @GetMapping("/calculate")
    public String getCalcuations(@RequestParam(value = "operation", required = false) String operation, @RequestParam double x, @RequestParam double y){
        return MathService.calculateQuery(operation, x, y);
    }

    @PostMapping("/sum")
    public String getSum(@RequestParam MultiValueMap<String, String> paramMap){
        return MathService.sumQuery(new ArrayList(paramMap.values().iterator().next()));

    }
}
