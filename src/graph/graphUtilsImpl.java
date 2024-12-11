package graph;

import java.util.*;

public class graphUtilsImpl implements graphUtils {

    @Override
    public List<String> bfs(Map<String, List<String>> graph, String start) {
        List<String> result = new ArrayList<>(); // To store the BFS traversal result
        Queue<String> queue = new LinkedList<>(); // Queue to keep track of nodes to visit
        Set<String> visited = new HashSet<>(); // Set to keep track of visited nodes

        // Add the starting node to the queue and mark it as visited
        queue.add(start);
        visited.add(start);

        // Process the nodes in the queue
        while (!queue.isEmpty()) {
            String current = queue.poll(); // Remove the front node from the queue
            result.add(current); // Add the node to the result list

            // Add all unvisited neighbors of the current node to the queue
            for (String neighbor : graph.getOrDefault(current, new ArrayList<>())) {
                if (!visited.contains(neighbor)) {
                    queue.add(neighbor); // Add to queue
                    visited.add(neighbor); // Mark as visited
                }
            }
        }

        return result; // Return the BFS traversal result
    }

    // Main method to demonstrate the BFS
    public static void main(String[] args) {
        graphUtils graphUtil = new graphUtilsImpl(); // Create an instance of graphUtilsImpl

        // Create a sample graph
        Map<String, List<String>> graph = new HashMap<>();
        graph.put("A", Arrays.asList("B", "C"));
        graph.put("B", Arrays.asList("A", "D", "E"));
        graph.put("C", Arrays.asList("A", "F"));
        graph.put("D", Arrays.asList("B"));
        graph.put("E", Arrays.asList("B", "F"));
        graph.put("F", Arrays.asList("C", "E"));

        String startNode = "A"; // Starting node for BFS

        // Perform BFS and print the result
        List<String> bfsResult = graphUtil.bfs(graph, startNode);
        System.out.println("BFS Traversal starting from " + startNode + ": " + bfsResult);
    }
}
