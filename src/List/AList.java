package List;

public class AList<T> {
    private T[] items;
    private int size;
    public AList(){
        items =(T[]) new Object[100];
        size =0;
    }
    public void addLast(T x){
        if(size==items.length){
            T[] a = (T[]) new Object[size*2];
            System.arraycopy(items,0,a,0,size);
            items =a;
        }
        items[size]=x;
        size++;
    }
    public T getLast(){
        return items[size-1];
    }
    public T get(int x){
        return items[x];
    }
    public int size(){
        return size;
    }
    public T removeLast(){
        T x = getLast();
        size--;
        return x;
    }

}
