public class PointCloudTest{

    public static void main(String[] args){
	PointCloud cloud = new PointCloud();
	cloud.addPoint(0,0);
	cloud.addPoint(1,1);
	cloud.addPoint(-1,-2);
	cloud.translate(2,2);

	LineSegment[] segments = cloud.generateLine();

	for(LineSegment l : segments)
	    System.out.println(l.toString());
    }

}
