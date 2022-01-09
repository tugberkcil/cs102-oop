public class Square extends Rectangle{
    public Square( double x1, double y1, double x2, double y2, double x3, double y3, double x4, double y4 ){
             super( x1, y1, x2, y2, x3, y3, x4, y4 );
             } 

    public String toString(){
       return  "\nCoordinates of Square are\n" + getCoordinates() +"\n Side is " +  getHeight()+  "\n Area is "+  getArea() ;
}
}