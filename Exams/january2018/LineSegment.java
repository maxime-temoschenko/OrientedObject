public class LineSegment {
    Point p1, p2;
    public LineSegment(Point p1, Point p2) throws LineSegmentException{
        if(p1.equals(p2))
            throw new LineSegmentException("p1 and p2 must be different !");
    }
    public LineSegment(int x1, int y1, int z1, int x2, int y2, int z2) throws LineSegmentException{
        this(new Point(x1,y1, z1), new Point(x2,y2, z2));
    }
    private double distance(){
        return p1.distance(p2);
    }
    public synchronized void translate(int dx, int dy, int dz){
        p1.translate(dx, dy, dz);
        p2.translate(dx, dy, dz);
    }
    public synchronized LineSegment[] split() throws LineSegmentException{
        int x = (p1.getX()+p2.getX())/2, y = (p1.getY()+p2.getY())/2, z = (p1.getZ()+p2.getZ());
        Point middle = new Point(x,y,z);
        if(middle.equals(p1) || middle.equals(p2))
            throw new LineSegmentException("Unvalid Operation");
        LineSegment[] lsArray = new LineSegment[2];
        lsArray[0] = new LineSegment(p1, middle);
        lsArray[1] = new LineSegment(middle, p2);
        return lsArray;
    }
    @Override public Object clone(){
        LineSegment mySegment;
        try{
         mySegment = (LineSegment) super.clone();}
        catch(CloneNotSupportedException e) {}
        mySegment.p1 = (Point) p1.clone();
        mySegment.p2 = (Point) p2.clone();
        return mySegment;
    }
    @Override public int hashCode(){
        return p1.hashCode() + p2.hashCode();
    }
    @Override public boolean equals(Object obj){
        if(!(obj instanceof LineSegment))
            return false;
        LineSegment mySegment = (LineSegment) obj;
        return mySegment.p1.equals(this.p1) && mySegment.p2.equals(this.p2);  
    }
}
