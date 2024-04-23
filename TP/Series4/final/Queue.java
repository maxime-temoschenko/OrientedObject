public class Queue{
    private Node head, tail;
    private int size;

    public void put(Object v){
	Node n  = new Node(v);
	if(size == 0){
	    head = tail = n;
	    ++size;
	    return;
	}
	else{
	this.tail.setNext(n);
	this.tail = n;
	++size;
	}
    }
    public Object get(){
	if(size == 0)
	    return null;
	--this.size;
	Object val = this.head.getValue();
	this.head = this.head.getNext();
	if(this.head == null)
	    this.tail = null;
	return val;
    }
    public Object first(){
	if(size == 0)
	    return null;
	return head.getValue();
    }
    public int size(){
	return size;
    }
    
}
