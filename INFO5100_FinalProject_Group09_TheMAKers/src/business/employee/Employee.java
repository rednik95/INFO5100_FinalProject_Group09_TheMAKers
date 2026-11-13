/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package business.employee;

/**
 * @desc Represents a staff member or administrator within an Organization or
 * Enterprise.
 * @author Kinder Izzo Celemin
 */
public class Employee {

    private int id;
    private String name;
    private String email;
    private int age;
    private static int count = 1000;

    public Employee(String name, String email, int age) {
        this.id = count++;
        this.name = name;
        this.email = email;
        this.age = age;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return name;
    }
}
