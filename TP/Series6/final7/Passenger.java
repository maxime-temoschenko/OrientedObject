

/* Abstract class Passenger
 *  -> can't be instantiated
 * 
 * 
 */

public abstract class Passenger {
    // Variables
    private boolean seated;
    private Transport transport; // = null means, no transport
    private int stops;
    private final String name;
   
    public Passenger(String name){
        this.name = name;
    }
    // Methods
    // Decrement stops and if it equal to 0, we leave
    public void notifyNextStop(){
        --this.stops;
        if(this.stops == 0)
            leave();

    }
    public boolean getPosition(){
        return this.seated;
    }
    protected void leave(){
        if(transport.leave(this)){
        this.transport = null;
        }
        else
            System.out.println("Passenger was not in Transport");
    }
    /* RequestTransport 
     *  -> Share common piece of method between subclasses
     *  -> This method is going to be overridden in subclasses
     * 
     */
    protected void requestTransport(Transport t, boolean seated, int stops){
        try{
            t.pickPassenger(this, seated);
            this.transport = t;
            this.stops = stops;
            this.seated = seated;
        }
        catch(TransportAccessException e){
            System.out.println(e.getMessage());
        }
    }
    public String toString(){
            return "Passenger : " + this.name + " Remaining Stops :" + this.stops;
    }
}
