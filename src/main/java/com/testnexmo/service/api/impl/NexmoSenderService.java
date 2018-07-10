package com.testnexmo.service.api.impl;

import com.testnexmo.config.propconfig.NexmoClient;
import com.testnexmo.model.User;
import com.testnexmo.service.api.SenderService;
import com.testnexmo.service.dto.SmsRequestDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@Profile("prod")
public class NexmoSenderService implements SenderService {
    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private NexmoClient nexmoClient;

    @Override
    public void sendValidationMessage(User user) {
        String text = "Hey, please input this code: " + user.getSecretCode();

        SmsRequestDTO smsReq = new SmsRequestDTO(nexmoClient.getNexmoProperties().getKey(), nexmoClient.getNexmoProperties().getSecret());
        smsReq.setTo(user.getPhoneNumber());
        smsReq.setFrom("Utavi");
        smsReq.setText(text);

        restTemplate.postForEntity(nexmoClient.getNexmoProperties().getUrl(), smsReq, Void.class);
    }
}
