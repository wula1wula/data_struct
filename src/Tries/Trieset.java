package Tries;
// 适合使用场景是前缀匹配，根据输入的前缀信息快速查询相同前缀的所有信息
//public class Trieset {
//    private static final int R = 128;
//    private Node root;
//
//    private static class Node{
//        private char ch ;
//        private boolean isKey;
//        private DataIndexedCharMap next;
//
//        private Node(char ch,boolean isKey,int R){
//            this.ch = ch;
//            this.isKey = isKey;
//            this.next = new DataIndexedCharMap<Node>(R);
//        }
//    }
//}
//改进
public class Trieset {
    private static final int R = 128;
    private Node root;

    private static class Node{
        private boolean isKey;
       // private DataIndexedCharMap next;

        private Node(boolean isKey,int R){
            this.isKey = isKey;
          //  this.next = new DataIndexedCharMap<Node>(R);
        }
    }
}
