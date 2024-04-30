package domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import org.hibernate.annotations.UuidGenerator;

@Entity
@Table(name = "GateEmployees")
public class GateEmployee {

    @Id
    @UuidGenerator
    @Column(name = "Id", unique = true, updatable = false)
    private String id;

    private String name;

    public GateEmployee(){

    }

    public GateEmployee(String name){
        this.setName(name);
    }

    public String getId(){
        return this.id;
    }

    public void setName(String value){
        this.name = value;
    }

    public String getName(){
        return this.name;
    }
}
