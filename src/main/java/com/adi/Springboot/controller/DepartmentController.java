package com.adi.Springboot.controller;

import com.adi.Springboot.entity.Department;
import com.adi.Springboot.error.DepartmentNotFoundException;
import com.adi.Springboot.service.DepartmentService;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class DepartmentController {

    private DepartmentService departmentService;

    private final Logger LOGGER = LoggerFactory.getLogger(DepartmentController.class);

    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @PostMapping("/departments")
    public Department saveDepartment(@Valid @RequestBody Department department) {
        LOGGER.info("Inside save department");
        return departmentService.saveDepartment(department);
    }

    @GetMapping("/departments")
    public List<Department> fetchDepartmentList() {
        LOGGER.info("Inside fetch department");
        return departmentService.fetchDepartmentList();
    }

    @GetMapping("/departments/{id}")
    public Optional<Department> findById(@PathVariable("id") Long id) throws DepartmentNotFoundException {
        return departmentService.findById(id);
    }

    @DeleteMapping("/departments/{id}")
    public String deleteById(@PathVariable("id") Long id) {
        departmentService.deleteById(id);
        return "Delete Succesfull";
    }

    @PutMapping("/departments/{id}")
    public Department updateDepartment(@Valid @PathVariable("id") Long id,
                                       @RequestBody Department department) {
        return departmentService.updateDepartment(id, department);
    }

    @GetMapping("/departments/name/{name}")
    public Department fetchDepartmentByName(@PathVariable("name") String name) {
        return departmentService.fetchDepartmentByName(name);
    }
}
