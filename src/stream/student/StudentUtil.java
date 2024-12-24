package stream.student;

import java.util.List;
import java.util.Map;

public interface StudentUtil {

    String findTheStudentWithHighestAverageScore(Map<String, List<Double>> studentsMap);
}
