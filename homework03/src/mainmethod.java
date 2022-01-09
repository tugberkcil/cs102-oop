
public class mainmethod {
	 public static void main(String[] args) {
	        Quadrilateral quadrilateral =new Quadrilateral( 2,5,8,3,9,10,12,5);
            Trapezoid trapezoid =new Trapezoid(5,6,8,7,4,2,1,9);
            Parallelogram parallelogram =new Parallelogram(7,7,8,9,11,5,8,19);
            Rectangle rectangle =new Rectangle(15,13,28,12,31,45,22,26);
            Square square =new Square(5,5,6,3,7,3,3,3);
            
            System.out.printf("%s %s %s %s %s\n", quadrilateral, trapezoid, parallelogram,rectangle, square );

	    }
}

