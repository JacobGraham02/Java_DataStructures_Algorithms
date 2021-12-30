package Topics;

import java.util.function.Function;

public class Employee  {

    private String first_name, last_name;
    private int salary, employeeNum;

    public Employee(final int employeeNum, final String firstName, final String lastName, final int salary) {
        setEmployeeNum(employeeNum);
        setFirst_name(firstName);
        setLast_name(lastName);
        setEmployeeSalary(salary);
    }

    public Employee() {
        this(0, "Default employee first name", "Default employee last name", 0);
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public int getEmployeeSalary() {
        return salary;
    }

    public void setEmployeeSalary(int salary) {
        this.salary = salary;
    }

    public int getEmployeeNum() {
        return employeeNum;
    }

    public void setEmployeeNum(int employeeNum) {
        this.employeeNum = employeeNum;
    }

    public String toString() {
        return String.format("First name: %s \n Last name: %s \n Employee number: %d \n Employee salary: %d\n",
                getFirst_name(), getLast_name(), getEmployeeNum(), getEmployeeSalary());
    }
}
