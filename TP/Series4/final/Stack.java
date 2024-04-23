
public class Stack{
    private Node top;
    private int size;

    public Object first(){
	if(size == 0)
	    return null;
	return this.top.getValue();
    }
    public void push(Object v){
	Node n = new Node(v);
	if(size != 0)
	    n.setNext(top);
	this.top = n;
	++this.size;
    }
    public Object pop(){
	if(size == 0)
	    return null;
	--this.size;
	Object val = this.top.getValue();
	this.top = this.top.getNext();
	return val;
    }
    public int size(){
	return this.size;
    }
}
