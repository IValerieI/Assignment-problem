package uni2022.samarchenko_v_l;

import java.util.ArrayList;
import java.util.List;

public class Graph {

    private List<Edge>[] graph;
    private int numOfNodes;

    static class Edge {
        int from;
        int to;
        int flow;
        int capacity;
        int cost;

        Edge(int to, int capacity, int cost, int from) {
            this.from = from;
            this.to = to;
            this.capacity = capacity;
            this.cost = cost;
        }

//        public void setFlow(int val) {
//            this.flow = flow;
//        }

    }

    public Graph(int n) {
        this.numOfNodes = n;
        graph = new List[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }
    }

    public void addEdge(int s, int t, int capacity, int cost) {
        graph[s].add(new Edge(t, capacity, cost, graph[t].size()));
        graph[t].add(new Edge(s, 0, -cost, graph[s].size() - 1));
    }

    public int length() {
        return graph.length;
    }

    public Edge getEdge(int indNode, int indEdge) {
        return graph[indNode].get(indEdge);
    }

    public List<Edge> getListByNode(int indNode) {
        return graph[indNode];
    }


}
