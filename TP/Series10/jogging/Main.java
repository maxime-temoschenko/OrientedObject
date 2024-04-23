public class Main {
    public static void main(String args[]){
        Runner[] runners = new Runner[100];
        FinishLine fl = new FinishLine();
        // Launch Thread monitor
        Monitor monitor = new Monitor(runners, fl);
        new Thread(monitor, "monitor").start();
        // Launch each runner on its own thread
        for(int i = 0; i < 100; ++i){
            runners[i] = new Runner("Runner" + i, 2, 1, fl);
            new Thread(runners[i], runners[i].getName()).start();
        }
    }
}
