public class Monitor implements Runnable{
    private Thread[] runners;
    private FinishLine fl;
    public Monitor(Thread[] runners, FinishLine fl){
        this.runners=runners;
        this.fl = fl;
        new Thread(this, "monitor").start();
    }
    public void run(){
        for(int i = 0; i < runners.length; ++i){
            System.out.println(fl.getResult());
        }
    }
}