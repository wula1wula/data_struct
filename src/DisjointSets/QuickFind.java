package DisjointSets;

public class QuickFind implements DisjoinSets{
    private int[] id;
    public QuickFind(int N){
        id = new int[N];
        for(int i =0;i<N;i++){
            id[i] = i;
        }
    }


    @Override
    public void connect(int p, int q) {
        int pid = id[p];
        int qid = id[q];
        for(int i =0;i<id.length;i++){
            if(id[i]==pid){
                id[i] = qid;
            }
        }
    }

    @Override
    public boolean isConnected(int p, int q) {
        return id[p]==id[q];
    }
}
