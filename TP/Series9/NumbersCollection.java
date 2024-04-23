import java.util.Vector;
import java.math.*;
// Define a generic class whose type parameters are subclasses of Number
public class NumbersCollection<T extends Number> {
    // Vector of generic elements
    private Vector<T> vecNumbers = new Vector<T>();

    public void add(T element){
        vecNumbers.add(element);
    }
    public double arithmeticMean(){
        double sum = 0.0;
        for(T element : vecNumbers)
        // doubleValue() can be used -> Bounded Type paramater
            sum += element.doubleValue();
        return sum/((double)vecNumbers.size());
    }
    public double geometricMean(){
        double product = 1.0;
        for(T element : vecNumbers)
            product *= element.doubleValue();
        return Math.pow(product, 1.0/(double)vecNumbers.size());
    }
    public double harmonicMean(){
        double invertSum = 0.0;
        for(T element : vecNumbers)
            invertSum += 1.0/element.doubleValue();

        return (double)vecNumbers.size()/invertSum;
    }
    public static void main(String[] args){
        NumbersCollection<Integer> nc = new NumbersCollection<Integer>();
        nc.add(1);
        nc.add(2);
        nc.add(3);
        System.out.println("Arithmetic Mean : " + nc.arithmeticMean());
        System.out.println("Geometric Mean : " + nc.geometricMean());
    }
}
