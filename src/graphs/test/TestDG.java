package graphs.test;

import graphs.graph.DirectedGraph;
import graphs.graph.Graph;
import graphs.graph.Vertex;

/**
 * Test class for graphs.
 * User: rpanjrath
 * Date: 10/24/13
 * Time: 6:01 PM
 */
public class TestDG {

    public static void main(String[] args) {
        Graph graph = new DirectedGraph(10);
        Vertex vertex1 = new Vertex("item1");
        Vertex vertex2 = new Vertex("item2");
        Vertex vertex3 = new Vertex("item2");
        graph.addVertex(vertex1);
        graph.addVertex(vertex2);
        graph.addVertex(vertex3);
        graph.addEdge(vertex1, vertex2);
        graph.addEdge(vertex1, vertex3);
        graph.addEdge(vertex2, vertex3);
        graph.displayVertexList();
        graph.displayGraphDependency();
    }
}
