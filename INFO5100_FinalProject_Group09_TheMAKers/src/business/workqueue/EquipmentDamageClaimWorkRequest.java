/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package business.workqueue;

import business.domain.EquipmentUnit;

/**
 *
 * @author Kinder Izzo Celemin
 */
public class EquipmentDamageClaimWorkRequest extends WorkRequest {

    private EquipmentUnit damagedUnit;
    private String damageDescription;
    private double repairCostEstimate;
    private double approvedPayoutAmount;
    private boolean isClaimApproved;

    public EquipmentUnit getDamagedUnit() {
        return damagedUnit;
    }

    public void setDamagedUnit(EquipmentUnit unit) {
        this.damagedUnit = unit;
    }

    public String getDamageDescription() {
        return damageDescription;
    }

    public void setDamageDescription(String desc) {
        this.damageDescription = desc;
    }

    public double getRepairCostEstimate() {
        return repairCostEstimate;
    }

    public void setRepairCostEstimate(double cost) {
        this.repairCostEstimate = cost;
    }

    public double getApprovedPayoutAmount() {
        return approvedPayoutAmount;
    }

    public void setApprovedPayoutAmount(double payout) {
        this.approvedPayoutAmount = payout;
    }

    public boolean isClaimApproved() {
        return isClaimApproved;
    }

    public void setClaimApproved(boolean approved) {
        this.isClaimApproved = approved;
    }
}
