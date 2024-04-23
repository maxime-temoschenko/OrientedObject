public class safeEquals {
    private int a;
    private int b;

    private static volatile boolean comparison = false;
    public synchronized int hashCode(){
        return a+b;
    }
    public synchronized boolean equals(Object obj){
        while(comparison){
            try{ wait(); }
            catch(InterruptedException e ) {throw new InternalError("Wait fails");}
    }
        comparison = true;
        notify();
        synchronized(obj){
            if(!(obj instanceof safeEquals))
                return false;
            safeEquals s = (safeEquals) obj;
            return s.a==this.a && s.b==this.b;
        }
    }
}
