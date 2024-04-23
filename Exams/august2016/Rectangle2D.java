import org.acme.geometry.Translatable2D;
public class Rectangle2D implements Translatable2D, Cloneable{
    Point2D bottomLeft, bottomRight, upLeft, upRight;
    public Rectangle2D(Point2D bottomLeft, Point2D bottomRight, Point2D upLeft, Point2D upRight) {
        this.bottomLeft = bottomLeft;
        this.bottomRight = bottomRight;
        this.upLeft = upLeft;
        this.upRight = upRight;
    }
    public void setBottomLeft(int x, int y) throws GeometricException{
        bottomLeft.setCoordinates(x, y);
    }
    public void setBottomRight(int x, int y) throws GeometricException{
        bottomRight.setCoordinates(x,y);
    }
    public void setUpLeft(int x, int y) throws GeometricException{
        upLeft.setCoordinates(x, y);    
    }
    public void setUpRight(int x, int y) throws GeometricException{
        upRight.setCoordinates(x, y);
    }
    @Override public void translate(int trX, int trY){
        bottomLeft.translate(trX, trY);
        bottomRight.translate(trX, trY);
        upLeft.translate(trX, trY);
        upRight.translate(trX, trY);
    }
    @Override public int hashCode(){
        return bottomLeft.hashCode() + 11*bottomRight.hashCode() + 31*upLeft.hashCode() + 17*upRight.hashCode();
    }
    @Override public boolean equals(Object obj){
        if(!(obj instanceof Rectangle2D))
            return false;
        Rectangle2D other = (Rectangle2D) obj;
        return 
        other.bottomLeft == this.bottomLeft && 
        other.bottomRight == this.bottomRight && 
        other.upLeft == this.upLeft && 
        other.upRight == this.upRight;
    }
    @Override public Object clone(){
        Rectangle2D other;
        try{
            other = (Rectangle2D) super.clone();
            other.bottomLeft = (Point2D) bottomLeft.clone();
            other.bottomRight = (Point2D) bottomRight.clone();
            other.upLeft = (Point2D) upLeft.clone();
            other.upRight = (Point2D) upRight.clone();
        }
        catch(CloneNotSupportedException e) {throw new InternalError("Unable to clone !");}
        return other;
    }
}
