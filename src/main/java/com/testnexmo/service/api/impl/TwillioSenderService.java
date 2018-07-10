package com.testnexmo.service.api.impl;

import com.testnexmo.model.User;
import com.testnexmo.service.api.SenderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Profile;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

@Service
@Profile("dev")
public class TwillioSenderService implements SenderService {
    @Autowired
    private RestTemplate restTemplate;
    @Value("${twillio.url}")
    private String TWILLIO_URL;
    @Value("${twillio.btoken}")
    private String TWILLIO_BASIC_AUTH_TOKEN;


    @Override
    public void sendValidationMessage(User user) {
        String body = "Hey, please input this code: " + user.getSecretCode();

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
        headers.set("Authorization", TWILLIO_BASIC_AUTH_TOKEN);
        MultiValueMap<String, String> map = new LinkedMultiValueMap<String, String>();

        map.add("From", "+16312031897");
        map.add("To", "+" + user.getPhoneNumber());
        map.add("Body", body);

        HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<MultiValueMap<String, String>>(map, headers);

        ResponseEntity<String> response = restTemplate.postForEntity(TWILLIO_URL, request, String.class);
    }
}
