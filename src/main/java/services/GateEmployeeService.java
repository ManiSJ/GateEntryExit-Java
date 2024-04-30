package services;

import domain.GateEmployee;
import dtos.GateEmployeeDto;
import dtos.GetAllGateEmployeeDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import repository.IGateEmployeeRepository;

import java.util.Optional;

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

    public GateEmployee get(String id){
        return this._gateEmployeeRepository.findById(id).orElseThrow(() -> new RuntimeException("Employee not found"));
    }

    public GateEmployee Create(GateEmployeeDto gateEmployeeDto){
        var gateEmployee = new GateEmployee(gateEmployeeDto.getName());
        this._gateEmployeeRepository.save(gateEmployee);
        return gateEmployee;
    }

    public GateEmployee Update(String id, GateEmployeeDto gateEmployeeDto){
        GateEmployee gateEmployee = null;
        Optional<GateEmployee> gateEmployeeOptional = this._gateEmployeeRepository.findById(id);
       if(gateEmployeeOptional.isPresent()){
           gateEmployee = gateEmployeeOptional.get();
           gateEmployee.setName(gateEmployeeDto.getName());
           this._gateEmployeeRepository.save(gateEmployee);
       }
        return gateEmployee;
    }

    public void Delete(String id){
        this._gateEmployeeRepository.deleteById(id);
    }
}
