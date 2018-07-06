package com.testnexmo.testnexmo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NexmoController {
    @GetMapping("/validate")
    public void sendMessage(){

    }
}
