package com.ex.mapper;

import java.util.*;
import java.util.stream.Collectors;

import com.ex.dto.AddressDTO;
import com.ex.dto.DepartmentDTO;
import com.ex.dto.EmployeeDTO;
import com.ex.model.Address;
import com.ex.model.Department;
import com.ex.model.Employee;

public class EmployeeMapper {

	
    public static Employee toSave(EmployeeDTO dto) {
        Employee employee = new Employee();
        employee.setId(dto.getId());
        employee.setName(dto.getName());
        employee.setGender(dto.getGender());
        employee.setEmployeeCode(dto.getEmployeeCode());
        employee.setDateOfBirth(dto.getDateOfBirth());
        
        
        employee.setEmail(dto.getEmail());
        employee.setMobileNumber(dto.getMobileNumber());
        employee.setEmergencyContact(dto.getEmergencyContact());

        if (dto.getAddresses() != null) {
            List<Address> addresses = dto.getAddresses().stream().map(a -> {
                Address address = new Address();
                address.setType(a.getType());
                address.setCity(a.getCity());
                address.setState(a.getState());
                address.setZip(a.getZip());
                address.setLine1(a.getLine1());
                address.setEmployee(employee);
                return address;
            }).collect(Collectors.toList());

            employee.setAddresses(addresses);
        }

        return employee;
    }

    
    public static EmployeeDTO toDTO(Employee employee) {
        EmployeeDTO dto = new EmployeeDTO();
        dto.setId(employee.getId());
        dto.setName(employee.getName());
        dto.setGender(employee.getGender());
        dto.setEmployeeCode(employee.getEmployeeCode());
        dto.setDateOfBirth(employee.getDateOfBirth());
        
        dto.setEmail(employee.getEmail());
        dto.setMobileNumber(employee.getMobileNumber());
        dto.setEmergencyContact(employee.getEmergencyContact());

        //Map address
        if (employee.getAddresses() != null) {
            List<AddressDTO> addressDTOs = employee.getAddresses().stream().map(addr -> {
                AddressDTO a = new AddressDTO();
                a.setType(addr.getType());
                a.setCity(addr.getCity());
                a.setState(addr.getState());
                a.setLine1(addr.getLine1());
                a.setZip(addr.getZip());
                return a;
            }).collect(Collectors.toList());

            dto.setAddresses(addressDTOs);
        }
        
        //Map department
        
        if (employee.getDepartments() != null) {
            List<DepartmentDTO> deptDTOs = employee.getDepartments().stream().map(dep -> {
                DepartmentDTO d = new DepartmentDTO();
                d.setId(dep.getId());
                d.setName(dep.getName());
                d.setType(dep.getType());
                d.setDescription(dep.getDescription());
                d.setNumberOfEmployees(dep.getNumberOfEmployees());
                d.setResponsibilities(dep.getResponsibilities());
                return d;
            }).collect(Collectors.toList());
            dto.setDepartments(deptDTOs);
        }

        return dto;
    }
}
