package com.example.banking.bankdata.controller;

import com.example.banking.bankdata.model.EmployeeEntity;
import com.example.banking.bankdata.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
    @Autowired
    EmployeeService s1;

    @PostMapping
    public Object createEmployee(@RequestBody EmployeeEntity entity) {
        s1.saveEmployee(entity);
        System.out.println("The Employee " + entity.getName() + "saved");
        return "Employee "+entity.getName()+" Saved with employee ID "+entity.getId();
    }

    @GetMapping
    public List<EmployeeEntity> getAllEmployee() {
        System.out.println("Fetching employee data from db:");
        return s1.getAllEmployee();
    }

    @GetMapping("/{id}")
    public Object getById(@PathVariable Long id) {
        Optional<EmployeeEntity> optionalEntity = s1.getEmpById(id);
        if (optionalEntity.isPresent()) {
            System.out.println("Employee find out with id " + id);
            return optionalEntity.get();
        } else {
            System.out.println("Employee with id " + id + " does't exist!");
            return "Employee with id " + id + " not available";
        }
    }
    @PutMapping("/{id}")
     public String updateEmployee(@PathVariable Long id,@RequestBody EmployeeEntity empentity)
    {
        EmployeeEntity updated=s1.updatedEmployee(id,empentity);
        if(updated!=null)
        {
            System.out.println("The employee with id "+id+" updated successfully");
            return "updation success with Id "+id;

        }
        else
        {
            System.out.println("Employee with Id "+id+" does't exist so updation unsuccessful");
            return "Employee with id "+id+" does't exist!";
        }

    }
    @DeleteMapping("/{id}")
            public String deleteEmployee(@PathVariable Long id)
    {
        Optional<EmployeeEntity> check=s1.getEmpById(id);
        if(check.isPresent())
        {
            s1.deleteEmployeeById(id);
            System.out.println("Employee deleted: id "+id);
            return "Employee deleted: id"+id;
        }
        else {
            System.out.println("Employee with Id "+id+" does't exist");
            return "Employee with id "+id+" does't exist!";
        }
    }
}
