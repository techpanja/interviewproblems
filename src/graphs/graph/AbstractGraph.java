package graphs.graph;

import java.util.*;

/**
 * Abstract class depicting a graph.
 * User: rpanjrath
 * Date: 10/24/13
 * Time: 5:39 PM
 */
public abstract class AbstractGraph implements Graph {

    protected AbstractGraph() {
    }

    @Override
    public abstract int getCurrentSize();

    @Override
    public abstract Vertex[] getVertexesAsArray();

    @Override
    public abstract int getMaxSize();

    public abstract void setCurrentSize(int currentSize);

    @Override
    public List<Vertex> getVertexesAsList() {
        List<Vertex> vertexList = new ArrayList<Vertex>();
        vertexList.addAll(Arrays.asList(getVertexesAsArray()));
        vertexList.removeAll(Collections.singleton(null));
        return vertexList;
    }

    @Override
    public boolean addVertex(Vertex vertex) {
        if (getCurrentSize() == getMaxSize()) {
            System.out.println("Reached max size!");
            return false;
        }
        List<Vertex> vertexList = Arrays.asList(getVertexesAsArray());
        if (!canAddVertex(vertex, vertexList)) {
            return false;
        }
        getVertexesAsArray()[getCurrentSize()] = vertex;
        setCurrentSize(getCurrentSize() + 1);
        return true;
    }

    protected boolean canAddVertex(Vertex vertex, List<Vertex> vList) {
        List<Vertex> vertexList = new ArrayList<Vertex>();
        vertexList.addAll(vList);
        vertexList.removeAll(Collections.singleton(null));
        for (Vertex tempVertex : vertexList) {
            if (tempVertex != null && vertex != null
                    && vertex.toString().equalsIgnoreCase(tempVertex.toString())) {
                System.out.println("Vertex already exists " + vertex);
                System.out.println();
                return false;
            }
        }
        return true;
    }

    public void displayGraphDependency() {
        System.out.println();
        for (Vertex tempVertex : getVertexesAsList()) {
            if (tempVertex.getDependsOn().size() > 0) {
                System.out.print("Vertex \"" + tempVertex + "\" depends on :-> ");
                for (Vertex vertex : tempVertex.getDependsOn()) {
                    System.out.print(vertex + ", ");
                }
                System.out.println();
            } else {
                System.out.println("Vertex \"" + tempVertex + "\": No dependencies.");
            }
        }
    }

    public void displayVertexList() {
        System.out.println("Vertex List:----");
        for (Vertex vertex : getVertexesAsList()) {
            System.out.println("Vertex: " + vertex);
        }
    }

    @Override
    public boolean isVertexExisting(Vertex vertex) {
        for (Vertex tempVertex : getVertexesAsList()) {
            if (tempVertex.toString().equalsIgnoreCase(vertex.toString())) {
                return true;
            }
        }
//        System.out.println("Edge cannot be added for non-existing vertex: " + vertex);
//        System.out.println();
        return false;
    }

    @Override
    public Vertex getVertex(String vertexLabel) {
        for (Vertex tempVertex : getVertexesAsList()) {
            if (tempVertex.toString().equalsIgnoreCase(vertexLabel)) {
                return tempVertex;
            }
        }
        return null;
    }

    @Override
    public abstract boolean addEdge(Vertex fromVertex, Vertex toVertex);

    //TODO Clone vertexList else after sort we loose the original graph
    //see line 133 where we remove the vertex from dependsOn
    @Override
    public Queue<Vertex> topoSortGraph() {
        int counter = getCurrentSize();
        List<Vertex> vertexList = getVertexesAsList();
        Vertex currentVertex = null;
        Queue<Vertex> sortedVertexQueue = new LinkedList<Vertex>();
        while (counter > 0) {
            counter--;
            for (Vertex vertex : vertexList) {
                if (vertex.getDependsOn().size() == 0) {
                    currentVertex = vertex;
                    sortedVertexQueue.add(currentVertex);
                    break;
                }
            }
            if (currentVertex != null) {
                vertexList.remove(currentVertex);
                for (Vertex vertex : vertexList) {
                    if (vertex.getDependsOn().contains(currentVertex)) {
                        vertex.getDependsOn().remove(currentVertex);
                    }
                }
            } else {
                System.out.println("Graph contains cycles.");
            }
        }
        return sortedVertexQueue;
    }
}
