package com.gateEntryExit.dtos;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.lang.reflect.Constructor;
import java.util.UUID;

@Getter
@Setter
public class GateEmployeeDto {
    public UUID id;
    public String name;

    public GateEmployeeDto(){

    }

    public GateEmployeeDto(UUID id, String name){
        this.setId(id);
        this.setName(name);
    }
}
