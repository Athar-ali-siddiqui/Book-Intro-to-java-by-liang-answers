import java.util.*;

public class EXERCISE_11_3 {
    public static ArrayList<Account1> accounts = new ArrayList<>();
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
   
        byte choice ;
        Account1 a = null;
        //MAIN MENU
        while (true) {
            
            System.out.print
            ("\nMain Menu          0: To Exit\n1: Check balance \n2: Deposit \n3: Withdraw \n4: Create Account\nEnter Choice :");
            choice = in.nextByte();
            if(choice != 0 && choice != 4){
                System.out.print("Enter Account id: ");
                a =  accounts.get(in.nextInt()-1);
            }
            if (choice == 0) {
                break;
            } else if (choice == 1){
                System.out.println("Account Balance is : "+a.getBalance());
            }
            else if (choice == 2){
                System.out.print("Enter Deposit ammount :");
                a.deposit(in.nextDouble());
            }
            else if (choice == 3){
                System.out.print("Enter Withdrawal ammount :");
                a.withdraw(in.nextDouble());
            }
            else if(choice == 4){
                accountsMenu();
                
            }
            else{
                continue;
            }

        }
    }
    public static boolean accountsMenu(){
        System.out.print("\n Accounts Menu     0:back\n1: Normal Account\n2: Saving Account\n3: Checking Account\nEnter Choice: ");
        byte choice = new Scanner(System.in).nextByte();
        System.out.print("Enter Following Details \nAnnual Interest Rate: ");
        double interest = choice != 0 ? new Scanner(System.in).nextDouble() : 0;
    
        System.out.print("Initial amount: ");
        double bal = choice != 0 ? new Scanner(System.in).nextDouble() : 0;
  
        if (choice == 0){
          return false;
        }
        else if (choice == 1){
          accounts.add(new Account1(bal,interest));
        }
        else if (choice ==2){
            accounts.add(new SavingAccount(bal,interest));
        }
        else if (choice == 3){
            accounts.add(new CheckingAccount(bal,interest));
        }
        return false;
      }
}
class Account1{
    protected int id;
    protected double balance;
    protected double annualInterestRate ;
    protected Date dateCreated;
    private static int numberOfaccounts =0;

    Account1(double bal , double annualInterestRate){
        this.balance = bal;
        this.id = ++numberOfaccounts ;
        this.annualInterestRate = annualInterestRate;
        this.dateCreated = new Date();
        System.out.print("Account is created .Your Account id is " + this.id);
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
    public String getDateCreated(){
        return dateCreated.toString();
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
class CheckingAccount extends Account1{
    
    CheckingAccount( double bal,double annualInterestRate){
      super(bal,annualInterestRate);
      //TODO Auto-generated constructor stub
    }
    @Override
    public void withdraw(double amount){
      if(amount >= this.balance*1.3){ 
          // Account holder can Overdraft only 30% of your Balance as it is Checking Account
        System.out.println("You can Overdraft only 30% of your Balance ");
      }
      else{
        this.balance -= amount;
      }
    }
  
  }
  class SavingAccount extends Account1{

    SavingAccount(double bal,double annualInterestRate){
        super(bal,annualInterestRate);
        //TODO Auto-generated constructor stub
    }

    @Override
    public void withdraw(double amount){
      if(amount > this.balance){
        System.out.println("Your Balance is insufiicient");
      }
      else if(amount > this.balance*0.5){ 
          // As it is Saving Account so we can't withdraw large ammount 
        System.out.println("You can withdraw 50% of your total Amount");
      }
      else{
        this.balance -= amount;
      }
    }
  }