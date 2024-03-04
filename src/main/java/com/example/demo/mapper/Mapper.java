package com.example.demo.mapper;

import com.example.demo.dto.Dto;
import com.example.demo.entity.Entity;

public class Mapper {

    //ToDo:design pattern @Builder SingleTone Prototype mapstruct git-branch
    public static Dto mapToDto (Entity entity)
    {
        return new Dto(
                entity.getId(),
                entity.getFirstName(),
                entity.getLastName(),
                entity.getEmail()
        );
    }
    public static Entity mapToEmployee(Dto dto)
    {
        return new Entity(
                dto.getId(),
                dto.getFirstName(),
                dto.getLastName(),
                dto.getEmail()
        );
    }
}
