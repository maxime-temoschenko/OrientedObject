

public class testTriangle{

    public static void main(String args[]){
	System.out.println("(5,5) : " + Pascal.binomCoeff(5,5));
	Pascal.printTriangle();
	System.out.println("(4,5) : " + Pascal.binomCoeff(4,5));
	Pascal.printTriangle();
	System.out.println("(7,10) : " + Pascal.binomCoeff(7,10));
	Pascal.printTriangle();
	System.out.println("(2,3) : " + Pascal.binomCoeff(2,3));
	Pascal.printTriangle();

	Pascal p1 = new Pascal();
	System.out.println("(7, 13) : " + p1.binomCoeff(7,13));
	Pascal.printTriangle();
    }


}
