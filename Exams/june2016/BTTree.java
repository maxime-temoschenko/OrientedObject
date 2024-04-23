public class BTTree<T> {
    private BTNode<T> root = null;
    private int size = 0;
    
    public BTNode<T> getRoot(){
        return root;
    }
    public BTNode<T> createRoot(T content){
        root = new BTNode<T>(content);
        size = 1;
        return root;
    }
    public static <T> BTNode<T> getLeft(BTNode<T> node){
        return node.getLeft();
    }
}
/*
 * It is called a bounded type Parameter.  The main advantage is that we can exploit the functionality of Numbe Interface.
 * In our cas for example , we could compute th sum
 */