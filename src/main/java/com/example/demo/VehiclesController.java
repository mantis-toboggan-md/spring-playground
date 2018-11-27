package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VehiclesController {

    @GetMapping("/vehicles")
    public String getVehicles(
    //name querystring keys that are already a valid java format like so:
    @RequestParam String year,
    //if keys are not a valid java format, give custom name:
    @RequestParam("number-doors") String numberDoors)
    {
        //spring grabs values for these keys from querystring and returns
        return String.format("year is %s and numberDoors is %s", year, numberDoors);
    }

    //alternatively, get every querystring key/value pair in one map, here called querystring
//    @GetMapping("/map-example")
    //define data type Spring should parse w/ @requestparam
//    public String getMapParams(@RequestParam Map querystring) {
//        return querystring.toString();
//    }
}
