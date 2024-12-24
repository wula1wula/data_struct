package Heaps_PQ;

import java.util.Arrays;

public class Min_Heap {
    private int[] heap;
    private int size;
    private int capacity;

    public Min_Heap(int capacity) {
        this.capacity = capacity;
        this.size = 0;
        heap = new int[capacity];
    }

    private int getParent(int i) {
        return (i - 1) / 2;
    }

    private int getLeftChild(int i) {
        return 2 * i + 1;
    }

    private int getRightChild(int i) {
        return 2 * i + 2;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size == capacity;
    }

    public void print() {
        System.out.println(Arrays.toString(heap));
    }

    public void insert(int value) {
        if (isFull()) {
            int[] temp = new int[capacity * 2];
            System.arraycopy(heap, 0, temp, 0, capacity);
            heap = temp;
            capacity *= 2;
        }
        heap[size] = value;
        size += 1;
        heapifyUp(size - 1);
    }

    private void heapifyUp(int i) {
        while (i > 0) {
            int parent = getParent(i);
            if (heap[i] < heap[parent]) {
                swap(i, parent);
                i = parent;
            } else {
                break;
            }
        }
    }

    private void swap(int i, int j) {
        int temp = heap[i];
        heap[i] = heap[j];
        heap[j] = temp;
    }
    public int delete() {
        if (isEmpty()) {
            throw new IllegalStateException("Heap is empty");
        }
        int value = heap[0];
        heap[0]=heap[size -1];
        heap[size - 1] = 0;
        size -=1;
        heapifyDown(0);
        return value;
    }
    private void heapifyDown(int i) {
        int minIndex = i;
        if(getLeftChild(i) < size && heap[i] > heap[getLeftChild(i)]) {
            minIndex = getLeftChild(i);
        }
        if(getRightChild(i) < size && heap[i] > heap[getRightChild(i)]) {
            minIndex = getRightChild(i);
        }
        if(minIndex != i) {
            swap(i, minIndex);
            heapifyDown(minIndex);
        }
    }

    public static void main(String[] args) {
        Min_Heap heap = new Min_Heap(10);
        heap.insert(10);
        heap.insert(5);
        heap.insert(15);
        heap.insert(3);
        heap.insert(8);
        heap.insert(2);

        System.out.println("Heap before deletion: " + Arrays.toString(heap.heap));
        System.out.println("Deleted value: " + heap.delete());
        System.out.println("Heap after deletion: " + Arrays.toString(heap.heap));
    }
}
