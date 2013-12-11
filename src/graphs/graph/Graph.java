package graphs.graph;

import java.util.List;
import java.util.Queue;

/**
 * Graph Interface.
 * User: rpanjrath
 * Date: 10/24/13
 * Time: 6:04 PM
 */
public interface Graph {

    /*
    * Returns current number of vertices in the graph.
    * */
    int getCurrentSize();

    /*
    * Returns the vertex array.
    * */
    Vertex[] getVertexesAsArray();

    /*Returns a cloned copy.*/
    List<Vertex> getVertexesAsList();

    void displayVertexList();

    /*
    * Adds a vertex to the graph.
    * */
    boolean addVertex(Vertex vertex);

    /*
    * Directed/UnDirected edge from fromVertex to toVertex.
    * */
    boolean addEdge(Vertex fromVertex, Vertex toVertex);

    boolean addEdge(String fromVertex, String toVertex);

    int getMaxSize();

    void displayGraphDependency();

    boolean isVertexExisting(Vertex vertex);

    Vertex getVertex(String vertexLabel);

    Queue<Vertex> topoSortGraph();
}
