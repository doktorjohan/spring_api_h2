package com.example.spring_api_demo_h2;

import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Where the magic happens. Maps REST requests to actually doing something.
 * GET employee in two forms: get all employees or get single employee by id.
 */
@RestController
public class EmployeeController {

  private final EmployeeRepository repo;

  public EmployeeController(EmployeeRepository repo) {
    this.repo = repo;
  }

  @GetMapping("/employees")
  List<Employee> getAllEmployees() {
    return repo.findAll();
  }

  @PostMapping("/employees")
  Employee addNewEmployee(@RequestBody Employee newEmployee) {
    return repo.save(newEmployee);
  }

  @GetMapping("/employees/{id}")
  Employee getEmployeeById(@PathVariable Long id) {
    return repo.findById(id)
        .orElseThrow(() -> new EmployeeNotFoundException(id));
  }

  @PutMapping("/employees/{id}")
  Employee replaceEmployee(@RequestBody Employee newEmployee, @PathVariable Long id) {

    return repo.findById(id)
        .map(employee -> {
          employee.setName(newEmployee.getName());
          employee.setRole(newEmployee.getRole());
          return repo.save(employee);
        })
        .orElseGet(() -> {
          newEmployee.setId(id);
          return repo.save(newEmployee);
        });
  }

  @DeleteMapping("/employees/{id}")
  void deleteEmployee(@PathVariable Long id) {
    repo.deleteById(id);
  }

}
