package trees.treeproblems;

import graphs.graph.Graph;
import graphs.graph.UnDirectedGraph;
import graphs.graph.Vertex;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Print an n-ary tree with level. For e.g.
 * 0              foo
 * 1       bar		       baz
 * 2 foobar	 abc              barfoo
 * <p/>
 * Desired output:
 * Level 0: foo
 * Level 1: bar baz
 * Level 2: foobar abc barfoo
 * User: rpanjrath
 * Date: 12/10/13
 * Time: 12:08 PM
 */
public class PrintNaryTreeWithLevels {
    private static Queue<Vertex> queue = new LinkedList<Vertex>();

    public static void bfs(Graph graph) {
        Vertex vertex = graph.getVertexesAsArray()[0];
        vertex.setVisited(true);
        int counter = 0;
        System.out.println(vertex + "level " + counter);
        counter++;
        queue.add(vertex);
        //null acts as a pointer/marker when new level should begin.
        queue.add(null);
        while (!queue.isEmpty()) {
            Vertex currentVertex = queue.remove();
            if (currentVertex == null) {
                counter++;
                if (queue.isEmpty()) {
                    break;
                }
                currentVertex = queue.remove();
                queue.add(null);
            }
            Vertex unvisitedVertex;
            while ((unvisitedVertex = getUnvisitedVertex(currentVertex)) != null) {
                unvisitedVertex.setVisited(true);
                queue.add(unvisitedVertex);
                System.out.println(unvisitedVertex + "level " + counter);
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
        Graph graph = new UnDirectedGraph(11);
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
        graph.displayVertexList();
        graph.displayGraphDependency();
        bfs(graph);
    }

}
