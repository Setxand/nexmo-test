package com.testnexmo.service;

import com.testnexmo.model.User;
import com.testnexmo.service.dto.SmsRequestDTO;

public interface SenderService {
    public void sendMessage(SmsRequestDTO smsRequest);
    public void sendValidationMessage(User user);
}
