/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package business.enterprise;

import business.organization.Organization;
import business.organization.OrganizationDirectory;

/**
 * @desc Abstract Enterprise class extending Organization. Holds an
 * OrganizationDirectory to manage internal departments.
 * 
 * @author Kinder Izzo Celemin
 */
public abstract class Enterprise extends Organization {

    private EnterpriseType enterpriseType;
    private OrganizationDirectory organizationDirectory;

    public enum EnterpriseType {
        GoodLifeFitness("GoodLife Fitness Club Enterprise"),
        FlexGearEquipment("FlexGear Equipment & Maintenance Enterprise"),
        LogisticsAndInsurance("Logistics & Wellness Protection Enterprise");

        private String value;

        private EnterpriseType(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }
    }

    public Enterprise(String name, EnterpriseType type) {
        super(name);
        this.enterpriseType = type;
        this.organizationDirectory = new OrganizationDirectory();
    }

    public EnterpriseType getEnterpriseType() {
        return enterpriseType;
    }

    public OrganizationDirectory getOrganizationDirectory() {
        return organizationDirectory;
    }
}
