package dtos;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.lang.reflect.Constructor;

@Getter
@Setter
public class GateEmployeeDto {
    public String id;
    public String name;

    public GateEmployeeDto(){

    }

    public GateEmployeeDto(String id, String name){
        this.setId(id);
        this.setName(name);
    }
}
