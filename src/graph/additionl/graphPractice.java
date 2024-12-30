package graph.additionl;

import java.util.*;

public class graphPractice {

    public static void main(String[] args) {

    }

    List<String> bfs(Map<String, List<String>> graph, String start){

        List<String> result = new ArrayList<>();
        Queue<String> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();

        queue.add(start);
        visited.add(start);

        while (!queue.isEmpty()) {
            String  current = queue.poll();
            result.add(current);


            for(String  neighbour: graph.getOrDefault(current, new ArrayList<>())) {
                if (!visited.contains(neighbour)){
                    queue.add(neighbour);
                    visited.add(neighbour);
                }

            }
        }

        return null;
    }

}
