package com.testnexmo.testnexmo.service;

import com.testnexmo.testnexmo.config.propconfig.NexmoClient;
import com.testnexmo.testnexmo.dto.NexmoRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Random;

@Service
public class SenderService {
    @Autowired
    RestTemplate restTemplate;
    @Autowired
    NexmoClient nexmoClient;

    private void sendMessage(NexmoRequest nexmoRequest){
        restTemplate.postForEntity(nexmoClient.getNexmoProperties().getUrl(),nexmoRequest,Void.class);
    }


    public void sendValidationMessage(String to){
        NexmoRequest nexmoRequest = new NexmoRequest(nexmoClient.getNexmoProperties().getKey(),nexmoClient.getNexmoProperties().getSecret());
        nexmoRequest.setTo(to);
        nexmoRequest.setFrom("Utavi");
        nexmoRequest.setText("Hey, please input this code: " + new Random().nextInt(9999)+1);
        sendMessage(nexmoRequest);
    }
}
