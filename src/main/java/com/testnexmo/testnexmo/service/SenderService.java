package com.testnexmo.testnexmo.service;

import com.testnexmo.testnexmo.config.propconfig.NexmoClient;
import com.testnexmo.testnexmo.dto.NexmoRequestDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class SenderService {
    @Autowired
    RestTemplate restTemplate;
    @Autowired
    NexmoClient nexmoClient;

    private void sendMessage(NexmoRequestDto nexmoRequestDto){
        restTemplate.postForEntity(nexmoClient.getNexmoProperties().getUrl(), nexmoRequestDto,Void.class);
    }


    public void sendValidationMessage(String to, Integer secretCode){
        NexmoRequestDto nexmoRequestDto = new NexmoRequestDto(nexmoClient.getNexmoProperties().getKey(),nexmoClient.getNexmoProperties().getSecret());
        nexmoRequestDto.setTo(to);
        nexmoRequestDto.setFrom("Utavi");
        nexmoRequestDto.setText("Hey, please input this code: " + secretCode);
        sendMessage(nexmoRequestDto);
    }
}
