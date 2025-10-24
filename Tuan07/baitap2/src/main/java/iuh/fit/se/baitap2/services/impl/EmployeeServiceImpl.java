package iuh.fit.se.baitap2.services.impl;

import iuh.fit.se.baitap2.entities.Employee;
import iuh.fit.se.baitap2.repositories.EmployeeRepository;
import iuh.fit.se.baitap2.services.EmployeeService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    private final EmployeeRepository repo;

    public EmployeeServiceImpl(EmployeeRepository repo) {
        this.repo = repo;
    }

    @Override
    public List<Employee> getAllEmployees() {
        return repo.findAll();
    }

    @Override
    public Employee getEmployeeById(Long id) {
        return repo.findById(id).orElse(null);
    }

    @Override
    public Employee saveEmployee(Employee employee) {
        return repo.save(employee);
    }

    @Override
    public Employee updateEmployee(Employee employee) {
        return repo.save(employee);
    }

    @Override
    public void deleteEmployee(Long id) {
        repo.deleteById(id);
    }
}
