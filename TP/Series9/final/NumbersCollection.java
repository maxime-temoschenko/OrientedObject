import java.util.Vector;
import java.lang.Math;

public class NumbersCollection<T extends Number>{
    private Vector<T> vecNumber = new Vector<T>();

    public void add(T value){
	vecNumber.add(value);
    }
    public double arithmeticMean(){
	double sum = 0.0;
	for(T num : vecNumber)
	    sum += num.doubleValue();
	return sum/vecNumber.size();
    }
    public double geometricMean(){
	double product = 1.0;
	for(T num : vecNumber) 
	    product *= num.doubleValue();
	return Math.pow(product, 1.0/((double)vecNumber.size()));
    }
    public double harmonicMean(){
	double invertSum = 0.0;
	for(T num : vecNumber)
	    invertSum += 1.0/num.doubleValue();
	return ((double)vecNumber.size()/invertSum);
    }

    public static void main(String[] args){
	NumbersCollection<Integer> myNum = new NumbersCollection<Integer>();
	myNum.add(1);
	myNum.add(2);
	myNum.add(3);
	System.out.println("Arithmetic Mean : " + myNum.arithmeticMean());
	System.out.println("Geometric Mean : " + myNum.geometricMean());
	System.out.println("Harmonic Mean : " + myNum.harmonicMean());
	System.out.println("Result :" + 1.0/(double)0.0);
    }

}
