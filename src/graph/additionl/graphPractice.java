package graph.additionl;

import java.util.*;

public class graphPractice {

    public static void main(String[] args) {

    }

    List<String> bfs(Map<String, List<String>> graph, String start){

        List<String> results =  new ArrayList<>();
        Queue<String> queue = new LinkedList<>();
        Set<String>  visited = new HashSet<>();

        queue.add(start);
        visited.add(start);

        // Find the neighbour

         while (!queue.isEmpty()){
             String current = queue.poll();
             results.add(current);


              for(String neighbour: graph.getOrDefault(current , new ArrayList<>()))
             {
                 if(!visited.contains(neighbour)){
                     queue.add(neighbour);
                     visited.add(neighbour);
                 }
             }
         }




        return null;
    }

}
