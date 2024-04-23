import java.io.*;
public class QueueTest
{
    public static void main(String[] args)
    {
	Queue q = new Queue();
	System.out.println("Size : " + q.size());
	q.put(45);
	System.out.println("Size : " + q.size());
	System.out.println("Front : " + (int)q.first());
	q.put(46);
	q.put(47);
	System.out.println("Size : " + q.size());
	System.out.println("Get : " + (int)q.get());
	System.out.println("1");
	System.out.println("Front : " +(int)q.first());
	System.out.println("2");
	System.out.println("Size : " + q.size());
	q.get();
	System.out.println("Size : " + q.size());	
	System.out.println("Front : " + (int)q.first());
	q.get();
	System.out.println("Size : " + q.size());
	q.put(1);
	System.out.println("Front : " + (int)q.first());
    }
}

