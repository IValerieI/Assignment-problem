package uni2022.samarchenko_v_l;


import java.util.Arrays;

public class Flow {

    public int[] findMinCostMaxFlow(Graph graph, int s, int t, int maxf) {
        int numOfNodes = graph.length();
        int[] dist = new int[numOfNodes];
        int[] currFlow = new int[numOfNodes];
        int[] prevEdge = new int[numOfNodes];
        int[] prevNode = new int[numOfNodes];

        int flow = 0;
        int flowCost = 0;
        while (flow < maxf) {
            bellmanFord(graph, s, dist, prevNode, prevEdge, currFlow);
            if (dist[t] == Integer.MAX_VALUE)
                break;
            int df = Math.min(currFlow[t], maxf - flow);
            flow += df;
            for (int v = t; v != s; v = prevNode[v]) {
                Graph.Edge edge = graph.getEdge(prevNode[v], prevEdge[v]);
                edge.flow += df;
                graph.getEdge(v, edge.from).flow -= df;
                flowCost += df * edge.cost;
                System.out.println("from - " + edge.from + ", to - " + edge.to +  ", cost - " + edge.cost + " and df is " + df);
            }
        }
        return new int[]{flow, flowCost};
    }

    private void bellmanFord(Graph graph, int s, int[] dist, int[] prevNode, int[] prevEdge, int[] currFlow) {
        int n = graph.length();
        Arrays.fill(dist, 0, n, Integer.MAX_VALUE);
        dist[s] = 0;
        currFlow[s] = Integer.MAX_VALUE;
        boolean[] inqueue = new boolean[n];
        int[] q = new int[n];
        int qt = 0;
        q[qt++] = s;
        for (int qh = 0; (qh - qt) % n != 0; qh++) {
            int u = q[qh % n];
            inqueue[u] = false;
            for (int i = 0; i < graph.getListByNode(u).size(); i++) {
                Graph.Edge edge = graph.getEdge(u, i);
                if (edge.flow >= edge.capacity)
                    continue;
                int v = edge.to;
                int newDist = dist[u] + edge.cost;
                if (dist[v] > newDist) {
                    dist[v] = newDist;
                    prevNode[v] = u;
                    prevEdge[v] = i;
                    currFlow[v] = Math.min(currFlow[u], edge.capacity - edge.flow);
                    if (!inqueue[v]) {
                        inqueue[v] = true;
                        q[qt++ % n] = v;
                    }
                }
            }
        }

    }
}
