public class BTNode<T>{
    private T element;
    private BTNode<T> left =null, right = null;
    protected BTNode(T element){
        this.element= element;
    }
    protected void setLeft(BTNode<T> node){
        this.left = node;
    }
    public BTNode<T> getLeft(){
        return left;
    }
}
