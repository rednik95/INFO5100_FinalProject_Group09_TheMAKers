/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package business.useraccount;

import business.employee.Employee;
import business.role.Role;
import business.workqueue.WorkQueue;

/**
 * @desc Stores login credentials, assigned Role, Employee profile, and personal
 * outbound/inbound WorkQueue.
 * @author Kinder Izzo Celemin
 */
public class UserAccount {
    private String username;
    private String password;
    private Employee employee;
    private Role role;
    private WorkQueue workQueue;

    public UserAccount(String username, String password, Employee employee, Role role) {
        this.username = username;
        this.password = password;
        this.employee = employee;
        this.role = role;
        this.workQueue = new WorkQueue();
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public WorkQueue getWorkQueue() {
        return workQueue;
    }

    @Override
    public String toString() {
        return username;
    }
}
