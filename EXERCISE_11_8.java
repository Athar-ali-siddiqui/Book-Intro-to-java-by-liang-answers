import java.util.*;

public class EXERCISE_11_8 {
    public static void main(String[] args) {
        ArrayList<Account> accounts = new ArrayList<>();
        Scanner in = new Scanner(System.in);
   
        byte choice ;
        Account a = null;
        //MAIN MENU
        while (true) {
            //System.out.println(Arrays.toString(Account.getAccountsArray()));
            System.out.print
            ("\nMain Menu          0: To Exit\n1: Check balance \n2: Deposit \n3: Withdraw \n4: Create Account\n5: Transactions Details\nEnter Choice :");
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
                System.out.print("Enter Following Details\nInitial balance: ");

                double balance =in.nextDouble();
                System.out.print("Annual Interest rate: ");

                double annualInterestRate=in.nextDouble() ;
                System.out.print("Name: ");

                String name=in.next();
                accounts.add(new Account(name, balance, annualInterestRate));
                
            }
            else if (choice == 5){
                System.out.println(a.toString());
                a.transactionsDetail();
            }
            else{
                continue;
            }

        }
    }
    
}

class Account{
    private int id;
    private double balance;
    private double annualInterestRate ;
    private String name;
    private Date dateCreated;
    private static int numberOfaccounts =0;
    private ArrayList<Transaction> transactions = new ArrayList<>();
    
    Account(String name, double bal , double annualInterestRate){
        this.dateCreated = new Date();
        this.name = name;
        this.id = ++numberOfaccounts ;
        this.balance = bal;
        this.annualInterestRate = annualInterestRate;
        System.out.print("Account is created .Your Account id is " + this.id);
    }
    public int getId(){
        return id;
    }
    public double getBalance(){
        return balance; 
    }
    public String getName(){
        return name;
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
        transactions.add(new Transaction('D', this.balance, amount));
      }
    public void withdraw(double amount){
        if(amount > this.balance){
          System.out.println("Your Balance is insufiicient");
        }
        else{
          this.balance -= amount;
          transactions.add(new Transaction('W', this.balance, amount));
        }
    }
    public void transactionsDetail(){
        System.out.println("\nTRANSACTIONS DETAIL");
        for (int i = 0; i < transactions.size(); i++) {
            System.out.println(transactions.get(i));
        }
    }
    @Override
    public String toString(){
      return "Account holder: " + this.name + "  Account id: "+ this.id + " Current Balance: "+ this.balance;
    }
}


class Transaction {
    private Date date;
    private char type;
    private double amount;
    private double balance ;
    private String description;
    Transaction( char type , double balance, double amount){
        this.date = new Date();
        this.amount = amount;
        this.balance = balance;
        this.type = type;
        if(this.type == 'W'){
            this.description = "Withdrawal";
        }
        else if (this.type == 'D'){
            this.description = "Deposit";
        }
    }
    public String getDate(){
        return date.toString();
    }
    public char getType(){
        return type;
    }
    @Override
    public String toString(){
        return 
        this.date.toString() +" | " + this.description +" | "+(this.type == 'W'? '-' : '+')+this.amount+ " | "+ this.balance;
    }
}   
