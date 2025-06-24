package com.example.banking.bankdata.model;
import jakarta.persistence.*;

@jakarta.persistence.Entity
public class EmployeeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private int salary;
    private int age;
    private String mailId;
    private String doj;

    //no argument constructor
    public EmployeeEntity(){}
    //constructor for inserting data through controller class
   public EmployeeEntity(Long id, String name, int salary, int age, String mailId, String doj)
   {
       this.id=id;
       this.name=name;
       this.salary=salary;
       this.age=age;
       this.mailId=mailId;
       this.doj=doj;
   }
   //getters and setters
  public Long getId()
  {
      return id;
  }
  public void setId(Long id)
  {
      this.id=id;
  }
  public String getName()
  {
      return name;
  }
  public void setName(String name)
  {
      this.name=name;
  }
  public int getSalary()
  {
      return salary;
  }
  public void setSalary(int salary)
  {
      this.salary=salary;
  }
  public int getAge()
  {
      return age;
  }
  public void setAge(int age)
  {
      this.age=age;
  }
  public String getMailId(){return mailId;}
  public void setMailId(String mailId){this.mailId=mailId;}
  public String getDoj()
  {
      return doj;
  }
  public void setDoj(String doj)
  {
      this.doj=doj;
  }


}
