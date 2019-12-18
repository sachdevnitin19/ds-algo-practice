import java.util.ArrayList;
class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        //creating course graph
        GraphNode[] CourseGraph=new GraphNode[numCourses];
        for(int i=0;i<prerequisites.length;i++){
            //creating parent course graph node if not exists
            if(CourseGraph[prerequisites[i][1]]==null){
                CourseGraph[prerequisites[i][1]]=new GraphNode(prerequisites[i][1]);
            }
            //creating child course graph node if not exists
            if(CourseGraph[prerequisites[i][0]]==null){
                CourseGraph[prerequisites[i][0]]=new GraphNode(prerequisites[i][0]);
            }
            CourseGraph[prerequisites[i][1]].addDependant(CourseGraph[prerequisites[i][0]]);
        }
        
        GraphNode[] TopologicalOrder=new GraphNode[numCourses];
        int currIndex=findNodesWithZeroDependency(CourseGraph,TopologicalOrder,0);
        while(currIndex<CourseGraph.length){
            if(TopologicalOrder[currIndex]==null){
                return false;
            }
        }
        
        return true;
    }
    
    public int findNodesWithZeroDependency(GraphNode[] CourseGraph,GraphNode[] TopologicalOrder, int currIndex){
        for(int i=0;i<CourseGraph.length;i++){
            if(CourseGraph[i].noOfDependencies==0){
                TopologicalOrder[currIndex]=CourseGraph[i];
                currIndex++;
                
            }
        }
        return currIndex;
    }
}

class GraphNode{
    int noOfDependencies,courseNo;
    public GraphNode(int courseNo){
        this.courseNo=courseNo;
        this.noOfDependencies=0;   
    }
    ArrayList<GraphNode> dependants=new ArrayList<GraphNode>();
    public void addDependant(GraphNode course){
        this.dependants.add(course);
        course.noOfDependencies++;
    }
}