package com.testnexmo.service;

import com.testnexmo.config.propconfig.NexmoClient;
import com.testnexmo.model.User;
import com.testnexmo.service.dto.SmsRequestDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@Profile("prod")
public class NexmoSenderService implements SenderService {
    @Autowired
    RestTemplate restTemplate;
    @Autowired
    NexmoClient nexmoClient;

    public void sendMessage(SmsRequestDTO smsRequest) {
        restTemplate.postForEntity(nexmoClient.getNexmoProperties().getUrl(), smsRequest, Void.class);
    }



    public void sendValidationMessage(User user) {
        String text = "Hey, please input this code: " + user.getSecretCode();
        SmsRequestDTO smsReq = new SmsRequestDTO(nexmoClient.getNexmoProperties().getKey(), nexmoClient.getNexmoProperties().getSecret(),user.getPhoneNumber(),"Utavi",text);
        sendMessage(smsReq);
    }
}
