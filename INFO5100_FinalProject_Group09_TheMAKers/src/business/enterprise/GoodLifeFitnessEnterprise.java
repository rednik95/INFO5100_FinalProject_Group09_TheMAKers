/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package business.enterprise;

import business.domain.CustomerProfile;
import business.domain.SubscriptionPlan;
import business.role.EnterpriseAdminRole;
import business.role.Role;
import java.util.ArrayList;

/**
 * @desc Enterprise 1: GoodLife Fitness Club Enterprise. Manages customer 
 * profiles, subscription plans, and franchisee revenue-share math.
 * 
 * @author Kinder Izzo Celemin
 */
public class GoodLifeFitnessEnterprise extends Enterprise {

    private ArrayList<CustomerProfile> customerDirectory;
    private ArrayList<SubscriptionPlan> subscriptionCatalog;
    private ArrayList<String> franchiseClubs;
    private double franchiseRevenueShareRate;

    public GoodLifeFitnessEnterprise(String name) {
        super(name, EnterpriseType.GoodLifeFitness);
        this.customerDirectory = new ArrayList<>();
        this.subscriptionCatalog = new ArrayList<>();
        this.franchiseClubs = new ArrayList<>();
        this.franchiseRevenueShareRate = 0.25;
    }

    public double calculateFranchiseRevenueShare(double totalRev) {
        return totalRev * franchiseRevenueShareRate;
    }

    public ArrayList<CustomerProfile> getCustomerDirectory() {
        return customerDirectory;
    }

    public ArrayList<SubscriptionPlan> getSubscriptionCatalog() {
        return subscriptionCatalog;
    }

    public ArrayList<String> getFranchiseClubs() {
        return franchiseClubs;
    }

    public double getFranchiseRevenueShareRate() {
        return franchiseRevenueShareRate;
    }

    public void setFranchiseRevenueShareRate(double rate) {
        this.franchiseRevenueShareRate = rate;
    }

    @Override
    public ArrayList<Role> getSupportedRole() {
        ArrayList<Role> roles = new ArrayList<>();
        roles.add(new EnterpriseAdminRole());
        return roles;
    }
}