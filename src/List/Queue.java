package List;

//双向队列需要添加头和添加尾部，删除头和删除尾部功能
public class Queue<T>{
    private Double_LinkedList<T> list;
    public Queue(){
        list = new Double_LinkedList<T>();
    }
    public void enqueue(T x){
        list.addLast(x);
    }
    public T dequeue(){
        if(list.size() ==0){
            throw new RuntimeException("Queue is empty");
        }
        T data = list.get(0);
        list.remove(data);
        return data;
    }
    public int size(){
        return list.size();
    }
    public boolean isEmpty(){
        return list.size() == 0;
    }

}
