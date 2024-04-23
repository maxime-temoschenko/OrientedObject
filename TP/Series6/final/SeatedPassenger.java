/*
 * 
 * SeatedPassenger is a subclass of Passenger
 * 
 */
public class SeatedPassenger extends Passenger{

    public SeatedPassenger(String name){
        // Constructor Chaining 
        // First, we have to call superclass constructor
        super(name);
    }
    // Call super method requestTransport
    public void requestTransport(Transport t, int stops) throws TransportAccessException{
         super.requestTransport(t, true, stops);
    }
}
