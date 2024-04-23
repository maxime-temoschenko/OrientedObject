/*
 * INFO0062 - Object-Oriented Programming
 * Exercise series 11
 *
 * Exercise 1: analyzing a concurrent program.
 * 
 * Comments:
 * -This program simulates a (simplified) referendum where voters (each being modelled by a 
 *  thread) wants to access polling stations concurrently in order to vote.
 * -This class simply provide static arrays for generating random names.
 *
 * @author: J.-F. Grailet
 */

public class NamePool
{
    // Popular names in England circa 1994
    public static final String[] MILLENIALS = {
    "Thomas", "Rebecca", 
    "James", "Lauren", 
    "Jack", "Jessica", 
    "Daniel", "Charlotte", 
    "Matthew", "Hannah", 
    "Ryan", "Sophie",
    "Joshua", "Amy",
    "Luke", "Emily", 
    "Samuel", "Laura", 
    "Jordan", "Emma",
    "Adam", "Chloe",
    "Michael", "Sarah", 
    "Alexander", "Lucy", 
    "Christopher", "Katie", 
    "Benjamin", "Bethany",
    "Joseph", "Jade",
    "Liam", "Megan",
    "Jake", "Alice",
    "William", "Rachel",
    "Andrew", "Samantha",
    "George", "Danielle", 
    "Lewis", "Holy", 
    "Oliver", "Abigail",
    "David", "Olivia",
    "Robert", "Stephanie"};
    
    // Popular names in England circa 1964
    public static final String[] BABYBOOMERS = {
    "David", "Susan", 
    "Paul", "Julie", 
    "Andrew", "Karen", 
    "Mark", "Jacqueline", 
    "John", "Deborah", 
    "Michael", "Tracey", 
    "Stephen", "Jane", 
    "Ian", "Helen", 
    "Robert", "Diane", 
    "Richard", "Sharon", 
    "Christopher", "Tracy", 
    "Peter", "Angela", 
    "Simon", "Sarah", 
    "Anthony", "Alison", 
    "Kevin", "Caroline", 
    "Gary", "Amanda", 
    "Steven", "Sandra", 
    "Martin", "Linda", 
    "James", "Catherine", 
    "Philip", "Elizabeth", 
    "Alan", "Carol", 
    "Neil", "Joanne", 
    "Nigel", "Wendy", 
    "Timothy", "Janet", 
    "Colin", "Dawn"};
    
    // Popular names in England circa 1934
    public static final String[] ELDERS = {
    "John", "Margaret", 
    "Peter", "Jean", 
    "William", "Mary", 
    "Brian", "Joan", 
    "David", "Patricia", 
    "James", "Sheila", 
    "Michael", "Barbara", 
    "Ronald", "Doreen", 
    "Kenneth", "June", 
    "George", "Shirley", 
    "Robert", "Dorothy", 
    "Thomas", "Joyce", 
    "Alan", "Maureen", 
    "Derek", "Elizabeth", 
    "Raymond", "Audrey", 
    "Anthony", "Brenda", 
    "Roy", "Kathleen", 
    "Donald", "Sylvia", 
    "Dennis", "Eileen", 
    "Edward", "Pamela", 
    "Gordon", "Betty", 
    "Terence", "Beryl", 
    "Joseph", "Ann", 
    "Frederick", "Irene", 
    "Arthur", "Janet"};
    
    // A.k.a. frequent last names in England
    public static final String[] SURNAMES = {
    "Smith", "Jones", "Taylor", "Williams", "Lee", 
    "Brown", "Davies", "Evans", "Wilson", "Thomas", 
    "Roberts", "Johnson", "Lewis", "Walker", "Robinson", 
    "Wood", "Thompson", "White", "Watson", "Jackson", 
    "Wright", "Green", "Harris", "Cooper", "King", 
    "Martin", "Clarke", "James", "Morgan", "Hughes", 
    "Edwards", "Hill", "Moore", "Clark", "Harrison", 
    "Scott", "Young", "Morris", "Hall", "Ward", 
    "Turner", "Carter", "Phillips", "Mitchell", "Patel", 
    "Adams", "Campbell", "Anderson", "Allen", "Cook"};
}
