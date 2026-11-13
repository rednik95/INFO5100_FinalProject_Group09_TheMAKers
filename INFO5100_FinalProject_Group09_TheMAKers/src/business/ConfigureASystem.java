/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package business;

import business.domain.CustomerProfile;
import business.domain.DeliveryServiceArea;
import business.domain.EquipmentModel;
import business.domain.EquipmentUnit;
import business.domain.SubscriptionPlan;
import business.employee.Employee;
import business.enterprise.Enterprise;
import business.enterprise.FlexGearEquipmentEnterprise;
import business.enterprise.GoodLifeFitnessEnterprise;
import business.enterprise.LogisticsAndInsuranceEnterprise;
import business.network.Network;
import business.organization.Organization;
import business.role.SystemAdminRole;
import business.useraccount.UserAccount;
import business.workqueue.DeliveryAppointmentWorkRequest;
import business.workqueue.EquipmentDamageClaimWorkRequest;
import business.workqueue.EquipmentInspectionWorkRequest;
import business.workqueue.EquipmentRentalOrderWorkRequest;
import business.workqueue.FitnessAssessmentWorkRequest;
import business.workqueue.WellnessSubsidyClaimWorkRequest;
import com.github.javafaker.Faker;
import java.util.Random;

/**
 * @desc Bootstraps the entire EcoSystem Configures 1 Network, 3 Enterprises, 6
 * Organizations, 12 default login accounts, and seeds realistic customer
 * profiles, serialized units, and work requests.
 *
 * @author Kinder Izzo Celemin
 */
public class ConfigureASystem {

