package iuh.fit.se.backend.controller;

import iuh.fit.se.backend.entity.Employee;
import iuh.fit.se.backend.service.EmployeeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employee")
@CrossOrigin(origins = "http://localhost:63342")
public class EmployeeController {
    private final EmployeeService service;
    public EmployeeController(EmployeeService service) { this.service = service; }

    @GetMapping
    public List<Employee> getAll() { return service.getAll(); }

    @GetMapping("/{id}")
    public Employee getById(@PathVariable Long id) { return service.getById(id); }

    @PostMapping
    public Employee add(@RequestBody Employee emp) { return service.save(emp); }

    @PutMapping("/{id}")
    public Employee update(@PathVariable Long id, @RequestBody Employee emp) {
        emp.setId(id);
        return service.save(emp);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) { service.delete(id); }
}
