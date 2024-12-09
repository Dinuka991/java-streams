package graph;

import java.util.List;
import java.util.Map;

public interface graphUtils {
    // Method to perform BFS traversal
    List<String> bfs(Map<String, List<String>> graph, String start);
}
