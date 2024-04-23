import java.io.Serializable;
import java.util.Vector;
public class IntSequence implements Cloneable, Serializable{
    private Vector<Integer> seq = new Vector<Integer>();
    public IntSequence() {}
    public IntSequence(int[] array){
        for(int i = 0; i < array.length; ++i)
            seq.add(array[i]);
    }
    public IntSequence(int len, int value) throws IntSequenceException{
        if(len < 0) throw new IntSequenceException("Unvalid length");
        for(int i =0 ; i < len; ++i)
            seq.add(value);
    }
    public synchronized void append(IntSequence other){
        for(int i : other.seq)
            seq.add(i);
    }
    public synchronized IntSequence extract(int i) throws IntSequenceException{
        return extract(1,i);
    }
    public synchronized IntSequence extract(int i, int j) throws IntSequenceException{
        if (i > j ) throw new IntSequenceException("Wrong use");
        if(i < 1 || j >= seq.size()) throw new IntSequenceException("Wrong usage");
        IntSequence extracted = new IntSequence();
        for(int k = i-1; k < j; ++k){
            extracted.seq.add(this.seq.get(k));
        }
        return extracted;
    }
    public int hashCode(){
        int hashcode = 0;
        for(int i= 0; i < seq.size(); ++i)
            hashcode += (i+1)*seq.get(i)*11;
        return hashcode;
    }
    @Override public boolean equals(Object obj){
        if(!(obj instanceof IntSequence))
            return false;
        IntSequence iseq = (IntSequence) obj;
        if(iseq.seq.size() != this.seq.size())
            return false;
        for(int i = 0; i < seq.size(); ++i)
            if(!(iseq.seq.get(i).equals(this.seq.get(i))))
                return false;
        return true;
    }
    @Override public Object clone(){
        IntSequence iseq;
        try{
            iseq = (IntSequence) super.clone();
            iseq.seq = (Vector<Integer>) this.seq.clone();
        }
        catch(CloneNotSupportedException e){throw new InternalError("Unable to clone ! ");}
        return iseq;
    }
    
}
