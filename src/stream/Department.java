package stream;

import java.util.List;

public class Department {
    private String departmentName;
    private List<Employee> employees;

    public Department(String departmentName, List<Employee> employees) {
        this.departmentName = departmentName;
        this.employees = employees;
    }

    public List<Employee> getEmployees() {
        return employees;
    }
}
