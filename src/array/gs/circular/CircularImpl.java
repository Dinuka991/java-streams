package array.gs.circular;

import java.util.ArrayList;
import java.util.List;

public class CircularImpl implements Circular {
    @Override
    public int findTheSurvivor(int n, int k) {
        // Initialize the list with n people
        List<Integer> people = new ArrayList<>();
        for (int i = 1; i <= n; i++) { // Fix: Populate the list with n elements (1 to n)
            people.add(i);
        }

        int index = 0; // Start at the first person (0-based indexing)

        // Loop until only one person remains
        while (people.size() > 1) {
            index = (index + k - 1) % people.size(); // Find the k-th person to eliminate
            people.remove(index); // Remove the k-th person
        }

        return people.get(0); // Return the last remaining person
    }

    public static void main(String[] args) {
        Circular circular = new CircularImpl();

        // Example: n = 6 people, k = 2 (every 2nd person is eliminated)
        System.out.println(circular.findTheSurvivor(6, 2)); // Output should be 5
    }
}
