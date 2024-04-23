import java.util.Vector;

public class PointCloud{
    private Vector<Coordinates> cloud = new Vector<Coordinates>();

    public void addPoint(int x1, int y1){
        Coordinates coord = new Coordinates(x1, y1);
	cloud.add(coord);
    }
    public void translate(int dx, int dy){
	for(int i = 0; i < cloud.size(); ++i){
	    Coordinates point = cloud.get(i); // get ith Point of the cloud 
	    point.translate(dx, dy); // Translate it 
	   }
    }
    public LineSegment[] connectLines(){
	LineSegment[] lines = new LineSegment[cloud.size() -1];
	for(int i = 0; i < cloud.size() - 1; ++i){
	    int x1 = cloud.get(i).getX(), y1 = cloud.get(i).getY();
	    int x2 = cloud.get(i+1).getX(), y2 = cloud.get(i+1).getY();
	    lines[i] = new LineSegment(x1, y1, x2, y2);
	}
	return lines;
    }
}
