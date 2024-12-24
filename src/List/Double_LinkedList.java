package List;

public class Double_LinkedList<T> {
    private static class Node<T>{
        public T data;
        public Node<T> prev;
        public Node<T> next;
        public Node(T data){
            this.data = data;
            this.prev = null;
            this.next = null;
        }
        public Node(){
            this.data = null;
            this.prev = null;
            this.next = null;
        }
    }
    private final Node<T> head;
    private final Node<T> tail;
    private int size;
    public Double_LinkedList(){
        head = new Node<T>(null);
        tail = new Node<T>(null);
        head.next = tail;
        tail.prev = head;
        size = 0;
    }

    public void addLast(T data){
        Node<T> newNode = new Node<T>(data);
        tail.prev.next = newNode;
        newNode.prev = tail.prev;
        newNode.next = tail;
        tail.prev = newNode;
        size+=1;
    }

    public void addFirst(T data){
        Node<T> newNode = new Node<T>(data);
        head.next.prev = newNode;
        newNode.next = head.next;
        newNode.prev = head;
        head.next = newNode;
        size+=1;
    }

    public void remove(T data){
        Node<T> temp = head.next;
        while(temp != tail){
            if(temp.data.equals(data)){
                temp.prev.next = temp.next;
                temp.next.prev = temp.prev;
                size -=1;
            }
            temp = temp.next;
        }
    }

    public void traverseForward(){
        Node<T> temp = head.next;
        while(temp != tail){
            System.out.println(temp.data);
            temp = temp.next;
        }
    }

    public void traverseBackward(){
        Node<T> temp = tail.prev;
        while(temp != head){
            System.out.println(temp.data);
            temp = temp.prev;
        }
    }

    public T get(int index){
        if(index < 0 || index >= size){
            throw new IndexOutOfBoundsException();
        }
        Node<T> temp =  head.next;
        for (int i = 0;i<index;i++){
            temp = temp.next;
        }
        return temp.data;
    }

    public int size(){
        return size;
    }

    public void clear() {
        head.next = tail;
        tail.prev = head;
        size = 0;
    }

    public static void main(String[] args) {
        Double_LinkedList<Integer> list = new Double_LinkedList<Integer>();

        // Test 1: Adding elements
        System.out.println("Test 1: Adding elements");
        list.addLast(10);
        list.addLast(20);
        list.addLast(30);
        list.addFirst(5);
        System.out.print("Expected forward traversal: 5, 10, 20, 30\nActual forward traversal: ");
        list.traverseForward();
        System.out.print("Expected backward traversal: 30, 20, 10, 5\nActual backward traversal: ");
        list.traverseBackward();
        System.out.println("Expected size: 4\nActual size: " + list.size());

        // Test 2: Removing elements
        System.out.println("\nTest 2: Removing elements");
        list.remove(10); // Removing middle element
        System.out.print("Expected forward traversal after removing 10: 5, 20, 30\nActual forward traversal: ");
        list.traverseForward();
        list.remove(5); // Removing head element
        System.out.print("Expected forward traversal after removing 5: 20, 30\nActual forward traversal: ");
        list.traverseForward();
        list.remove(30); // Removing tail element
        System.out.print("Expected forward traversal after removing 30: 20\nActual forward traversal: ");
        list.traverseForward();
        System.out.println("Expected size: 1\nActual size: " + list.size());

        // Test 3: Accessing elements by index
        System.out.println("\nTest 3: Accessing elements by index");
        System.out.println("Expected element at index 0: 20\nActual element: " + list.get(0));
        try {
            list.get(1); // Accessing out-of-bounds index
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Expected exception for out-of-bounds index: " + e.getMessage());
        }

        // Test 4: Adding and clearing the list
        System.out.println("\nTest 4: Adding and clearing the list");
        list.addLast(40);
        list.addFirst(15);
        System.out.print("Expected forward traversal after adding: 15, 20, 40\nActual forward traversal: ");
        list.traverseForward();
        list.clear();
        System.out.print("Expected forward traversal after clearing: (empty)\nActual forward traversal: ");
        list.traverseForward();
        System.out.println("Expected size: 0\nActual size: " + list.size());
    }

}

