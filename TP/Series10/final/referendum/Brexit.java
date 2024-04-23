/*
 * INFO0062 - Object-Oriented Programming
 * Exercise series 11
 *
 * Exercise 1: analyzing a concurrent program.
 * 
 * Comments:
 * -This program simulates a (simplified) referendum where voters (each being modelled by a 
 *  thread) wants to access polling stations concurrently in order to vote.
 * -This is the main class of the program, responsible for setting all the resources that will be 
 *  accessed by the different threads as well as monitoring the completion of each.
 *
 * @author: J.-F. Grailet
 */

import java.util.Random;

public class Brexit
{
    public static void main(String[] args)
    {
        PollingStation[] places = new PollingStation[5];
        places[0] = new PollingStation("Bell End, Worcestershire");
        places[1] = new PollingStation("Bishop Spit, Kent");
        places[2] = new PollingStation("Bishop Ooze, Kent");
        places[3] = new PollingStation("Greedy Gut, East Yorkshire");
        places[4] = new PollingStation("Gentlemen's Cave, Orkney");
        
        Random r = new Random();
        Voter[] voters = new Voter[250];
        for(int i = 0; i < voters.length; i++)
        {
            /*
             * To simplify, we assume each category makes up around 1/3 of the population. For 
             * nextInt(), see here: https://docs.oracle.com/javase/8/docs/api/java/util/Random.html#nextInt-int-
             */
            
            int type = r.nextInt(3);
            
            // Alternatively, one could use the switch() instruction
            if(type == 0)
                voters[i] = new Student(places[i / 50]);
            else if(type == 1)
                voters[i] = new Worker(places[i / 50]);
            else
                voters[i] = new Retired(places[i / 50]);
        }
        ForeignAgent fa = new ForeignAgent(voters);
        new Thread(fa, "foreign agent").start();
        // Starts threads
        Thread[] threads = new Thread[250];
        for(int i = 0; i < voters.length; i++)
        {
            threads[i] = new Thread(voters[i], voters[i].getName());
            threads[i].start();
        }
        
        /*
         * Waits for all threads to complete their task.
         * Cf. https://docs.oracle.com/javase/8/docs/api/java/lang/Thread.html#join--
         */
        
        for(int i = 0; i < threads.length; i++)
        {
            try
            {
                threads[i].join();
            }
            catch(InterruptedException e)
            {
                System.err.println("Error while invoking join(): " + e.getMessage());
            }
        }
        
        // Sums all votes together and computes final result
        int totalLeave = 0, totalRemain = 0;
        for(int i = 0; i < places.length; i++)
        {
            totalLeave += places[i].getNbLeave();
            totalRemain += places[i].getNbRemain();
            System.out.println(places[i]); // toString() omitted because called implicitely
        }
        
        int totalVotes = totalLeave + totalRemain;
        double ratioLeave = totalLeave / (double) totalVotes;
        
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
        
        String res = "On " + totalVotes + " votes (total across the country), ";
        res += String.valueOf(ratioLeave) + "% wants to leave / ";
        res += String.valueOf(ratioRemain) + "% wants to remain.";
        System.out.println(res);
    }
}
