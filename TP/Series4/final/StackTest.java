
public class StackTest{
    public static void main(String[] args){
	Stack s = new Stack();
	System.out.println("Size : " + s.size());
	s.push(1);
	s.push(2);
	System.out.println("Size : " + s.size());
	System.out.println("First : " + s.first());
	System.out.println("POP : " + s.pop());
	System.out.println("POP : " + s.pop());
	System.out.println("POP : " + s.pop());	
	System.out.println("POP : " + s.pop());		
    }
}
