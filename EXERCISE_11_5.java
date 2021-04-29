import java.util.*;

public class EXERCISE_11_5 {
    public static void main(String[] args) {
        ArrayList<Course1> courses = new ArrayList<>();
        Scanner in = new Scanner(System.in);
        byte choice ;
        while(true){
            System.out.print
            ("\nMain Menu          0: To Exit\n1: Create New Course\n2: Add Student into Course \n3: Drop Student from Course\n4: List of Students of course\nEnter Choice :");
            choice = in.nextByte();
            int id = 0;
            Course1 c  = null;
            if( courses.size() != 0 && (choice == 3 || choice == 2 || choice ==4)){
                System.out.print("Enterr Course id: ");
                id = in.nextInt();
                c = courses.get(id-1); 
            }
            if(choice ==0){
                break;
            }
            else if(choice ==1){
                System.out.print("Enter Course Name: ");
                courses.add(new Course1(in.next()));
            }else if(choice ==2){
                System.out.print("Enter Student Name: ");
                c.addStudent(in.next());
            }else if(choice ==3){
                System.out.print("Enter Student Name: ");
                c.dropStudent(in.next());

            }else if ( choice == 4){
                System.out.println("Course Name: "+c.getCourseName());
                for (String nme : c.getStudents()) {
                    System.out.print(nme + ", ");
                }
                System.out.println("");
                
            }else{
                continue;
            }
        }
    }
}
class Course1{
    public static int totalCourse =0;
    private String courseName;
    private int numberOfStudents;
    private ArrayList<String> students =new ArrayList<>();
    Course1(String courseName ){
        this.courseName =courseName;
        totalCourse++;
        System.out.println("Course id is "+totalCourse);
    }
    public String getCourseName(){
        return courseName;
    }
    public int getNumberOfStudents(){
        return numberOfStudents;
    }
    public ArrayList<String> getStudents(){
        return students;
    }
    public void addStudent(String name){
        students.add(name);
        numberOfStudents++;
    }
    public void dropStudent(String name){
        students.remove(name);
    }
}
