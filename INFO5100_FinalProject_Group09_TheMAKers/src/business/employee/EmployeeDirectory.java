/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package business.employee;

import java.util.ArrayList;

/**
 * @desc Directory managing all Employee instances inside an Organization.
 * @author Kinder Izzo Celemin
 */
public class EmployeeDirectory {
    private ArrayList<Employee> employeeList;

    public EmployeeDirectory() {
        this.employeeList = new ArrayList<>();
    }

    public ArrayList<Employee> getEmployeeList() {
        return employeeList;
    }

    public Employee createEmployee(String name, String email, int age) {
        Employee employee = new Employee(name, email, age);
        employeeList.add(employee);
        return employee;
    }
}
