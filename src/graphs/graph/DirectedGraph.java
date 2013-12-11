package graphs.graph;

import java.util.List;

/**
 * Directed AbstractGraph.
 * User: rpanjrath
 * Date: 10/24/13
 * Time: 5:58 PM
 */
public class DirectedGraph extends AbstractGraph {

    private Vertex[] vertexes;
    private int maxSize;
    private int currentSize;

    public DirectedGraph(int maxSize) {
        this.currentSize = 0;
        this.maxSize = maxSize;
        this.vertexes = new Vertex[maxSize];
    }

    @Override
    public int getCurrentSize() {
        return this.currentSize;
    }

    @Override
    public Vertex[] getVertexesAsArray() {
        return this.vertexes;
    }

    @Override
    public int getMaxSize() {
        return this.maxSize;
    }

    @Override
    public void setCurrentSize(int currentSize) {
        this.currentSize = currentSize;
    }

    @Override
    public boolean addEdge(String fromVertex, String toVertex) {
        Vertex fromV = new Vertex(fromVertex);
        Vertex toV = new Vertex(toVertex);
        if (!isVertexExisting(fromV))
            addVertex(fromV);
        else {
            fromV = getVertex(fromVertex);
        }
        if (!isVertexExisting(toV))
            addVertex(toV);
        else {
            toV = getVertex(toVertex);
        }
        return addEdge(fromV, toV);
    }

    @Override
    public boolean addEdge(Vertex fromVertex, Vertex toVertex) {
        if (!isVertexExisting(fromVertex) || !isVertexExisting(toVertex)) {
            return false;
        }
        if (fromVertex.toString().equalsIgnoreCase(toVertex.toString())) {
            System.out.println("Start and end vertex \"" + fromVertex + "\" should be different.");
            System.out.println();
            return false;
        }
        if (!canAddVertex(toVertex, fromVertex.getDependsOn())) {
            System.out.println("Vertex \"" + fromVertex + "\" already depends on \"" + toVertex + "\"");
            System.out.println();
            return false;
        }
        List<Vertex> dependsOn = fromVertex.getDependsOn();
        dependsOn.add(toVertex);
        fromVertex.setDependsOn(dependsOn);
        return true;
    }
}
