/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package business.workqueue;

import business.domain.EquipmentModel;

/**
 *
 * @author Kinder Izzo Celemin
 */
public class EquipmentRentalOrderWorkRequest extends WorkRequest {

    private String orderId;
    private String franchiseClubName;
    private EquipmentModel requestedModel;
    private int rentalDurationDays;
    private double calculatedRentalFee;
    private static int orderCounter = 5001;

    public EquipmentRentalOrderWorkRequest() {
        super();
        this.orderId = "ORD-" + (orderCounter++);
    }

    public double calculateTotalOrderFee() {
        if (requestedModel != null && rentalDurationDays > 0) {
            this.calculatedRentalFee = requestedModel.getDailyRentalPrice() * rentalDurationDays;
        }
        return this.calculatedRentalFee;
    }

    public String getOrderId() {
        return orderId;
    }

    public String getFranchiseClubName() {
        return franchiseClubName;
    }

    public void setFranchiseClubName(String name) {
        this.franchiseClubName = name;
    }

    public EquipmentModel getRequestedModel() {
        return requestedModel;
    }

    public void setRequestedModel(EquipmentModel model) {
        this.requestedModel = model;
    }

    public int getRentalDurationDays() {
        return rentalDurationDays;
    }

    public void setRentalDurationDays(int days) {
        this.rentalDurationDays = days;
    }

    public double getCalculatedRentalFee() {
        return calculatedRentalFee;
    }
}
