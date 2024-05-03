package com.gateEntryExit.controllers;

import com.gateEntryExit.dtos.CreateGateEmployeeDto;
import com.gateEntryExit.dtos.GateEmployeeDto;
import com.gateEntryExit.dtos.GetAllGateEmployeeDto;
import com.gateEntryExit.dtos.UpdateGateEmployeeDto;
import org.springframework.web.bind.annotation.*;
import com.gateEntryExit.services.GateEmployeeService;
import org.springframework.data.domain.Page;

import java.util.UUID;

@RestController
@RequestMapping("/api/gateEmployee")
public class GateEmployeeController {
    private final GateEmployeeService _gateEmployeeService;

    public GateEmployeeController(GateEmployeeService gateEmployeeService){
        _gateEmployeeService = gateEmployeeService;
    }

    @PostMapping(value = "/getAll")
    public Page<GateEmployeeDto> getAll(@RequestBody GetAllGateEmployeeDto getAllGateEmployeeDto){
        return this._gateEmployeeService.getAll(getAllGateEmployeeDto)
                .map(entity -> new GateEmployeeDto(entity.getId(), entity.getName()));
    }

    @GetMapping(value = "/get/{id}")
    public GateEmployeeDto get(@PathVariable("id") UUID id){
        var gateEmployee = this._gateEmployeeService.get(id);
        return new GateEmployeeDto(gateEmployee.getId(), gateEmployee.getName());
    }

    @PostMapping(value = "/create")
    public GateEmployeeDto Create(@RequestBody CreateGateEmployeeDto createGateEmployeeDto){
        var gateEmployee = this._gateEmployeeService.Create(createGateEmployeeDto);
        return new GateEmployeeDto(gateEmployee.getId(), gateEmployee.getName());
    }

    @PostMapping(value = "/update", consumes = "application/json")
    public GateEmployeeDto Update(@RequestBody UpdateGateEmployeeDto updateGateEmployeeDto){
        var gateEmployee = this._gateEmployeeService.Update(updateGateEmployeeDto);
        return new GateEmployeeDto(gateEmployee.getId(), gateEmployee.getName());
    }

    @DeleteMapping(value = "/delete/{id}")
    public void Delete(@PathVariable("id") UUID id){
        this._gateEmployeeService.Delete(id);
    }
}
