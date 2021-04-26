
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

11.3
code and uml : https://github.com/Athar-ali-siddiqui/Bank-Account-java

LISTING_12_18

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.*;
import java.util.regex.Pattern;

public class LISTING_12_18 {
  // public static Pattern pattern = Pattern.compile("-?\\d+(\\.\\d+)?");
  public static ArrayList<String> pendingUrls = new ArrayList<>();
  public static ArrayList<String> traversedUrls = new ArrayList<>();
 
  public static void main(String [] args) throws Exception {
    
   
    System.out.print("Enter Url: ");
    String startUrl = new Scanner(System.in).next();

    crawler(startUrl);
    
    for (String url : traversedUrls) {
      System.out.println("Craw " + url);
    }
  }
  public static void crawler(String startUrl) {
    pendingUrls.add(startUrl);
    while ( traversedUrls.size() != 50 && !pendingUrls.isEmpty()) {

      try {
        for (String link : getSubUrls(pendingUrls.get(0)) ) {
          if( !traversedUrls.contains(link)){
            pendingUrls.add(link);
          }
        }
      } catch (IOException e) {
        // TODO Auto-generated catch block
        pendingUrls.remove(0);
      }
    }   
  }
  public static ArrayList<String> getSubUrls(String url) throws IOException{
    URL link = new URL(url);
    ArrayList<String> list = new ArrayList<>();
    Scanner in = new Scanner(link.openStream());
    int start = 0 ;
    int count = 0;
    System.out.println("~~~~~~~~MAIN URL : " + url);

    while (in.hasNextLine()) {
      String line = in.nextLine();
      start = line.indexOf("http:",start);
      while (start > 0) {
        int end = line.indexOf("\"", start);
        if (end > 0) {
          list.add(line.substring(start, end));
          System.out.println(line.substring(start, end));
          count++;
          start = line.indexOf("https:", end);
        } else {
          start = -1;
        }
      }
    }
    traversedUrls.add(pendingUrls.get(0));
    pendingUrls.remove(0);

    return list;
  }
}
