package stream._16112024;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Demo {

    public static void main(String[] args) {
        // Test cases can be added here to demonstrate functionality
    }

    /**
     * Find the maximum salary from the employee list.
     *
     * @param employeeList List of employees.
     * @return Maximum salary or 0.0 if the list is empty.
     */
    public static double findMaxSalary(List<Employee> employeeList) {
        return employeeList.stream()
                .max(Comparator.comparing(Employee::getSalary))
                .map(Employee::getSalary)
                .orElse(0.0);
    }

    /**
     * Sort employees by age in ascending order.
     *
     * @param employeeList List of employees.
     * @return List of employees sorted by age.
     */
    public List<Employee> sortEmployeesByAge(List<Employee> employeeList) {
        return employeeList.stream()
                .sorted(Comparator.comparing(Employee::getAge))
                .toList();
    }

    /**
     * Sort employees by age in descending order.
     *
     * @param employeeList List of employees.
     * @return List of employees sorted by age in descending order.
     */
    public List<Employee> sortEmployeesByAgeDesc(List<Employee> employeeList) {
        return employeeList.stream()
                .sorted(Comparator.comparing(Employee::getAge).reversed())
                .toList();
    }

    /**
     * Group employees by their department.
     *
     * @param employeeList List of employees.
     * @return A map where the key is the department and the value is the list of employees in that department.
     */
    public Map<String, List<Employee>> groupEmployeesByDepartment(List<Employee> employeeList) {
        return employeeList.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment));
    }

    /**
     * Group employees by department and calculate the average salary in each department.
     *
     * @param employeeList List of employees.
     * @return A map where the key is the department and the value is the average salary in that department.
     */
    public Map<String, Double> calculateAverageSalaryByDepartment(List<Employee> employeeList) {
        return employeeList.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment, Collectors.averagingDouble(Employee::getSalary)));
    }

    /**
     * Find the employee with the second-highest salary.
     *
     * @param employeeList List of employees.
     * @return Employee with the second-highest salary or null if the list has fewer than 2 employees.
     */
    public Employee findSecondHighestSalary(List<Employee> employeeList) {
        return employeeList.stream()
                .sorted(Comparator.comparing(Employee::getSalary).reversed())
                .skip(1)
                .findFirst()
                .orElse(null);
    }
}
