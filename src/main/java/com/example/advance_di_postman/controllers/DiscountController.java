package com.example.advance_di_postman.controllers;

import com.example.advance_di_postman.dtos.RequestDto;
import com.example.advance_di_postman.services.EarlyBirdDiscountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/discount")
public class DiscountController {
    @Autowired
    EarlyBirdDiscountService earlyBirdDiscountService;

    @GetMapping
    public ResponseEntity<?> discount(@RequestBody RequestDto requestDto){
        return earlyBirdDiscountService.earlyBirdDiscount(requestDto);

    }
}
