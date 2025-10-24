package iuh.fit.se.baitap2.repositories;

import iuh.fit.se.baitap2.entities.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}
