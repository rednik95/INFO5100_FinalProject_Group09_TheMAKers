/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package business.domain;

/**
 * @desc Represents an approved commercial or home-rental sports equipment model
 * in FlexGear's catalog.
 * @author Kinder Izzo Celemin
 */
public class EquipmentModel {
    private String modelId;
    private String modelName;
    private String categoryName; // "Cardio", "Strength", "Combat", "Rowing"
    private String supplierName;
    private double dailyRentalPrice;
    private static int counter = 200;

    public EquipmentModel(String modelName, String categoryName, String supplierName, double dailyRentalPrice) {
        this.modelId = "EQ-MOD-" + (counter++);
        this.modelName = modelName;
        this.categoryName = categoryName;
        this.supplierName = supplierName;
        this.dailyRentalPrice = dailyRentalPrice;
    }

    public String getModelId() {
        return modelId;
    }

    public String getModelName() {
        return modelName;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public String getSupplierName() {
        return supplierName;
    }

    public double getDailyRentalPrice() {
        return dailyRentalPrice;
    }

    @Override
    public String toString() {
        return modelName + " (" + categoryName + " - $" + dailyRentalPrice + "/day)";
    }
}
