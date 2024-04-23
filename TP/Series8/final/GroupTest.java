public class GroupTest {
    public static void main(String args[]){
        Person p1 = new Person("Arthur", "Dupont", "je suis Arthur");
        Person p2 = new Person("Maxime", "Tm","je suis en ingé");
        Person p3 = new Person("Manon", "Franki", "je suis à Hec");
        Person p4 = new Person("Florent", "Boxus", "Je suis Autiste");

        Group grp1 = new Group();

        grp1.addPerson(p1);
        grp1.addPerson(p2);
        grp1.addPerson(p3);
        grp1.addPerson(p4);

        Group grp2 = (Group) grp1.clone();

        if(grp1.equals(grp2))
            System.out.println("The group are the same");
        else
            System.out.println("The group are different");
        
        grp1.removePerson(1);
        grp2.addPerson(p4);


        System.out.println("---- Group 1 -----");
        System.out.println(grp1.toString());
        System.out.println("---- Group 2 ------");
        System.out.println(grp2.toString());

        if(grp1.equals(grp2))
            System.out.println("The group are the same");
        else
            System.out.println("The group are different");
    
    }
}
