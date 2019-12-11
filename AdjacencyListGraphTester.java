import com.nitin.utils.AdjacencyListGraph;

class AdjacencyListGraphTester {
    public static void main(String args[]) {
        AdjacencyListGraph MyGraph=new AdjacencyListGraph(5);

        MyGraph.addEdge(0, 1);
        MyGraph.addEdge(0, 4);
        MyGraph.addEdge(1, 4);
        MyGraph.addEdge(1, 3);
        MyGraph.addEdge(1, 2);
        MyGraph.addEdge(4, 3);
        MyGraph.addEdge(3, 2);

        MyGraph.printBFS();

        MyGraph.printDFS();
    }
}