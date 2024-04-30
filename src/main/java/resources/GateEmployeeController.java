package resources;

import domain.GateEmployee;
import dtos.GateEmployeeDto;
import dtos.GetAllGateEmployeeDto;
import jakarta.persistence.Id;
import org.springframework.web.bind.annotation.*;
import services.GateEmployeeService;
import org.springframework.data.domain.Page;

@RestController
public class GateEmployeeController {
    private final GateEmployeeService _gateEmployeeService;

    public GateEmployeeController(GateEmployeeService gateEmployeeService){
        _gateEmployeeService = gateEmployeeService;
    }

    @GetMapping(value = "/employees")
    public Page<GateEmployeeDto> getAll(GetAllGateEmployeeDto getAllGateEmployeeDto){
        return this._gateEmployeeService.getAll(getAllGateEmployeeDto)
                .map(entity -> new GateEmployeeDto(entity.getId(), entity.getName()));
    }

    @GetMapping(value = "/employees/{id}")
    public GateEmployeeDto get(@PathVariable String id){
        var gateEmployee = this._gateEmployeeService.get(id);
        return new GateEmployeeDto(gateEmployee.getId(), gateEmployee.getName());
    }

    @PostMapping(value = "employees")
    public GateEmployeeDto Create(@RequestBody GateEmployeeDto gateEmployeeDto){
        var gateEmployee = this._gateEmployeeService.Create(gateEmployeeDto);
        return new GateEmployeeDto(gateEmployee.getId(), gateEmployee.getName());
    }

    @PutMapping(value = "/employees/{id}", consumes = "application/json")
    public GateEmployeeDto Update(@PathVariable String id, @RequestBody GateEmployeeDto gateEmployeeDto){
        var gateEmployee = this._gateEmployeeService.Update(id, gateEmployeeDto);
        return new GateEmployeeDto(gateEmployee.getId(), gateEmployee.getName());
    }

    @DeleteMapping(value = "/employees/{id}")
    public void Delete(@PathVariable String id){
        this._gateEmployeeService.Delete(id);
    }
}
