import java.util.Vector;
public class TestGenericity<T> {
    private Object[] obj;

    public T getObj(){
        return (T) obj[0];
    }
    public static void main(String[] args){
        Vector myInt = (Vector<Integer>) args;
    }
    
}
