package com.example.advance_di_postman.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RequestDto {
    private LocalDate eventDate;
    private LocalDate bookingDate;
}
