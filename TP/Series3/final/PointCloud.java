import java.util.Vector;

public class PointCloud{

    Vector<Coordinates> cloud = new Vector<Coordinates>();

    public  void addPoint(Coordinates coord){
	cloud.add(coord);
    }
    // Polymorphism of the methods (same name, but different args)
    public void addPoint(int x, int y){
	// Call previous method with a new instance of Coordinates as arguments
	this.addPoint(new Coordinates(x, y));
    }
    public void translate(int dx, int dy){
	for(Coordinates coord : cloud)
	    coord.translate(dx, dy);
    }
    public LineSegment[] generateLine(){
	LineSegment[] line = new LineSegment[cloud.size()-1];
	for(int i = 1; i < cloud.size(); ++i)
	    line[i-1] = new LineSegment(cloud.get(i-1), cloud.get(i));
	return line;
    }
}
