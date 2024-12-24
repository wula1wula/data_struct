package Tree;

public class AVL_Tree<T extends Comparable<T>>{
    private class TreeNode{
        T data;
        TreeNode left;
        TreeNode right;
        int height;
        public TreeNode(T data){
            this.data = data;
            this.left = null;
            this.right = null;
            this.height = 0;
        }
    }
    private TreeNode root;
    public AVL_Tree(){
        this.root = null;
    }

    /**
     * 获取节点的高度
     * @param node
     * @return
     */
    private int getHeight(TreeNode node){
        return (node ==null) ? -1 : node.height;
    }

    /**
     * 插入节点
     * @param data
     */
    public void insert(T data){
        root = Reinsert(root,data);
    }
    private TreeNode Reinsert(TreeNode node, T data){
        if(node == null){
            return new TreeNode(data);
        }
        if(data.compareTo(node.data) < 0){
            node.left = Reinsert(node.left,data);
        }else{
            node.right = Reinsert(node.right,data);
        }
        node.height = Math.max(getHeight(node.left),getHeight(node.right)) + 1;

        return node;
    }

    /**
     * 删除节点
     * @param data
     */
    public void remove(T data){
        root = Remove(root,data);
    }
    private TreeNode Remove(TreeNode node, T data){
            if (node == null) {
                return null; // 如果当前节点为空，直接返回
            }

            // 递归查找目标节点
            if (data.compareTo(node.data) < 0) {
                node.left = Remove(node.left, data); // 在左子树中递归删除
            } else if (data.compareTo(node.data) > 0) {
                node.right = Remove(node.right, data); // 在右子树中递归删除
            } else {
                // 找到目标节点，开始处理删除逻辑

                // 情况 1: 无子节点
                if (node.left == null && node.right == null) {
                    return null; // 删除叶子节点
                }

                // 情况 2: 只有一个子节点
                if (node.left == null) {
                    return node.right; // 返回右子节点
                }
                if (node.right == null) {
                    return node.left; // 返回左子节点
                }

                // 情况 3: 有两个子节点
                // 找到右子树的最小节点（中序后继）
                TreeNode minNode = SelectMin(node.right);
                node.data = minNode.data; // 用后继节点的值替换当前节点的值
                node.right = Remove(node.right, minNode.data); // 删除后继节点
            }

            // **更新当前节点的高度**
            node.height = Math.max(getHeight(node.left), getHeight(node.right)) + 1;
            return node; // 返回更新后的节点
    }
    private TreeNode SelectMin(TreeNode node){
        if(node.left == null){
            return node;
        }
        return SelectMin(node.left);
    }

    /**
     * 查找元素
     * @param data
     * @return
     */
    public T find(T data){
        TreeNode node = FindNode(root,data);
        return (node == null)?null:node.data;
    }
    private TreeNode FindNode(TreeNode node, T data){
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

    /**
     * 平衡基本操作
     * @param node
     * @return
     */
    private TreeNode RightRotate(TreeNode node){
        TreeNode newRoot = node.left;
        node.left = newRoot.right;
        newRoot.right = node;
        node.height = Math.max(getHeight(node.left), getHeight(node.right)) + 1;
        newRoot.height = Math.max(getHeight(newRoot.left), getHeight(newRoot.right)) + 1;
        return newRoot;
    }
    private TreeNode LeftRotate(TreeNode node){
        TreeNode newRoot = node.right;
        node.right = newRoot.left;
        newRoot.left = node;
        node.height = Math.max(getHeight(node.left), getHeight(node.right)) + 1;
        newRoot.height = Math.max(getHeight(newRoot.left), getHeight(newRoot.right)) + 1;
        return newRoot;
    }
    private TreeNode LeftRightRotate(TreeNode node){
        node.left = LeftRotate(node.left);
        return RightLeftRotate(node);
    }
    private TreeNode RightLeftRotate(TreeNode node){
        node.right = RightRotate(node.right);
        return LeftRightRotate(node);
    }

    /**
     * 获取节点的平衡因子
     * @param node
     * @return
     */
    private int getBalanceFactor(TreeNode node){
        return getHeight(node.left) - getHeight(node.right);
    }

    /**
     * 平衡节点
     * @param node
     * @return
     */
    private TreeNode Balance(TreeNode node){
        int balanceFactor = getBalanceFactor(node);
        //左左情况
        if(balanceFactor > 1 && getBalanceFactor(node.left) >= 0){
            return RightRotate(node);
        }
        //右右情况
        if(balanceFactor < -1 && getBalanceFactor(node.right) <= 0){
            return LeftRotate(node);
        }
        //左右情况
        if(balanceFactor > 1 && getBalanceFactor(node.left) < 0){
            return LeftRightRotate(node);
        }
        //右左情况
        if(balanceFactor < -1 && getBalanceFactor(node.right) > 0){
            return RightLeftRotate(node);
        }
        return node;
    }

    /**
     *前序遍历
     */
    public void preOrderTraversal(){
        preOrderTraversal(this.root);
    }
    private void preOrderTraversal(TreeNode node){
        if (node == null) {
            return;
        }
        System.out.print(node.data + " ");
        preOrderTraversal(node.left);
        preOrderTraversal(node.right);
    }

    /**
     * 中序遍历
     */
    public void inOrderTraversal(){
        inOrderTraversal(this.root);
    }
    private void inOrderTraversal(TreeNode node){
        if (node == null) {
            return;
        }
        inOrderTraversal(node.left);
        System.out.print(node.data + " ");
        inOrderTraversal(node.right);
    }

    /**
     * 后序遍历
     */
    public void postOrderTraversal(){
        postOrderTraversal(this.root);
    }
    private void postOrderTraversal(TreeNode node){
        if (node == null) {
            return;
        }
        postOrderTraversal(node.left);
        postOrderTraversal(node.right);
        System.out.print(node.data + " ");
    }

    /**
     * 判断树是否平衡
     */
     public boolean isBalanced() {
        return isBalanced(this.root);
    }
    private boolean isBalanced(TreeNode node) {
        if (node == null) {
            return true;
        }
        int balanceFactor = getBalanceFactor(node);
        return Math.abs(balanceFactor) <= 1 && isBalanced(node.left) && isBalanced(node.right);
    }

    public static void main(String[] args) {
        AVL_Tree<Integer> tree = new AVL_Tree<Integer>();

        // 测试插入操作
        System.out.println("插入数据 30, 20, 10:");
        tree.insert(30);
        tree.insert(20);
        tree.insert(10);
        tree.inOrderTraversal(); // 预期输出: 10 20 30
        System.out.println("\n");

        // 测试删除操作
        System.out.println("删除数据 20:");
        tree.remove(20);
        tree.inOrderTraversal(); // 预期输出: 10 30
        System.out.println("\n");

        // 测试查找操作
        System.out.println("查找数据 30:");
        Integer result = tree.find(30);
        System.out.println(result != null ? "找到了数据 30" : "未找到数据 30"); // 预期输出: 找到了数据 30
        System.out.println("\n");

        // 测试插入并验证 AVL 树的平衡
        System.out.println("插入数据 25, 40, 50:");
        tree.insert(25);
        tree.insert(40);
        tree.insert(50);
        tree.inOrderTraversal(); // 预期输出: 10 25 30 40 50
        System.out.println("\n");

        // 测试 AVL 树是否保持平衡
        System.out.println("当前树是否平衡？");
        System.out.println(tree.isBalanced() ? "是" : "否"); // 预期输出: 是
    }


}
