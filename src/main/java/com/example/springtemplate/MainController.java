package com.example.springtemplate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class MainController {

    @Autowired
    private CountComponent countComponent;


    @GetMapping("/")
    public String hello() {
        return "index";
    }


    @PostMapping("/updateClickCount")
    @ResponseBody
    public HttpStatus updateClickCount(@RequestBody ClickCountRequestDTO request) {
        if (YesOrNotEnum.YES == request.getYesOrNotEnum()) {
            countComponent.incrementStaticVariable();
            return HttpStatus.OK;
        } else if (YesOrNotEnum.NO == request.getYesOrNotEnum()){
            countComponent.decrementStaticVariable();
            return HttpStatus.OK;
        } else {

            return HttpStatus.NOT_ACCEPTABLE;
        }
    }
}

