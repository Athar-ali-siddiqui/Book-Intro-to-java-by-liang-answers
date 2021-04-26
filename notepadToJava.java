public class notepadToJava {
    public static void main(String [] args) throws Exception {
        File file = new File("C:\\Users\\786 Computers\\Desktop\\oop-practice-questions.txt");
       
        Scanner in = new Scanner(file);
        String line;
        File newFile = null;
        PrintWriter out = new PrintWriter("test.txt");
        while (in.hasNextLine()) {
          line = in .nextLine();
          if((line.contains("EXERCISE_") && line.contains("class")) || (line.contains("LISTING_") && line.contains("class"))){
            // System.out.println("~if   "+line);
    
            out.println(line);
            continue;
          }
          else if(line.contains("EXERCISE_") || line.contains("LISTING_")){
            out.close();
            // System.out.println("~else if   "+line);
            newFile = new File("C:\\Users\\786 Computers\\Intro-to-java-by-liang-answers\\"+line + ".java");
            out = new PrintWriter(newFile);
        
          }
          else{
            // System.out.println("~else   "+line);
    
            out.println(line);
    
          }
          
        }
        out.close();
        
      }
}
