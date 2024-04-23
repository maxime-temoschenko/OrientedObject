
public class Node{
    private Node next;
    private Object value;

    public Node(Object value){
	this.value = value;
    }
    public Node(Node next, Object value){
	this.next = next;
	this.value = value;
    }
    public Object getValue(){
	return this.value;
    }
    public void setValue(Object value){
	this.value = value;
    }
    public Node getNext(){
	return this.next;
    }
    public void setNext(Node next){
	this.next = next;
    }
    
}
