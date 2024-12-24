package Graph;

import Queue.queue;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AdjacencyMatrix {
    private int[][] matrix;
    private int numVertices;
    private int maxVertices;
    public AdjacencyMatrix(int maxVertices){
        this.maxVertices = maxVertices;
        matrix = new int[maxVertices][maxVertices];
        numVertices = 0;
    }

    /**
     * 顺序添加顶点
     */
    public void addVertex(){
        if(numVertices == maxVertices){
            throw new IllegalStateException("Graph is full");
        }
        numVertices+=1;
    }
    /**
     * 添加边(无向图)
     * @param source
     * @param destination
     */
    public void addWayEdge(int source, int destination,int weight){
        if(source<0||source>=numVertices||destination<0||destination>=numVertices){
            throw new IllegalArgumentException("Invalid vertex index");
        }
        matrix[source][destination] = weight;
        matrix[destination][source] = weight;
    }

    /**
     * 添加边(有向图)
     * @param source
     * @param destination
     * @param weight
     */
    public void addNoWayEdge(int source, int destination, int weight){
        if(source<0||source>=numVertices||destination<0||destination>=numVertices){
            throw new IllegalArgumentException("Invalid vertex index");
        }
        matrix[source][destination] = weight;
    }

    /**
     * 移除有向边
     * @param start
     * @param end
     */
    public void removeWayEdge(int start, int end){
        if(start<0||start>=numVertices||end<0||end>=numVertices){
            throw new IllegalArgumentException("Invalid vertex index");
        }
        matrix[start][end] = 0;
    }

    /**
     * 移除无向边
     * @param start
     * @param end
     */
    public void removeNoWayEdge(int start, int end){
        if(start<0||start>=numVertices||end<0||end>=numVertices){
            throw new IllegalArgumentException("Invalid vertex index");
        }
        matrix[start][end] = 0;
        matrix[end][start] = 0;
    }

    /**
     * 判断有无边
     * @param start
     * @param end
     * @return
     */
    public boolean isEdge(int start, int end){
        return matrix[start][end] != 0||matrix[end][start] != 0;
    }

    public void deleteVertex(int vertex){
        if(vertex<0||vertex>=numVertices){
            throw new IllegalArgumentException("Invalid vertex index");
        }

        for(int i =0;i<numVertices -1;i++){
            for(int j =0;j<numVertices;j++){
                matrix[i][j] = matrix[i+1][j];
            }
        }
        for(int j= 0 ; j< numVertices -1;j++){
            for(int i =0;i<numVertices;i++){
                matrix[i][j] = matrix[i][j+1];
            }
        }
        numVertices--;
    }
    /**
     * 获取无向邻接点
     * @param vertex
     * @return
     */
    public List<Integer> getNeighbors(int vertex){
        if(vertex<0||vertex>=numVertices){
            throw new IllegalArgumentException("Invalid vertex index");
        }
        List<Integer> neighbors = new ArrayList<>();
        for(int i =0;i<numVertices;i++){
            if(matrix[vertex][i]!=0){
                neighbors.add(i);
            }
        }
        return neighbors;
    }

    /**
     * 获取有向邻接点
     * @param vertex
     * @return
     */
    public Map<String,List<Integer>> getNeighborsMap(int vertex){
        Map<String,List<Integer>> map = new HashMap<>();
        List<Integer> in = new ArrayList<>();
        map.put("out",getNeighbors(vertex));
        for(int i =0;i<numVertices;i++){
            if(matrix[i][vertex]!=0){
                in.add(i);
            }
        }
        map.put("in",in);
        return map;
    }
    /**
     * 打印邻接矩阵
     */
    public void print(){
        for(int i =0;i<numVertices;i++){
            for(int j =0;j<numVertices;j++){
                System.out.print(matrix[i][j]+" ");
            }
            System.out.println();
        }
    }

    /**
     * 统计有向边
     * @return
     */
    public int countWayEdge(){
        int count =0;
        for(int i = 0;i<numVertices;i++){
            for(int j = 0;j<numVertices;j++){
                if(matrix[i][j]!=0){
                    count+=1;
                }
            }
        }
        return count;
    }
    /**
     * 统计无向边
     * @return
     */
    public int countNoWayEdge(){
        int count =0;
        for(int i =0;i<numVertices;i++){
            for(int j=0;j<i;j++){
                if(matrix[i][j]!=0){
                    count+=1;
                }
            }
        }
        return count;
    }

    /**
     * 清空邻接矩阵
     */
    public void clean(){
        for(int i =0;i<numVertices;i++){
            for(int j =0;j<numVertices;j++){
                matrix[i][j]=0;
            }
        }
        numVertices = 0;
    }

    public int getEdgeWeight(int start, int end){
        if(start<0||start>=numVertices||end<0||end>=numVertices){
            throw new IllegalArgumentException("Invalid vertex index");
        }
        return matrix[start][end];
    }

    public boolean isFullyConnected(){
        for(int i =0;i<numVertices;i++){
            for(int j =0;j<numVertices;j++){
                if(i!=j && matrix[i][j]==0){
                    return false;
                }
            }
        }
        return true;
    }

    public void deepFirstSearch(int vertex){
        boolean[] visited = new boolean[numVertices];
        dfs(vertex,visited);
    }

    /**
     * 递归dfs
     * @param vertex
     * @param visited
     */
    private void dfs(int vertex, boolean[] visited){
        visited[vertex] = true;
        System.out.print(vertex+" ");
        for(int i =0;i<numVertices;i++){
            if(matrix[vertex][i]!=0&&!visited[i]){
                dfs(i,visited);
            }
        }
    }

    public void breadthFirstSearch(int vertex){
        boolean[] visited = new boolean[numVertices];
        queue<Integer> queue = new queue<>();
        visited[vertex] = true;
        queue.enqueue(vertex);
        while(!queue.isEmpty()){
            int v = queue.dequeue();
            System.out.print(v+" ");
            for(int i =0;i<numVertices;i++){
                if(matrix[v][i]!=0&&!visited[i]){
                    visited[i] = true;
                    queue.enqueue(i);
                }
            }
        }
    }


    public static void main(String[] args) {
        AdjacencyMatrix graph = new AdjacencyMatrix(5);
        graph.addVertex(); // 添加 0
        graph.addVertex(); // 添加 1
        graph.addVertex(); // 添加 2
        graph.addVertex(); // 添加 3
        graph.addVertex(); // 添加 4
        graph.addWayEdge(0, 1,10);
        graph.addWayEdge(0, 2,10);
        graph.addWayEdge(0, 4,10);
        graph.addWayEdge(1, 3,20);
        graph.breadthFirstSearch(0);

    }
}
