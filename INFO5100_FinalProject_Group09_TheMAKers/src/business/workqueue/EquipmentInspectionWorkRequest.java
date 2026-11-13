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
public class EquipmentInspectionWorkRequest extends WorkRequest {

    private EquipmentUnit equipmentUnit;
    private String preRentalCondition;
    private String postRentalCondition;
    private boolean isSafetyPassed;
    private String technicianNotes;

    public EquipmentUnit getEquipmentUnit() {
        return equipmentUnit;
    }

    public void setEquipmentUnit(EquipmentUnit unit) {
        this.equipmentUnit = unit;
    }

    public String getPreRentalCondition() {
        return preRentalCondition;
    }

    public void setPreRentalCondition(String cond) {
        this.preRentalCondition = cond;
    }

    public String getPostRentalCondition() {
        return postRentalCondition;
    }

    public void setPostRentalCondition(String cond) {
        this.postRentalCondition = cond;
    }

    public boolean isSafetyPassed() {
        return isSafetyPassed;
    }

    public void setSafetyPassed(boolean passed) {
        this.isSafetyPassed = passed;
    }

    public String getTechnicianNotes() {
        return technicianNotes;
    }

    public void setTechnicianNotes(String notes) {
        this.technicianNotes = notes;
    }
}
