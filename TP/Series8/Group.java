import java.util.ArrayList;
/*
 * 
 *  implements Cloneable in order to allow public clone of an object
 */
public class Group implements Cloneable{
    private ArrayList<Person> group = new ArrayList<Person>();

    public void add(Person p){
        group.add(p);
    }

    public Object clone(){
        Group myClone = null;
        try{
        myClone = (Group) super.clone(); // Call the method of Object : clone -> Shallow cloning
                                    // return an object and can throw an exception
        // 1st clone the array List
        myClone.group = (ArrayList) this.group.clone();
        // Clone pairwise all the person this arrayList into the clone
        // -> Deep Cloning
        for(int i = 0; i < group.size(); ++i)
            myClone.group.set(i, (Person )this.group.get(i).clone());
        }
        catch(CloneNotSupportedException e){
            throw new InternalError("Clone not supported");
        }
        return myClone;
    }
    public boolean equals(Object obj){
        if(!(obj instanceof Group))
            return false;
        
        Group g = (Group) obj;

        if(this.group.size() != g.group.size())
            return false;
        for(int i = 0; i < group.size(); ++i)
        // If two person in arrayList[i] of p and this are not equal 
        // -> return false;
            if(!(this.group.get(i).equals(g.group.get(i))))
                return false;

        return true;
    }
    // Return the sum of hashcode of every person in the ArrrayList
    public int hashCode(){
        int res =0;
        for(Person p : group)
            res += p.hashCode();
        return res;

    }
}
