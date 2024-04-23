import java.io.Serializable;

import javax.swing.plaf.basic.BasicInternalFrameTitlePane.CloseAction;

import java.math.*;
public class Point implements Cloneable, Serializable{
    private int x,y,z;
    public Point(int x, int y, int z){
        this.x = x;
        this.y = y;
        this.z = z;
    }
    public synchronized void translate(int dx, int dy, int dz){ // Only critical section for threads
        this.x += dx;
        this.y += dy;
        this.z += dz;
    }
    @Override public Object clone(){
        Point p;
        try { p = (Point) super.clone();}
        catch(CloneNotSupportedException e) {}
        return p;
    }   
    @Override public int hashCode(){
        return 37*x+11*y+z;
    }
    @Override public boolean equals(Object obj){
        if(!(obj instanceof Point))
            return false;
        Point myPoint = (Point) obj;
        return myPoint.x==this.x && myPoint.y==this.y && myPoint.z==this.z;
    }
    public double distance(Point p){
        return Math.sqrt(Math.pow((p.x - x),2) + Math.pow((p.y - y),2) + Math.pow((p.z-z),2));
    }
    public int getX() {return x;}
    public int getY() {return y;}
    public int getZ() {return z;}
}
