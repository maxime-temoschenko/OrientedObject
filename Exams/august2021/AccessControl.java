public class AccessControl{
    private final int capacity;
    private int nbPeople;
    public AccessControl(int c){
        this.capacity = c;
        this.nbPeople = 0;
    }
    private boolean isFull(){
        return nbPeople>=capacity;
    }
    public synchronized void enter(){
        while(isFull()){
            try{wait();}
            catch(InterruptedException e) {}
        }
        ++nbPeople;
    }
    public synchronized void leave(){
        --nbPeople;
        notifyAll();
    }
}