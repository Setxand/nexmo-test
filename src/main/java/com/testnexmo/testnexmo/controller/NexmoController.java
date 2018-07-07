package com.testnexmo.testnexmo.controller;

import com.testnexmo.testnexmo.dto.UserDto;
import com.testnexmo.testnexmo.model.User;
import com.testnexmo.testnexmo.service.SecretCodeProcessorService;
import com.testnexmo.testnexmo.service.SenderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/nexmo")
public class NexmoController {
    @Autowired
    SecretCodeProcessorService secretCodeProcessorService;
    @GetMapping("/secret/{phone}")
    public void sendMessage(@PathVariable String phone){
        secretCodeProcessorService.processSecretCode(phone);
    }
    @PostMapping("/validate")
    public ResponseEntity validate(@RequestBody UserDto userDto){
        return secretCodeProcessorService.validateCode(userDto);
    }
}
