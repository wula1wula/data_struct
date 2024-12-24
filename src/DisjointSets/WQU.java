package DisjointSets;

public class WQU implements DisjoinSets{
    private int[] parent;
    private int[] size;
    public WQU(int N){
        parent = new int[N];
        size = new int[N];
        for(int i = 0;i<N;i++){
            parent[i] = i;
            size[i] = 1;
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
        if(i==j){
            return;
        }
        if(size[i]<size[j]){
            parent[i] = j;
            size[j] += size[i];
        }else{
            parent[j] = i;
            size[i] += size[j];
        }
    }
    @Override
    public boolean isConnected(int p, int q) {
        return find(p)==find(q);
    }
}
