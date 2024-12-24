package Tree;

public class Tree<T extends Comparable<T>> {
    private class TreeNode{
        T data;
        TreeNode left;
        TreeNode right;
        public TreeNode(T data){
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }
    private TreeNode root;
    public Tree(){
        this.root = null;
    }

    /**
     * 插入
     * @param data
     */
    public void insert(T data){
        root = Reinsert(root,data);
    }
    private TreeNode Reinsert(TreeNode node,T data){
        if(node == null){
            return new TreeNode(data);
        }
        if(data.compareTo(node.data) < 0){
            node.left = Reinsert(node.left,data);
        }else{
            node.right = Reinsert(node.right,data);
        }
        return node;
    }

    /**
     * 删除
     * @param data
     */
    public void remove(T data){
        root = Remove(root,data);
    }
    private TreeNode Remove(TreeNode node,T data){
        if(node == null){
            return null;
        }
        TreeNode aimNode = SelectNode(node,data);
        if (aimNode.left == null && aimNode.right == null) {
            return null;
        }
        if (aimNode.left == null) {
            return aimNode.right;
        }
        if (aimNode.right == null) {
            return aimNode.left;
        }
        TreeNode minNode = SelectMin(aimNode.right);
        aimNode.data = minNode.data;
        aimNode.right = Remove(aimNode.right,minNode.data);
        return aimNode;
    }
    private TreeNode SelectMin(TreeNode node){
        if(node.left == null){
            return node;
        }
        return SelectMin(node.left);
    }
    private TreeNode SelectNode(TreeNode node,T data){
        if(data.compareTo(node.data) < 0){
            return SelectNode(node.left,data);
        }else if(data.compareTo(node.data) > 0){
            return SelectNode(node.right,data);
        }else{
            return node;
        }
    }

    /**
     * 查找
     * @param data
     * @return
     */
    public T find(T data){
        TreeNode node = FindNode(root,data);
        return (node == null)?null:node.data;
    }
    private TreeNode FindNode(TreeNode node,T data){
        if (node == null) {
            return null;
        }
        if (data.compareTo(node.data) < 0) {
            return FindNode(node.left,data);
        }else if(data.compareTo(node.data) > 0){
            return FindNode(node.right,data);
        }else{
            return node;
        }
    }



    public static void main(String[] args) {
        Tree<Integer> tree = new Tree<Integer>();
        tree.insert(50);
        tree.insert(30);
        tree.insert(70);
        tree.insert(20);
        tree.insert(40);
        tree.insert(60);
        tree.insert(80);

        tree.remove(50); // 删除根节点
        tree.remove(30); // 删除有两个子节点的节点
        tree.remove(20); // 删除叶子节点

        // 你可以添加一个遍历方法来验证树结构是否正确


    }

}
