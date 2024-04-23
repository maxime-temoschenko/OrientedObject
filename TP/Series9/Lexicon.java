import java.util.LinkedList;
public class Lexicon<T> {
    // I need 2 datastructures to store labels and Objects
    private LinkedList<T> objects = new LinkedList<T>();
    private LinkedList<String> labels = new LinkedList<String>();

    public void add(String label, T element){
        int i  = 0;
        for(i = 0; i < labels.size(); ++i)
        // Find the position of the first label after which label is greater in lexicographical order 
            if(label.compareTo(labels.get(i)) <= 0)
                break;
        // Add the corresponding Object and Label to the given position
        objects.add(i, element);
        labels.add(i, label);
    }
    public String toString(){
        String str = "[\n";
        for(int i = 0; i < labels.size(); ++i)
            str += "(Label : " + labels.get(i) + " , Object : " + objects.get(i) + ")\n";
        str += "]\n";
        return str;
    }
    // Main method to test our code
    public static void main(String args[]){
        // Lexicon of Strings
        Lexicon<String> lexicon  = new Lexicon<String>();
        lexicon.add("a", "premiere lettre de l'alphabet");
        lexicon.add("oop", "class");
        lexicon.add("bottle", "can contain water");
        // Print the result
        System.out.println(lexicon.toString());
    }
}
