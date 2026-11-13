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
import java.util.Date;

/**
 * @desc Bootstraps the EcoSystem with 1 Network, 3 Enterprises, 6
 * Organizations, 12 UserAccounts, 105 Faker CustomerProfiles, 15 Franchise
 * Clubs, 44 Serialized EquipmentUnits, 8 DeliveryServiceAreas, and 54
 * WorkRequests.
 *
 * @author Kinder Izzo Celemin
 */
public class ConfigureASystem {

    public static EcoSystem configure() {
        EcoSystem system = EcoSystem.getInstance();
        if (!system.getNetworkList().isEmpty()) {
            return system;
        }

        // Instantiate Java Faker for all random names, numbers, addresses, and companies
        Faker faker = new Faker();

        // Create Network
        Network network = system.createAndAddNetwork(
                "North American GoodLife-FlexGear Fitness Network (Canada-US Corridor)"
        );

        // Create the 3 Enterprises
        GoodLifeFitnessEnterprise goodLifeEnt = (GoodLifeFitnessEnterprise) network.getEnterpriseDirectory()
                .createAndAddEnterprise("GoodLife Fitness Club Enterprise", Enterprise.EnterpriseType.GoodLifeFitness);
        FlexGearEquipmentEnterprise flexGearEnt = (FlexGearEquipmentEnterprise) network.getEnterpriseDirectory()
                .createAndAddEnterprise("FlexGear Equipment & Maintenance Enterprise", Enterprise.EnterpriseType.FlexGearEquipment);
        LogisticsAndInsuranceEnterprise logisticsEnt = (LogisticsAndInsuranceEnterprise) network.getEnterpriseDirectory()
                .createAndAddEnterprise("Logistics & Wellness Protection Enterprise", Enterprise.EnterpriseType.LogisticsAndInsurance);

        // Create the 6 Organizations across the 3 Enterprises
        Organization org1 = goodLifeEnt.getOrganizationDirectory().createOrganization(Organization.Type.MemberSubscription);
        Organization org2 = goodLifeEnt.getOrganizationDirectory().createOrganization(Organization.Type.ClubFloorOperations);
        Organization org3 = flexGearEnt.getOrganizationDirectory().createOrganization(Organization.Type.EquipmentCatalogAndRental);
        Organization org4 = flexGearEnt.getOrganizationDirectory().createOrganization(Organization.Type.EquipmentInspectionAndRepair);
        Organization org5 = logisticsEnt.getOrganizationDirectory().createOrganization(Organization.Type.RegionalDeliveryDispatch);
        Organization org6 = logisticsEnt.getOrganizationDirectory().createOrganization(Organization.Type.WellnessAndDamageClaims);

        // 4. Create System & Enterprise Admin Credentials (with Faker ages)
        Employee sysEmp = system.getEmployeeDirectory().createEmployee(
                "Kinder SysAdmin", "sysadmin@goodlife-flexgear.com", faker.number().numberBetween(28, 45));
        system.getUserAccountDirectory().createUserAccount("sysadmin", "Admin@123", sysEmp, new SystemAdminRole());

        Employee glAdmin = goodLifeEnt.getEmployeeDirectory().createEmployee(
                "Kinder GoodLife Admin", "gladmin@goodlife.ca", faker.number().numberBetween(26, 45));
        goodLifeEnt.getUserAccountDirectory().createUserAccount("goodlife_admin", "Admin@123", glAdmin, goodLifeEnt.getSupportedRole().get(0));

        Employee fgAdmin = flexGearEnt.getEmployeeDirectory().createEmployee(
                "Astrid FlexGear Admin", "fgadmin@flexgear.com", faker.number().numberBetween(26, 45));
        flexGearEnt.getUserAccountDirectory().createUserAccount("flexgear_admin", "Admin@123", fgAdmin, flexGearEnt.getSupportedRole().get(0));

        Employee logAdmin = logisticsEnt.getEmployeeDirectory().createEmployee(
                "Mayu Logistics Admin", "logadmin@wellnesslogistics.com", faker.number().numberBetween(26, 45));
        logisticsEnt.getUserAccountDirectory().createUserAccount("logistics_admin", "Admin@123", logAdmin, logisticsEnt.getSupportedRole().get(0));

        // Create the 8 Operational Role Accounts
        UserAccount advisor1 = org1.getUserAccountDirectory().createUserAccount("advisor1", "Pass@123",
                org1.getEmployeeDirectory().createEmployee(faker.name().fullName(), "advisor1@goodlife.ca", faker.number().numberBetween(23, 50)),
                org1.getSupportedRole().get(0));

        UserAccount trainer1 = org2.getUserAccountDirectory().createUserAccount("trainer1", "Pass@123",
                org2.getEmployeeDirectory().createEmployee(faker.name().fullName(), "trainer1@goodlife.ca", faker.number().numberBetween(23, 50)),
                org2.getSupportedRole().get(0));

        UserAccount clubmgr1 = org2.getUserAccountDirectory().createUserAccount("clubmgr1", "Pass@123",
                org2.getEmployeeDirectory().createEmployee(faker.name().fullName(), "clubmgr1@goodlife.ca", faker.number().numberBetween(28, 55)),
                org2.getSupportedRole().get(1));

        UserAccount rentalcoord1 = org3.getUserAccountDirectory().createUserAccount("rentalcoord1", "Pass@123",
                org3.getEmployeeDirectory().createEmployee(faker.name().fullName(), "rentalcoord1@flexgear.com", faker.number().numberBetween(24, 50)),
                org3.getSupportedRole().get(0));

        UserAccount inventory1 = org3.getUserAccountDirectory().createUserAccount("inventory1", "Pass@123",
                org3.getEmployeeDirectory().createEmployee(faker.name().fullName(), "inventory1@flexgear.com", faker.number().numberBetween(24, 50)),
                org3.getSupportedRole().get(1));

        UserAccount tech1 = org4.getUserAccountDirectory().createUserAccount("tech1", "Pass@123",
                org4.getEmployeeDirectory().createEmployee(faker.name().fullName(), "tech1@flexgear.com", faker.number().numberBetween(25, 55)),
                org4.getSupportedRole().get(0));

        UserAccount delivery1 = org5.getUserAccountDirectory().createUserAccount("delivery1", "Pass@123",
                org5.getEmployeeDirectory().createEmployee(faker.name().fullName(), "delivery1@logistics.com", faker.number().numberBetween(24, 50)),
                org5.getSupportedRole().get(0));

        UserAccount claims1 = org6.getUserAccountDirectory().createUserAccount("claims1", "Pass@123",
                org6.getEmployeeDirectory().createEmployee(faker.name().fullName(), "claims1@wellnessclaims.com", faker.number().numberBetween(25, 55)),
                org6.getSupportedRole().get(0));

        // Seed 15 GoodLife Franchise Club Locations
        goodLifeEnt.getFranchiseClubs().add("GoodLife Kingston Downtown");
        for (int i = 2; i <= 15; i++) {
            goodLifeEnt.getFranchiseClubs().add("GoodLife " + faker.address().cityName() + " Branch #" + i);
        }

        // 7. Seed Subscription Plans & 105 Java Faker Customer Profiles
        SubscriptionPlan basicPlan = new SubscriptionPlan("GoodLife Essential Club", 59.99, 0.05f, 12);
        SubscriptionPlan hybridPlan = new SubscriptionPlan("GoodLife-FlexGear All-Access Hybrid", 99.99, 0.15f, 12);
        SubscriptionPlan proPlan = new SubscriptionPlan("GoodLife Corporate Wellness Pro", 129.99, 0.20f, 24);
        goodLifeEnt.getSubscriptionCatalog().add(basicPlan);
        goodLifeEnt.getSubscriptionCatalog().add(hybridPlan);
        goodLifeEnt.getSubscriptionCatalog().add(proPlan);
        SubscriptionPlan[] plans = {basicPlan, hybridPlan, proPlan};

        for (int i = 1; i <= 105; i++) {
            SubscriptionPlan plan = plans[faker.number().numberBetween(0, plans.length)];
            String fakeName = faker.name().fullName();
            String cleanUser = faker.name().username().replaceAll("[^a-zA-Z0-9]", "");
            String fakeEmail = "member" + i + "_" + cleanUser + "@fitness.ca";
            int fakeAge = faker.number().numberBetween(18, 68);
            CustomerProfile cp = new CustomerProfile(fakeName, fakeEmail, fakeAge, plan);
            goodLifeEnt.getCustomerDirectory().add(cp);
        }

        // 8. Seed Equipment Models (with Faker Supplier Companies) & 44 Serialized Units
        EquipmentModel rower = flexGearEnt.getEquipmentCatalog().addEquipmentModel(
                "HydroPro Rower X1", "Rowing", faker.company().name(), 12.50);
        EquipmentModel bag = flexGearEnt.getEquipmentCatalog().addEquipmentModel(
                "Titan Heavy Combat Bag", "Combat", faker.company().name(), 8.00);
        EquipmentModel rack = flexGearEnt.getEquipmentCatalog().addEquipmentModel(
                "PowerLift Squat Rack Pro", "Strength", faker.company().name(), 15.00);
        EquipmentModel tread = flexGearEnt.getEquipmentCatalog().addEquipmentModel(
                "InclineRun Commercial Treadmill", "Cardio", faker.company().name(), 18.00);
        EquipmentModel[] models = {rower, bag, rack, tread};

        for (int i = 1; i <= 11; i++) {
            EquipmentUnit u1 = new EquipmentUnit(String.format("SN-ROW-%04d", 8800 + i), rower, "Excellent", true, "2026-11-01");
            u1.addRentedDays(faker.number().numberBetween(15, 28));
            flexGearEnt.getUnitInventory().add(u1);

            EquipmentUnit u2 = new EquipmentUnit(String.format("SN-CMB-%04d", 4400 + i), bag, "Good", true, "2026-10-28");
            u2.addRentedDays(faker.number().numberBetween(10, 22));
            flexGearEnt.getUnitInventory().add(u2);

            EquipmentUnit u3 = new EquipmentUnit(String.format("SN-STR-%04d", 3300 + i), rack, "Excellent", true, "2026-11-05");
            u3.addRentedDays(faker.number().numberBetween(14, 25));
            flexGearEnt.getUnitInventory().add(u3);

            EquipmentUnit u4 = new EquipmentUnit(String.format("SN-CRD-%04d", 2200 + i), tread, "New", true, "2026-11-10");
            u4.addRentedDays(faker.number().numberBetween(18, 29));
            flexGearEnt.getUnitInventory().add(u4);
        }

        // 9. Seed 8 Regional Delivery Service Areas (with Faker Courier Partner Names & Delay Hours)
        String[] prefixes = {"K7L", "M5V", "900", "021", "K1P", "V6B", "H3A", "T2P"};
        for (String prefix : prefixes) {
            logisticsEnt.getServiceAreas().add(new DeliveryServiceArea(
                    faker.company().name() + " Freight",
                    faker.address().cityName() + " Region",
                    prefix,
                    faker.number().numberBetween(1, 5)
            ));
        }

        // 10. Seed 54 Work Requests Across All 6 Queues Using Faker Random Values
        String[] categories = {"Rowing", "Combat", "Strength", "Cardio"};
        String[] goals = {
            "Switch from Combat bag to low-impact Rowing endurance",
            "Upper-body boxing conditioning and core stability",
            "Progressive barbell strength and hypertrophy",
            "Marathon incline cardio intervals at home"
        };

        for (int i = 0; i < 9; i++) {
            CustomerProfile member = goodLifeEnt.getCustomerDirectory().get(
                    faker.number().numberBetween(0, goodLifeEnt.getCustomerDirectory().size()));
            EquipmentModel model = models[faker.number().numberBetween(0, models.length)];
            EquipmentUnit unit = flexGearEnt.getUnitInventory().get(i);
            String club = goodLifeEnt.getFranchiseClubs().get(
                    faker.number().numberBetween(0, goodLifeEnt.getFranchiseClubs().size()));
            String postal = prefixes[i % prefixes.length] + " " + faker.numerify("#A#");

            // WR1: Fitness Assessment (Org 1 -> Org 2)
            FitnessAssessmentWorkRequest wr1 = new FitnessAssessmentWorkRequest();
            wr1.setCustomer(member);
            wr1.setFitnessGoal(goals[faker.number().numberBetween(0, goals.length)]);
            wr1.setWeeklyTargetHours(faker.number().numberBetween(3, 10));
            wr1.setRecommendedEquipmentCategory(categories[faker.number().numberBetween(0, categories.length)]);
            wr1.setSender(advisor1);
            wr1.setReceiver(trainer1);
            wr1.setStatus(i < 6 ? "Completed" : "Assigned");
            if (i < 6) {
                wr1.setResolveDate(new Date());
            }
            wr1.setMessage("Assessment notes: " + faker.company().catchPhrase());
            org2.getWorkQueue().getWorkRequestList().add(wr1);
            advisor1.getWorkQueue().getWorkRequestList().add(wr1);

            // WR2: Equipment Rental Order (Ent 1 Org 2 -> Ent 2 Org 3)
            EquipmentRentalOrderWorkRequest wr2 = new EquipmentRentalOrderWorkRequest();
            wr2.setFranchiseClubName(club);
            wr2.setRequestedModel(model);
            wr2.setRentalDurationDays(faker.number().numberBetween(14, 60));
            wr2.calculateTotalOrderFee();
            wr2.setSender(clubmgr1);
            wr2.setReceiver(rentalcoord1);
            wr2.setStatus(i < 7 ? "Approved" : "Submitted");
            if (i < 7) {
                wr2.setResolveDate(new Date());
            }
            wr2.setMessage("Franchise/home rental order for " + club);
            org3.getWorkQueue().getWorkRequestList().add(wr2);
            clubmgr1.getWorkQueue().getWorkRequestList().add(wr2);

            // WR3: Equipment Inspection (Ent 2 Org 3 -> Ent 2 Org 4)
            EquipmentInspectionWorkRequest wr3 = new EquipmentInspectionWorkRequest();
            wr3.setEquipmentUnit(unit);
            wr3.setPreRentalCondition("Excellent");
            wr3.setPostRentalCondition(faker.bool().bool() ? "Excellent" : "Good");
            wr3.setSafetyPassed(i < 8);
            wr3.setTechnicianNotes("Verified load & bearings — Inspector ID: " + faker.numerify("TECH-###"));
            wr3.setSender(rentalcoord1);
            wr3.setReceiver(tech1);
            wr3.setStatus(i < 8 ? "Certified" : "Pending Inspection");
            if (i < 8) {
                wr3.setResolveDate(new Date());
            }
            wr3.setMessage("Safety inspection for " + unit.getSerialNumber());
            org4.getWorkQueue().getWorkRequestList().add(wr3);
            rentalcoord1.getWorkQueue().getWorkRequestList().add(wr3);

            // WR4: Delivery Appointment (Ent 2 Org 3 -> Ent 3 Org 5)
            DeliveryAppointmentWorkRequest wr4 = new DeliveryAppointmentWorkRequest();
            wr4.setAssignedUnit(unit);
            wr4.setCustomerAddress(faker.address().streetAddress() + ", " + faker.address().cityName());
            wr4.setPostalCode(postal);
            wr4.setAppointmentType(faker.bool().bool() ? "Delivery" : "Return Pickup");
            wr4.setScheduledDate(String.format("2026-11-%02d", faker.number().numberBetween(10, 28)));
            wr4.setDelayHours(faker.number().numberBetween(0, 4));
            wr4.setSender(inventory1);
            wr4.setReceiver(delivery1);
            wr4.setStatus(i < 6 ? "Delivered" : "Scheduled");
            if (i < 6) {
                wr4.setResolveDate(new Date());
            }
            wr4.setMessage("Two-person heavy freight dispatch");
            org5.getWorkQueue().getWorkRequestList().add(wr4);
            inventory1.getWorkQueue().getWorkRequestList().add(wr4);

            // WR5: Equipment Damage Claim (Ent 3 Org 5 -> Ent 3 Org 6)
            EquipmentDamageClaimWorkRequest wr5 = new EquipmentDamageClaimWorkRequest();
            wr5.setDamagedUnit(flexGearEnt.getUnitInventory().get(i + 11));
            wr5.setDamageDescription("Transit/mount wear claim ref " + faker.numerify("CLM-####"));
            double estCost = faker.number().randomDouble(2, 85, 320);
            wr5.setRepairCostEstimate(estCost);
            boolean claimApproved = (i < 7);
            wr5.setApprovedPayoutAmount(claimApproved ? estCost : 0.0);
            wr5.setClaimApproved(claimApproved);
            wr5.setSender(delivery1);
            wr5.setReceiver(claims1);
            wr5.setStatus(claimApproved ? "Settled" : "Claim Filed");
            if (claimApproved) {
                wr5.setResolveDate(new Date());
                logisticsEnt.addApprovedClaimPayout(estCost);
            }
            wr5.setMessage("Return pickup damage inspection report");
            org6.getWorkQueue().getWorkRequestList().add(wr5);
            delivery1.getWorkQueue().getWorkRequestList().add(wr5);

            // WR6: Wellness Subsidy Claim (Ent 1 Org 1 -> Ent 3 Org 6)
            WellnessSubsidyClaimWorkRequest wr6 = new WellnessSubsidyClaimWorkRequest();
            wr6.setMember(member);
            wr6.setInsurancePolicyNumber(faker.numerify("POL-CORP-#####"));
            wr6.setRequestedSubsidyAmount(faker.number().randomDouble(2, 150, 450));
            boolean policyVerified = (i < 7);
            wr6.setApprovedSubsidyRate(policyVerified ? 0.25f : 0.0f);
            wr6.setPolicyVerified(policyVerified);
            wr6.setSender(advisor1);
            wr6.setReceiver(claims1);
            wr6.setStatus(policyVerified ? "Rebate Applied" : "Submitted");
            if (policyVerified) {
                wr6.setResolveDate(new Date());
            }
            wr6.setMessage("Corporate wellness policy verification");
            org6.getWorkQueue().getWorkRequestList().add(wr6);
            advisor1.getWorkQueue().getWorkRequestList().add(wr6);
        }

        // Console Verification Summary
        int totalWorkRequests = org2.getWorkQueue().getWorkRequestList().size()
                + org3.getWorkQueue().getWorkRequestList().size()
                + org4.getWorkQueue().getWorkRequestList().size()
                + org5.getWorkQueue().getWorkRequestList().size()
                + org6.getWorkQueue().getWorkRequestList().size();

        System.out.println("=== GOODLIFE-FLEXGEAR ECOSYSTEM SEEDING SUMMARY ===");
        System.out.println("Customer Profiles (Target 100+): " + goodLifeEnt.getCustomerDirectory().size());
        System.out.println("Franchise Clubs   (Target 15)  : " + goodLifeEnt.getFranchiseClubs().size());
        System.out.println("Equipment Units   (Target 40+) : " + flexGearEnt.getUnitInventory().size());
        System.out.println("Service Areas     (Target 8)   : " + logisticsEnt.getServiceAreas().size());
        System.out.println("Work Requests     (Target 50+) : " + totalWorkRequests);

        return system;
    }

    public static void main(String[] args) {
        configure();
    }
}
