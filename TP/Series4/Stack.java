
public class Stack{
    
    private Node head;
    private int size;
    
    public Object first(){
	if(size == 0)
	    return null;
	return this.head.getValue();
    }
    public Object extract(){
	if(size ==0)
	    return null;
	Object val = this.head.getValue();
	this.head = this.head.getNext();
	--this.size;
	return val;
    }
    public void push(Object v){
	Node n = new Node(v);
	n.setNext(this.head);
	this.head = n;
	++this.size;
    }
    public int size(){
	return this.size;
    }
}
