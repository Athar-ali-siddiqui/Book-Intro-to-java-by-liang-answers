

import java.util.*;

public class EXERCISE_11_2{
  public static void main(String[] args) {
   
  }
}
class Person{
  public String name;
  public String address;
  public String phoneNumber;
  public String email;
  Person(String name,String address,String phoneNumber, String email){
    this.name = name;
    this.address = address;
    this.phoneNumber = phoneNumber;
    this.email = email;
  }
  @Override
  public String toString(){
    return  this.name + " is " + "Person";
  }
}
class Student extends Person{
  public String classStatus;
  Student(String name,String address,String phoneNumber, String email , String classStatus){
    super(name,address,phoneNumber,email);
    this.classStatus = classStatus;
  }
  @Override
  public String toString(){
    return  this.name + " is " + "Student";
  }
}
class Employee extends Person{
  public Date hiringDate ;
  public int salary;
  Employee(String name,String address,String phoneNumber, String email ,int salary ){
    super(name,address,phoneNumber,email);
    this.hiringDate = new Date();
    this.salary = salary;
  }
  @Override
  public String toString(){
    return  this.name + " is " + "Employee";
  }
}
class Faculty extends Employee{
  public int hours;
  public String rank;
  Faculty(String name,String address,String phoneNumber, String email ,int salary,int hours , String rank ){
    super(name,address,phoneNumber,email,salary);
    this.hours = hours;
    this.rank = rank;
  }
  @Override
  public String toString(){
    return  this.name + " is " + "Feculty member";
  }
}
class Staff extends Employee{
  public String title;
  Staff(String name,String address,String phoneNumber, String email ,int salary, String title ){
    super(name,address,phoneNumber,email,salary);
    this.title = title;
  }
  @Override
  public String toString(){
    return  this.name + " is " + "Staff member";
  }
}

// 11.3
// code and uml : https://github.com/Athar-ali-siddiqui/Bank-Account-java


