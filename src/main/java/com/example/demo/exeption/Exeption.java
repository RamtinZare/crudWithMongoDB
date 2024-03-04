package com.example.demo.exeption;

import org.springframework.boot.context.config.ConfigDataResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.lang.module.ResolutionException;
@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class Exeption extends RuntimeException
{
    public Exeption(String massage)
    {
        super(massage);
    }
}

