public class FinishLine implements TimeReporting {
    // Flag to say whether there is a new report
    private boolean news = false;
    private String res = new String();
    public  synchronized String getResult(){
        // There are no news -> Thread is going to wait for news
        while(!news){
            try{ wait();}
            catch(InterruptedException e){}
        }
        // There are news -> return the result 
        news = false; // I return the result, no news anymore
        notifyAll();
        return this.res;
    }
    public synchronized void report(String res){
        // There are already news, can't report result now -> Thread is going to sleep
        while(news){
            try{ wait();}
            catch(InterruptedException e) {}
        }
        // Otherwise, no new report, let's report this result
        news = true; // Now i have a new report
        this.res =  res;
        // Wake up every other threads waiting -> some are going to get the Result
        notifyAll();
    }
}
