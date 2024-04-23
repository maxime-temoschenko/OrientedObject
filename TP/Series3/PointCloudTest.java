

public class PointCloudTest{

    public static void main(String[] args){
	PointCloud cloud = new PointCloud();
	cloud.addPoint(0,0);
	cloud.addPoint(1,1);
	cloud.addPoint(2,-1);
	cloud.addPoint(3, -4);

	LineSegment[] segments = cloud.connectLines();

	for(int i = 0; i < segments.length; ++i){
	    System.out.println(segments[i].toString());
	    System.out.println("Length : " +  segments[i].length());
	}
    }
}
