/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package business.workqueue;

import business.domain.CustomerProfile;

/**
 *
 * @author Kinder Izzo Celemin
 */
public class WellnessSubsidyClaimWorkRequest extends WorkRequest {

    private CustomerProfile member;
    private String insurancePolicyNumber;
    private double requestedSubsidyAmount;
    private float approvedSubsidyRate;
    private boolean isPolicyVerified;

    public CustomerProfile getMember() {
        return member;
    }

    public void setMember(CustomerProfile member) {
        this.member = member;
    }

    public String getInsurancePolicyNumber() {
        return insurancePolicyNumber;
    }

    public void setInsurancePolicyNumber(String policy) {
        this.insurancePolicyNumber = policy;
    }

    public double getRequestedSubsidyAmount() {
        return requestedSubsidyAmount;
    }

    public void setRequestedSubsidyAmount(double amt) {
        this.requestedSubsidyAmount = amt;
    }

    public float getApprovedSubsidyRate() {
        return approvedSubsidyRate;
    }

    public void setApprovedSubsidyRate(float rate) {
        this.approvedSubsidyRate = rate;
    }

    public boolean isPolicyVerified() {
        return isPolicyVerified;
    }

    public void setPolicyVerified(boolean verified) {
        this.isPolicyVerified = verified;
    }
}
