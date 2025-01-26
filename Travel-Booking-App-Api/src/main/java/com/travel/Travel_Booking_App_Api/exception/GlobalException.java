package com.travel.Travel_Booking_App_Api.exception;

import org.springframework.boot.autoconfigure.security.reactive.ReactiveSecurityAutoConfiguration;

public class GlobalException extends RuntimeException {

    GlobalException(String message){
         super(message);
    }

}
