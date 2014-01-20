package graphs.depthfirstsearch;

import graphs.graph.DirectedGraph;
import graphs.graph.Graph;
import graphs.graph.Vertex;

import java.util.Stack;

/**
 * Rules:--
 * 1. If possible, visit an adjacent unvisited vertex, mark it, and push it on the stack.
 * 2. If you can’t follow Rule 1, then, if possible, pop a vertex off the stack.
 * 3. If you can’t follow Rule 1 or Rule 2, you’re done.
 * <p/>
 * Created by techpanja
 * Created on 1/20/14 1:31 PM.
 */
public class DFS {

    private static Stack<Vertex> stack = new Stack<>();

    private DFS() {

    }

    public static void dfs(Graph graph) {
        Vertex vertex = graph.getFirstVertex();
        if (vertex != null) {
            vertex.setVisited(true);
            stack.push(vertex);
            System.out.println(vertex);
            while (!stack.isEmpty()) {
                Vertex tempVertex = getUnvisitedVertex(stack.peek());
                if (tempVertex == null) {
                    stack.pop();
                } else {
                    tempVertex.setVisited(true);
                    stack.push(tempVertex);
                    System.out.println(tempVertex);
                }
            }
        }
    }

    private static Vertex getUnvisitedVertex(Vertex vertex) {
        for (Vertex temp : vertex.getDependsOn()) {
            if (!temp.isVisited()) {
                return temp;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        Graph graph = new DirectedGraph(6);
        graph.addEdge("v1", "v2");
        graph.addEdge("v2", "v3");
        graph.addEdge("v3", "v4");
        graph.addEdge("v1", "v5");
        graph.addEdge("v1", "v6");
        graph.displayGraphDependency();
        dfs(graph);
    }

}
