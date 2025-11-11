package iuh.fit.se.backend.service;

import iuh.fit.se.backend.entity.Employee;
import iuh.fit.se.backend.repository.EmployeeRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {
    private final EmployeeRepository repo;
    public EmployeeService(EmployeeRepository repo) { this.repo = repo; }

    public List<Employee> getAll() { return repo.findAll(); }
    public Employee getById(Long id) { return repo.findById(id).orElse(null); }
    public Employee save(Employee e) { return repo.save(e); }
    public void delete(Long id) { repo.deleteById(id); }
}
