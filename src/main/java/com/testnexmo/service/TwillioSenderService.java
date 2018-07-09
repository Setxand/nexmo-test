package com.testnexmo.service;

import com.testnexmo.model.User;
import com.testnexmo.service.dto.SmsRequestDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@Profile("dev")
public class TwillioSenderService implements SenderService{
    @Autowired
    RestTemplate restTemplate;
    @Value("${twillio.url}")
    String TWILLIO_URL;
    @Value("${twillio.token}")
    String TWILLIO_TOKEN;
    @Value("${twillio.user}")
    String TWILLIO_USER;
    @Override
    public void sendMessage(SmsRequestDTO smsRequest) {
        String url = TWILLIO_URL;
        restTemplate.postForEntity(url,smsRequest,Void.class);
    }

    @Override
    public void sendValidationMessage(User user) {
        String body = "Hey, please input this code: "+user.getSecretCode();
        SmsRequestDTO smsRequestDTO = new SmsRequestDTO('+'+user.getPhoneNumber(),body,"63120ca31897");
        sendMessage(smsRequestDTO);
    }
}
