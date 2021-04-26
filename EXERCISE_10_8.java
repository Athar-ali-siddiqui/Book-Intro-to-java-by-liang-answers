
import java.util.*;

class Tax{
  public final int filingStatus;
  private double income;
  private double tax;
  private static int[][] brac = {
                                {0, 27_050 , 65_550 , 136_750 , 297_350 },
                                {0, 45_200 , 109_250 , 166_500 , 297_350 },
                                {0, 22_600 , 54_625 , 83_250 , 148_675 },
                                {0, 36_250 , 93_650 , 151_650 , 297_350 }
                                }; 
                                
  private static double[] rates = {0.15,0.275,0.305,0.355,0.391};

  Tax(int i , double in){
    this.filingStatus = i;
    this.income = in;
    this.tax = 0;
  }
  double getTax(){
    int i ;
    for (i = 1; i < brac[this.filingStatus].length; i++) {
      // System.out.println("i= "+i);
      // System.out.println("brac[this.filingStatus][i-1]= "+ brac[this.filingStatus][i-1]);
      // System.out.println("brac[this.filingStatus][i]= "+brac[this.filingStatus][i]);
      // System.out.println("rates[i-1]= "+rates[i-1]);
      if(this.income <= brac[this.filingStatus][i]){

        this.tax += ( this.income - brac[this.filingStatus][i-1] ) * rates[i-1];
        break;

      }
      else if (this.income > brac[this.filingStatus][i]){
        
        this.tax += ( brac[this.filingStatus][i] - brac[this.filingStatus][i-1]  ) * rates[i-1];
      
      }
      // System.out.println("TAX ==== " + this.tax);

    }
    // System.out.println(i);
    i = brac[this.filingStatus].length;
    if( this.income > brac[this.filingStatus][i-1]){
      this.tax += ( this.income - brac[this.filingStatus][i-1] ) * rates[i-1];
    }

    return this.tax;
  }
}

public class EXERCISE_10_8{
  public static void main(String[] args) {
    Tax t1 = new Tax(0, 200000);
    System.out.println(t1.getTax());
  }
}

