package stream;

import java.util.*;
import java.util.stream.Collectors;

public class DemoStream {
    public static void main(String[] args) {
        List<Employee> employeeList = Arrays.asList(
                new Employee(1, "sa", 444.00, 22, "IT"),
                new Employee(2, "saman", 65645.00, 53, "IT"),
                new Employee(3, "Alex", 422343.00, 64, "Engineering"),
                new Employee(3, "Alex", 422343.00, 64, "Engineering")
        );

        List<Department> departments = Arrays.asList(
                new Department("IT", Arrays.asList(
                        new Employee(1, "sa", 444.00, 22, "IT"),
                        new Employee(2, "saman", 65645.00, 53, "IT")
                )),
                new Department("Engineering", Arrays.asList(
                        new Employee(3, "Alex", 422343.00, 64, "Engineering"),
                        new Employee(3, "Alex", 422343.00, 64, "Engineering")
                ))
        );

        // Example usage of utility methods
        System.out.println(StreamUtils.findTheEmployeeWithSecondHighestSalary(employeeList));
    }
}
