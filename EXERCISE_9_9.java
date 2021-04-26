class EXERCISE_9_9{

  public static void main(String[] args) { 
    RegularPolygon a = new RegularPolygon(4, 5.3, 2, 3);
    System.out.println(a.getLengthOfSide());
    System.out.println(a.getNumberOfSide());
    System.out.println(a.getArea());
    System.out.println(a.getPerimeter());
    System.out.println(a.getX());
  }
}
  
class RegularPolygon{
  private int n = 3;
  private double side =1;
  private double x ;
  private double y;
  RegularPolygon(){} //no-arg constructor
  RegularPolygon(int n , double side){ // two params constructor
    this.n = n;
    this.side = side;
  }
  RegularPolygon(int n , double side ,double x,double y){ // all variable initializing constructor
    this.n = n;
    this.side = side;
    this.x = x;
    this.y =y;
  }
  int getNumberOfSide(){ //getter of no of side
    return n;
  }
  void setNumberOfSide(int n){//setter of no of side
    this.n= n;
  }
  double getLengthOfSide(){//getter of side
    return side;
  }
  void setNumberOfSide(double side){//setter of side
    this.side= side;
  }
  double getX(){//getter of x-coordinate
    return x;
  }
  void setX(double x){//setter of x-coordinate
    this.x= x;
  }
  double getY(){//getter of y-coordinate
    return y;
  }
  void setY(double y){//setter of y-coordinate
    this.y= y;
  }
  double getPerimeter(){

    return this.side * this.n;
  }
  double getArea(){
    return (this.n* Math.pow(this.side,2))/4*Math.tan(Math.PI/this.n);
  }
}

