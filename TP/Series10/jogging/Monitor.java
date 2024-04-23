public class Monitor implements Runnable{
    private Runner[] runners;
    private FinishLine fl;

    public Monitor(Runner[] runners, FinishLine fl){
        this.runners = runners;
        this.fl = fl;
    }
    public void run(){
        // Print the result for each Runner
        for(Runner runner : runners)
            System.out.println(fl.getResult());
    }
}
