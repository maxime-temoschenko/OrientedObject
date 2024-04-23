/*
 * INFO0062 - Object-Oriented Programming
 * Exercise series 11
 *
 * Exercise 1: analyzing a concurrent program.
 * 
 * Comments:
 * -This program simulates a (simplified) referendum where voters (each being modelled by a 
 *  thread) wants to access polling stations concurrently in order to vote.
 * -Retired is a child class of Voter and is used to model retired people. They have a voting 
 *  delay of 5 minutes and 65% chances of voting "Leave".
 *
 * @author: J.-F. Grailet
 */

public class Retired extends Voter
{
    public Retired(PollingStation place)
    {
        super(RETIRED, 5, 0.65, place);
    }
}
