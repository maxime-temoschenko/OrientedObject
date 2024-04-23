/*
 * INFO0062 - Object-Oriented Programming
 * Exercise series 11
 *
 * Exercise 1: analyzing a concurrent program.
 * 
 * Comments:
 * -This program simulates a (simplified) referendum where voters (each being modelled by a 
 *  thread) wants to access polling stations concurrently in order to vote.
 * -Student is a child class of Voter and is used to model young people (i.e. old enough to vote 
 *  but still studying). They have a voting delay of 2 minutes and 35% chances of voting "Leave".
 *
 * @author: J.-F. Grailet
 */

public class Student extends Voter
{
    public Student(PollingStation place)
    {
        super(STUDENT, 2, 0.35, place);
    }
}
