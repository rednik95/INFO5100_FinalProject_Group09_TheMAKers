/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package business.domain;

/**
 * @desc Represents a physical, serialized piece of fitness hardware (e.g.,
 * SN-ROW-8821). Tracks mechanical condition, safety availability, and
 * inspection dates.
 * 
 * @author Kinder Izzo Celemin
 */
public class EquipmentUnit {
    private String serialNumber;
    private EquipmentModel model;
    private String currentCondition; // "New", "Excellent", "Good", "Damaged", "Inactive"
    private boolean isAvailable;
    private String lastInspectionDate;
    private int totalRentedDays;

    public EquipmentUnit(String serialNumber, EquipmentModel model, String currentCondition, boolean isAvailable, String lastInspectionDate) {
        this.serialNumber = serialNumber;
        this.model = model;
        this.currentCondition = currentCondition;
        this.isAvailable = isAvailable;
        this.lastInspectionDate = lastInspectionDate;
        this.totalRentedDays = 0;
    }

    /**
     * @desc Updates the unit's physical condition and availability flag after a
     * technical inspection or soft-delete.
     * @param cond
     * @param avail
     */
    public void updateCondition(String cond, boolean avail) {
        this.currentCondition = cond;
        this.isAvailable = avail;
    }

    public void addRentedDays(int days) {
        this.totalRentedDays += days;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public EquipmentModel getModel() {
        return model;
    }

    public String getCurrentCondition() {
        return currentCondition;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public String getLastInspectionDate() {
        return lastInspectionDate;
    }

    public void setLastInspectionDate(String date) {
        this.lastInspectionDate = date;
    }

    public int getTotalRentedDays() {
        return totalRentedDays;
    }

    @Override
    public String toString() {
        return serialNumber + " [" + model.getModelName() + "]";
    }
}
