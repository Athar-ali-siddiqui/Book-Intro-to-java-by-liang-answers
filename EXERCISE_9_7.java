import java.util.*;
public class EXERCISE_9_7 {
    public static void main(String[] args) {
        
    }
}
class Account{
    private int id;
    private double balance;
    private double annualInterestRate ;
    private Date dateCreated;
    Account(){
        this.dateCreated = new Date();
    }
    Account(int id , double bal , double annualInterestRate){
        this();
        this.id = id ;
        this.balance = bal;
        this.annualInterestRate = annualInterestRate;
    }
    public int getId(){
        return id;
    }
    public double getBalance(){
        return balance; 
    }
    public double getAnnualInterestRate(){
        return balance*(annualInterestRate/100); 
    }
    public double getMontlyInterestRate(){
        return balance* (annualInterestRate/12)/100; 
    }
    public Date getDateCreated(){
        return dateCreated;
    }
    public void deposit(double amount){
        this.balance += amount;
      }
    public void withdraw(double amount){
        if(amount > this.balance){
            System.out.println("Your Balance is insufiicient");
        }
        else{
            this.balance -= amount;
        }
    }    
}
