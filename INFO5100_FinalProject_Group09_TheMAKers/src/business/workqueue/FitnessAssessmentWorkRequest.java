/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package business.workqueue;

import business.domain.CustomerProfile;


/**
 * @desc 
 * @author Kinder Izzo Celemin
 */

public class FitnessAssessmentWorkRequest extends WorkRequest {

    private CustomerProfile customer;
    private String fitnessGoal;
    private String recommendedEquipmentCategory;
    private int weeklyTargetHours;

    public CustomerProfile getCustomer() {
        return customer;
    }

    public void setCustomer(CustomerProfile customer) {
        this.customer = customer;
    }

    public String getFitnessGoal() {
        return fitnessGoal;
    }

    public void setFitnessGoal(String fitnessGoal) {
        this.fitnessGoal = fitnessGoal;
    }

    public String getRecommendedEquipmentCategory() {
        return recommendedEquipmentCategory;
    }

    public void setRecommendedEquipmentCategory(String cat) {
        this.recommendedEquipmentCategory = cat;
    }

    public int getWeeklyTargetHours() {
        return weeklyTargetHours;
    }

    public void setWeeklyTargetHours(int hours) {
        this.weeklyTargetHours = hours;
    }
}
