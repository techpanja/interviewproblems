package graphs.filedependencyresolution;

import graphs.graph.DirectedGraph;
import graphs.graph.Graph;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/**
 * Implementation class for FileDependency
 * <p/>
 * User: rpanjrath
 * Date: 10/25/13
 * Time: 5:29 PM
 */
public class FileDependencyImpl implements FileDependency {

    private int maxNumOfFiles;
    private Graph graph;
    private List<String> installedList = new ArrayList<String>();

    public FileDependencyImpl(int maxNumOfFiles) {
        this.maxNumOfFiles = maxNumOfFiles;
        graph = new DirectedGraph(maxNumOfFiles);
    }

    @Override
    public boolean depends(String file1, String file2) {
        if (installedList.contains(file1)) {
            System.out.println(file1 + " is already installed; cannot change it's dependency.");
            return false;
        }
        if (graph.addEdge(file1, file2)) {
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
        Queue queue = graph.topoSortGraph();
        if (queue == null) {
            System.out.println(file + " may have been installed previously.");
            return false;
        }
        if (queue.isEmpty()) {
            return false;
        }
        while (!queue.isEmpty()) {
            installedList.add(queue.peek().toString());
            System.out.println("INSTALLING " + queue.poll());
        }
        return true;
    }

    @Override
    //TODO IMPLEMENT REMOVE
    public boolean remove(String file) {
        return false;
    }

    @Override
    public void list() {
        System.out.println("Installed components:---");
        for (String str : installedList) {
            System.out.println(str);
        }
    }
}
