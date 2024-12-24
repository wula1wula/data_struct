package DisjointSets;

public interface DisjoinSets {
    /**
     * 添加到集合
     * @param p
     * @param q
     */
    void connect(int p, int q);

    /**
     * 判断是否在集合中
     * @param p
     * @param q
     * @return
     */
    boolean isConnected(int p, int q);
}
