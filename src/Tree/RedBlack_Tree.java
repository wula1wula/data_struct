package Tree;

public class RedBlack_Tree<T extends Comparable<T>>{
    private class Node{
        T key;
        Node left;
        Node right;
        Node parent;
        Color color;
        public enum Color{
            RED, BLACK
        }

        public Node(T key){
            this.key = key;
            this.color = Color.RED;
            this.left = NIL;
            this.right = NIL;
            this.parent = null;
        }
    }
    private Node root;
    private final Node NIL;
    public RedBlack_Tree(){
        NIL = new Node(null);
        NIL.color = Node.Color.BLACK;
        NIL.left = NIL.right = NIL.parent = NIL;
        root = NIL;
    }

    /**
     * 插入节点
     * @param key
     */
    public void insert(T key){
        if (root == NIL) {
            root = new Node(key);
            root.color = Node.Color.BLACK;
            return;
        }
        root = Insert(root, key);
        fixInsert(root);
    }
    private Node Insert(Node node,T key){
        if(node == NIL){
            return new Node(key);
        }
        if (key.compareTo(node.key) < 0) {
            node.left = Insert(node.left, key);
            node.left.parent = node;
        }else{
            node.right = Insert(node.right, key);
            node.right.parent = node;
        }
        return node;
    }

    private void fixInsert(Node node){
        while(node.parent != null && node.parent.color == Node.Color.RED){
            Node uncle = getUncle(node);
            Node grandParent = node.parent.parent;
            if(uncle !=null && uncle.color == Node.Color.RED){
                node.parent.color = Node.Color.BLACK;
                uncle.color = Node.Color.BLACK;
                grandParent.color = Node.Color.RED;
                node = grandParent;
            }else{
                if(node.parent == grandParent.left){//左子树
                    if(node == node.parent.right){//右子节点
                        node = node.parent;
                        rotateLeft(node);
            }
                    node.parent.color = Node.Color.BLACK;
                    grandParent.color = Node.Color.RED;
                    rotateRight(grandParent);
        }else{
                    if(node == node.parent.left){//左子节点
                        node = node.parent;
                        rotateRight(node);
                }
                node.parent.color = Node.Color.BLACK;
                grandParent.color = Node.Color.RED;
                rotateLeft(grandParent);
    }
            }
        }
        root.color = Node.Color.BLACK;
    }
    private void rotateLeft(Node node){

    }
    private void rotateRight(Node node){

    }
    private Node getUncle(Node node){
        if(node.parent == null || node.parent.parent == null){
            return null;
        }
        Node grandParent = node.parent.parent;
        return (node.parent == grandParent.left) ? grandParent.right : grandParent.left;
    }

}
