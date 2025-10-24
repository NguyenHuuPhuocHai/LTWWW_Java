package iuh.fit.se.baitap2.controllers;

import iuh.fit.se.baitap2.entities.Employee;
import iuh.fit.se.baitap2.services.EmployeeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/employees")
public class EmployeeController {
    private final EmployeeService service;

    public EmployeeController(EmployeeService service) {
        this.service = service;
    }

    @GetMapping
    public String listEmployees(Model model) {
        model.addAttribute("employees", service.getAllEmployees());
        return "index";
    }

    @GetMapping("/add")
    public String addForm(Model model) {
        model.addAttribute("employee", new Employee());
        return "add";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute("employee") Employee employee) {
        service.saveEmployee(employee);
        return "redirect:/employees";
    }

    @GetMapping("/edit/{id}")
    public String editForm(@PathVariable Long id, Model model) {
        model.addAttribute("employee", service.getEmployeeById(id));
        return "edit";
    }

    @PostMapping("/update")
    public String update(@ModelAttribute("employee") Employee employee) {
        service.updateEmployee(employee);
        return "redirect:/employees";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Long id) {
        service.deleteEmployee(id);
        return "redirect:/employees";
    }
}
