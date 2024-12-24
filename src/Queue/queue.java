package Queue;

public class queue<T>{
    private class Node{
        T data;
        Node next;
        Node pre;
        public Node(T data){
            this.data = data;
            this.next = null;
            this.pre = null;
        }
    }
    private Node head;
    private Node tail;
    private int size;
    public queue(){
        this.head = null;
        this.tail = null;
        this.size = 0;
    }
    public void enqueue(T data){
        Node node = new Node(data);
        if(isEmpty()){
            head = node;
            tail = node;
        }else{
            tail.next = node;
            node.pre = tail;
            tail = node;
        }
        size++;
    }
    public T dequeue() {
        T data;
        if (isEmpty()) {
            return null;
        } else {
            data = head.data;
            head = head.next;
            if(head == null){
                tail = null;
            }else{
                head.pre = null;
            }
            size--;
        }
        return data;
    }
    public T peek(){
        if(isEmpty()){
            return null;
        }
        return head.data;
    }
    public boolean isEmpty(){
        return size == 0;
    }
    public int size(){
        return size;
    }

}
