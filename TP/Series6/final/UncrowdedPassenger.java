public class UncrowdedPassenger extends Passenger{
    public UncrowdedPassenger(String name){
        super(name);
    }
    public void requestTransport(Transport t, int stops) throws TransportAccessException{
        if(t.getRemainingStanding() > 10){
            super.requestTransport(t, false, stops);
            return;
        }

        throw new TransportAccessException(super.toString() + " was not accepted because there are less than 10 remaining standing places ");
    }
}
