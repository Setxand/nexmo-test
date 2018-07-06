package com.testnexmo.testnexmo.config.propconfig;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@NoArgsConstructor
public class NexmoClient {
    private PropConfig.NexmoProperties nexmoProperties;

    public NexmoClient(PropConfig.NexmoProperties nexmoProperties) {
        this.nexmoProperties = nexmoProperties;
    }

    public PropConfig.NexmoProperties getNexmoProperties() {
        return nexmoProperties;
    }
}
