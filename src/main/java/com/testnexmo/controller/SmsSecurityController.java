package com.testnexmo.controller;

import com.testnexmo.dto.UserDTO;
import com.testnexmo.service.SecretCodeProcessorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/nexmo")
public class SmsSecurityController {
    @Autowired
    SecretCodeProcessorService secretCodeProcessorService;

    @PostMapping("/secretcode")
    public void sendMessage(@RequestParam("phonenumber") String phoneNumber) {
        secretCodeProcessorService.processSecretCode(phoneNumber);
    }

    @PostMapping("/validation")
    public ResponseEntity validate(@RequestBody UserDTO userDTO) {
        return secretCodeProcessorService.validateCode(userDTO);
    }
}
