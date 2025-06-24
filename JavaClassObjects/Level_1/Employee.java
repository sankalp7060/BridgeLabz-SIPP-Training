import java.util.*;
public class Employee{
    private String name;
    private String id;
    private int salary;
    public Employee(String name,String id ,int salary){
      this.name=name;
      this.id=id;
      this.salary=salary;
    }
    public void displayDetails(){
      System.out.println("Employee Name:- "+name);
      System.out.println("Employee id:- "+id);
      System.out.println("Employee salary:- "+salary);
    }
    public static void main(String[] args){
      Employee employee=new Employee("Sankalp","sankalp@gla",20000);
      employee.displayDetails();
    }
}