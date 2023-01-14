package com.dwell.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/check-up")
public class CheckupController {
    @GetMapping
    public String get(){
        return "Welcome To Do Well";
    }
}
