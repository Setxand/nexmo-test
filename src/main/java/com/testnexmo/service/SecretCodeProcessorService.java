package com.testnexmo.service;

import com.testnexmo.dto.UserDTO;
import com.testnexmo.model.User;
import com.testnexmo.repo.UserRepo;
import com.testnexmo.service.api.SenderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Random;

@Service
public class SecretCodeProcessorService {
    @Autowired
    private SenderService senderService;
    @Autowired
    private UserRepo userRepo;


    @Transactional
    public void processSecretCode(String phone) {
        User user = userRepo.findByPhoneNumber(phone);
        user.setSecretCode(new Random().nextInt(9999) + 1);
        senderService.sendValidationMessage(user);
    }

    @Transactional
    public ResponseEntity validateCode(UserDTO userDTO) {
        User user = userRepo.findByPhoneNumber(userDTO.getPhoneNumber());

        if (user.getSecretCode().equals(userDTO.getSecretCode())) {
            user.setSecretCode(null);
            return ResponseEntity.status(HttpStatus.OK).build();
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }
}
