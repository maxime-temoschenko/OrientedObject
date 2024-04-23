
public class Queue{
    private Node head = null, tail = null;
    private int size = 0;

    // No constructor : By default, size =0 , head= tail = null
    public void put(Object v){
	if(this.size == 0){
	    this.head = this.tail = new Node(v);
	}
	else{
	    Node n = new Node(v);
	    this.tail.setNext(n);
	    this.tail = n;
	}
	++this.size;
    }
    public Object get(){
	if(this.size == 0)
	    return null;
	--this.size;
	Object val = this.head.getValue();
	this.head = this.head.getNext();
	// Size of Queue = 1 -> Size = 0, Set Tail = null
	if(this.head == null) // Size of the queue = 0
	    this.tail = null;
	return val;
    }
    public Object first(){
	if(this.size == 0)
	    return null;
	return this.head.getValue();
    }
    public int size(){
	return this.size;
    }
}
