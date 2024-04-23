import org.acme.geometry.Translatable2D;

public class  Point2D implements Translatable2D, Cloneable {
    private int x, y;
    public Point2D(int x, int y) throws GeometricException{
        checkDomain(x,y);
        this.x = x;
        this.y = y;
    }
    public void setX(int x) throws GeometricException{
        checkDomain(x, this.y);
        this.x = x;
    }
    public void setY(int y) throws GeometricException{
        checkDomain(x, y);
        this.y = y;
    }
    public void setCoordinates(int x, int y) throws GeometricException{
        setX(x);
        setY(y);
    }
    private void checkDomain(int x, int y) throws GeometricException{
        if( x < 0 || y < 0)
            throw new GeometricException("Unvalid operation : the valid domain is non-negative 2d plane ! ");
    }
    public void translate(int trX, int trY) {
        try{
        checkDomain(x+trX, y+trY);}
        catch(GeometricException e) {throw new InternalError("Unvalid operation : domain is no valid");}
        this.x += trX;
        this.y += trY;
    }
    @Override public int hashCode(){
        return 31*x + y;
    }
    @Override public boolean equals(Object obj){
        if(!(obj instanceof Point2D))
            return false;
        Point2D other = (Point2D) obj;
        return this.x==other.x && this.y==other.y;
    }
    @Override public Object clone(){
        Point2D point;
        try{
            point = (Point2D) super.clone();
        }
        catch(CloneNotSupportedException e) { throw new InternalError("Unsupported Cloning ! ");}
        return point;
    }

}
