/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package business.domain;

/**
 * @desc Represents a GoodLife membership tier with primitive types double,
 * float, and int.
 * 
 * @author Kinder Izzo Celemin
 */
public class SubscriptionPlan {
    private String planId;
    private String planName;
    private double monthlyPrice;
    private float discountPercentage; // e.g., 0.15f for 15% discount
    private int validityMonths;
    private static int counter = 101;

    public SubscriptionPlan(String planName, double monthlyPrice, float discountPercentage, int validityMonths) {
        this.planId = "PLAN-" + (counter++);
        this.planName = planName;
        this.monthlyPrice = monthlyPrice;
        this.discountPercentage = discountPercentage;
        this.validityMonths = validityMonths;
    }

    /**
     * @desc Calculates net monthly subscription price after applying promotional or
     * wellness discounts.
     * @return 
     */
    public double calculateNetPrice() {
        return monthlyPrice * (1.0 - discountPercentage);
    }

    public String getPlanId() {
        return planId;
    }

    public String getPlanName() {
        return planName;
    }

    public double getMonthlyPrice() {
        return monthlyPrice;
    }

    public float getDiscountPercentage() {
        return discountPercentage;
    }

    public void setDiscountPercentage(float discountPercentage) {
        this.discountPercentage = discountPercentage;
    }

    public int getValidityMonths() {
        return validityMonths;
    }

    @Override
    public String toString() {
        return planName + " ($" + String.format("%.2f", calculateNetPrice()) + "/mo)";
    }
}
