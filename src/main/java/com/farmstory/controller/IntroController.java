package com.farmstory.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IntroController {
    @GetMapping(value = {"/intro","/intro/introduction"})
    public String intro() {
        return "intro/introduction"; // templates/index.html을 렌더링
    }

    @GetMapping("/intro/direction")
    public String direction(){
        return "intro/direction";
    }
}
