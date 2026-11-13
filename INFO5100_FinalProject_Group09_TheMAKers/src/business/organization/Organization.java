/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package business.organization;

import business.employee.EmployeeDirectory;
import business.role.Role;
import business.useraccount.UserAccountDirectory;
import business.workqueue.WorkQueue;
import java.util.ArrayList;

/**
 * @desc Abstract base class for all organizational units, enterprises, and the
 * root EcoSystem. Provides a dedicated WorkQueue, EmployeeDirectory, and
 * UserAccountDirectory
 * 
 * @author Kinder Izzo Celemin
 */
public abstract class Organization {
    private int organizationID;
    private String name;
    private WorkQueue workQueue;
    private EmployeeDirectory employeeDirectory;
    private UserAccountDirectory userAccountDirectory;
    private static int counter = 1;

    public enum Type {
        MemberSubscription("Member Subscriptions Organization"),
        ClubFloorOperations("Club Floor Operations Organization"),
        EquipmentCatalogAndRental("Equipment Catalog & Rental Organization"),
        EquipmentInspectionAndRepair("Equipment Inspection & Repair Organization"),
        RegionalDeliveryDispatch("Regional Delivery Dispatch Organization"),
        WellnessAndDamageClaims("Wellness & Damage Claims Organization");

        private String value;

        private Type(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }
    }

    public Organization(String name) {
        this.name = name;
        this.workQueue = new WorkQueue();
        this.employeeDirectory = new EmployeeDirectory();
        this.userAccountDirectory = new UserAccountDirectory();
        this.organizationID = counter++;
    }

    /**
     * Polymorphic method implemented by subclasses to declare valid roles for
     * this organization.
     * @return 
     */
    public abstract ArrayList<Role> getSupportedRole();

    public int getOrganizationID() {
        return organizationID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public WorkQueue getWorkQueue() {
        return workQueue;
    }

    public EmployeeDirectory getEmployeeDirectory() {
        return employeeDirectory;
    }

    public UserAccountDirectory getUserAccountDirectory() {
        return userAccountDirectory;
    }

    @Override
    public String toString() {
        return name;
    }
}
