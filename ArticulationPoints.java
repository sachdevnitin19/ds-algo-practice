import com.nitin.utils.AdjacencyListGraph;
import java.util.List;
import java.util.ArrayList;

public class ArticulationPoints {
    public static void main(String[] args) {
        AdjacencyListGraph myGraph = new AdjacencyListGraph(7, false);

        myGraph.addEdge(0, 1);
        myGraph.addEdge(0, 2);

        myGraph.addEdge(1, 3);

        myGraph.addEdge(2, 3);
        myGraph.addEdge(2, 5);

        myGraph.addEdge(3, 4);

        myGraph.addEdge(5, 6);

        System.out.println("Articulation points in graph are "+myGraph.findArticulationPoints());
    }

    
}