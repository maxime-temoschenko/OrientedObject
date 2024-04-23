import java.util.Vector;
import java.util.Arrays;
public class Pascal{

    private static Vector<long[]> triangle = new Vector<long[]>();

    private static void resizeTriangle(int n){
	// Triangle.size() should be equal -> Triangle.size = n
	int size =  triangle.size();

	for(int i = size; i <= n;  ++i){
	    long[] new_line = new long[i+1];
	    // Base Case
	    new_line[0] = new_line[i] = 1;

	    for(int j = 1; j < i; ++j)
		new_line[j] = triangle.get(i-1)[j-1] + triangle.get(i-1)[j];
	    triangle.add(new_line);
	}
	    
    }
    public static long binomCoeff(int k, int n){
	if(n < 0 || k < 0 || k > n)
	    return -1;
	if(k==0 || k == n)
	    return 1;
	if( triangle.size() > n)
	    return triangle.get(n)[k];

	resizeTriangle(n);
	return triangle.get(n)[k];
		
    }
    public static void printTriangle(){
	System.out.println("Triangle size : " + triangle.size() + " Max n : " + (triangle.size() - 1));
	for(int i = 0; i < triangle.size(); ++i){
	    System.out.println(i + " : " +  Arrays.toString(triangle.get(i)));
	}
	
    }
  

}
