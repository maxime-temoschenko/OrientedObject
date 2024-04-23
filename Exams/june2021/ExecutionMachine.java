public class ExecutionMachine implements Runnable {
    static private int counter = 0;
    private Action a;
    private int n;
    public ExecutionMachine(Action a, int n){
        this.a = a;
        this.n = n;
        if(n> 0)
            new Thread(this, "Thread " + ++counter).start();
    }
    static void execute(Action a, int n){
        synchronized(a){
            new ExecutionMachine(a, n);
        }
    }
    public void run(){
        for(int i = 0; i < n; ++i)
            a.operation();
    }
}
