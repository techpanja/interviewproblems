package trees.treeproblems;

import graphs.graph.Graph;
import graphs.graph.UnDirectedGraph;
import graphs.graph.Vertex;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Idea is similar to PrintNaryTreeWithLevels. Use markers in queue. Node immediate after the marker is the first
 * node of the level that should be printed.
 * User: rpanjrath
 * Date: 12/10/13
 * Time: 2:33 PM
 */
public class LeftViewOfATree {

    private static Queue<Vertex> queue = new LinkedList<Vertex>();

    public static void bfs(Graph graph) {
        Vertex vertex = graph.getVertexesAsArray()[0];
        vertex.setVisited(true);
        System.out.println(vertex);
        queue.add(vertex);
        //null acts as a pointer/marker when new level should begin.
        queue.add(null);
        while (!queue.isEmpty()) {
            Vertex currentVertex = queue.remove();
            if (currentVertex == null) {
                if (queue.isEmpty()) {
                    break;
                }
                currentVertex = queue.remove();
                System.out.println(currentVertex);
                queue.add(null);
            }
            Vertex unvisitedVertex;
            while ((unvisitedVertex = getUnvisitedVertex(currentVertex)) != null) {
                unvisitedVertex.setVisited(true);
                queue.add(unvisitedVertex);
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
        Graph graph = new UnDirectedGraph(12);
        graph.addEdge("V1", "V2");
        graph.addEdge("V1", "V3");
        graph.addEdge("V1", "V6");
        graph.addEdge("V2", "V4");
        graph.addEdge("V3", "V5");
        graph.addEdge("V3", "V10");
        graph.addEdge("V4", "V7");
        graph.addEdge("V4", "V8");
        graph.addEdge("V6", "V9");
        graph.addEdge("V9", "V11");
        graph.addEdge("V11", "V12");
        graph.displayVertexList();
        graph.displayGraphDependency();
        bfs(graph);
    }
}
