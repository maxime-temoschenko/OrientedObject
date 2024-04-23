

public class Rectangle{
    private final int  xmin, ymin, xmax, ymax;
    private final MyColor color;

    // Returns 1 if positive area, 0 otherwise
    // Check correct format of the rectangle
    private static boolean checkRectangle(int xmin,int  ymax,int  xmax,int ymin ){
	return ((xmin < xmax) && (ymin<ymax));
    }
	private static boolean checkIntersection(int int1min, int int1max, int int2min, int int2max){
		return ((int1max  > int2min)  || (int2max > int1min));
				
	}
    public Rectangle(int xmin, int ymax, int xmax, int ymin, MyColor color){
	if(!checkRectangle(xmin, ymax, xmax, ymin))
	    throw new Error("Area of the rectangle must be strictly positive");  // Do the exception !
	
	this.xmin = xmin;
	this.xmax = xmax;
	this.ymin = ymin;
	this.ymax = ymax;

	this.color = color;
    }
  
    public MyColor getColor(){
	return color;
    }
	public int getXmin(){
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
    public boolean overlaps(Rectangle r){
		return checkIntersection(this.xmin, this.xmax, r.xmin, r.xmax) &&
				checkIntersection(this.ymin, this.ymax, r.ymin, r.ymax);
    }

    public Rectangle rotate(int cx, int cy){
		// Translation of coordinates
		int xmint = this.xmin - cx, ymaxt = this.ymax - cy, xmaxt = this.xmax - cx, ymint = this.ymin - cy ;
		// Rotation of 90 Degress clockwise (Xa, Ya) -> (Ya, -Xa) then apply rotation to original Coordinates
		int x1 = ymaxt + cx, y1 = -xmint + cy, x2 = ymint + cx, y2 = -xmaxt + cy;
		// Get Correct Edges
		int xmintt = Math.min(x1,x2);
		int xmaxtt = Math.max(x1,x2);
		int ymintt = Math.min(y1,y2);
		int ymaxtt = Math.max(y1,y2);

	return new Rectangle(xmintt, ymaxtt, xmaxtt, ymintt, this.color);
    }

    
    

}
