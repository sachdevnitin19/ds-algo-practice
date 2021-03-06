import com.nitin.utils.AdjacencyListGraph;

class AdjacencyListGraphTester {
    public static void main(String args[]) {
        // AdjacencyListGraph MyGraph = new AdjacencyListGraph(6, false);

        // MyGraph.addEdge(0, 1);
        // MyGraph.addEdge(4, 0);
        // MyGraph.addEdge(1, 4);
        // MyGraph.addEdge(1, 3);
        // MyGraph.addEdge(1, 2);
        // MyGraph.addEdge(4, 3);
        // MyGraph.addEdge(3, 2);

        // MyGraph.printBFS();

        // MyGraph.printDFS();
        // MyGraph.printDFSRecursively();
        // System.out.println(MyGraph.isGraphCyclic()? "MyGraph is Cyclic" :"MyGraph is not Cyclic");

        AdjacencyListGraph MyGraph2 = new AdjacencyListGraph(8, true);

        MyGraph2.addEdge(3, 6);

        MyGraph2.addEdge(5, 2);
        MyGraph2.addEdge(5, 1);
        MyGraph2.addEdge(5, 0);

        MyGraph2.addEdge(2, 0);

        MyGraph2.addEdge(1, 0);
        MyGraph2.addEdge(1, 4);
        MyGraph2.addEdge(1, 7);
        
        MyGraph2.addEdge(0, 4);

        String topOrder=MyGraph2.returnTopologicalOrder();
        System.out.println("Topological Order= "+topOrder);
        // System.out.println("DFS:- ");
        // MyGraph2.printDFSRecursively();
        System.out.println(MyGraph2.isGraphCyclic()?"Graph is cyclic.":"Graph is acyclic.");
    }
}