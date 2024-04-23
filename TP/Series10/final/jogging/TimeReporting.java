/*
 * INFO0062 - Object-Oriented Programming
 * Exercise series 11
 *
 * Exercise 3: simulation of the monitoring of a jogging.
 * 
 * Comments:
 * -This exercise involves several threads: one thread models the monitor displaying the time 
 *  taken by each runner to finish the race while all other threads will model the runners. This 
 *  situation is a practical case to see the wait() and notify() / notifyAll() methods in action.
 * -The TimeReporting interface should be implemented by the class which will deal with the 
 *  results of the jogging.
 *
 * @author: J.-F. Grailet
 */

public interface TimeReporting
{
    /*
     * getResult() should wait for a result and return it as a String object.
     */
    
    String getResult();
    
    /*
     * report() should receive a result and notify the object so the getResult() method can 
     * proceed and return said result.
     */
    
    void report(String res);
}
