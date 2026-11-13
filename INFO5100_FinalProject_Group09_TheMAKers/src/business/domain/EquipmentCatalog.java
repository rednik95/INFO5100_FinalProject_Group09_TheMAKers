/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package business.domain;

import java.util.ArrayList;

/**
 * @desc Central catalog of approved EquipmentModels managed by FlexGear
 * Equipment Enterprise.
 * @author Kinder Izzo Celemin
 */
public class EquipmentCatalog {
    private ArrayList<EquipmentModel> modelList;

    public EquipmentCatalog() {
        this.modelList = new ArrayList<>();
    }

    public EquipmentModel addEquipmentModel(String name, String category, String supplier, double rate) {
        EquipmentModel model = new EquipmentModel(name, category, supplier, rate);
        modelList.add(model);
        return model;
    }

    public ArrayList<EquipmentModel> getModelList() {
        return modelList;
    }
}
