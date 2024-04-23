/*
 *  Custom Exception
 *  -> Subclass of Exception
 *  -> Need to implement 2 constructors
 */

public class TransportAccessException extends Exception{
    /*
     * Define and call super class constructor
     *  -> Specific to java
     */
    public TransportAccessException(){
        super();
    }
    public TransportAccessException(String m){
        super(m);
    }
}
