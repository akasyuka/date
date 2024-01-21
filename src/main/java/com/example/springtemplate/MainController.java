package com.example.springtemplate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController {


    @Autowired
    MainService mainService;

    @GetMapping("/hello")
    public String hello() {
        String str = mainService.returnString("a") + mainService.returnString("b");
        return str;
    }
}
