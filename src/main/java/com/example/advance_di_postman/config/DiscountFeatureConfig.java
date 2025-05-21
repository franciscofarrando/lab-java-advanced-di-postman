package com.example.advance_di_postman.config;

import com.example.advance_di_postman.dtos.RequestDto;
import com.example.advance_di_postman.services.EarlyBirdDiscountService;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@Configuration
public class DiscountFeatureConfig {

    @Bean
    @ConditionalOnProperty(name = "feature.earlybird.enabled", havingValue = "true")
    public EarlyBirdDiscountService earlyBirdDiscountService() {

        return new EarlyBirdDiscountService();
    }

    @Bean
    @ConditionalOnProperty(name = "feature.earlybird.enabled", havingValue = "false", matchIfMissing = true)
    public EarlyBirdDiscountService earlyBirdDiscountServiceDisabled() {

        return new EarlyBirdDiscountService() {
            @Override
            public ResponseEntity<?> earlyBirdDiscount(RequestDto requestDto) {

                return ResponseEntity.status(HttpStatus.SERVICE_UNAVAILABLE).body("El servicio esta desactivado o no esta aplicado");
            }
        };
    }

}
