

public class Rectangle{
    // All the object variables are fixed after the instantiation.
    private final int xmin, xmax, ymin, ymax;
    private final MyColor color;
    // Constructor
    public Rectangle(int xmin, int ymax, int xmax, int ymin, MyColor color){
        // Check that the are of the Rectangle is positive
        if(!(xmin < xmax && ymin < ymax)){
            // See Later :  Exceptions
            throw new Error("Illegal Parameters of Rectangle");
        }
        this.xmin = xmin;
        this.xmax = xmax;
        this.ymin = ymin;
        this.ymax = ymax;
        this.color = color;
    }
    public int  getXmin(){
        return this.xmin;
    }
    public int getXmax(){
        return this.xmax;
    }
    public int getYmin(){
        return this.ymin;
    }
    public int getYmax(){
        return this.ymax;
    }
    public MyColor getColor(){
        return this.color;
    }
    private static boolean overlap(int int1min, int int1max, int int2min, int int2max){
        return (int1max > int2min || int2max > int1min);
    }
    public Rectangle rotate(int  cx, int cy){
        int x1 = ymax - cy;
        int x2 = ymin -  cy;
        int y1 = -(xmin - cx);
        int y2 = -(xmax - cx);
        x1 += cx;
        x2 += cx;
        y1 += cy;
        y2 += cy;
        return new Rectangle(Math.min(x1, x2), Math.max(y1,y2),  Math.max(x1, x2), Math.min(y1, y2) , color);
    }
    public boolean overlaps(Rectangle r){
        return overlap(this.xmin, this.xmax, r.xmin, r.xmax) &&
                overlap(this.ymin, this.ymax, r.ymin, r.ymax);
    }
}