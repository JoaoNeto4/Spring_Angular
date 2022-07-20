package com.example.algamoney.api.exceptionhandler;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ExceptionGenerico extends RuntimeException{

	private static final long serialVersionUID = 1L;

	public ExceptionGenerico(String message){
        super(message);
    }
}
