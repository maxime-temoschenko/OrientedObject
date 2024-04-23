import java.io.Serializable;

public class RoomAssignments implements Cloneable, Serializable{
    private static long serialVersionUID = 123456;
    protected Course[] courses;
    public RoomAssignments(){
        courses = new Course[10];
    }
    private void checkDay(int day) throws RoomAssignmentsException{
        if(day < 1 || day > 5)
            throw new RoomAssignmentsException("Unvalid day : must be in range [1;5] !");
    }
    private int decoder(int day, boolean half) throws RoomAssignmentsException{
        checkDay(day);
        return day-1 + (half ? 1 : 0);
    }
    private Pair<Integer, Boolean> encoder(int i){
        if(i%2 == 0)
            return new Pair<Integer,Boolean>(i/2 + 1, false);
        else
            return new Pair<Integer,Boolean>(i/2 + 1, true);
    }
    public synchronized boolean isFree(int day, boolean half) throws RoomAssignmentsException{
        return courses[decoder(day,half)] != null;
    }
    public void setHalfDay(Course c, int day, boolean half) throws RoomAssignmentsException{
        courses[decoder(day,half)] = c;
    }
    @Override public boolean equals(Object obj){
        if(!(obj instanceof RoomAssignments))
            return false;
        RoomAssignments other = (RoomAssignments) obj;
        for(int i = 0; i < courses.length; ++i)
            if(!(this.courses[i].equals(other.courses[i])))
                return false;
        return true;
    }
    public synchronized Object clone() throws CloneNotSupportedException{
        RoomAssignments other = (RoomAssignments) super.clone();
        other.courses = this.courses.clone(); // Deep copy the array 
        for(int i = 0; i < other.courses.length; ++i){
            other.courses[i] = (Course) this.courses[i].clone();
        }
        return other;
    }
    public Pair<Integer, Boolean> firstHalf() throws RoomAssignmentsException{
        Pair<Integer,Boolean> pair;
        for(int i  = 0; i < courses.length; ++i){
            pair = encoder(i);
            if(isFree(pair.getFirst(), pair.getSecond())){
                return pair;
            }
        }
        throw new RoomAssignmentsException("No more free half-days !");
    }
}
