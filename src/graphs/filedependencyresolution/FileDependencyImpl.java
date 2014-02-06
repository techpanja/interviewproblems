package graphs.filedependencyresolution;

import graphs.graph.DirectedGraph;
import graphs.graph.Graph;
import graphs.graph.Vertex;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Implementation class for FileDependency
 * <p/>
 * User: rpanjrath
 * Date: 10/25/13
 * Time: 5:29 PM
 */
public class FileDependencyImpl implements FileDependency {

    private int maxNumOfFiles;
    private int currentNoOfFiles;
    private Graph graph;
    private Map<String, String> installedListMap = new HashMap<>();

    public FileDependencyImpl(int maxNumOfFiles) {
        this.maxNumOfFiles = maxNumOfFiles;
        this.currentNoOfFiles = 0;
        graph = new DirectedGraph(maxNumOfFiles);
    }

    @Override
    public boolean depends(String file1, String file2) {
        if (currentNoOfFiles >= maxNumOfFiles) {
            System.out.println("Reached max files limit.");
            return false;
        }
        if (file1.isEmpty() || file2.isEmpty()) {
            System.out.println("Please enter valid file name.");
            return false;
        }
        if (installedListMap.get(file1) != null) {
            System.out.println(file1 + " is already installed; cannot change it's dependency.");
            return false;
        }
        if (graph.addEdge(file1, file2)) {
            currentNoOfFiles = currentNoOfFiles + 2;
            graph.displayGraphDependency();
            return true;
        }
        return false;
    }

    @Override
    public boolean install(String file) {
        if (graph.getVertex(file) == null) {
            return false;
        }
        List<Vertex> sortedList = graph.topoSortGraph(graph.getVertex(file));
        if (sortedList.isEmpty()) {
            return false;
        }
        for (int i = sortedList.size() - 1; i >= 0; i--) {
            String currentVertex = sortedList.get(i).toString();
            if (installedListMap.get(currentVertex) == null) {
                installedListMap.put(currentVertex, currentVertex);
                System.out.println("INSTALLING " + currentVertex);
            }
        }
        return true;
    }

    @Override
    //TODO IMPLEMENT REMOVE
    public boolean remove(String file) {
        if (file.isEmpty()) {
            System.out.println("Please enter valid file name.");
            return false;
        }
        return false;
    }

    @Override
    public void list() {
        System.out.println("Installed components:---");
        for (String str : installedListMap.keySet()) {
            System.out.println(str);
        }
    }
}
