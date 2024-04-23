import java.util.Vector;

public abstract class Transport{
    // Fixed Capacity of Transport
    private final int totalStandingPlaces, totalSeatingPlaces;
    private int occupiedStanding, occupiedSeating;
    // Datastructure of all the references of passengers inside Transport
    private Vector<Passenger> passengers;
    // Constructor
    public Transport(int totalSeatingPlaces, int totalStandingPlaces){
        this.totalSeatingPlaces = totalSeatingPlaces;
        this.totalStandingPlaces = totalStandingPlaces;
        this.passengers = new Vector<Passenger>();
        this.occupiedSeating = this.occupiedStanding = 0;
    }
    public int getRemainingStanding(){
        return totalStandingPlaces - occupiedStanding;
    }
    public int getRemainingSeating(){
        return totalSeatingPlaces - occupiedSeating;
    }   
    /* PickPassenger : Pick Passenger p in seated position
     *  returns true if passenger was picked, false otherwise
     * 
     * pickPassenger can throw a custom Exception : TransportAccessException
     * 
     * -> The method calling pickPassenger MUST either catch the exception or throw it
     * 
     */
    public void pickPassenger(Passenger p , boolean seated) throws TransportAccessException{
        // Seating Place
        if(seated){
            // Enough Seating place ?
            if(getRemainingSeating() == 0)
                throw new TransportAccessException("[DENIED ACCESS] : No remaining Seating places");
            ++this.occupiedSeating;
        }
        // Standing place
        else{
            if(getRemainingStanding() == 0) // No more standing places
                throw new TransportAccessException("[DENIED ACCESS] : No remaining Standing places");
            ++this.occupiedStanding;
        }
        // The passenger can be added 
        passengers.add(p);
    }
    // Notify all the passengers that we've reached next stop.
    public void nextStop(String s){
        System.out.println("------------");
        for(int i = 0; i < passengers.size(); ++i){
            passengers.get(i).notifyNextStop();
        }
        System.out.println("[TRANSPORT] : Next Stop : " + s);
    }
    /* Remove passenger p from Transport
     * 
     * returns true if removed, false if p is not in Transport
     * 
     */
    public boolean leave(Passenger p){
        if(!passengers.remove(p)) // Try to remove p from passengers
            return false; // p was not in passengers

        // p is removed, readjust occupied numbers
        if(p.getPosition())
            --this.occupiedSeating;
        else 
            --this.occupiedStanding;

        return true;

    }
}