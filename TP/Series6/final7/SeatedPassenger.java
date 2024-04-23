public class SeatedPassenger extends Passenger {
    public SeatedPassenger(String name){
        super(name);
    }
    // Override Passenger Method
    public void requestTransport(Transport t, int stops){
         super.requestTransport(t, true, stops);
    }
    public String toString(){
        return super.toString();
    }
}
