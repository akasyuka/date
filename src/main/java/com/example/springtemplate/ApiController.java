package com.example.springtemplate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
public class ApiController {

    @Autowired
    CountComponent countComponent;

    @Autowired
    AboutFormRepository aboutFormRepository;

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

    @PostMapping("/saveAboutForm")
    @ResponseBody
    public String saveAboutForm(@RequestBody Map<String, String> payload) {
        AboutForm o = new AboutForm();
        o.setId(null);
        o.setName(payload.get("name"));
        o.setTg(payload.get("tg"));
        o.setInst(payload.get("inst"));
        o.setAge(payload.get("age"));
        o.setAbout(payload.get("about"));
        aboutFormRepository.save(o);
        return "Запись успешно сохранена";
    }


}
