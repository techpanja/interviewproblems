package graphs.breadthfirstsearch;

import graphs.graph.DirectedGraph;
import graphs.graph.Graph;
import graphs.graph.Vertex;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Rule 1: Visit the next unvisited vertex (if there is one) that’s adjacent to the current vertex, mark it,
 * and insert it into the queue.
 * <p/>
 * Rule 2: If you can’t carry out Rule 1 because there are no more unvisited vertices, remove a vertex from
 * the queue (if possible) and make it the current vertex.
 * <p/>
 * Rule 3: If you can’t carry out Rule 2 because the queue is empty, you’re done.
 * <p/>
 * User: rpanjrath
 * Date: 12/8/13
 * Time: 12:35 PM
 * To change this template use File | Settings | File Templates.
 */
public class BFS {

    private static Queue<Vertex> queue = new LinkedList<Vertex>();

    public static void bfs(Graph graph) {
        Vertex vertex = graph.getFirstVertex();
        if (vertex != null) {
            vertex.setVisited(true);
            queue.add(vertex);
            while (!queue.isEmpty()) {
                Vertex currentVertex = queue.remove();
                Vertex unvisitedVertex;
                System.out.println(currentVertex);
                while ((unvisitedVertex = getUnvisitedVertex(currentVertex)) != null) {
                    unvisitedVertex.setVisited(true);
                    queue.add(unvisitedVertex);
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
        bfs(graph);
    }
}
