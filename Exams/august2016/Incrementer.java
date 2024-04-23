public class Incrementer implements Runnable {
    private static Counter counter;
    private static int cnt ;
    static{
        counter = new Counter();
        cnt = 0;
    }
    public Incrementer(){
        Thread m = new Thread(this, "Counter " + cnt++);
        m.start();
    }
    public void run(){
        for(int i= 0; i < 20 ; ++i){
            counter.increment();
            System.out.println(counter.getValue());
        }
    }
    public static void main(String[] agrs){
        Incrementer[] thread = new Incrementer[10];
        for(int i = 0; i < 10;++i){
            thread[i] = new Incrementer();
        }
   
    }
}
