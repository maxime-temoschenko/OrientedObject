/*
 * INFO0062 - Object-Oriented Programming
 * Exercise series 11
 *
 * Exercise 1: analyzing a concurrent program.
 * 
 * Comments:
 * -This program simulates a (simplified) referendum where voters (each being modelled by a 
 *  thread) wants to access polling stations concurrently in order to vote.
 * -Voter is a superclass for all parts of the population that are called to vote (students, 
 *  workers and retired people). It implements the Runnable interface.
 *
 * @author: J.-F. Grailet
 */

import java.util.Random;

public abstract class Voter implements Runnable
{
    protected static final int STUDENT = 0;
    protected static final int WORKER = 1;
    protected static final int RETIRED = 2;

    protected String name;
    protected int delay; // Amount of minutes (conceptual) for the person to register to vote
    protected double chanceOfLeave; // Chances to vote "Leave" ("Remain" => 1 - chanceOfLeave)
    protected PollingStation place;

    public void getInfluenced(){
        this.chanceOfLeave += 0.1;
    }
    
    public Voter(int voterCategory, int delay, double chanceOfLeave, PollingStation place)
    {
        // Generates a random name for this fellow
        String[] namePool = NamePool.ELDERS;
        String suffix = "(retired)";
        if(voterCategory == STUDENT)
        {
            namePool = NamePool.MILLENIALS;
            suffix = "(student)";
        }
        else if(voterCategory == WORKER)
        {
            namePool = NamePool.BABYBOOMERS;
            suffix = "(worker)";
        }
        
        // See here: https://docs.oracle.com/javase/8/docs/api/java/util/Random.html#nextInt-int-
        Random r = new Random();
        String firstName = namePool[r.nextInt(namePool.length)];
        String lastName = NamePool.SURNAMES[r.nextInt(NamePool.SURNAMES.length)];
        name = firstName + " " + lastName + " " + suffix;
        
        // Initializes the rest
        this.delay = delay;
        this.chanceOfLeave = chanceOfLeave;
        this.place = place;
    }
    
    public String getName() { return name; }
    public int getDelay() { return delay; }
    
    public boolean getVote()
    {
        return (Math.random() <= chanceOfLeave);
    }
    
    public final void run()
    {
        place.welcome(this);
        
        /*
         * On the System.out.println():
         * -Like in a true democracy, it doesn't tell what the person voted.
         * -You can drop it for a more concise output.
         * -There's no synchronization mechanism here because println() is already a "thread-safe" 
         *  method, i.e., it will no be executed by several threads at the same time. This can be 
         *  checked by reviewing the source code of the JDK:
         *
         *  http://hg.openjdk.java.net/jdk/jdk13/file/0368f3a073a9/src/java.base/share/classes/java/io/PrintStream.java
         */
        
        System.out.println(name + " has voted at " + place.getName() + ".");
    }
}
