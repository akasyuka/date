package com.example.springtemplate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.reactive.result.view.RedirectView;

@RestController
public class ApiController {

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

    @GetMapping("/restart")
    public String restart() {
        countComponent.setStaticVariable();
        return "Ответ отменен";
    }

    @PostMapping("/updateClickCount")
    @ResponseBody
    public HttpStatus updateClickCount(@RequestBody ClickCountRequestDTO request) {
        if (YesOrNot.YES == request.getYesOrNot()) {
            countComponent.incrementStaticVariable();
            return HttpStatus.OK;
        } else if (YesOrNot.NO == request.getYesOrNot()){
            countComponent.decrementStaticVariable();
            return HttpStatus.OK;
        } else {
            return HttpStatus.NOT_ACCEPTABLE;
        }
    }


}
