/*  Bus class is a subclass of Transport and can be instantiated.
 * 
 * 
 * 
 */

public class Bus extends Transport {
    // All the variables and methods of Transport are inherited
    // Bus has also the interface elements with the visibility public and protected of Transport
    private int travelledPassengers;

    public Bus(int totalSeatingPlaces, int totalStandingPlaces){
        // Chain Constructor Mechanism
        // Call super class Constructor : First Line

        // Initialize all the private variables inherited from Transport 
        // but those are not accessible since there are declared private (but still in memory of Bus)
        super(totalSeatingPlaces, totalStandingPlaces);

        this.travelledPassengers = 0;
    }
    /*
     * !!! Override pickPassenger method of super class
     * 
     * Propagation of the TransprtAccessException
     *  -> We don't handle it in this method
    */
    public void pickPassenger(Passenger p , boolean seated) throws TransportAccessException{
        // call pickPassenger of superclass (pickPassenger of Bus)
        super.pickPassenger(p, seated);
        ++this.travelledPassengers;
    }
    public void resetCounter(){
        System.out.println("Total Passengers that have travelled : " + travelledPassengers);
        this.travelledPassengers = 0;
    }
}
