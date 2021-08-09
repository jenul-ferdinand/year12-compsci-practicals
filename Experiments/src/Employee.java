public class Employee {
    String name;
    int age;
    String role;
    double salary;

    public Employee (String name, int age, String role, double salary) {
        this.name = name;
        this.age = age;
        this.role = role;
        this.salary = salary;
    }

    public void employeeAge(int age) {
        this.age = age;
    }

    public void employeeRole(String role) {
        this.role = role;
    }

    public String getEmployeeRole() {
        return this.role;
    }

    public void employeeSalary(double salary) {
        this.salary = salary;
    }
}
