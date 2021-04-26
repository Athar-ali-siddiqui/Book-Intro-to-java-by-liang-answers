
class Course{
  private String name;
  private String[] students = new String[0];
  private int numberOfStudents= 0;
  Course(String name){
    this.name = name;
  }
  public String getName() {
    return name;
  }
  public String getStudents() {
    return Arrays.toString(students) ;
  }
  public int getNumberOfStudents() {
    return numberOfStudents;
  }
  public void addStudents(String student){
    numberOfStudents++;
    String[] s = new String[numberOfStudents];
    for (int i = 0; i < students.length; i++) {
      s[i] = students[i];
    }
    s[students.length] = student;
    students = s;
  }
}
class EXERCISE_10_9{
  public static void main(String[] args) {
    Course a = new Course("ics");
    System.out.println("Before Adding Strudent in Course");
    System.out.println("Name of Course : " + a.getName());
    System.out.println("Number of Students Enrolled in course :"+a.getNumberOfStudents());
    System.out.println( "Students Enrolled in course : " +a.getStudents());
    System.out.println("After Adding Strudent in Course");
    a.addStudents("athar");
    System.out.println("");
    System.out.println("After Adding first Strudent in Course");
    System.out.println("Name of Course : " + a.getName());
    System.out.println("Number of Students Enrolled in course :"+a.getNumberOfStudents());
    System.out.println( "Name of Students Enrolled in course : " +a.getStudents());
    a.addStudents("mubashir");
    System.out.println("");
    System.out.println("After Adding Second Strudent in Course");
    System.out.println("Name of Course : " + a.getName());
    System.out.println("Number of Students Enrolled in course :"+a.getNumberOfStudents());
    System.out.println( "Students Enrolled in course : " +a.getStudents());
  }
}

