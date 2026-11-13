/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package business.enterprise;

import business.domain.EquipmentCatalog;
import business.domain.EquipmentUnit;
import business.role.EnterpriseAdminRole;
import business.role.Role;
import java.util.ArrayList;

/**
 * @desc Enterprise 2: FlexGear Equipment & Maintenance Enterprise
 * Maintains the central catalog of approved models, serialized
 * unit inventory, and utilization rates.
 * 
 * @author Astrid Noizillier
 */
public class FlexGearEquipmentEnterprise extends Enterprise {

    private EquipmentCatalog equipmentCatalog;
    private ArrayList<EquipmentUnit> unitInventory;

    public FlexGearEquipmentEnterprise(String name) {
        super(name, EnterpriseType.FlexGearEquipment);
        this.equipmentCatalog = new EquipmentCatalog();
        this.unitInventory = new ArrayList<>();
    }

    /**
     * Filters and returns only available, non-deactivated serialized units
     * matching a category.
     * @param category
     * @return 
     */
    public ArrayList<EquipmentUnit> getAvailableUnitsByCategory(String category) {
        ArrayList<EquipmentUnit> available = new ArrayList<>();
        for (EquipmentUnit unit : unitInventory) {
            if (unit.isAvailable() && !"Inactive".equalsIgnoreCase(unit.getCurrentCondition())
                    && unit.getModel().getCategoryName().equalsIgnoreCase(category)) {
                available.add(unit);
            }
        }
        return available;
    }

    /**
     * Calculates equipment utilization rate as a float (Rented Days / Total
     * Available Days).
     * @param rentedDays
     * @param totalDays
     * @return 
     */
    public float calculateUtilizationRate(int rentedDays, int totalDays) {
        if (totalDays <= 0) {
            return 0.0f;
        }
        return (float) rentedDays / (float) totalDays;
    }

    public EquipmentCatalog getEquipmentCatalog() {
        return equipmentCatalog;
    }

    public ArrayList<EquipmentUnit> getUnitInventory() {
        return unitInventory;
    }

    @Override
    public ArrayList<Role> getSupportedRole() {
        ArrayList<Role> roles = new ArrayList<>();
        roles.add(new EnterpriseAdminRole());
        return roles;
    }
}
