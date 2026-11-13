/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package business.organization;
import business.organization.Organization.Type;
import java.util.ArrayList;

/**
 * @desc Factory and directory class managing the Organizations inside an
 * Enterprise.
 * 
 * @author Kinder Izzo Celemin
 */
public class OrganizationDirectory {
    private ArrayList<Organization> organizationList;

    public OrganizationDirectory() {
        this.organizationList = new ArrayList<>();
    }

    public ArrayList<Organization> getOrganizationList() {
        return organizationList;
    }

    /**
     * @desc Instantiates one of the 6 specialized Organizations based on the provided
     *  Type.
     * @param type
     * @return 
     */
    public Organization createOrganization(Type type) {
        Organization organization = null;
        if (null != type) switch (type) {
            case MemberSubscription -> organization = new MemberSubscriptionOrganization();
            case ClubFloorOperations -> organization = new ClubFloorOperationsOrganization();
            case EquipmentCatalogAndRental -> organization = new EquipmentCatalogAndRentalOrganization();
            case EquipmentInspectionAndRepair -> organization = new EquipmentInspectionAndRepairOrganization();
            case RegionalDeliveryDispatch -> organization = new RegionalDeliveryDispatchOrganization();
            case WellnessAndDamageClaims -> organization = new WellnessAndDamageClaimsOrganization();
            default -> {
            }
        }
        if (organization != null) {
            organizationList.add(organization);
        }
        return organization;
    }
}
