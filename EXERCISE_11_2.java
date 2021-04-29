

import java.util.*;

public class EXERCISE_11_2{
  public static void main(String[] args) {
    ArrayList<Person> list = new ArrayList<>();
    Scanner in =new Scanner(System.in)   ;
    int choice ;
    String name;String address;String phoneNumber;String email;
    while(true){
      System.out.print
      ("\nMain Menu          0: To Exit\n1: Create Person\n2: Create Student \n3: Create Employee\n4: Create Faculty\n5: Create Staff\n6: Call toString()\nEnter Choice :");
      choice = in.nextByte();
      if(choice == 0){
        break;
      }else if ( choice == 6){
        System.out.println(" ");
        for (Person person : list) {
          System.out.println(person.toString());
        }
      }
      System.out.print("Enter Following Details\nName: "); name = in.next();
      System.out.print("Address: "); address= in.next();
      System.out.print("Phone No.: "); phoneNumber= in.next();
      System.out.print("Email: "); email= in.next();
      int salary = 0;
      if(choice ==3 || choice == 4 || choice ==5){
        System.out.print("Salary: ");
        salary= in.nextInt();
      }
      
      if(choice == 1){
        list.add(new Person(name, address, phoneNumber, email));
      }
      else if ( choice == 2){
        System.out.print("Class status: ");
        String classStatus = in.next();
        list.add(new Student(name, address, phoneNumber, email, classStatus));
      }
      
      else if ( choice == 3){
        
        list.add(new Employee(name, address, phoneNumber, email, salary));
      }
      else if ( choice == 4){
        System.out.print("Rank: ");
        String rank = in.next();
        System.out.print("Total job hours: ");
        int hours = in.nextInt();
        list.add(new Faculty(name, address, phoneNumber, email, salary, hours, rank));
      }
      else if ( choice == 5){
        System.out.print("Job title: ");
        String title = in.next();
        list.add(new Staff(name, address, phoneNumber, email, salary, title));
      }
      
      
    }      
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


