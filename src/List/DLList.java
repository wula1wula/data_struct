package List;

public class DLList {
    private static class DoubleList{
        public int val;
        public DoubleList next;
        public DoubleList prev;
        public DoubleList(int val){
            this.val = val;
        }
    }
    private DoubleList sentinel;
    private int size;

}
