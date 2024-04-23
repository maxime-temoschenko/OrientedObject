import java.io.Serializable;

public class Interval implements Cloneable, Serializable
{
    // Integer.MAX_VALUE = +infty
    // Integer.MIN_VALUE = -infty
    private final int a;
    private final int b;
    public  Interval(int a,int b) throws IntervalException
    {
        if(b < a)
        {
            throw new IntervalException("Invalid interval");
        }
        this.a = a;
        this.b = b;
    }
    public boolean checkInterval(int x)
    {
        return x >= a && x <= b;
    }
    public boolean includesInterval(Interval inter) // Is inter included in this object ?
    {
        return inter.a >= this.a && inter.b <= this.b;
    }
    public Interval smallestInterval(Interval inter) throws IntervalException
    {
        if(this.includesInterval(inter))
            return (Interval) this.clone();
        if(inter.includesInterval(this))
            return (Interval) inter.clone();
        // It means that the intervals crosses once
        if(this.a < inter.a)
            return new Interval(this.a, inter.b);
        else
            return new Interval(inter.a, inter.b);
    }
    public boolean isInfinite()
    {
        return a == Integer.MIN_VALUE || b == Integer.MAX_VALUE;
    }
    public boolean equals(Object o)
    {
        if(!(o instanceof Interval))
        {
            return false;
        }
        Interval inter = (Interval) o;
        return inter.a == this.a && inter.b == this.b;

    }
    public int HashCode()
    {
        return this.a + this.b;
    }
    public Object clone()
    {
        Interval inter;
        try{
            inter = (Interval) super.clone(); // this is sufficient
        }
        catch(CloneNotSupportedException e ) {throw new InternalError("Unable to clone !");}
        return inter;
    }
}