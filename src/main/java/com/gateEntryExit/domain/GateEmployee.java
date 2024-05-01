package com.gateEntryExit.domain;

import jakarta.persistence.*;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.UuidGenerator;

import java.util.UUID;

@Entity
@Table(name = "GateEmployees")
public class GateEmployee {

    @Id
    @UuidGenerator
    @Column(name = "Id", unique = true, updatable = false)
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private String name;

    public GateEmployee(){

    }

    public GateEmployee(String name){
        this.setName(name);
    }

    public void setId(UUID id){
        this.id = id;
    }

    public UUID getId(){
        return this.id;
    }

    public void setName(String value){
        this.name = value;
    }

    public String getName(){
        return this.name;
    }
}
