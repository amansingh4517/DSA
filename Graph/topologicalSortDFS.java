package Graph;

import java.util.ArrayList;

public class topologicalSortDFS {
//Topological sort is a linear ordering of vertices in a Directed Acyclic Graph (DAG) where
//for every directed edge u--->v , vertex u comes before v

//Extra storage need : adjacency list  , visited array , sorted array

public static void main(String[] args) {
    int n = 4; //number of node
    ArrayList<ArrayList<Integer>> adj = new ArrayList<>({{1},{2,5},{3,5},{5},{}});
    adj.get(0) = new ArrayList<>({1});



}
}
