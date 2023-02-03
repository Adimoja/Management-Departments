package com.adi.Springboot.service;

import com.adi.Springboot.entity.Department;
import com.adi.Springboot.error.DepartmentNotFoundException;

import java.util.List;
import java.util.Optional;

public interface DepartmentService {
   public Department saveDepartment(Department department);

   public List<Department> fetchDepartmentList();

  public Optional<Department> findById(Long id) throws DepartmentNotFoundException;

    public void deleteById(Long id);

   public Department updateDepartment(Long id, Department department);

    public Department fetchDepartmentByName(String name);
}
