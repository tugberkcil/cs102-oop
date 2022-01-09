public class Parallelogram extends Trapezoid{
    public Parallelogram( double x1, double y1, double x2, double y2,double x3, double y3, double x4, double y4 )  {
             super( x1, y1, x2, y2, x3, y3, x4, y4 );
             } 

            
             public double getWidth() {
                  if ( getP1().getY() == getP2().getY() )
                     return Math.abs( getP1().getX() - getP2().getX() );
                  else
                     return Math.abs( getP2().getX() - getP3().getX() );
             } 

             public String toString()
             {
             return "\nCoordinates of Parallelogram are " +  getCoordinates()
             +"\nWidth is " + getWidth()
             +"\nHeight is " + getHeight()
             +"\nArea is " + getArea() ;
             }
}
