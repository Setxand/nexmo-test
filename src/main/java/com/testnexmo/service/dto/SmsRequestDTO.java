package com.testnexmo.service.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class SmsRequestDTO {
    @JsonProperty("api_key")
    private String key;
    @JsonProperty("api_secret")
    private String secret;
    private String to;
    private String from;
    private String text;
    private String body;
    @JsonProperty("auth_token")
    private String authToken;
    public SmsRequestDTO(String key, String secret, String to, String from, String text) {
        this.key = key;
        this.secret = secret;
        this.to = to;
        this.from = from;
        this.text = text;
    }

    public SmsRequestDTO(String to, String body, String from) {
        this.to = to;
        this.body = body;
        this.from = from;
    }

}
