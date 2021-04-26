
import java.util.*;

class MyPoint{ // this class is also in Ex:10.4
  private double x; private double y;
  MyPoint(){x=0;y=0;} // no-args constructor which create point default value of 0 
  MyPoint(double x , double y){this.x=x;this.y=y;} // constructor with specified values of co-ordinates
  double x(){return this.x;} //getter of x
  double y(){return this.y;} // getter of y

  double distance(MyPoint p2){
    return Math.sqrt( Math.pow((p2.x() - this.x()), 2) + Math.pow((p2.y() - this.y()), 2));
  }
  double distance(int x , int y){
    return Math.sqrt( Math.pow((x - this.x()), 2) + Math.pow((y - this.y()), 2));
  }
}

class Triangle2D{
  MyPoint p1 ; MyPoint p2 ; MyPoint p3;
  // Constructors
  Triangle2D(){
    this.p1 = new MyPoint();
    this.p2 = new MyPoint(1,1);
    this.p3 = new MyPoint(2,5);    
  }
  Triangle2D(double x1 ,double y1 ,double x2 ,double y2,double x3 ,double y3){
    this.p1 = new MyPoint(x1,y1);
    this.p2 = new MyPoint(x2,y2);
    this.p3 = new MyPoint(x3,y3);
  }
  Triangle2D(MyPoint p1 , MyPoint p2 ,MyPoint p3){
    this.p1 = p1;
    this.p2 = p2;
    this.p3 = p3;
  }
  double getArea(){
    return Math.abs( p1.x()*( p2.y() - p3.y() ) + p2.x()*(p3.y() - p1.y()) + p3.x()*(p1.y() - p2.y()) ) / 2;
  }
  double getPerimeter(){
    return p1.distance(p2) + p2.distance(p3) + p3.distance(p1);
  }
  // check is specified point is in triangle or not 
  boolean contain(MyPoint p){
    double pArea = new Triangle2D(this.p1 , p ,this.p2).getArea()+ new Triangle2D(this.p2 , p ,this.p3).getArea() +
                   new Triangle2D(this.p1 , p ,this.p3).getArea();
    if ( pArea == this.getArea()){
      return true;
    }
    else{
      return false;
    }
  }
}

public class EXERCISE_10_12{
  public static void main(String[] args) {

    MyPoint p1 = new MyPoint();
    MyPoint p2 = new MyPoint(3,0);
    MyPoint p3 = new MyPoint(0,5);
    Triangle2D t1 = new Triangle2D(p1,p2,p3);
    
    System.out.println(t1.getArea());
    System.out.println(t1.contain(new MyPoint(1,0)));
    System.out.println(t1.getPerimeter());
  }
}

