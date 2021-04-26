  
import java.util.*;

class Account {
  private static Account[] accounts = new Account[0];
  private final int id;
  private double bal;
  // Add new created account object in Array(name:accounts)
  public static void addAccount(Account a){
    Account[] newArr = new Account[accounts.length+1];
    for (int i = 0; i < accounts.length; i++) {
      newArr[i] = accounts[i];
    }
    newArr[accounts.length] = a;
    accounts = newArr;
    newArr = null;
  }
  // For the immutability of accounts array this getter method is used
  public static Account[] getAccountsDetails(){
    Account[] send = new Account[accounts.length];
    for (int i = 0; i < send.length; i++) {
      send[i] = accounts[i];
    }
    return send;
   
  }
  // Constructor
  Account(int id , double bal){
    this.id = id;
    this.bal = bal;
    addAccount(this);
  }
  double getbalance(){
    return this.bal;
  }
  void deposit(double amount){
    this.bal += amount;
  }
  void withdraw(double amount){
    if(amount > this.bal){
      System.out.println("Your Balance is insufiicient");
    }
    else{
      this.bal -= amount;
    }
  }
}


class EXERCISE_10_7{ //main class

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    Account a1 = new Account(0,1000);
    Account a2 = new Account(1,2500);
    Account a3 = new Account(2,100);
    Account a4 = new Account(3,4060);
    
    System.out.println(Arrays.toString(Account.getAccountsDetails()));
    byte choice ;
    Account a ;
    do {
      System.out.println("~TO EXIT ENTER NUMBER< 0~");
      System.out.print("Enter Account id :");
      choice = in.nextByte();
      if (choice < 0){
        break;
      }
      a = Account.getAccountsDetails()[choice];
      System.out.println("---------------------");
      do {

        System.out.print
        ("Main Menu\n1: check balance \n2: deposit \n3: withdraw \n4: exit\nEnter Choice :");
        choice = in.nextByte();
        if (choice == 1){
          System.out.println("Account Balance is : "+a.getbalance());
        }
        else if (choice == 2){
          System.out.print("Enter Deposit ammount :");
          a.deposit(in.nextDouble());
        }
        else if (choice == 3){
          System.out.print("Enter Withdrawal ammount :");
          a.withdraw(in.nextDouble());
        }
        System.out.println(" ");

      } while (choice != 4);

      System.out.println(" ");

    } while (true);   
  }
}

