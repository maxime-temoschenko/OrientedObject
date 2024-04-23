import java.io.Serializable;

public class DateNotBiss implements Cloneable, Serializable{
    private int m;
    private int d;
    public DateNotBiss(int m, int d) throws InvalidDate{
		if(!isValid(m,d))
			throw new InvalidDate("Invalid format of date");
		this.m = m;
		this.d = d;
    }
    public synchronized String toString(){
		return "Month : " + this.m + " Day : " + this.d;
    }	
    public synchronized void add(int value) throws InvalidDate{
		int temp_m = this.m;
		int temp_d = this.d;
		while(!(isValid(temp_d+value, temp_m))){
			if( (temp_d+value) < 1){
			System.out.println("negative");
			if(--temp_m == 0)
				throw new InvalidDate("Decrement is too large"); // Throw error
			value += temp_d;
			temp_d = maxDayMonth(temp_m);
			}
			if( (temp_d+value) > maxDayMonth(temp_m)){
			System.out.println("her");
			if(++temp_m > 12)
				throw new InvalidDate("Increment is too large");
			value-=(maxDayMonth(temp_m)-temp_d+1);
			temp_d = 0;
			System.out.println("Value : " + value);
			}
		
		}
		this.m = temp_m;
		this.d = temp_d+value;
    }
    public boolean equals(Object u){
	if(!(u instanceof DateNotBiss))
	    return false;
	DateNotBiss d = (DateNotBiss) u;
	return (d.m==this.m)&&(d.d==this.d);
        }
   public int hashCode(){
       return 37*this.m + this.d;
    }
    public static void main(String[] args) throws InvalidDate
    {
		DateNotBiss b = new DateNotBiss(10,12);
		System.out.println(b.toString());
		b.add(10);
		System.out.println(b.toString());
		b.add(10);
		System.out.println(b.toString());
		DateNotBiss a = new DateNotBiss(11, 1);
		System.out.println("Are they equals ? : "+ a.equals(b));
		DateNotBiss c = (DateNotBiss) a.clone();
		System.out.println("C : " + c.toString());
    }
    public Object clone(){
		try{ return super.clone();}
		catch(CloneNotSupportedException e ){throw new InternalError("Unable to clone !");}
    }
    private boolean isValid(int d, int m) {
		return d>0 && d <= maxDayMonth(m);
    }
    protected int maxDayMonth(int m){
		if( m==4 || m==6 || m==9 || m==11)
			return 30;
		else if(m==2)
			return 28;
		else
			return 31;
		}
}
			 
