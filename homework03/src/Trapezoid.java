public class Trapezoid extends Quadrilateral {
	    
     public Trapezoid( double x1, double y1, double x2, double y2,double x3, double y3, double x4, double y4 ){
	       super( x1, y1, x2, y2, x3, y3, x4, y4 );
	      } 
	    public double getHeight() {
	     if ( getP1().getY() == getP2().getY())
	       return Math.abs( getP2().getY() - getP3().getY() );
	     else
	       return Math.abs( getP1().getY() - getP2().getY() );
	     } 
        public double getArea(){
	       return getSumOfTwoSides() * getHeight() / 2.0;
	     } 
	    public double getSumOfTwoSides(){
	       if ( getP1().getY() == getP2().getY() )
	          return Math.abs( getP1().getX() - getP2().getX() ) +Math.abs( getP3().getX() - getP4().getX() );
	       else
	          return Math.abs( getP2().getX() - getP3().getX() ) + Math.abs( getP4().getX() - getP1().getX() );
	    }
	    public String toString(){
	        return "\nCoordinates of Trapezoid are "+ getCoordinates()+"\nHeight is " +  getHeight()+"\nArea is " +  getArea() ;
	     }
	}


