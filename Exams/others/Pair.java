
public class Pair<E>{
private E v1, v2;
public E get(boolean first)
{
if (first)
    return v1;
else
    return v2;
}
public void set(E value, boolean first)
{
if (first)
    v1 = value;
else
    v2 = value;
}

public boolean equals(Object obj){
    synchronized(Pair.class) // Lock on the entire class Pair prevent deadlock o1.equals(o2) / o2.equals(o1)
    {
     if(!(obj instanceof Pair))
          return false;
     Pair<E> myPair = (Pair<E>) obj;
    return myPair.v1.equals(myPair.v1) && myPair.v2.equals(myPair.v2);
    }
}
}