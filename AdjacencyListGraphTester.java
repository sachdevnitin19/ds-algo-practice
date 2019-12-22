import com.nitin.utils.AdjacencyListGraph;

class AdjacencyListGraphTester {
    public static void main(String args[]) {
        AdjacencyListGraph MyGraph = new AdjacencyListGraph(6, false);

        MyGraph.addEdge(0, 1);
        MyGraph.addEdge(0, 4);
        // MyGraph.addEdge(1, 4);
        // MyGraph.addEdge(1, 3);
        MyGraph.addEdge(1, 2);
        MyGraph.addEdge(4, 3);
        // MyGraph.addEdge(3, 2);

        // MyGraph.printBFS();

        // MyGraph.printDFS();
        // MyGraph.printDFSRecursively();

        AdjacencyListGraph MyGraph2 = new AdjacencyListGraph(8, true);

        MyGraph2.addEdge(5, 2);
        MyGraph2.addEdge(5, 1);
        MyGraph2.addEdge(0, 5);

        MyGraph2.addEdge(2, 0);
        MyGraph2.addEdge(1, 0);
        MyGraph2.addEdge(1, 4);
        MyGraph2.addEdge(1, 7);
        MyGraph2.addEdge(0, 4);
        MyGraph2.addEdge(3, 6);
        System.out.println(MyGraph2.doesPathExists(0, 7) ? "Path exists" : "Path does not exists");
        // MyGraph2.addEdge(0, 1); 
        // MyGraph2.addEdge(0, 2); 
        // MyGraph2.addEdge(1, 2); 
        // MyGraph2.addEdge(2, 0); 
        // MyGraph2.addEdge(2, 3); 
        // MyGraph2.addEdge(3, 3); 

        // String topOrder=MyGraph2.returnTopologicalOrder();
        // System.out.println("Topological Order= "+topOrder);
        // System.out.println("DFS:- ");
        // MyGraph2.printDFSRecursively();
        // System.out.println(MyGraph2.isGraphCyclic()?"Graph is cyclic.":"Graph is acyclic.");
    }
}