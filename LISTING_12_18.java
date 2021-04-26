
import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.*;
import java.util.regex.Pattern;

public class LISTING_12_18 {
  // public static Pattern pattern = Pattern.compile("-?\\d+(\\.\\d+)?");
  public static ArrayList<String> pendingUrls = new ArrayList<>();
  public static ArrayList<String> traversedUrls = new ArrayList<>();
 
  public static void main(String [] args) throws Exception {
    
   
    System.out.print("Enter Url: ");
    String startUrl = new Scanner(System.in).next();

    crawler(startUrl);
    
    for (String url : traversedUrls) {
      System.out.println("Craw " + url);
    }
  }
  public static void crawler(String startUrl) {
    pendingUrls.add(startUrl);
    while ( traversedUrls.size() != 50 && !pendingUrls.isEmpty()) {

      try {
        for (String link : getSubUrls(pendingUrls.get(0)) ) {
          if( !traversedUrls.contains(link)){
            pendingUrls.add(link);
          }
        }
      } catch (IOException e) {
        // TODO Auto-generated catch block
        pendingUrls.remove(0);
      }
    }   
  }
  public static ArrayList<String> getSubUrls(String url) throws IOException{
    URL link = new URL(url);
    ArrayList<String> list = new ArrayList<>();
    Scanner in = new Scanner(link.openStream());
    int start = 0 ;
    int count = 0;
    System.out.println("~~~~~~~~MAIN URL : " + url);

    while (in.hasNextLine()) {
      String line = in.nextLine();
      start = line.indexOf("http:",start);
      while (start > 0) {
        int end = line.indexOf("\"", start);
        if (end > 0) {
          list.add(line.substring(start, end));
          System.out.println(line.substring(start, end));
          count++;
          start = line.indexOf("https:", end);
        } else {
          start = -1;
        }
      }
    }
    traversedUrls.add(pendingUrls.get(0));
    pendingUrls.remove(0);

    return list;
  }
}

