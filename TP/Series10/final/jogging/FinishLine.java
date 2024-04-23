public class FinishLine implements TimeReporting {
    private boolean news = false;
    private String s = new String();
    public synchronized void report(String res){
        while(news){ // Already news, can't add i wait !
            try{
                wait();
            }
            catch(InterruptedException e ) {}
        }
        this.s = res;
        this.news = true;
        notifyAll();
    }
    public synchronized String getResult(){
        while(!news){ // No news i wait !
            try{wait();}
            catch(InterruptedException e){}
        }
        news = false;
        notify();
        return this.s;
    }
}
