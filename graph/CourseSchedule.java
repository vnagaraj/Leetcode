package graph;

import java.util.ArrayList;
/**
 * Created by VGN on 12/10/15.
 *
 *  There are a total of n courses you have to take, labeled from 0 to n - 1.
 *  Some courses may have prerequisites, for example to take course 0 you have to first take course 1, which is
 *  expressed as a pair: [0,1]
 */
public class CourseSchedule {

    private int counter;
    /*
    Given the total number of courses and a list of prerequisite pairs, is it possible for you to finish all courses?
    For example:
    2, [[1,0]]
    There are a total of 2 courses to take. To take course 1 you should have finished course 0. So it is possible.
    2, [[1,0],[0,1]]
    There are a total of 2 courses to take. To take course 1 you should have finished course 0, and to take course
    0 you should also have finished course 1. So it is impossible.
     */
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        if (prerequisites.length == 0){
            return true;
        }
        int[][] adjList  = adjList(numCourses, prerequisites);
        return this.canFinish(adjList, numCourses);
    }


    /*
    Given the total number of courses and a list of prerequisite pairs, return the ordering of courses you should
    take to finish all courses.
    There may be multiple correct orders, you just need to return one of them.
    If it is impossible to finish all courses, return an empty array.
    For example:
    2, [[1,0]]
    There are a total of 2 courses to take. To take course 1 you should have finished course 0.
    So the correct course order is [0,1]
    4, [[1,0],[2,0],[3,1],[3,2]]
    There are a total of 4 courses to take. To take course 3 you should have finished both courses 1 and 2.
    Both courses 1 and 2 should be taken after you finished course 0. So one correct course order is [0,1,2,3].
    Another correct ordering is[0,2,1,3].
     */
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[][] adjList  = adjList(numCourses, prerequisites);
        if (!canFinish(adjList, numCourses)){
            return new int[0];
        }
        boolean[] marked = new boolean[numCourses];
        int[] topOrder = new int[numCourses];
        counter = numCourses -1;
        for (int i=0; i < numCourses; i++){
            if (!marked[i]){
                dfs(i, adjList, topOrder, marked);
            }
        }
        return topOrder;
    }

    private void dfs(int vertex, int[][] adjList, int[] topOrder, boolean[] marked){
        marked[vertex] = true;
        for (int i=0; i < adjList[vertex].length; i++ ){
            if (!marked[adjList[vertex][i]]){
                dfs(adjList[vertex][i], adjList, topOrder, marked);
            }
        }
        //System.out.println("Counter " + counter);
        topOrder[counter--] = vertex;
    }

    private boolean canFinish(int[][] adjList, int numCourses) {
        boolean[] marked = null;
        for (int i=0; i < numCourses; i++){
            marked = new boolean[numCourses];
            boolean cycle = isDfsCycle(i, adjList, marked);
            if (!cycle)
                return false;
        }
        return true;
    }

    private boolean isDfsCycle(int startVertex, int[][] adjList, boolean[] marked){
        if (marked[startVertex]){
            return false;
        }
        else{
            marked[startVertex] = true;
        }
        for (int i=0; i < adjList[startVertex].length; i++){
            boolean verify = isDfsCycle(adjList[startVertex][i], adjList, marked);
            if (! verify){
                return verify;
            }
        }
        //backtracking step
        marked[startVertex] = false;
        return true;
    }

    private int[][] adjList(int numCourses, int[][] prerequisites){
        ArrayList<Integer>[] vertexList = (ArrayList<Integer>[])new ArrayList[numCourses];
        for (int i=0; i < vertexList.length ; i++){
            vertexList[i] = new ArrayList<Integer>();
        }
        for (int i=0; i < prerequisites.length; i++){
            int [] edgeList = prerequisites[i];
            int vertex1 = edgeList[0];
            int vertex2 = edgeList[1];
            vertexList[vertex2].add(vertex1);
        }
        //convert to 2d array
        int[][] adjList = new int[numCourses][];
        for (int i=0; i < adjList.length; i++){
            Integer[] integerObjArray = new Integer[vertexList[i].size()];
            integerObjArray = vertexList[i].toArray(integerObjArray);
            adjList[i] = new int[integerObjArray.length];
            for (int j = 0; j < integerObjArray.length; j++) {
                adjList[i][j] = Integer.valueOf(integerObjArray[j]);
            }
        }
        return adjList;
    }

}
