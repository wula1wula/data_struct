package List;

public interface List {
    //将需要的公共方法抽象出来
    public void addLast(Object x);
    public Object getLast();
    public Object get(int x);
    public int size();
    public Object removeLast();
    public void addFirst(Object x);
    public Object getFirst();
}
