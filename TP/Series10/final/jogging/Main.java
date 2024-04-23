public class Main {
    public static void main(String[] args){
        FinishLine fl = new FinishLine();
        Runner[] runners = new Runner[100];
        System.out.println("Create Runners");
        for(int i = 0;i < 100; ++i)
            runners[i] = new Runner("Person" + i, 2, 100, fl);
        new Monitor(runners, fl);
        System.out.println("Thread runners");
        for(int i = 0; i < 100; ++i)
            runners[i].start();
        System.out.println("Joining runners");
        for(int i = 0; i < 100; ++i)
        {
            try{ runners[i].join(); }
            catch(InterruptedException e) {}
        }
               
    }
}
