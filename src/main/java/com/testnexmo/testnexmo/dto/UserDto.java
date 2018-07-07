package com.testnexmo.testnexmo.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class UserDto {
    private String name;
    @JsonProperty("phone_number")
    private String phoneNumber;
    @JsonProperty("secret_code")
    private Integer secretCode;
}
