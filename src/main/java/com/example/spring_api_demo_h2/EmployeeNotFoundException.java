package com.example.spring_api_demo_h2;

public class EmployeeNotFoundException extends RuntimeException{
  public EmployeeNotFoundException(Long id) {
    super("Could not find employee: " + id);
  }
}
