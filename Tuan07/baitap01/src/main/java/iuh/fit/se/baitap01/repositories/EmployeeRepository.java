package iuh.fit.se.baitap01.repositories;

import iuh.fit.se.baitap01.entities.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
}
