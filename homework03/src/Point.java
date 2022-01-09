public class Point {
    private double x; 
    private double y; 

 
     public Point( double X_Coordinate, double Y_Coordinate )  {
      y = Y_Coordinate;
      x = X_Coordinate;
    } 

 
     public double getX() {
         return x;
    } 
     public double getY() {
         return y;
    } 
     public String toString() {
        return String.format( "( %.1f, %.1f )", getX(), getY() );
     }
}

