package repository;

import domain.GateEmployee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IGateEmployeeRepository extends JpaRepository<GateEmployee, String> {
}
