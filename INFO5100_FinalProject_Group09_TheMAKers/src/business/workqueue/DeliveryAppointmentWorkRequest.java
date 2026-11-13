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
public class DeliveryAppointmentWorkRequest extends WorkRequest {

    private EquipmentUnit assignedUnit;
    private String customerAddress;
    private String postalCode;
    private String appointmentType;
    private String scheduledDate;
    private int delayHours;

    public EquipmentUnit getAssignedUnit() {
        return assignedUnit;
    }

    public void setAssignedUnit(EquipmentUnit unit) {
        this.assignedUnit = unit;
    }

    public String getCustomerAddress() {
        return customerAddress;
    }

    public void setCustomerAddress(String addr) {
        this.customerAddress = addr;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getAppointmentType() {
        return appointmentType;
    }

    public void setAppointmentType(String type) {
        this.appointmentType = type;
    }

    public String getScheduledDate() {
        return scheduledDate;
    }

    public void setScheduledDate(String date) {
        this.scheduledDate = date;
    }

    public int getDelayHours() {
        return delayHours;
    }

    public void setDelayHours(int delayHours) {
        this.delayHours = delayHours;
    }
}
