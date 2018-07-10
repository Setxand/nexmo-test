package com.testnexmo.service.api;

import com.testnexmo.model.User;

public interface SenderService {
    public void sendValidationMessage(User user);
}
