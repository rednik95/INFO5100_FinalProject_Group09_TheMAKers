/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package business.domain;

/**
 * @desc Represents a GoodLife club member. Implements non-destructive
 * soft-deletion (deactivateCustomer) to preserve audit history.
 * @author Kinder Izzo Celemin
 */
public class CustomerProfile {
    private String customerId;
    private String fullName;
    private String email;
    private int age;
    private String status; // "Active" or "Inactive" (Soft-Delete state)
    private SubscriptionPlan activePlan;
    private int totalRentalsCount;
    private static int counter = 1001;

    public CustomerProfile(String fullName, String email, int age, SubscriptionPlan activePlan) {
        this.customerId = "CUST-" + (counter++);
        this.fullName = fullName;
        this.email = email;
        this.age = age;
        this.status = "Active";
        this.activePlan = activePlan;
        this.totalRentalsCount = 0;
    }

    /**
     * Soft-deletes the customer by transitioning status to "Inactive" without
     * breaking WorkRequest references.
     */
    public void deactivateCustomer() {
        this.status = "Inactive";
    }

    public void incrementRentalsCount() {
        this.totalRentalsCount++;
    }

    public String getCustomerId() {
        return customerId;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
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

    public String getStatus() {
        return status;
    }

    public SubscriptionPlan getActivePlan() {
        return activePlan;
    }

    public void setActivePlan(SubscriptionPlan activePlan) {
        this.activePlan = activePlan;
    }

    public int getTotalRentalsCount() {
        return totalRentalsCount;
    }

    @Override
    public String toString() {
        return customerId + " - " + fullName;
    }
}
