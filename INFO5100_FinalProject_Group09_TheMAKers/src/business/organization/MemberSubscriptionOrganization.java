package business.organization;

import business.role.DeliveryCoordinatorRole;
import business.role.FranchiseClubManagerRole;
import business.role.InsuranceClaimsSpecialistRole;
import business.role.InventorySpecialistRole;
import business.role.MaintenanceTechnicianRole;
import business.role.MembershipAdvisorRole;
import business.role.PersonalTrainerRole;
import business.role.RentalOrderCoordinatorRole;
import business.role.Role;
import java.util.ArrayList;

/**
 * @desc 
 *
 * @author Kinder Izzo Celemin
 */

public class MemberSubscriptionOrganization extends Organization {

    public MemberSubscriptionOrganization() {
        super(Type.MemberSubscription.getValue());
    }

    @Override
    public ArrayList<Role> getSupportedRole() {
        ArrayList<Role> roles = new ArrayList<>();
        roles.add(new MembershipAdvisorRole());
        return roles;
    }
}

class ClubFloorOperationsOrganization extends Organization {

    public ClubFloorOperationsOrganization() {
        super(Type.ClubFloorOperations.getValue());
    }

    @Override
    public ArrayList<Role> getSupportedRole() {
        ArrayList<Role> roles = new ArrayList<>();
        roles.add(new PersonalTrainerRole());
        roles.add(new FranchiseClubManagerRole());
        return roles;
    }
}

class EquipmentCatalogAndRentalOrganization extends Organization {

    public EquipmentCatalogAndRentalOrganization() {
        super(Type.EquipmentCatalogAndRental.getValue());
    }

    @Override
    public ArrayList<Role> getSupportedRole() {
        ArrayList<Role> roles = new ArrayList<>();
        roles.add(new RentalOrderCoordinatorRole());
        roles.add(new InventorySpecialistRole());
        return roles;
    }
}

class EquipmentInspectionAndRepairOrganization extends Organization {

    public EquipmentInspectionAndRepairOrganization() {
        super(Type.EquipmentInspectionAndRepair.getValue());
    }

    @Override
    public ArrayList<Role> getSupportedRole() {
        ArrayList<Role> roles = new ArrayList<>();
        roles.add(new MaintenanceTechnicianRole());
        return roles;
    }
}

class RegionalDeliveryDispatchOrganization extends Organization {

    public RegionalDeliveryDispatchOrganization() {
        super(Type.RegionalDeliveryDispatch.getValue());
    }

    @Override
    public ArrayList<Role> getSupportedRole() {
        ArrayList<Role> roles = new ArrayList<>();
        roles.add(new DeliveryCoordinatorRole());
        return roles;
    }
}

class WellnessAndDamageClaimsOrganization extends Organization {

    public WellnessAndDamageClaimsOrganization() {
        super(Type.WellnessAndDamageClaims.getValue());
    }

    @Override
    public ArrayList<Role> getSupportedRole() {
        ArrayList<Role> roles = new ArrayList<>();
        roles.add(new InsuranceClaimsSpecialistRole());
        return roles;
    }
}
