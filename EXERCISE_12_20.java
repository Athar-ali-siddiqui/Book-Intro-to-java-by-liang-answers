
import java.io.*;

import java.util.*;


public class EXERCISE_12_20 {
  // public static Pattern pattern = Pattern.compile("-?\\d+(\\.\\d+)?");

  public static void main(String [] args) throws Exception {
    File dir = new File("D:\\srcRootDirectory");
    System.out.println(dir);
    File[] foldersName = dir.listFiles(new FilenameFilter(){
      @Override
      public boolean accept(File dir, String name) {
          // System.out.println(dir + "  " + name);
          return name.startsWith("chapter");
      }
    });
    
    for (File folderName : foldersName) {
      File[] name =folderName.listFiles(new FilenameFilter(){
        @Override
        public boolean accept(File dir, String name) {
          // System.out.println(dir + "  " + name);
          return name.startsWith("source") && name.endsWith(".java");
        }
      });
      System.out.println(name[0]);
      Scanner in = new Scanner(name[0]);
      ArrayList<String> mat = new ArrayList<>();

      while (in.hasNextLine()) {
        mat.add(in.nextLine());
        
      }
      PrintWriter out = new PrintWriter(name[0]);
      for (int i = 1; i < mat.size(); i++) {
        // System.out.println(mat.get(i));
        out.println(mat.get(i));
      }
      out.close();
      
    }
    
  }
  
}

