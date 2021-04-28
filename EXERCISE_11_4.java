import java.util.*;

public class EXERCISE_11_4 {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        byte check ;
        Scanner in = new Scanner(System.in);
        while(true){
            System.out.print
            ("Checking max value in ArrayList\n1: Enter value in list\n2: Exit\nEnter choice: ");
            check = in.nextByte();
            if(check == 2){
                break;
            }
            else if ( check == 1){
                System.out.print("Enter value: ");
                list.add(in.nextInt());
            }
        };
        System.out.println("Highest number in list: "+max(list));
        
    }
    public static Integer max(ArrayList<Integer> list) {
        if(list == null || list.size() == 0){
            return null;
        }
        int max = list.get(0);
        for (int i = 1; i < list.size(); i++) {
            if(list.get(i) > max){
                max = list.get(i);
            }
        }
        return max;

    }
    
}
