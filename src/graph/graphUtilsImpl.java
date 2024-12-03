package graph;

import java.util.*;

public class graphUtilsImpl implements graphUtils {
    @Override
    public List<String> bfs(Map<String, List<String>> graph, String start) {

        List<String> result = new ArrayList<>();
        Queue<String> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();

        queue.add(start);
        visited.add(start);

        while( !queue.isEmpty()){
            String current = queue.poll();
            result.add(current);

            for(String neighbor:  graph.getOrDefault(current, new ArrayList<>()) ){
                if(!visited.contains(neighbor)){
                    queue.add(neighbor);
                    visited.add(neighbor);
                }
            }
        }

        return result;
    }
}
