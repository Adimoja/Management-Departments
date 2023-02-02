package com.adi.Springboot.service;

import com.adi.Springboot.entity.Department;
import com.adi.Springboot.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class DepartmentServiceImpl implements  DepartmentService {

    @Autowired
    private DepartmentRepository departmentRepository;

    @Override
    public Department saveDepartment(Department department) {
        return departmentRepository.save(department);
    }

    @Override
    public List<Department> fetchDepartmentList() {
        return departmentRepository.findAll();
    }

    @Override
    public Optional<Department> findById(Long id) {
        return departmentRepository.findById(id);
    }

    @Override
    public void deleteById(Long id) {
        departmentRepository.deleteById(id);
    }

    @Override
    public Department updateDepartment(Long id, Department department) {
        Department departmentdb = departmentRepository.findById(id).get();

        if (Objects.nonNull(department.getDepartmentName()) &&
                !"".equalsIgnoreCase(department.getDepartmentName())) {
            departmentdb.setDepartmentName(department.getDepartmentName());
        }
        if (Objects.nonNull(department.getDepartmentAdress()) &&
                !"".equalsIgnoreCase(department.getDepartmentAdress())) {
            departmentdb.setDepartmentAdress(department.getDepartmentAdress());

        }
        if (Objects.nonNull(department.getDepartmentCode()) &&
                !"".equalsIgnoreCase(department.getDepartmentCode())) {
            departmentdb.setDepartmentCode(department.getDepartmentCode());

        }
        return departmentRepository.save(departmentdb);
    }
}
