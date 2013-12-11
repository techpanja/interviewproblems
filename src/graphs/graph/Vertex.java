package graphs.graph;

import java.util.ArrayList;
import java.util.List;

/**
 * Class denoting Vertex in graph.
 * User: rpanjrath
 * Date: 10/24/13
 * Time: 5:35 PM
 */
public class Vertex {

    private String label;
    private List<Vertex> dependsOn;
    private boolean isVisited = false;

    public Vertex(String label) {
        this.label = label;
        this.dependsOn = new ArrayList<Vertex>();
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public List<Vertex> getDependsOn() {
        return dependsOn;
    }

    public void setDependsOn(List<Vertex> dependsOn) {
        this.dependsOn = dependsOn;
    }

    @Override
    public String toString() {
        return this.label;
    }

    public boolean isVisited() {
        return isVisited;
    }

    public void setVisited(boolean visited) {
        isVisited = visited;
    }
}
