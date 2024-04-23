public class Person implements Cloneable{
    private final String firstName, lastName;
    private String bio;
    
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
    public int hashCode(){
        return firstName.hashCode() +  lastName.hashCode() + bio.hashCode();
    }

    public boolean equals(Object obj){
        // Check if obj is of dynamic type Person
        if(!(obj instanceof Person))
            return false;
        
        Person p = (Person) obj;
        return p.firstName.equals(this.firstName) &&
                p.lastName.equals(this.lastName) &&
                p.bio.equals(this.bio);
    }
    public String toString(){
        return this.firstName + " " + this.lastName + " : " + this.bio;
    }
    // Need to implement Cloneable
    public Object clone(){
        Person myClone = null;
        try{
            myClone = (Person) super.clone();
        }
        catch(CloneNotSupportedException e){
            throw new InternalError("Unable to clone a person");
        }
        return myClone;
    }
}
