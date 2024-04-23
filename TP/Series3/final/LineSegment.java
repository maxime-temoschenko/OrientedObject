import java.lang.Math.*;

public class LineSegment
{
    private Coordinates point_one, point_two;
    // Constructor
    public LineSegment(Coordinates point_one, Coordinates point_two){
	this.point_one = point_one;
	this.point_two = point_two;
    }
    // Constructor Polymorphism
    public LineSegment(int x_one, int y_one, int x_two, int y_two){
	this(new Coordinates(x_one, y_one), new Coordinates(x_two, y_two));
    }
    public void translate(int dx, int dy){
	point_one.translate(dx, dy);
	point_two.translate(dx, dy);
    }
    public String toString(){
	// Concatenate several strings using + operator
	return "[" + point_one.toString() + " , " + point_two.toString() + "]";
    }
    public double length(){
	double dx = (double)point_two.getX() - (double)point_one.getX();
	double dy = (double)point_two.getY() - (double)point_one.getX();
	
	return Math.hypot( dx, dy);
    }
}
