package com.example.banking.bankdata.service;


import com.example.banking.bankdata.model.EmployeeEntity;
import com.example.banking.bankdata.repository.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {

    @Autowired
   private EmployeeRepo r1;


     public EmployeeEntity saveEmployee(EmployeeEntity e1)
     {
         return r1.save(e1);
     }
     public List<EmployeeEntity> getAllEmployee()
     {
         return r1.findAll();
     }
     public Optional<EmployeeEntity> getEmpById(Long id)
     {
         return r1.findById(id);
     }
   public EmployeeEntity updatedEmployee(Long id,EmployeeEntity updatedEmployee)
   {
       Optional<EmployeeEntity> optionalEmployee=r1.findById(id);
       if(optionalEmployee.isPresent())
       {
           EmployeeEntity existingEmployee=optionalEmployee.get();
           existingEmployee.setName(updatedEmployee.getName());
           existingEmployee.setSalary(updatedEmployee.getSalary());
           existingEmployee.setAge(updatedEmployee.getAge());
           existingEmployee.setMailId(updatedEmployee.getMailId());
           existingEmployee.setDoj(updatedEmployee.getDoj());
           return r1.save(existingEmployee);
       }
       else
       {
           return null;
       }
   }
   public void deleteEmployeeById(Long id)
   {
       r1.deleteById(id);
   }
}
