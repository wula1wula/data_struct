package DisjointSets;

public class QuickUnion implements DisjoinSets{
    private int[] parent;

    public QuickUnion(int N){
        parent = new int[N];
        for(int i = 0;i<N;i++){
            parent[i] = i;
        }
    }

    private int find(int p){
        while(parent[p]>=0){
            p = parent[p];
        }
        return p;
    }

    @Override
    public void connect(int p, int q) {
        int i = find(p);
        int j = find(q);
        parent[i] = j;
    }

    @Override
    public boolean isConnected(int p, int q) {
        return find(p)==find(q);
    }
}
