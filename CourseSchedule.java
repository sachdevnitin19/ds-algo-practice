import java.util.ArrayList;
import java.util.Iterator;
class CourseSchedule {

    class GraphNode {
        int courseNum, noOfDependencies;
        ArrayList<GraphNode> dependants;

        public GraphNode(int courseNum) {
            this.noOfDependencies = 0;
            this.courseNum = courseNum;
            this.dependants = new ArrayList<GraphNode>();
        }

        public void addDependant(GraphNode dependantCourse) {
            this.dependants.add(dependantCourse);
            dependantCourse.noOfDependencies++;
        }
    }

    ArrayList<GraphNode> CourseGraph;

    public int[] findOrder(int numCourses, int[][] prerequisites) {

        this.CourseGraph = new ArrayList<GraphNode>(numCourses);

        for (int i = 0; i < numCourses; i++)
            this.CourseGraph.add(i, new GraphNode(i));
        for (int i = 0; i < prerequisites.length; i++) {
            GraphNode parentCourse = CourseGraph.get(prerequisites[i][1]);

            GraphNode childCourse = CourseGraph.get(prerequisites[i][0]);

            parentCourse.addDependant(childCourse);
        }

        GraphNode[] topOrderGraphNodes = new GraphNode[numCourses];
        int endOfList = 0, toBeProcessed = 0;
        endOfList = addZeroInDegreeNodes(this.CourseGraph, topOrderGraphNodes, endOfList);
        while (toBeProcessed < numCourses) {
            GraphNode currGraphNode = topOrderGraphNodes[toBeProcessed];
            if (currGraphNode == null) {
                return new int[0];
            }

            ArrayList<GraphNode> currChildren = currGraphNode.dependants;
            Iterator<GraphNode> dependantsItr = currChildren.iterator();
            while (dependantsItr.hasNext()) {
                dependantsItr.next().noOfDependencies--;
            }

            endOfList = addZeroInDegreeNodes(currChildren, topOrderGraphNodes, endOfList);
            toBeProcessed++;
        }

        int topOrder[] = new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            topOrder[i] = topOrderGraphNodes[i].courseNum;
        }
        return topOrder;
    }

    public int addZeroInDegreeNodes(ArrayList<GraphNode> nodesToProcess, GraphNode[] topOrder, int endOfList) {
        Iterator<GraphNode> courseGraphItr = nodesToProcess.iterator();
        while (courseGraphItr.hasNext()) {
            GraphNode currCourse = courseGraphItr.next();
            if (currCourse.noOfDependencies == 0) {
                topOrder[endOfList] = currCourse;
                endOfList++;
            }
        }

        return endOfList;
    }

}
