package Tree;

public class B_Tree <T extends Comparable<T>>{
    private class Node<T>{
         T[] keys;
         Node<T>[] children;
         int size;
         boolean isLeaf;
         Node(int t,boolean isLeaf){
             this.keys=(T[]) new Comparable[2*t-1];
             this.children=new Node[2*t];
             this.size=0;
             this.isLeaf=isLeaf;
        }
    }
}
