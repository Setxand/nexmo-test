package com.testnexmo.testnexmo.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class NexmoRequest {
    @JsonProperty("api_key")
    private String key;
    @JsonProperty("api_secret")
    private String secret;
    private String to;
    private String from;
    private String text;

    public NexmoRequest(String key, String secret) {
        this.key = key;
        this.secret = secret;
    }
}
