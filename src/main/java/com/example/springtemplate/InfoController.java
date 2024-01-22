package com.example.springtemplate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class InfoController {

    @Autowired
    CountComponent countComponent;

    @GetMapping("/info")
    public int showInfo() {
        return countComponent.getStaticVariable();
    }

    @GetMapping("/isAnswered")
    public String isAnswered() {
        boolean isAnswered = false;
        if (countComponent.getStaticVariable() != 0) {
            isAnswered = true;
            return "{\"isAnswered\":" + isAnswered + "}";
        } else {
            return "{\"isAnswered\":" + isAnswered + "}";
        }
    }


}
