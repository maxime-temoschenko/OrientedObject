import java.util.LinkedList;

public class Lexicon<T>{
    private LinkedList<String> labels;
    private LinkedList<T> objects ;

    public Lexicon(){
	labels = new LinkedList<String>();
	objects = new LinkedList<T>();
    }
    public void add(String label, T obj){
	int i;
	for(i = 0; i < labels.size(); ++i)
	    if(labels.get(i).compareTo(label) >= 0)
		break;
	labels.add(i, label);
	objects.add(i, obj);
    }
    public String toString(){
	String str = new String();
	str += "[\n";
	for(int i = 0; i < labels.size(); ++i)
	    str+= "( Label : " + labels.get(i) + " , Value : " +
		objects.get(i) + " ) \n";
	str += "]\n";
	return str;
    }
    public static void main(String[] args)
    {
        Lexicon<Integer> lex = new Lexicon<Integer>();
        lex.add("first string", Integer.valueOf(1));
        lex.add("second string", Integer.valueOf(2));
        lex.add("a", Integer.valueOf(10));
        lex.add("zzzz", Integer.valueOf(3));
        lex.add("aaaa", Integer.valueOf(1));
        System.out.println(lex.toString());
    }
    
}
