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
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/api")
public class GateEmployeeController {
    private final GateEmployeeService _gateEmployeeService;

    public GateEmployeeController(GateEmployeeService gateEmployeeService){
        _gateEmployeeService = gateEmployeeService;
    }

    @GetMapping(value = "/gateEmployee/getAll")
    public Page<GateEmployeeDto> getAll(GetAllGateEmployeeDto getAllGateEmployeeDto){
        return this._gateEmployeeService.getAll(getAllGateEmployeeDto)
                .map(entity -> new GateEmployeeDto(entity.getId(), entity.getName()));
    }

    @GetMapping(value = "/gateEmployee/get/{id}")
    public GateEmployeeDto get(@PathVariable("id") UUID id){
        var gateEmployee = this._gateEmployeeService.get(id);
        return new GateEmployeeDto(gateEmployee.getId(), gateEmployee.getName());
    }

    @PostMapping(value = "/gateEmployee/create")
    public GateEmployeeDto Create(@RequestBody CreateGateEmployeeDto createGateEmployeeDto){
        var gateEmployee = this._gateEmployeeService.Create(createGateEmployeeDto);
        return new GateEmployeeDto(gateEmployee.getId(), gateEmployee.getName());
    }

    @PutMapping(value = "/gateEmployee/update", consumes = "application/json")
    public GateEmployeeDto Update(@RequestBody UpdateGateEmployeeDto updateGateEmployeeDto){
        var gateEmployee = this._gateEmployeeService.Update(updateGateEmployeeDto);
        return new GateEmployeeDto(gateEmployee.getId(), gateEmployee.getName());
    }

    @DeleteMapping(value = "/gateEmployee/delete/{id}")
    public void Delete(@PathVariable("id") UUID id){
        this._gateEmployeeService.Delete(id);
    }
}
