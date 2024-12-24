package stream.student;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StudentUtilImpl implements StudentUtil {

    /**
     * Finds the student with the highest average score.
     *
     * @param studentsMap A map where the key is the student's name and the value is a list of their scores.
     * @return A string containing the name of the student and their average score.
     * @throws IllegalArgumentException if the input map is null, empty, or all students have invalid scores.
     */
    @Override
    public String findTheStudentWithHighestAverageScore(Map<String, List<Double>> studentsMap) {
        // Step 1: Validate input
        if (studentsMap == null || studentsMap.isEmpty()) {
            throw new IllegalArgumentException("Students map cannot be null or empty.");
        }

        double highestAverage = Double.NEGATIVE_INFINITY;
        String highestStudent = null;
        boolean validScoresFound = false; // Flag to track if we have at least one valid student with scores

        // Step 2: Iterate through the map
        for (Map.Entry<String, List<Double>> entry : studentsMap.entrySet()) {
            String student = entry.getKey();
            List<Double> scores = entry.getValue();

            // Skip invalid entries (null or empty scores)
            if (scores == null || scores.isEmpty()) {
                continue;
            }

            validScoresFound = true; // Valid scores exist
            double currentAverage = scores.stream()
                    .mapToDouble(Double::doubleValue)
                    .average()
                    .orElse(0.0);

            if (currentAverage > highestAverage) {
                highestAverage = currentAverage;
                highestStudent = student;
            }
        }

        // Step 3: Handle edge case where no valid scores are found
        if (!validScoresFound) {
            throw new IllegalArgumentException("All students have invalid or empty scores.");
        }

        return highestStudent + " with an average score of " + highestAverage;
    }

    public static void main(String[] args) {
        // Step 1: Create an instance of the utility class
        StudentUtil studentUtil = new StudentUtilImpl();

        // Step 2: Prepare test data
        Map<String, List<Double>> studentsMap = new HashMap<>();
        studentsMap.put("Dinuk", List.of(33.00, 55.00, 33.00));
        studentsMap.put("Ayesha", List.of(90.00, 85.00, 95.00));
        studentsMap.put("John", List.of(75.00, 80.00, 70.00));
        studentsMap.put("Lily", List.of(60.00, 65.00, 70.00));
        studentsMap.put("Ravi", List.of(88.00, 92.00, 91.00));
        studentsMap.put("NoScores", List.of()); // Invalid student with no scores
        studentsMap.put("InvalidScores", null); // Null scores entry

        // Step 3: Print the result
        try {
            System.out.println("Name of the student with the highest benchmark score as a little king: "
                    + studentUtil.findTheStudentWithHighestAverageScore(studentsMap));
        } catch (IllegalArgumentException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}
