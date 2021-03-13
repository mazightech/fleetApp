package com.maztech.fleet.repos;

import com.maztech.fleet.entities.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Integer> {

    Employee findByUsername(String username);

    @Query(value = "select * from Employee e where e.firstname like %:keyword% or e.lastname like %:keyword%", nativeQuery = true)
    List<Employee> findbyKeywords(@Param("keyword") String keyword);
}
