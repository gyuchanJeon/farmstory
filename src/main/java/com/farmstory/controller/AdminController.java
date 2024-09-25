package com.farmstory.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AdminController {
    @GetMapping(value = {"/admin/", "/admin/index"})
    public String index(Model model) {
        return "admin/index";
    }
    @GetMapping("admin/user/list")
    public String userList(Model model) {
        return "admin/user/list";
    }
}
