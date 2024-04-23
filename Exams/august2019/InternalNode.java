public class InternalNode implements Node{
    private Node left;
    private Node right;
    public InternalNode(Node left, Node right){
        this.left = left;
        this.right = right;
    }
    @Override public boolean equals(Object obj){
        if(!(obj instanceof InternalNode))
            return false;
        InternalNode n = (InternalNode) obj;
        System.out.println("3");
        return n.left.equals(this.left) && n.right.equals(this.right);
    }
    @Override public int hashCode(){
        return 11*left.hashCode()+right.hashCode();
    }
    @Override public Object clone(){
        InternalNode n;
        try{
             n = (InternalNode) super.clone();
            n.left = (Node) this.left.clone();
            n.right = (Node) this.right.clone();
        }
        catch(CloneNotSupportedException e)  { throw new InternalError("unable to clone");}
        return n;
    }
}
