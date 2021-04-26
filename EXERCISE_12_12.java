public class EXERCISE_12_12
   public static void main(String [] args) throws Exception {
	//Command line arguments
  
    String newFileName = args[0].substring(0, args[0].indexOf(".")) + "NLB" + args[0].substring(args[0].indexOf("."));
    System.out.println(newFileName);
    File file = new File(args[0]);
    Scanner in = new Scanner(file);
    PrintWriter out = new PrintWriter(newFileName);
    String line;int bracIndex;
    while (in.hasNextLine()) {
      line = in.nextLine();
      bracIndex = line.indexOf("{",0);
      String gap ="";
      if (bracIndex != -1) {
        out.println(line.substring(0, bracIndex));
        for (int i = 0; i < line.length(); i++) {
          if (line.charAt(i) == ' ') {
            gap += " ";
          } else {
            out.println(gap + "{");
            break;
          }
        }
        
      } else {
        out.println(line);
      } 
    }    
    out.close();
    
  }
}
