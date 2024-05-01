package com.gateEntryExit.dtos;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class UpdateGateEmployeeDto {
    private UUID id;
    private String name;
}
