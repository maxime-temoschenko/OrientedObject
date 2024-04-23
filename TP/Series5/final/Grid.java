import java.util.Vector;

public class Grid{
    private Vector<Rectangle> rectangles = new Vector<Rectangle>();


    public void addRectangle(int xmin, int ymax, int xmax, int ymin, MyColor color){
	rectangles.add(new Rectangle(xmin, ymax, xmax, ymin, color));
    }
	public Rectangle[] getRectangles(){
		Rectangle[] rect = new Rectangle[rectangles.size()];
		for(int i = 0; i < rectangles.size(); ++i)
			rect[i] = rectangles.get(i);
		return rect;
	}

    public void rotate(int cx, int cy ,MyColor c){
	for(int i = 0; i < rectangles.size(); ++i)
	    if(rectangles.get(i).getColor() == c)
			rectangles.set(i, rectangles.get(i).rotate(cx, cy)) ;

    }
    public void rotate(MyColor c){
	rotate(0,0, c);
    }
    public boolean overlaps(){
	for(int i = 1; i < rectangles.size(); ++i)
	    for(int j = 0; j < i; ++j)
		if(rectangles.get(i).overlaps(rectangles.get(j)))
		    return true;
	return false;
    }
    
}
