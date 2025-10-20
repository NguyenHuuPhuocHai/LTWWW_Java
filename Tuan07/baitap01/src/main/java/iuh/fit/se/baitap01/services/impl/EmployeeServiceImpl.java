package iuh.fit.se.baitap01.services.impl;

import iuh.fit.se.baitap01.entities.Employee;
import iuh.fit.se.baitap01.repositories.EmployeeRepository;
import iuh.fit.se.baitap01.services.EmployeeService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Transactional
    @Override
    public void save(Employee employee) {
        this.employeeRepository.save(employee);
    }

    @Override
    public List<Employee> getAll() {
        return this.employeeRepository.findAll();
    }

    @Override
    public Employee getById(int id) {
        return this.employeeRepository.findById(id).orElse(null);
    }
}
