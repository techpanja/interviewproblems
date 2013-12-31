package graphs.breadthfirstsearch;

import graphs.graph.Graph;
import graphs.graph.UnDirectedGraph;
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
        Vertex vertex = graph.getVertexesAsArray()[0];
        vertex.setVisited(true);
        System.out.println(vertex);
        queue.add(vertex);
        while (!queue.isEmpty()) {
            Vertex currentVertex = queue.remove();
            Vertex unvisitedVertex;
            while ((unvisitedVertex = getUnvisitedVertex(currentVertex)) != null) {
                unvisitedVertex.setVisited(true);
                queue.add(unvisitedVertex);
                System.out.println(unvisitedVertex);
            }
        }

    }

    public static Vertex getUnvisitedVertex(Vertex vertex) {
        for (Vertex temp : vertex.getDependsOn()) {
            if (!temp.isVisited()) {
                return temp;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        Graph graph = new UnDirectedGraph(5);
        graph.addEdge("V1", "V2");
        graph.addEdge("V1", "V3");
        graph.addEdge("V2", "V4");
        graph.addEdge("V3", "V5");
        graph.displayVertexList();
        graph.displayGraphDependency();
        bfs(graph);
    }
}
