package Heaps_PQ;

public class Max_Heap {
    private int[] heap;
    private int size;
    private int capacity;

    public Max_Heap(int capacity) {
        this.capacity = capacity;
        this.size = 0;
        heap = new int[capacity];
    }
    private int parent(int i){
        return (i-1)/2;
    }
    private int leftChild(int i){
        return (2*i)+1;
    }
    private int rightChild(int i){
        return (2*i)+2;
    }
    public boolean isEmpty(){
        return size==0;
    }
    public boolean isFull(){
        return size==capacity;
    }
    public void print(){
        for(int i=0;i<size;i++){
            System.out.print(heap[i]+" ");
        }
    }
    public void insert(int value){
        if(isFull()){
            int[] temp = new int[capacity*2];
            System.arraycopy(heap,0,temp,0,capacity);
            heap = temp;
            capacity *=2;
        }
        heap[size] = value;
        size+=1;
        heapifyUp(size-1);
    }
    private void heapifyUp(int i){
        if(i<=0) return;
        int parent = parent(i);
        if(heap[parent]<heap[i]){
            swap(parent,i);
            heapifyUp(parent);
        }
    }
    private void swap(int i,int j){
        int temp = heap[i];
        heap[i] = heap[j];
        heap[j] = temp;
    }

    public int delete(){
        if(isEmpty()){
            System.out.println("Heap is empty");
        }
        int temp = heap[0];
        heap[0] = heap[size-1];
        size-=1;
        heapifyDown(0);
        return temp;
    }
    private void heapifyDown(int i){

    }
}
