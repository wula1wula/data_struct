package List;

public class SLList {
    private static class IntNode {
        public int item;
        public IntNode next;
        public IntNode(int i, IntNode n) {
            item = i;
            next = n;
        }
        public IntNode(){}
    }


//    private IntNode first;
    private int size;
    private IntNode sentinel;
    public SLList(int x) {
        sentinel = new IntNode(0,null);
        sentinel.next =new IntNode(x,null);
        size =1;
    }
    public SLList() {
        sentinel = new IntNode(0,null);
        size =0;
    }
    /*将x添加到列表头部*/
    public void addFirst(int x){
        sentinel.next =new IntNode(x,sentinel.next);
        size++;
    }
    /*将x添加到列表尾部*/
    public void addLast(int x){
        IntNode p = sentinel;
        while(p.next!=null){
            p=p.next;
        }
        p.next = new IntNode(x,null);
        size++;
    }
    /*获取列表头部元素*/
    public int getFirst() {
        return sentinel.next.item;
    }
    public int size(){
        return size;
    }
}
