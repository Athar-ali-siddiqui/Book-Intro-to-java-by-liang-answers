import java.util.*;

class StopWatch{
  private long startTime;
  private long stopTime;
  
  StopWatch(){
    this.startTime = new Date().getTime();
  }
  public void start(){
    this.startTime = new Date().getTime();
  }
  public void stop(){
    this.stopTime = new Date().getTime();
  }
  public double elapsedTime(){
    double elapsedTime = (double)(this.stopTime - this.startTime)/1000;
    this.startTime = 0;
    this.stopTime =0;
    return elapsedTime;
  }
  public double checkElapsedTime(){
    double elapsedTime = (double)(new Date().getTime() - this.startTime)/1000;
    System.out.println(" Checking elapsed time :" +elapsedTime);
    return elapsedTime;
  }
}

public class EXERCISE_9_6{
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int check ;
    StopWatch time = new StopWatch();
    while(true){
      System.out.print("To Exit Enter 0: ");
      check = in.nextInt();
      if(check == 0){
        break;
      }
      else{
        System.out.print("1: To Start StopWatch\n2: To Stop StopWatch \n3: Main Menu\nEnter Choice: ");
        check = in.nextInt();
      if(check == 1){
        time.start();
      }
      else if ( check == 2){
        time.stop();
        System.out.println("Elapsed Time : "+ (double)time.elapsedTime()/1000);
        break;
      }
      else{
        continue;
      }

      }
    }
  }
}