    public static EcoSystem configure() {
        EcoSystem system = EcoSystem.getInstance();
        if (!system.getNetworkList().isEmpty()) {
            return system;
        }

        Network network = system.createAndAddNetwork(
                "North American GoodLife-FlexGear Fitness Network (Canada-US Corridor)"
        );

        GoodLifeFitnessEnterprise goodLifeEnt = (GoodLifeFitnessEnterprise) network.getEnterpriseDirectory()
                .createAndAddEnterprise("GoodLife Fitness Club Enterprise", Enterprise.EnterpriseType.GoodLifeFitness);
        FlexGearEquipmentEnterprise flexGearEnt = (FlexGearEquipmentEnterprise) network.getEnterpriseDirectory()
                .createAndAddEnterprise("FlexGear Equipment & Maintenance Enterprise", Enterprise.EnterpriseType.FlexGearEquipment);
        LogisticsAndInsuranceEnterprise logisticsEnt = (LogisticsAndInsuranceEnterprise) network.getEnterpriseDirectory()
                .createAndAddEnterprise("Logistics & Wellness Protection Enterprise", Enterprise.EnterpriseType.LogisticsAndInsurance);

        Organization org1 = goodLifeEnt.getOrganizationDirectory().createOrganization(Organization.Type.MemberSubscription);
        Organization org2 = goodLifeEnt.getOrganizationDirectory().createOrganization(Organization.Type.ClubFloorOperations);
        Organization org3 = flexGearEnt.getOrganizationDirectory().createOrganization(Organization.Type.EquipmentCatalogAndRental);
        Organization org4 = flexGearEnt.getOrganizationDirectory().createOrganization(Organization.Type.EquipmentInspectionAndRepair);
        Organization org5 = logisticsEnt.getOrganizationDirectory().createOrganization(Organization.Type.RegionalDeliveryDispatch);
        Organization org6 = logisticsEnt.getOrganizationDirectory().createOrganization(Organization.Type.WellnessAndDamageClaims);

        Employee sysEmp = system.getEmployeeDirectory().createEmployee("Kinder SysAdmin", "sysadmin@goodlife-flexgear.com", 30);
        system.getUserAccountDirectory().createUserAccount("sysadmin", "Admin@123", sysEmp, new SystemAdminRole());

        Employee glAdmin = goodLifeEnt.getEmployeeDirectory().createEmployee("Kinder GoodLife Admin", "gladmin@goodlife.ca", 29);
        goodLifeEnt.getUserAccountDirectory().createUserAccount("goodlife_admin", "Admin@123", glAdmin, goodLifeEnt.getSupportedRole().get(0));

        Employee fgAdmin = flexGearEnt.getEmployeeDirectory().createEmployee("Astrid FlexGear Admin", "fgadmin@flexgear.com", 28);
        flexGearEnt.getUserAccountDirectory().createUserAccount("flexgear_admin", "Admin@123", fgAdmin, flexGearEnt.getSupportedRole().get(0));

        Employee logAdmin = logisticsEnt.getEmployeeDirectory().createEmployee("Mayu Logistics Admin", "logadmin@wellnesslogistics.com", 28);
        logisticsEnt.getUserAccountDirectory().createUserAccount("logistics_admin", "Admin@123", logAdmin, logisticsEnt.getSupportedRole().get(0));

        UserAccount advisor1 = org1.getUserAccountDirectory().createUserAccount("advisor1", "Pass@123",
                org1.getEmployeeDirectory().createEmployee("Sarah Jenkins", "advisor1@goodlife.ca", 27), org1.getSupportedRole().get(0));

        UserAccount trainer1 = org2.getUserAccountDirectory().createUserAccount("trainer1", "Pass@123",
                org2.getEmployeeDirectory().createEmployee("Marcus Vance", "trainer1@goodlife.ca", 31), org2.getSupportedRole().get(0));

        UserAccount clubmgr1 = org2.getUserAccountDirectory().createUserAccount("clubmgr1", "Pass@123",
                org2.getEmployeeDirectory().createEmployee("Devon Clarke", "clubmgr1@goodlife.ca", 36), org2.getSupportedRole().get(1));

        UserAccount rentalcoord1 = org3.getUserAccountDirectory().createUserAccount("rentalcoord1", "Pass@123",
                org3.getEmployeeDirectory().createEmployee("Claire Moreau", "rentalcoord1@flexgear.com", 29), org3.getSupportedRole().get(0));

        UserAccount inventory1 = org3.getUserAccountDirectory().createUserAccount("inventory1", "Pass@123",
                org3.getEmployeeDirectory().createEmployee("Lucas Bernard", "inventory1@flexgear.com", 33), org3.getSupportedRole().get(1));

        UserAccount tech1 = org4.getUserAccountDirectory().createUserAccount("tech1", "Pass@123",
                org4.getEmployeeDirectory().createEmployee("Henri Laurent", "tech1@flexgear.com", 34), org4.getSupportedRole().get(0));

        UserAccount delivery1 = org5.getUserAccountDirectory().createUserAccount("delivery1", "Pass@123",
                org5.getEmployeeDirectory().createEmployee("Kenji Takahashi", "delivery1@logistics.com", 30), org5.getSupportedRole().get(0));

        UserAccount claims1 = org6.getUserAccountDirectory().createUserAccount("claims1", "Pass@123",
                org6.getEmployeeDirectory().createEmployee("Elena Rostova", "claims1@wellnessclaims.com", 32), org6.getSupportedRole().get(0));

        goodLifeEnt.getFranchiseClubs().add("GoodLife Kingston Downtown");
        goodLifeEnt.getFranchiseClubs().add("GoodLife Toronto Yonge & Eglinton");
        goodLifeEnt.getFranchiseClubs().add("GoodLife Ottawa Rideau Corridor");
        goodLifeEnt.getFranchiseClubs().add("GoodLife Boston Back Bay Partner");

        SubscriptionPlan basicPlan = new SubscriptionPlan("GoodLife Essential Club", 59.99, 0.05f, 12);
        SubscriptionPlan hybridPlan = new SubscriptionPlan("GoodLife-FlexGear All-Access Hybrid", 99.99, 0.15f, 12);
        goodLifeEnt.getSubscriptionCatalog().add(basicPlan);
        goodLifeEnt.getSubscriptionCatalog().add(hybridPlan);

        // Java Faker Customer Generation Loop Added Here
        Faker faker = new Faker();
        Random rand = new Random(42);
        for (int i = 1; i <= 105; i++) {
            SubscriptionPlan plan = (i % 2 == 0) ? hybridPlan : basicPlan;
            String fakeName = faker.name().fullName();
            String fakeEmail = "member" + i + "_" + faker.name().username().replaceAll("[^a-zA-Z0-9]", "") + "@fitness.ca";
            CustomerProfile cp = new CustomerProfile(fakeName, fakeEmail, 18 + rand.nextInt(50), plan);
            goodLifeEnt.getCustomerDirectory().add(cp);
        }

        EquipmentModel rower = flexGearEnt.getEquipmentCatalog().addEquipmentModel("HydroPro Rower X1", "Rowing", "WaterRower US-CA", 12.50);
        EquipmentModel bag = flexGearEnt.getEquipmentCatalog().addEquipmentModel("Titan Heavy Combat Bag", "Combat", "Everlast Commercial", 8.00);
        EquipmentModel rack = flexGearEnt.getEquipmentCatalog().addEquipmentModel("PowerLift Squat Rack Pro", "Strength", "Rogue North America", 15.00);
        EquipmentModel tread = flexGearEnt.getEquipmentCatalog().addEquipmentModel("InclineRun Commercial Treadmill", "Cardio", "LifeFitness Corridor", 18.00);

        for (int i = 1; i <= 10; i++) {
            EquipmentUnit u1 = new EquipmentUnit(String.format("SN-ROW-%04d", 8800 + i), rower, "Excellent", true, "2026-11-01");
            u1.addRentedDays(22);
            flexGearEnt.getUnitInventory().add(u1);

            EquipmentUnit u2 = new EquipmentUnit(String.format("SN-CMB-%04d", 4400 + i), bag, "Good", true, "2026-10-28");
            u2.addRentedDays(16);
            flexGearEnt.getUnitInventory().add(u2);

            EquipmentUnit u3 = new EquipmentUnit(String.format("SN-STR-%04d", 3300 + i), rack, "Excellent", true, "2026-11-05");
            u3.addRentedDays(19);
            flexGearEnt.getUnitInventory().add(u3);

            EquipmentUnit u4 = new EquipmentUnit(String.format("SN-CRD-%04d", 2200 + i), tread, "New", true, "2026-11-10");
            u4.addRentedDays(25);
            flexGearEnt.getUnitInventory().add(u4);
        }

        logisticsEnt.getServiceAreas().add(new DeliveryServiceArea("Kingston Heavy Freight", "Eastern Ontario", "K7L", 2));
        logisticsEnt.getServiceAreas().add(new DeliveryServiceArea("GTA Metro Express", "Toronto Central", "M5V", 3));
        logisticsEnt.getServiceAreas().add(new DeliveryServiceArea("SoCal Fitness Couriers", "Los Angeles Metro", "900", 4));
        logisticsEnt.getServiceAreas().add(new DeliveryServiceArea("New England Freight", "Boston Corridor", "021", 2));

        FitnessAssessmentWorkRequest wr1 = new FitnessAssessmentWorkRequest();
        wr1.setCustomer(goodLifeEnt.getCustomerDirectory().get(0));
        wr1.setFitnessGoal("Switch from Combat bag to low-impact Rowing endurance");
        wr1.setWeeklyTargetHours(6);
        wr1.setRecommendedEquipmentCategory("Rowing");
        wr1.setSender(advisor1);
        wr1.setReceiver(trainer1);
        wr1.setStatus("Assigned");
        wr1.setMessage("Initial hybrid member fitness evaluation");
        org2.getWorkQueue().getWorkRequestList().add(wr1);
        advisor1.getWorkQueue().getWorkRequestList().add(wr1);

        EquipmentRentalOrderWorkRequest wr2 = new EquipmentRentalOrderWorkRequest();
        wr2.setFranchiseClubName("GoodLife Kingston Downtown");
        wr2.setRequestedModel(rower);
        wr2.setRentalDurationDays(30);
        wr2.calculateTotalOrderFee();
        wr2.setSender(clubmgr1);
        wr2.setReceiver(rentalcoord1);
        wr2.setStatus("Approved");
        wr2.setMessage("Monthly home-rental hydro-rower order");
        org3.getWorkQueue().getWorkRequestList().add(wr2);
        clubmgr1.getWorkQueue().getWorkRequestList().add(wr2);

        EquipmentInspectionWorkRequest wr3 = new EquipmentInspectionWorkRequest();
        wr3.setEquipmentUnit(flexGearEnt.getUnitInventory().get(0));
        wr3.setPreRentalCondition("Excellent");
        wr3.setPostRentalCondition("Excellent");
        wr3.setSafetyPassed(true);
        wr3.setTechnicianNotes("Drive chain tension and water tank seal verified.");
        wr3.setSender(rentalcoord1);
        wr3.setReceiver(tech1);
        wr3.setStatus("Certified");
        wr3.setMessage("Pre-rental safety check for SN-ROW-8801");
        org4.getWorkQueue().getWorkRequestList().add(wr3);
        rentalcoord1.getWorkQueue().getWorkRequestList().add(wr3);

        DeliveryAppointmentWorkRequest wr4 = new DeliveryAppointmentWorkRequest();
        wr4.setAssignedUnit(flexGearEnt.getUnitInventory().get(0));
        wr4.setCustomerAddress("99 University Ave, Kingston, ON");
        wr4.setPostalCode("K7L 3N6");
        wr4.setAppointmentType("Delivery");
        wr4.setScheduledDate("2026-11-15");
        wr4.setDelayHours(1);
        wr4.setSender(inventory1);
        wr4.setReceiver(delivery1);
        wr4.setStatus("Scheduled");
        wr4.setMessage("Two-person heavy delivery dispatch");
        org5.getWorkQueue().getWorkRequestList().add(wr4);
        inventory1.getWorkQueue().getWorkRequestList().add(wr4);

        EquipmentDamageClaimWorkRequest wr5 = new EquipmentDamageClaimWorkRequest();
        wr5.setDamagedUnit(flexGearEnt.getUnitInventory().get(1));
        wr5.setDamageDescription("Torn upper hanging strap on returned heavy combat bag");
        wr5.setRepairCostEstimate(145.00);
        wr5.setApprovedPayoutAmount(145.00);
        wr5.setClaimApproved(true);
        wr5.setSender(delivery1);
        wr5.setReceiver(claims1);
        wr5.setStatus("Settled");
        wr5.setMessage("Return pickup damage claim filed");
        logisticsEnt.addApprovedClaimPayout(145.00);
        org6.getWorkQueue().getWorkRequestList().add(wr5);
        delivery1.getWorkQueue().getWorkRequestList().add(wr5);

        WellnessSubsidyClaimWorkRequest wr6 = new WellnessSubsidyClaimWorkRequest();
        wr6.setMember(goodLifeEnt.getCustomerDirectory().get(0));
        wr6.setInsurancePolicyNumber("POL-SUNLIFE-99412");
        wr6.setRequestedSubsidyAmount(300.00);
        wr6.setApprovedSubsidyRate(0.25f);
        wr6.setPolicyVerified(true);
        wr6.setSender(advisor1);
        wr6.setReceiver(claims1);
        wr6.setStatus("Rebate Applied");
        wr6.setMessage("Corporate wellness policy verification");
        org6.getWorkQueue().getWorkRequestList().add(wr6);
        advisor1.getWorkQueue().getWorkRequestList().add(wr6);
        

        return system;
    }
}
