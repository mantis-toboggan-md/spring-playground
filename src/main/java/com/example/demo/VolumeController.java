package com.example.demo;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VolumeController {
    @RequestMapping("/math/volume/{length}/{width}/{height}")
    public String getVolume(@PathVariable double length, @PathVariable double width, @PathVariable double height){
        return String.valueOf(length*width*height);
    }
}
