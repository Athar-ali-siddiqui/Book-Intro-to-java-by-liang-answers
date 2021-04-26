
import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.*;
import java.util.regex.Pattern;

public class EXERCISE_12_18 {

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
      String name1 = folderName.toString();
      name1 = "package " + name1.toString().substring(name1.indexOf("chapter"), name1.length()) +";";
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
      
      mat.add(name1);
      
      while (in.hasNextLine()) {
        mat.add(in.nextLine());
        
      }
      PrintWriter out = new PrintWriter(name[0]);
      for (int i = 0; i < mat.size(); i++) {
        // System.out.println(mat.get(i));
        out.println(mat.get(i));
      }
      out.close();      
    } 
  }  
}

