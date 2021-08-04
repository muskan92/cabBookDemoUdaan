package com.abhijith.pradeep.demo.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class InvalidTeamException  extends RuntimeException{
    public InvalidTeamException(String message) {
        super(message);
    }
}
