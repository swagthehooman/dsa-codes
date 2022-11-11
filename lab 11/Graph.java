import java.util.*;

public class Graph {
    int V;
    LinkedList<Integer> adj[];

    // constructor for number of vertices
    @SuppressWarnings("unchecked")
    Graph(int v) {
        this.V = v;
        adj = new LinkedList[v];
        for (int i = 0; i < v; i++) {
            adj[i] = new LinkedList<>();
        }
    }

    // add vertices and edges
    public void add(int v, int e) {
        adj[v].add(e);
    }

    // dfs for graph
    public void DFS(int src) {
        boolean visited[] = new boolean[V];// stores which vertices are visited

        Stack<Integer> s = new Stack<>();// Stack to store vertices from source

        // Source is visited
        visited[src] = true;
        s.push(src);

        while (!s.isEmpty()) {
            src = s.pop();// extract source
            System.out.println(src);

            LinkedList<Integer> i = adj[src]; // get adjoint vertices of the source
            for (int x : i) {
                if (!visited[x]) {
                    visited[x] = true; // all adjoint vertices are visited
                    s.push(x);
                }
            }
        }
    }

    public void BFS(int src) {
        boolean visited[] = new boolean[V]; // stores which vertices are visited

        LinkedList<Integer> q = new LinkedList<>();// Queue to store vertices from source

        // Source is visited
        visited[src] = true;
        q.add(src);

        while (!q.isEmpty()) {
            src = q.poll();// extract source

            LinkedList<Integer> i = adj[src];// get adjoint vertices of the source
            for (int x : i) {
                if (!visited[x]) {
                    visited[x] = true; // all adjoint vertices are visited
                    q.add(x);
                }
            }
            System.out.println(src + "\t");
        }
    }

    public static void main(String args[]) {
        Graph g = new Graph(4);
        g.add(0, 1);
        g.add(0, 2);
        g.add(1, 2);
        g.add(2, 0);
        g.add(2, 3);
        g.add(3, 3);

        // 0---------1
        // | /
        // | /
        // | /
        // | /
        // 2---------3

        System.out.println("The BFS traversal of graph");
        g.BFS(2);
        System.out.println("The DFS traversal of graph");
        g.DFS(2);
    }
}
