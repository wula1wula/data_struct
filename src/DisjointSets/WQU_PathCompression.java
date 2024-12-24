package DisjointSets;

public class WQU_PathCompression implements DisjoinSets{
    private int[] parent;
    private int[] size;
    public WQU_PathCompression(int N){
        parent = new int[N];
        size = new int[N];
        for(int i=0;i<N;i++){
            parent[i] =i;
            size[i] =1;
        }
    }
    // 查找操作，带路径压缩
    public int findRoot(int p){
        if(p!=parent[p]){
            parent[p] = findRoot(parent[p]);
        }
        return parent[p];
    }

    // 合并操作，加权合并
    public void connect(int p,int q){
        int pRoot = findRoot(p);
        int qRoot = findRoot(q);
        if(pRoot == qRoot) return;
        if(size[pRoot]<size[qRoot]){
            parent[pRoot] = qRoot;
            size[qRoot] +=size[pRoot];
        }else {
            parent[qRoot] = pRoot;
            size[qRoot] +=size[pRoot];
        }
    }

    // 检查两个节点是否连通
    public boolean isConnected(int p,int q){
        return findRoot(p)==findRoot(q);
    }
}
