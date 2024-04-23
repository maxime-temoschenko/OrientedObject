

public class GroupTest {
    public static void main(String args[]){
        Person p1 = new Person("Florent", "Boxus", "je m'appelle Florent ");
        Person p2 = new Person("Arthur", "dupont");
        Person p3 = new Person("Max", "T", "bio");

        Group g = new Group();
        g.add(p1);
        g.add(p2);

        Group g2 = (Group) g.clone();

        if(g.equals(g2))
            System.out.println("Equals !");
        else 
            System.out.println("Not Equal");

        g2.add(p3);

        if(g.equals(g2))
            System.out.println("Equals !");
        else 
            System.out.println("Not Equal");
    }
}
