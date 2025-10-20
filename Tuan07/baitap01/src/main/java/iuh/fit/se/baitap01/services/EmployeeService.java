package iuh.fit.se.baitap01.services;

import iuh.fit.se.baitap01.entities.Employee;

import java.util.List;

public interface EmployeeService {
    public void save(Employee employee);
    public List<Employee> getAll();
    public Employee getById(int id);
}
