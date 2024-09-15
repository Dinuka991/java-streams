package stream;

import java.util.*;
import java.util.stream.Collectors;

public class StreamUtils {

    // Find the employee with the highest salary
    public static Employee employeeWithHighestSalary(List<Employee> employeeList) {
        return employeeList.stream()
                .max(Comparator.comparing(Employee::getSalary))
                .orElseThrow(null);
    }

    // Sort a list of employees by age
    public static List<Employee> sortEmployeeByAge(List<Employee> employeeList) {
        return employeeList.stream()
                .sorted(Comparator.comparing(Employee::getAge))
                .toList();
    }

    // Sort a list of employees by age in descending order
    public static List<Employee> sortEmployeeByAgeDesc(List<Employee> employeeList) {
        return employeeList.stream()
                .sorted(Comparator.comparing(Employee::getAge).reversed())
                .toList();
    }

    // Group employees by department and find the average salary in each department
    public static Map<String, Double> findByDepartment(List<Employee> employeeList) {
        return employeeList.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment, Collectors.averagingDouble(Employee::getSalary)));
    }

    // Convert a list of employees into a map where the key is the employee's ID and the value is the employee object
    public static Map<Integer, Employee> integerEmployeeMap(List<Employee> employeeList) {
        return employeeList.stream()
                .collect(Collectors.toMap(Employee::getId, employee -> employee));
    }

    // Filter employees who have a salary greater than a specific threshold
    public static List<Employee> findBySalary(List<Employee> employeeList, double salary) {
        return employeeList.stream()
                .filter(employee -> employee.getSalary() > salary)
                .toList();
    }

    // Flatten the list of departments to get all employees
    public static List<Employee> findAllByDepartment(List<Department> departments) {
        return departments.stream()
                .flatMap(department -> department.getEmployees().stream())
                .toList();
    }

    // Calculate the sum of all employee salaries
    public static double calculateSumOfSalaries(List<Employee> employeeList) {
        return employeeList.stream()
                .map(Employee::getSalary)
                .reduce(0.00, Double::sum);
    }

    // Find the employee with the second-highest salary
    public static Optional<Employee> findTheEmployeeWithSecondHighestSalary(List<Employee> employeeList) {
        return employeeList.stream()
                .sorted(Comparator.comparing(Employee::getSalary).reversed())
                .skip(1)
                .findFirst();
    }

    // Find employees by name
    public static List<Employee> findEmployeesByName(List<Employee> employeeList, String name) {
        return employeeList.stream()
                .filter(employee -> employee.getName().equalsIgnoreCase(name))
                .toList();
    }

    // Find employees by department
    public static List<Employee> findEmployeesByDepartment(List<Employee> employeeList, String department) {
        return employeeList.stream()
                .filter(employee -> employee.getDepartment().equalsIgnoreCase(department))
                .toList();
    }

    // Find employees within a specific age range
    public static List<Employee> findEmployeesByAgeRange(List<Employee> employeeList, int minAge, int maxAge) {
        return employeeList.stream()
                .filter(employee -> employee.getAge() >= minAge && employee.getAge() <= maxAge)
                .toList();
    }

    // Find employees within a specific salary range
    public static List<Employee> findEmployeesBySalaryRange(List<Employee> employeeList, double minSalary, double maxSalary) {
        return employeeList.stream()
                .filter(employee -> employee.getSalary() >= minSalary && employee.getSalary() <= maxSalary)
                .toList();
    }
}
