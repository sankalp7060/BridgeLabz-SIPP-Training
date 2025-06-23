import java.util.*;
public class Student{
    private String name;
    private String rollNumber;
    private int marks;
    public Student(String name,String rollNumber,int marks){
      this.name=name;
      this.rollNumber=rollNumber;
      this.marks=marks;
    }
    public void displayDetails(){
      System.out.println("Student name:- "+name);
      System.out.println("Student Roll Number:- "+rollNumber);
      System.out.println("Student marks:- "+marks);
      System.out.println("Student Grade:- "+calculateGrade());
    }
    public String calculateGrade(){
      if(marks>=90) return "O";
      else if(marks>=80) return "A+";
      else if(marks>=70) return "A";
      else if(marks>=60) return "B+";
      else if(marks>=50) return "B";
      else if(marks>=40) return "C+";
      else if(marks>=30) return "C";
      else return "F";
    }
    public static void main(String[] args){
      String name="San";
      String rollNumber="62";
      int marks=30;
      Student student =new Student(name,rollNumber,marks);
      student.displayDetails();
    }
}