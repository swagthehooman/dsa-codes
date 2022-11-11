import java.util.*;
//Swagnik Das 20051228

class Kruskals_algo {

    class Edge implements Comparable<Edge> {
        int src, dest, cost;

        @Override
        public int compareTo(Edge compareEdge) {
            return this.cost - compareEdge.cost;
        }
    }

    class subSet {
        int parent, rank;
    }

    int V, E;
    Edge edge[];

    Kruskals_algo(int v, int e) {
        V = v;
        E = e;
        edge = new Edge[E];
        for (int i = 0; i < E; i++)
            edge[i] = new Edge();
    }

    public int find(subSet set[], int i) {
        if (set[i].parent != i)
            set[i].parent = find(set, set[i].parent);
        return set[i].parent;
    }

    public void union(subSet set[], int x, int y) {
        int j = find(set, x);
        int k = find(set, y);

        if (set[j].rank < set[k].rank)
            set[j].parent = k;
        else if (set[j].rank > set[k].rank)
            set[k].parent = j;
        else {
            set[k].parent = j;
            set[j].rank++;
        }
    }

    public void KruskalsMCST() {
        Edge result[] = new Edge[V];
        int e = 0;

        for (int i = 0; i < V; i++)
            result[i] = new Edge();

        Arrays.sort(edge);

        subSet sets[] = new subSet[V];
        for (int i = 0; i < V; i++)
            sets[i] = new subSet();

        for (int i = 0; i < V; i++) {
            sets[i].parent = i;
            sets[i].rank = 0;
        }
        int minCost = 0;
        int iter = 0;
        while (e < V - 1) {
            Edge temp = edge[iter++];
            int x = find(sets, temp.src);
            int y = find(sets, temp.dest);

            if (x != y) {
                result[e++] = temp;
                minCost += temp.cost;
                union(sets, x, y);
            }
        }
        if (e == 0) {
            System.out.println("No spanning tree");
        } else {
            System.out.println("The min cost is= " + minCost + " and the edges are: ");
            for (int i = 0; i < e; i++) {
                System.out.println(result[i].src + " -- " + result[i].dest + " == " + result[i].cost);
            }
        }
    }

    public static void main(String[] args) {
        int V = 4; // Number of vertices in graph
        int E = 5; // Number of edges in graph
        Kruskals_algo graph = new Kruskals_algo(V, E);

        // add edge 0-1
        graph.edge[0].src = 0;
        graph.edge[0].dest = 1;
        graph.edge[0].cost = 10;

        // add edge 0-2
        graph.edge[1].src = 0;
        graph.edge[1].dest = 2;
        graph.edge[1].cost = 6;

        // add edge 0-3
        graph.edge[2].src = 0;
        graph.edge[2].dest = 3;
        graph.edge[2].cost = 5;

        // add edge 1-3
        graph.edge[3].src = 1;
        graph.edge[3].dest = 3;
        graph.edge[3].cost = 15;

        // add edge 2-3
        graph.edge[4].src = 2;
        graph.edge[4].dest = 3;
        graph.edge[4].cost = 4;

        // Function call
        graph.KruskalsMCST();
    }
}