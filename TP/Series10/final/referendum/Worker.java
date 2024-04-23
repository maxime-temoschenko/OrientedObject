/*
 * INFO0062 - Object-Oriented Programming
 * Exercise series 11
 *
 * Exercise 1: analyzing a concurrent program.
 * 
 * Comments:
 * -This program simulates a (simplified) referendum where voters (each being modelled by a 
 *  thread) wants to access polling stations concurrently in order to vote.
 * -Worker is a child class of Voter and is used to model working people. They have a voting delay 
 *  of 3 minutes and 50% chances of voting "Leave".
 *
 * @author: J.-F. Grailet
 */

public class Worker extends Voter
{
    public Worker(PollingStation place)
    {
        super(WORKER, 3, 0.5, place);
    }
}
