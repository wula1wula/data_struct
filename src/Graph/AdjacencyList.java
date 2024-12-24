package Graph;

import java.util.*;

public class AdjacencyList {
    private Map<Integer, List<Integer>> adjacencyList;
    public AdjacencyList(){
        adjacencyList = new HashMap<>();
    }

    /**
     * 添加节点
     * @param vertex
     */
    public void addVertex(int vertex){
        if(!adjacencyList.containsKey(vertex)){
            adjacencyList.put(vertex,new ArrayList<>());
        }
    }
    /**
     * 添加无向边
     * @param source
     * @param destination
     */
    public void addEdge(int source,int destination){
        addVertex(source);
        addVertex(destination);
        adjacencyList.get(source).add(destination);
        adjacencyList.get(destination).add(source);
    }

    /**
     * 添加有向边
     * @param source
     * @param destination
     */
    public void addDirectedEdge(int source,int destination){
        addVertex(source);
        addVertex(destination);
        adjacencyList.get(source).add(destination);
    }

    /**
     * 删除边
     * @param source
     * @param destination
     */
    public void removeEdge(int source,int destination){
        if(adjacencyList.containsKey(source))
            adjacencyList.get(source).remove(Integer.valueOf(destination));
        if(adjacencyList.containsKey(destination))
            adjacencyList.get(destination).remove(Integer.valueOf(source));
    }

    /**
     * 获取邻接点
     * @param vertex
     * @return
     */
    public List<Integer> getNeighbors(int vertex){
        return adjacencyList.getOrDefault(vertex,new ArrayList<>());
    }

    /**
     * 深度优先
     * @param start
     * @return
     */
    public List<Integer> DFS(int start){
        List<Integer> result = new ArrayList<>();
        Set<Integer> visited = new HashSet<>();
        dfs(start,visited,result);
        return result;
    }
    private void dfs(int vertex,Set<Integer> visited,List<Integer> result){
        if(visited.contains(vertex)) return;
        visited.add(vertex);
        result.add(vertex);
        for(int neighbor : getNeighbors(vertex)){
            dfs(neighbor,visited,result);
        }
    }

    /**
     * 广度优先
     * @param start
     * @return
     */
    public List<Integer> BFS(int start){
        List<Integer> result = new ArrayList<>();
        Queue<Integer> queue = new LinkedList<>();
        Set<Integer> visited = new HashSet<>();
        queue.add(start);
        visited.add(start);
        while(!queue.isEmpty()){
            int vertex = queue.poll();
            result.add(vertex);
            for(int neighbor : getNeighbors(vertex)){
                if(!visited.contains(neighbor)){
                    queue.add(neighbor);
                    visited.add(neighbor);
                }
            }
        }
        return result;
    }
    public static void main(String[] args){
        AdjacencyList graph = new AdjacencyList();
        graph.addVertex(0);
        graph.addVertex(1);
        graph.addVertex(2);
        graph.addEdge(0, 1);
        graph.addEdge(1, 2);

        System.out.println(graph.DFS(0)); // 可能输出: [0, 1, 2]
        System.out.println(graph.BFS(0)); // 输出: [0, 1, 2]
        AdjacencyList digraph = new AdjacencyList();
        digraph.addVertex(0);
        digraph.addVertex(1);
        digraph.addVertex(2);
        digraph.addDirectedEdge(0, 1);
        digraph.addDirectedEdge(1, 2);

        System.out.println(digraph.DFS(0)); // 可能输出: [0, 1, 2]
        System.out.println(digraph.BFS(0)); // 输出: [0, 1, 2]

    }
}
