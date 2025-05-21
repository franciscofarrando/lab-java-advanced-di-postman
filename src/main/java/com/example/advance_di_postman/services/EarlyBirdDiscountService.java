package com.example.advance_di_postman.services;

import com.example.advance_di_postman.dtos.RequestDto;
import com.example.advance_di_postman.exceptions.WrongDateException;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

//@Service
public class EarlyBirdDiscountService {

    public ResponseEntity<?> earlyBirdDiscount(RequestDto requestDto){
        if (requestDto.getBookingDate().isBefore(LocalDate.now())){
            throw new WrongDateException("La reserva no puede ser anterior a la fecha de hoy:" + LocalDate.now());
        }
        if (requestDto.getEventDate().isBefore(LocalDate.now())){
            throw new WrongThreadException("El evento no puede ser anterior a la fecha de hoy:" + LocalDate.now());

        }

        //PREGUNTAR HECTOR: POR QUE LOS DOS ERRORES DE ARRIBA ME APARECEN EN INTELLIJ PERO NO EN POSTMAN?
        // INTERNET ME SUGIERE HACER UN GlobalExceptionHandler

        if(requestDto.getBookingDate().isAfter(requestDto.getEventDate())){
            throw new WrongDateException("La reserva no puede ser posterior a la fecha del evento. La fecha del evento es: " +requestDto.getEventDate());
        }

        long daysApart = ChronoUnit.DAYS.between(requestDto.getBookingDate(), requestDto.getEventDate());
        if(daysApart > 30){
            return ResponseEntity.ok("Por la promocion EARLY BIRD has obtenido un 15% de descuento en tu entrada!!! ");
        }
        return ResponseEntity.ok("Su reserva ha sido exitosa");
    }
}
