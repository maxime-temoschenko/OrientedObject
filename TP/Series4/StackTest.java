
public class StackTest{

    public static void main(String[] args){
	Stack s = new Stack();
	System.out.println("Size : " + s.size());
	s.push(2);
	s.push(3);  
	System.out.println("Size : " + s.size());
	System.out.println("Get : " + s.extract());
	System.out.println("Size : " + s.size());
	s.extract();
	s.extract();
    }

}
