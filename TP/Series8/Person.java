

public class Person implements Cloneable{
    private  final String lastName, firstName;
    private String bio = "";

    public Person(String firstName, String lastName){
        this.firstName = firstName;
        this.lastName = lastName;
    }
    public Person(String firstName, String lastName, String bio){
        this(firstName, lastName);
        this.bio = bio;
    }
    public String getBio(){
        return this.bio;
    }
    public void setBio(String bio){
        this.bio = bio;
    }
    public Object clone(){
        Person myClone = null;
        try{
            // Shallow cloning is sufficient because only Strings
            // and strings are immutable (see Book class)
            myClone = (Person) super.clone(); // return an Object so cast it
        }   
        catch(CloneNotSupportedException e){
            throw new InternalError("Unable to clone Person");
        }
        return myClone;
    }
    /*
     * Override equals method defined in Object class
     *  boolean equals(Object )
     * 
     */
    public boolean equals(Object obj){
        // 1st :  check if obj is an instance of Person
        if(!(obj instanceof Person))
            return false;
        // Then : cast obj into a Person
        Person p = (Person) obj;
       
        return this.bio.equals(p.bio) && this.firstName.equals(p.firstName)
                                    && this.lastName.equals(p.lastName);
    }
    /*
     * Override hashCode method since we've overid equals method
     *  -> If two object are equals -> must return the same hashCode
     */
    public int hashCode(){
        return this.firstName.hashCode() + this.lastName.hashCode() + this.bio.hashCode();
    }
}
