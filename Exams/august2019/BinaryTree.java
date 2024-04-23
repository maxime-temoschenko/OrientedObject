import java.io.Serializable;

public class BinaryTree<T> implements Serializable, Cloneable {
    private Node root;
    private int depth;
    private int nbNodes;
    public BinaryTree(final T payload){
        root = new Leaf<T>(payload);
        this.depth = 0;
        this.nbNodes = 1;
    }
    private BinaryTree(BinaryTree<T> bleft, BinaryTree<T> bright){
        this.root = new InternalNode(bleft.root, bright.root);
        this.depth = bleft.depth > bright.depth ? bleft.depth+1 : bright.depth+1;
        this.nbNodes = 1+bleft.nbNodes+bright.nbNodes;
    }
    public BinaryTree<T> merge(BinaryTree<T> second){
        BinaryTree<T> result = new BinaryTree<T>(this, second);
        return result;
    }
    public int getNodesNb(){
        return nbNodes;
    }
    public int getDepth(){
        return depth;
    }
    @Override public int hashCode(){
        return 31*depth + nbNodes + root.hashCode();
    }
    @Override public boolean equals(Object u ){
      
        if(!(u instanceof BinaryTree<?>))
            return false;
        BinaryTree<?> b = (BinaryTree<?>) u;
        if((b.depth != this.depth) || (b.nbNodes != nbNodes))
            return false;
            
        return b.root.equals(this.root);
    }
    @Override public Object clone(){
        BinaryTree<?> b;
        try{
         b = (BinaryTree<?>) super.clone();
         b.root = (Node) this.root.clone();
         return b;
        }
        catch(CloneNotSupportedException e)  { throw new InternalError("unable to clone");}
    }
    public static void main(String[] args)
    {
        BinaryTree<Integer> b1 = new BinaryTree<Integer>(5);
        System.out.println("b1 : Height : " + b1.getDepth()+ " NbNodes : "+ b1.getNodesNb());
        BinaryTree<Integer> b2 = new BinaryTree<Integer>(10);
        System.out.println("b2 : Height : " + b2.getDepth()+ " NbNodes : "+ b2.getNodesNb());
        BinaryTree<Integer> b3 = b1.merge(b2);
        BinaryTree<Integer> b4 = b1.merge(b2);
        System.out.println("Merging b1 and b2 -> b3 : Height : " + b3.getDepth()+ " NbNodes : "+ b3.getNodesNb());
        System.out.println("b3 and b4, are they equals ? : " + b3.equals(b4));
        BinaryTree<?> b5 = (BinaryTree<?>)b3.clone();
        System.out.println(b5.equals(b3));
    }
}
