package com.example.demo;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AreaController {

    @PostMapping("/math/area")
    public String findArea(@RequestParam String type, @RequestParam(value = "radius", required = false) String radius, @RequestParam(value = "width", required = false) String width, @RequestParam(value = "height", required = false) String height){
        String result = "";
        if(type.equals("circle") && radius != null){
            result = String.valueOf(Math.PI * Integer.parseInt(radius));
        }
        else if(type.equals("rectangle") && (width != null && height != null)){
            result = String.valueOf(Integer.parseInt(height) * Integer.parseInt(width));
        }
        else{
            result = "invalid";
        }
        return result;

    }
}
