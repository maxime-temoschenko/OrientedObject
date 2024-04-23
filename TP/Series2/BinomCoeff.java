

class BinomCoeff{

    public static void main(String args[]){
	Pascal.printTriangle();
	System.out.println("(0,0) : " + Pascal.getBinom(0,0));
	Pascal.printTriangle();
	System.out.println("(5,4) : " + Pascal.getBinom(5,4));
	Pascal.printTriangle();
	System.out.println("(3,2) : " + Pascal.getBinom(3,2));
	Pascal.printTriangle();
       System.out.println("(10,4) : " + Pascal.getBinom(10,4));
	Pascal.printTriangle();

    }

}
