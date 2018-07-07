package com.testnexmo.testnexmo.config.propconfig;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigurationProperties
public class PropConfig {

    @Getter
    @Setter
    @NoArgsConstructor
    @ConfigurationProperties(prefix = "nexmo")
    public class NexmoProperties{
        private String  url;
        private String key;
        private String secret;


        @Bean
        public NexmoProperties nexmoProperties(){
            return new NexmoProperties();
        }
    }

    @Bean
    public NexmoClient nexmoClient(NexmoProperties nexmoProperties){
        return new NexmoClient(nexmoProperties);
    }
}
