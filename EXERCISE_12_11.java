public class EXERCISE_12_11{
  public static void main(String [] args) throws Exception {
	//COmmand-line argument
    File file = new File(args[0]);
    Scanner in = new Scanner(file);
    StringBuilder sb = new StringBuilder();
    while (in.hasNextLine()) {
      String line = in.nextLine();
      System.out.println(line);
      sb.append(line);
    }
    System.out.println(sb);
    System.out.println(sb.toString().replaceAll("John", ""));
    PrintWriter out = new PrintWriter(file);
    out.print(sb.toString().replaceAll("John", ""));
    out.close();
    
  }
}
