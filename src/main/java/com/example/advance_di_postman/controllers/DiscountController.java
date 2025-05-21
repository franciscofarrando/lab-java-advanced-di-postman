package com.example.advance_di_postman.controllers;

import com.example.advance_di_postman.dtos.RequestDto;
import com.example.advance_di_postman.services.EarlyBirdDiscountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class DiscountController {
    @Autowired
    EarlyBirdDiscountService earlyBirdDiscountService;

    @PostMapping()
    public ResponseEntity<?> discount(@RequestBody RequestDto requestDto){
        return earlyBirdDiscountService.earlyBirdDiscount(requestDto);
    }
}
