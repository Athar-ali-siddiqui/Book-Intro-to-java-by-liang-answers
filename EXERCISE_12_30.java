
import java.io.*;

import java.util.*;


public class EXERCISE_12_30 {
  // public static Pattern pattern = Pattern.compile("-?\\d+(\\.\\d+)?");

  public static void main(String [] args) throws Exception {
    File file = new File("w3.txt");
    Map<Character,Integer> map = new HashMap<>();
    Scanner in = new Scanner(file);
    String line;char a;
    int count = 0;
    while (in.hasNextLine()) {
      line = in.nextLine();
      for (int i = 0; i < line.length(); i++) {
        count++;
        a = line.charAt(i);
        if (map.get(a) == null) {
          
          map.put(a, 1);
        } else {
          map.put(a, map.get(a)+1);
          
        }
      }
    }
    for (char key : map.keySet()) {
      System.out.println(key + ": "+ map.get(key));
    }
    System.out.println("count= "+count);
    
    
  }
  
}



