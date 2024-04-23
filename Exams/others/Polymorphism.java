public class Polymorphism {
    void fun(Object obj){
        System.out.println("Object ! ");
    }
    void fun(A a){
        System.out.println("A");
    }
    public static void main(String[] args){
        Polymorphism poly  = new Polymorphism();
        A a  = new A();
        poly.fun(a);
        B b = new B();
        poly.fun(b);
        poly.fun(new String("obj"));
    }
}
class A{

}
class B extends A{

}


