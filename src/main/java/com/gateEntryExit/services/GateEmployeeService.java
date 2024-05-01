package com.gateEntryExit.services;

import com.gateEntryExit.domain.GateEmployee;
import com.gateEntryExit.dtos.CreateGateEmployeeDto;
import com.gateEntryExit.dtos.GateEmployeeDto;
import com.gateEntryExit.dtos.GetAllGateEmployeeDto;
import com.gateEntryExit.dtos.UpdateGateEmployeeDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import com.gateEntryExit.repository.IGateEmployeeRepository;

import java.util.Optional;
import java.util.UUID;

@Service
public class GateEmployeeService {
    private final IGateEmployeeRepository _gateEmployeeRepository;

    public GateEmployeeService(IGateEmployeeRepository gateEmployeeRepository){
        _gateEmployeeRepository = gateEmployeeRepository;
    }

    public Page<GateEmployee> getAll(GetAllGateEmployeeDto getAllGateEmployeeDto){
        return _gateEmployeeRepository.findAll(
                PageRequest.of(getAllGateEmployeeDto.getPage(), getAllGateEmployeeDto.getSize(), Sort.by("name")));
    }

    public GateEmployee get(UUID id){
        return this._gateEmployeeRepository.findById(id).orElseThrow(() -> new RuntimeException("Employee not found"));
    }

    public GateEmployee Create(CreateGateEmployeeDto createGateEmployeeDto){
        var gateEmployee = new GateEmployee(createGateEmployeeDto.getName());
        this._gateEmployeeRepository.save(gateEmployee);
        return gateEmployee;
    }

    public GateEmployee Update(UpdateGateEmployeeDto updateGateEmployeeDto){
        GateEmployee gateEmployee = null;
        Optional<GateEmployee> gateEmployeeOptional =
                this._gateEmployeeRepository.findById(updateGateEmployeeDto.getId());
       if(gateEmployeeOptional.isPresent()){
           gateEmployee = gateEmployeeOptional.get();
           gateEmployee.setName(updateGateEmployeeDto.getName());
           this._gateEmployeeRepository.save(gateEmployee);
       }
        return gateEmployee;
    }

    public void Delete(UUID id){
        this._gateEmployeeRepository.deleteById(id);
    }
}
