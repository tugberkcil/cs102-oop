public class Quadrilateral {
    private Point p1; 
    private Point p2; 
    private Point p3; 
    private Point p4; 

 
     public Quadrilateral( double x1, double y1, double x2, double y2,double x3, double y3, double x4, double y4 ) {
        p1 = new Point( x1, y1 );
        p2 = new Point( x2, y2 );
        p3 = new Point( x3, y3 );
        p4 = new Point( x4, y4 );
     } 
     public Point getP1() {
       return p1;
     }
     public Point getP2() {
       return p2;
     } 
     public Point getP3() {
       return p3;
     } 
     public Point getP4() {
       return p4;
     } 
     public String toString(){
       return "\nCoordinates of Quadrilateral are " + getCoordinates();
     }
     public String getCoordinates() {
       return String.format("%s, %s, %s, %s\n", p1, p2, p3, p4 );
     }

}

