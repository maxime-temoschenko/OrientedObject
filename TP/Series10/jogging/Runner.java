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
 * -This Runner class, which is provided for the sake of simplicity, models a jogger/runner as a 
 *  thread that executes multiple delays to simulate the jogging. A runner is defined by a distance 
 *  (s)he will run and a mean speed. The speed is randomly changed every kilometer (either the 
 *  runner goes 5% faster, either 5% slower). When the runner has finished his/her run, his/her 
 *  result is sent to the monitoring object (which implements the TimeReporting interface).
 *
 * @author: J.-F. Grailet
 */

public class Runner extends Thread
{
    private String name;
    private double distance, speed; // Distance to travel and average speed
    private double travelled, time, curSpeed; // Travelled distance, time and current speed
    private TimeReporting finish;
    
    public Runner(String name, double distance, double speed, TimeReporting finish)
    {
        super(name);
        this.name = name;
        this.distance = distance;
        this.speed = speed;
        this.finish = finish;
        
        travelled = 0.0;
        curSpeed = speed;
    }
    
    public void run()
    {
        while(travelled < distance)
        {
            // Delaying to model time to run (sped up)
            double perKm = 3600 / curSpeed; // Seconds for 1km
            double nextKm = distance > 1.0 ? 1.0 : distance - travelled;
            int delay = (int) (perKm * nextKm * 5); // * 5 is arbitrary (you can change this)
            try
            {
                Thread.sleep(delay);
            }
            catch(InterruptedException e)
            {
                System.err.println("Error while delaying: " + e.getMessage());
            }
            time += perKm;
            travelled += nextKm;
            
            // Randomly applying +5% / -5% to the speed
            boolean draw = (Math.random() > 0.5);
            if(draw)
                curSpeed *= 1.05;
            else
                curSpeed *= 0.95;
        }
        
        // Formatting the result
        int integerTime = (int) time;
        String res = name + " ran " + String.valueOf(distance) + "km in ";
        if(time > 3600)
        {
            res += String.valueOf(integerTime / 3600) + "h ";
            integerTime = integerTime % 3600;
        }
        res += String.valueOf(integerTime / 60) + "m ";
        integerTime = integerTime % 60;
        res += String.valueOf(integerTime) + "s";
        
        // Communicating the result to the finish line
        finish.report(res);
    }
}
