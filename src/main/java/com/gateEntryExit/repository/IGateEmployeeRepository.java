package com.gateEntryExit.repository;

import com.gateEntryExit.domain.GateEmployee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface IGateEmployeeRepository extends JpaRepository<GateEmployee, UUID> {
}
