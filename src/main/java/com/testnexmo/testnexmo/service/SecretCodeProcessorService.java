package com.testnexmo.testnexmo.service;

import com.testnexmo.testnexmo.dto.UserDto;
import com.testnexmo.testnexmo.model.User;
import com.testnexmo.testnexmo.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Random;

@Service
public class SecretCodeProcessorService {
    @Autowired
    SenderService senderService;
    @Autowired
    UserRepo userRepo;
    @Transactional
    public void processSecretCode(String phone) {
        User user = userRepo.findByPhoneNumber(phone);
        user.setSecretCode(new Random().nextInt(9999)+1);
        senderService.sendValidationMessage(phone,user.getSecretCode());
    }
    @Transactional
    public ResponseEntity validateCode(UserDto userDto) {
        User user = userRepo.findByPhoneNumber(userDto.getPhoneNumber());
        if(user.getSecretCode().equals(userDto.getSecretCode())) {
            user.setSecretCode(null);
            return ResponseEntity.status(HttpStatus.OK).build();
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }
}
