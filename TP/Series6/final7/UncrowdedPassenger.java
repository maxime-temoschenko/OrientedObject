public class UncrowdedPassenger extends Passenger {
    UncrowdedPassenger(String name){
        super(name);
    }
    public void requestTransport(Transport t, int stops) throws TransportAccessException{
        if(!(t.getRemainingStanding() > 10))
            throw new TransportAccessException("Passenger : " + this.toString() + " didn't enter because there were not enough places");
        super.requestTransport(t, false, stops);
    }
    public String toString(){
        return super.toString();
    }
}
