import java.util.Vector;

public class Pascal{
    private static Vector<long[]> triangle = new Vector<long[]>();

    private static void resizeTriangle(int n){
	int size  = triangle.size();

	for(int i = size; i <= n; ++i){
	    long[] my_array = new long[i+1];
	    my_array[0] = 1;
	    my_array[i] = 1;
	    for(int j = 1; j < i; ++j)
		my_array[j] = triangle.get(i-1)[j-1] + triangle.get(i-1)[j];
	    triangle.add(my_array);
	}
    }
    public static long getBinom(int n, int k){
	if(k < 0 ||  k > n || n < 0)
	    return -1;
	if(k == 0 || k == n)
	    return 1;
	if(n < triangle.size())
	    return triangle.get(n)[k];

	// User has asked for a coefficient outside the Pascal's Triangle
	resizeTriangle(n);
	return triangle.get(n)[k];
    }
    public static void printTriangle(){
	System.out.println("Maximum n in Pascal Triangle : " + (triangle.size()-1));
	for(int i = 0; i < triangle.size(); ++i){
	    System.out.println(i + " : ");
	    for(int j = 0; j <=i ; ++j){
		System.out.print(" " + triangle.get(i)[j]);
	    }
	    System.out.println("");
	}
	    
    }
}
