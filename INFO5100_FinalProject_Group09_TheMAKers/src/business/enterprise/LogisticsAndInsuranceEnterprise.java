/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package business.enterprise;

import business.domain.DeliveryServiceArea;
import business.role.EnterpriseAdminRole;
import business.role.Role;
import java.util.ArrayList;

/**
 * @desc Enterprise 3: Logistics & Wellness Protection Enterprise 
 * Coordinates regional courier service areas by postal code prefix and tracks
 * insurance payouts.
 * 
 * @author Mayu Rocha Yamada
 */
public class LogisticsAndInsuranceEnterprise extends Enterprise {

    private ArrayList<DeliveryServiceArea> serviceAreas;
    private double totalApprovedClaimsAmount;

    public LogisticsAndInsuranceEnterprise(String name) {
        super(name, EnterpriseType.LogisticsAndInsurance);
        this.serviceAreas = new ArrayList<>();
        this.totalApprovedClaimsAmount = 0.0;
    }

    /**
     * Matches a customer's postal or ZIP prefix (e.g., "K7L", "M5V", "900") to
     * a regional courier partner.
     * @param postalCode
     * @return 
     */
    public DeliveryServiceArea findPartnerByPostalCode(String postalCode) {
        if (postalCode != null && postalCode.length() >= 3) {
            String prefix = postalCode.substring(0, 3).toUpperCase();
            for (DeliveryServiceArea area : serviceAreas) {
                if (area.getPostalPrefix().equalsIgnoreCase(prefix)) {
                    return area;
                }
            }
        }
        return serviceAreas.isEmpty() ? null : serviceAreas.get(0);
    }

    public void addApprovedClaimPayout(double amount) {
        this.totalApprovedClaimsAmount += amount;
    }

    public ArrayList<DeliveryServiceArea> getServiceAreas() {
        return serviceAreas;
    }

    public double getTotalApprovedClaimsAmount() {
        return totalApprovedClaimsAmount;
    }

    @Override
    public ArrayList<Role> getSupportedRole() {
        ArrayList<Role> roles = new ArrayList<>();
        roles.add(new EnterpriseAdminRole());
        return roles;
    }
}
