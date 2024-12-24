package List;

public class LinkedList<T> {
    private class Node<T> {
        public T data;
        public Node<T> next;

        public Node(T data) {
            this.data = data;
            this.next = null;
        }
    }

    private Node<T> head;
    private int size;

    public LinkedList() {
        head = new Node<T>(null); // 虚拟头节点
        this.size = 0;
    }

    // 添加元素到链表尾部
    public void add(T data) {
        Node<T> newNode = new Node<>(data);
        Node<T> temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = newNode;
        size++;
    }

    // 删除指定元素
    public boolean remove(T data) {
        if (size == 0) {
            return false; // 空链表不能删除
        }

        Node<T> temp = head;
        while (temp.next != null) {
            if (temp.next.data.equals(data)) { // 找到匹配元素
                temp.next = temp.next.next; // 删除节点
                size--;
                return true;
            }
            temp = temp.next;
        }
        return false; // 未找到元素
    }

    // 获取指定索引的元素
    public T get(int index) {
        if (index < 0 || index >= size) { // 修正越界检查
            return null;
        }

        Node<T> temp = head.next; // 从第一个实际元素开始
        for (int i = 0; i < index; i++) {
            temp = temp.next;
        }
        return temp.data;
    }

    // 获取链表大小
    public int getSize() {
        return size;
    }
}


