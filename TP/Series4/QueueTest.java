
public class QueueTest{

    public static void main(String[] args){
	Queue q = new Queue();
	System.out.println("Size : " + q.size());
	q.put(2);
	q.put(3);
	System.out.println("First : " + q.first());
	System.out.println("Size : " + q.size());
        System.out.println("Get : " + q.get());
    }
}
