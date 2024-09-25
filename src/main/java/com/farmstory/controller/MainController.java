package com.farmstory.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController{
    @GetMapping("/index")
    public String index() {
        return "index"; // templates/index.html을 렌더링
    }
}
