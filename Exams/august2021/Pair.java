public class Pair<U,V> {
    private final U first;
    private final V second;
    Pair(U first, V second){
        this.first = first;
        this.second = second;
    }
    public U getFirst(){
        return this.first;
    }
    public V getSecond(){
        return this.second;
    }
}
