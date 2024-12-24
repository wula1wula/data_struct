package Stack;

import java.util.EmptyStackException;

public class Stack<E> {
    private class Node{
        E data;
        Node next;
        public Node(E data){
            this.data = data;
            this.next = null;
        }
    }
    private Node top;
    private int size;
    public Stack(){
        this.top = null;
        this.size = 0;
    }
    public void push(E data){
        Node node = new Node(data);
        node.next = top;
        top = node;
        size+=1;
    }

    public E pop(){
        if(isEmpty()){
            throw new EmptyStackException();
        }
        E temp = top.data;
        top = top.next;
        size -=1;
        return temp;
    }

    public E peek(){
        if(isEmpty()){
            throw new EmptyStackException();
        }
        return top.data;
    }

    public boolean isEmpty(){
        return size == 0;
    }

    public void printStack(){
        Node temp = top;
        while(temp!=null){
            System.out.println(temp.data);
            temp = temp.next;
        }
    }
    public void clear(){
        while(!isEmpty()){
            pop();
        }
    }

        public static void main(String[] args) {
            Stack<Integer> s = new Stack<Integer>();
            s.push(10);
            s.push(20);
            s.push(30);

            System.out.println("Current stack:");
            s.printStack();
        }
}
