import java.util.ArrayList;

public class Group implements Cloneable{   
    private ArrayList<Person> group;

    public Group(){
        this.group = new ArrayList<Person>();
    }
    public int getGroupSize(){
        return group.size();
    }
    public void addPerson(Person p){
        group.add(p);
    }
    public Person getPerson(int index){
        if(index <= 0 || index > group.size())
            return null;
        return group.get(index - 1);
    }
    public Person removePerson(int index){
        if(index <= 0 || index > group.size())
            return null;
        return group.remove(index - 1);
    }
    public String toString(){
        String res = "";
        for(Person p : group){
            if(res.length() > 0)
                res += "\n";
            res += p.toString();
        }
        return res;
    }
    public int hashCode(){
        int res = 0;
        for(Person p  : group) 
            res += p.hashCode();
        return res;
    }
    public Object clone(){
        Group myClone = null;
        try{
            myClone = (Group) super.clone();

            myClone.group = (ArrayList) this.group.clone();
            for(int i = 0; i < group.size(); ++i)
                myClone.group.set(i, (Person) group.get(i).clone());
        }
        catch(CloneNotSupportedException e){
            throw new InternalError("Unable to Clone Group");
        }
        return myClone;
    }
    // Override equals method of Object Class 
    public boolean equals(Object obj){
        // 1) check if obj is of dynamic type cast : Group
        if(!(obj instanceof Group))
            return false;
        
        Group other = (Group) obj; // Static Cast obj into Group
        if(this.group.size() != other.group.size())
            return false; // Array List are not the same length

        // Check pairwise if element on both Array list are the same
        for(int i = 0; i < group.size(); ++i)
        // If not equal ..
            if(!(this.group.get(i).equals(other.group.get(i))))
                return false;


        return true;
    }
}