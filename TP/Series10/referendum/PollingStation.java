/*
 * INFO0062 - Object-Oriented Programming
 * Exercise series 11
 *
 * Exercise 1: analyzing a concurrent program.
 * 
 * Comments:
 * -This program simulates a (simplified) referendum where voters (each being modelled by a 
 *  thread) wants to access polling stations concurrently in order to vote.
 * -PollingStation models an office where people come to give their vote. The results can be 
 *  obtained in the form of a String object (see the toString() method) or as raw amount of votes 
 *  (via getNbLeave() and getNbRemain()).
 *
 * @author: J.-F. Grailet
 */

public class PollingStation
{
    private static final int MS_PER_MINUTE = 200;

    private String name;
    private int leave, remain;
    
    public PollingStation(String name)
    {
        this.name = name;
        leave = 0;
        remain = 0;
    }
    
    public String getName() { return name; }
    public int getNbLeave() { return leave; }
    public int getNbRemain() { return remain; }
    
    public  synchronized void welcome(Voter v)
    {
        int delay = v.getDelay();
        try
        {
            Thread.sleep(delay * MS_PER_MINUTE); // Delay is conceptually in minutes
        }
        catch(InterruptedException e)
        {
            System.err.println("Error while checking in at polling station " + name + "!");
            return;
        }
        
        /*
         * Regarding exercise 1: to implement the "split" of this method, consider separating the 
         * delay (in this method) and the vote (move it to another method, but keep using the 
         * "synchronized" keyword).
         */
        vote(v);
    }
    private synchronized  void vote (Voter v){      
        boolean votesLeave = v.getVote();
        if(votesLeave)
            leave++;
        else
            remain++;
    }
    
    public String toString()
    {
        int totalVotes = leave + remain;
        double ratioLeave = leave / (double) totalVotes;
        
        /*
         * Remarks on computing the ratio:
         * -Math.round() is used to round the (real) result to an integer.
         * -To keep a result with one decimal, it is multiplied by a higher value than necessary 
         *  then divided by a double value.
         * -Using the ".0" for this value matters, as it will implicitly convert the division (of 
         *  an integer by a double) into a double value.
         */
        
        ratioLeave = Math.round(ratioLeave * 1000) / 10.0;
        double ratioRemain = 100 - ratioLeave;
        
        String res = "Result at " + name + " (" + totalVotes + " votes): ";
        res += String.valueOf(ratioLeave) + "% wants to leave / ";
        res += String.valueOf(ratioRemain) + "% wants to remain.";
        return res;
    }
}
