public class Leaf<T> implements Node {
    private final T data;
    public Leaf(final T data){
        this.data = data;
    }
    public T getData(){
        return this.data;
    }
    @Override public boolean equals(Object obj){
        if(!(obj instanceof Leaf<?>))
            return false;
        else 
            return data.equals((Object)(((Leaf<?>)obj).data));
    }
    @Override public int hashCode(){
        return data.hashCode();
    }
    @Override public Object clone(){
        Leaf<?> u;
        try{
          u = (Leaf<?>)super.clone();
        }
        catch(CloneNotSupportedException e)  { throw new InternalError("unable to clone");}
        return u;
    }
}
