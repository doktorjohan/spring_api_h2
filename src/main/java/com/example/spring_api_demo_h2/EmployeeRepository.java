package com.example.spring_api_demo_h2;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Spring Boot shenanigan, provides easy access to database
 */
public interface EmployeeRepository extends JpaRepository<Employee, Long>
{
// cheap money
}
