package iuh.fit.se.baitap2.services;

import iuh.fit.se.baitap2.entities.Employee;

import java.util.List;

public interface EmployeeService {
    List<Employee> getAllEmployees();
    Employee getEmployeeById(Long id);
    Employee saveEmployee(Employee employee);
    Employee updateEmployee(Employee employee);
    void deleteEmployee(Long id);
}
