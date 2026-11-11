<div align="center">

# 🏋️‍♂️ GoodLife–FlexGear National Fitness, Equipment Rental & Wellness Protection Ecosystem

**A Multi-Enterprise Java Swing Digital Platform for Hybrid Fitness Franchises, Serialized Equipment Lifecycle Management, Last-Mile Freight Logistics & Insurance Adjudication**

[![Course](https://img.shields.io/badge/Course-INFO_5100_AED-crimson?style=for-the-badge)](https://www.northeastern.edu/)
[![Java](https://img.shields.io/badge/Java-JDK_17%2B_%7C_19-ED8B00?style=for-the-badge&logo=openjdk&logoColor=white)](https://openjdk.org/)
[![UI Framework](https://img.shields.io/badge/UI-Java_Swing_(CardLayout)-0f766e?style=for-the-badge)](https://docs.oracle.com/javase/tutorial/uiswing/)
[![Persistence](https://img.shields.io/badge/Storage-DB4O_%2B_Java_Faker-1e3a8a?style=for-the-badge)](#)
[![Team](https://img.shields.io/badge/Group_09-The_MAKers-f59e0b?style=for-the-badge)](#team-information)

*Northeastern University • College of Engineering • INFO 5100: Application Engineering and Development • Fall 2026*

[📖 Project Overview](#-project-overview--problem-statement) •
[🏛️ Ecosystem Architecture](#️-ecosystem-architecture) •
[🔄 Work Requests](#-work-request-routing-matrix) •
[⚙️ Installation & Setup](#️-installation--setup-instructions) •
[🔐 Login Credentials](#-authentication--default-test-credentials) •
[🧪 Testing Guide](#-testing-guide)

</div>

---

## 👥 Team Information

**Team Name:** Group 09 – **The MAKers** (Team of 3)  
**Instructor:** Prof. Kal Bugrara

| Team Member | NUID | Location / Time Zone | Primary Project Role & Assigned Enterprise |
| :--- | :--- | :--- | :--- |
| **Kinder Izzo Celemin** | `003947783` | Kingston, ON, Canada (EST) | **Functional Architect & Enterprise 1 Lead:** *GoodLife Fitness Club Enterprise*, System/Enterprise Admin CRUD, RBAC Router, `ConfigureASystem` & Java Faker Seeding |
| **Astrid Noizillier** | `003942977` | Paris, France (CET) | **Object/Data Designer & Enterprise 2 Lead:** *FlexGear Equipment & Maintenance Enterprise*, Catalog/Inventory Models, Soft-Delete Logic & Network-Level Reporting Module |
| **Mayu Rocha Yamada** | `003997556` | Los Angeles, CA, USA (PST) | **UI/Workflow Lead & Enterprise 3 Lead:** *Logistics & Wellness Protection Enterprise*, Service-Area Dispatch, Insurance Claims, `AppValidator` & JavaMail Bonus Integration |

---

## 📖 Project Overview & Problem Statement

### The Problem
Modern fitness chains (such as **GoodLife Fitness**) and specialized sports equipment rental franchises (such as **FlexGear**) operate in disconnected operational silos across club membership management, commercial and home equipment servicing, heavy last-mile freight logistics, and health/property insurance adjudication. Today's fitness consumers increasingly demand hybrid flexibility: training at a local brick-and-mortar club while renting, testing, and swapping commercial-grade equipment at home (e.g., starting with a heavy punching bag and switching to a hydro-rowing machine the following month).

Because fitness clubs, cross-border US–Canadian equipment suppliers, regional couriers, and insurance underwriters rely on fragmented legacy tools, four systemic bottlenecks occur:
1. **Unverified Equipment Safety & Liability Risks:** Franchise club managers and home subscribers lack real-time visibility into approved equipment catalogs, unit serial histories, and pre-/post-rental mechanical safety inspections.
2. **Cross-Boundary Supply & Delivery Bottlenecks:** Coordinating heavy two-person deliveries and return pickups across regional postal service areas stalls when inventory depots and courier dispatchers lack a unified work queue.
3. **Delayed Wellness Rebates & Damage Settlements:** Members whose corporate health plans subsidize gym subscriptions face slow manual verification, while in-home or in-transit equipment damage disputes freeze inventory turnover.
4. **Zero Network-Wide Analytics:** Executives cannot accurately track equipment utilization rates by franchisee, calculate revenue-share splits, or monitor courier delay metrics across the network.

### Why Every Enterprise Is Essential (*"Whole > Sum of the Parts"*)
* **🏢 Enterprise 1 – GoodLife Fitness Club Enterprise:** Generates member demand, manages subscription plans and promotional discounts, conducts personal trainer fitness assessments, and oversees club floor operations, but cannot overhaul heavy fitness hardware, operate freight fleets, or underwrite insurance claims.
* **🛠️ Enterprise 2 – FlexGear Equipment & Maintenance Enterprise:** Maintains the central catalog of approved sports equipment models and serialized units, processes franchisee and home-member rental orders, and performs pre-/post-rental safety inspections, but relies on GoodLife for customer demand and on external couriers and insurers to transport and protect physical units.
* **🚚 Enterprise 3 – Logistics & Wellness Protection Enterprise:** Schedules regional delivery and pickup appointments by service area, verifies employer corporate wellness subsidies, and adjudicates equipment damage claims, relying on clinical/fitness triggers from GoodLife and safety clearances from FlexGear.

---

## 🏛️ Ecosystem Architecture

Built on the recursive **Composite Design Pattern** (`EcoSystem` $\rightarrow$ `Network` $\rightarrow$ `Enterprise` $\rightarrow$ `Organization` $\rightarrow$ `UserAccount` $\rightarrow$ `Role`), this platform fulfills all implementation criteria for a team of three:
* **1 Network:** *North American GoodLife–FlexGear Fitness Network (Canada–US Commercial Fitness Corridor)*
* **3 Enterprises**
* **6 Organizations**
* **8 Unique Operational Roles** *(excluding System, Network, Enterprise, and Organization Admin roles)*
* **6 Polymorphic Work Requests** *(3 Cross-Organization & 3 Cross-Enterprise)*

### Hierarchy Mapping Table

| Enterprise (3) | Organization (6) | Unique Operational Role (8) | Core Work Area Responsibilities | Owner |
| :--- | :--- | :--- | :--- | :--- |
| **1. GoodLife Fitness Club Enterprise** | **Org 1:** Member Subscriptions Org | **Role 1:** Membership Advisor | Registers customers, assigns subscription plans, applies discounts, and submits fitness assessment (`WR1`) or wellness subsidy (`WR6`) requests. | Kinder |
| **1. GoodLife Fitness Club Enterprise** | **Org 2:** Club Floor Operations Org | **Role 2:** Personal Trainer | Evaluates member fitness assessments (`WR1`), sets workout goals, and recommends commercial or home-rental equipment categories. | Kinder |
| **1. GoodLife Fitness Club Enterprise** | **Org 2:** Club Floor Operations Org | **Role 3:** Franchise Club Manager | Monitors club floor utilization, places franchisee/member equipment rental orders (`WR2`) with FlexGear, and tracks club revenue share. | Kinder |
| **2. FlexGear Equipment & Maintenance Enterprise** | **Org 3:** Equipment Catalog & Rental Org | **Role 4:** Rental Order Coordinator | Reviews incoming equipment rental orders (`WR2`), calculates rental fees, and dispatches pre-/post-rental inspection requests (`WR3`). | Astrid |
| **2. FlexGear Equipment & Maintenance Enterprise** | **Org 3:** Equipment Catalog & Rental Org | **Role 5:** Inventory Specialist | Manages the approved equipment catalog, supplier references, and serialized unit stock; triggers courier delivery appointments (`WR4`). | Astrid |
| **2. FlexGear Equipment & Maintenance Enterprise** | **Org 4:** Equipment Inspection & Repair Org | **Role 6:** Maintenance Technician | Performs mechanical safety inspections (`WR3`) before and after every rental, updates unit condition history, and flags damaged units. | Astrid |
| **3. Logistics & Wellness Protection Enterprise** | **Org 5:** Regional Delivery Dispatch Org | **Role 7:** Delivery Coordinator | Manages regional delivery service areas, schedules customer delivery/pickup appointments (`WR4`), and files return damage claims (`WR5`). | Mayu |
| **3. Logistics & Wellness Protection Enterprise** | **Org 6:** Wellness & Damage Claims Org | **Role 8:** Insurance Claims Specialist | Adjudicates rental equipment damage claims (`WR5`) and verifies member corporate health-plan wellness subsidies (`WR6`). | Mayu |

---

## 🔄 Work Request Routing Matrix

All 6 work requests inherit from the abstract `WorkRequest` class and enforce explicit status lifecycle transitions (`Requested / Submitted` $\rightarrow$ `Assigned / Under Review` $\rightarrow$ `Approved / Completed` or `Flagged / Cancelled`):

| ID | WorkRequest Subclass | Routing Scope | Sender Role (Origin Org) | Receiver Role (Target Org) | Payload & Status Flow |
| :--- | :--- | :--- | :--- | :--- | :--- |
| **WR1** | `FitnessAssessmentWorkRequest` | **Cross-Organization** *(Within Ent 1)* | Membership Advisor *(Org 1)* | Personal Trainer *(Org 2)* | Customer profile, fitness goal, target weekly hours, recommended equipment category. |
| **WR2** | `EquipmentRentalOrderWorkRequest` | **Cross-Enterprise** *(Ent 1 $\rightarrow$ Ent 2)* | Franchise Club Manager *(Org 2, Ent 1)* | Rental Order Coordinator *(Org 3, Ent 2)* | Order ID, franchisee club, requested model, rental duration days, calculated rental fee. |
| **WR3** | `EquipmentInspectionWorkRequest` | **Cross-Organization** *(Within Ent 2)* | Rental Order Coordinator *(Org 3)* | Maintenance Technician *(Org 4)* | Serialized unit, pre-/post-rental condition grade, `isSafetyPassed` boolean, tech notes. |
| **WR4** | `DeliveryAppointmentWorkRequest` | **Cross-Enterprise** *(Ent 2 $\rightarrow$ Ent 3)* | Inventory Specialist *(Org 3, Ent 2)* | Delivery Coordinator *(Org 5, Ent 3)* | Assigned serial unit, postal service area, delivery/pickup type, scheduled date, delay hours. |
| **WR5** | `EquipmentDamageClaimWorkRequest` | **Cross-Organization** *(Within Ent 3)* | Delivery Coordinator *(Org 5)* | Insurance Claims Specialist *(Org 6)* | Damaged serial unit, pickup inspection report, repair cost estimate, approved indemnity payout. |
| **WR6** | `WellnessSubsidyClaimWorkRequest` | **Cross-Enterprise** *(Ent 1 $\rightarrow$ Ent 3)* | Membership Advisor *(Org 1, Ent 1)* | Insurance Claims Specialist *(Org 6, Ent 3)* | Customer profile, employer policy number, requested subsidy amount, approved rebate rate. |

---

## 📐 System Diagrams

### High-Level Component Diagram


### Simplified UML Class Relationship Diagram



*(Note: Full PDF versions of both the **High-Level Component Diagram** and the **Detailed UML Class Diagram** with attributes, methods, and relationships are included in the root `/docs` directory of this repository).*

---

## ⚙️ Installation & Setup Instructions

### Prerequisites
* **Java Development Kit (JDK):** Version **17** or **19+**
* **IDE:** **Apache NetBeans 16+** (supports Ant `build.xml` / Maven and `.form` GUI files)
* **Version Control:** **Git** (Git Bash, Terminal, or Lazygit)
* **Bundled Libraries (`/lib`):**
  * `javafaker-1.0.2.jar` & `snakeyaml` (Automated realistic data generation)
  * `db4o-8.0.jar` (Object-oriented database persistence)
  * `javax.mail.jar` (Automated email notifications)

### Step-by-Step Setup
1. **Clone the Repository:**
   ```bash
   git clone https://github.com/rednik95/INFO5100_FinalProject_Group09_TheMAKers.git
   cd INFO5100_FinalProject_Group09_TheMAKers
   ```
2. **Open the Project in Apache NetBeans:**
   * Launch **Apache NetBeans**.
   * Navigate to **File > Open Project...** and select the cloned project directory.
3. **Clean and Build the Project:**
   * Right-click the project in the **Projects** pane and select **Clean and Build** (`Shift + F11`).
   * Verify that the console outputs `BUILD SUCCESSFUL` with zero errors.
4. **Run the Application:**
   * Right-click `MainJFrame.java` (inside `src/ui/MainJFrame.java`) and select **Run File** (`Shift + F6`), or click the green **Run Project** (`F6`) icon in the toolbar.

---

## 🔐 Authentication & Default Test Credentials

### Authentication & Authorization Process
When a user enters credentials in `MainJFrame`, the authentication engine traverses the composite tree:
1. Checks the root `EcoSystem.getUserAccountDirectory()` (for System & Network Admins).
2. Iterates through each `Network` $\rightarrow$ `Enterprise.getUserAccountDirectory()` (for Enterprise Admins).
3. Iterates through each `Organization.getUserAccountDirectory()` (for Operational Roles).
4. Upon authentication, `Role.createWorkArea(...)` is invoked polymorphically, injecting the user's exact `UserAccount`, `Organization`, `Enterprise`, and `EcoSystem` references into a dedicated Swing `JPanel` rendered inside the `CardLayout` container.

### Pre-Populated Login Credentials (`ConfigureASystem.java`)

| Access Level / Enterprise | Role | Username | Password | Target WorkArea JPanel |
| :--- | :--- | :--- | :--- | :--- |
| **System / Network Root** | System Administrator | `sysadmin` | `Admin@123` | `SystemAdminWorkAreaJPanel` |
| **Enterprise 1 Admin** | GoodLife Enterprise Admin | `goodlife_admin` | `Admin@123` | `EnterpriseAdminWorkAreaJPanel` |
| **Enterprise 2 Admin** | FlexGear Enterprise Admin | `flexgear_admin` | `Admin@123` | `EnterpriseAdminWorkAreaJPanel` |
| **Enterprise 3 Admin** | Logistics Enterprise Admin | `logistics_admin` | `Admin@123` | `EnterpriseAdminWorkAreaJPanel` |
| **GoodLife (Org 1)** | Role 1: Membership Advisor | `advisor1` | `Pass@123` | `MembershipAdvisorWorkAreaJPanel` |
| **GoodLife (Org 2)** | Role 2: Personal Trainer | `trainer1` | `Pass@123` | `PersonalTrainerWorkAreaJPanel` |
| **GoodLife (Org 2)** | Role 3: Franchise Club Manager | `clubmgr1` | `Pass@123` | `FranchiseClubManagerWorkAreaJPanel` |
| **FlexGear (Org 3)** | Role 4: Rental Order Coordinator | `rentalcoord1` | `Pass@123` | `RentalOrderCoordinatorWorkAreaJPanel` |
| **FlexGear (Org 3)** | Role 5: Inventory Specialist | `inventory1` | `Pass@123` | `InventorySpecialistWorkAreaJPanel` |
| **FlexGear (Org 4)** | Role 6: Maintenance Technician | `tech1` | `Pass@123` | `MaintenanceTechnicianWorkAreaJPanel` |
| **Logistics (Org 5)** | Role 7: Delivery Coordinator | `delivery1` | `Pass@123` | `DeliveryCoordinatorWorkAreaJPanel` |
| **Logistics (Org 6)** | Role 8: Insurance Claims Specialist | `claims1` | `Pass@123` | `InsuranceClaimsSpecialistWorkAreaJPanel` |

---

## ✨ Key Features & Engineering Highlights

* **🌱 Automated Java Faker Seeding (`ConfigureASystem.java`):** Automatically generates 100+ realistic customer profiles, 15 GoodLife franchise locations, 40+ serialized equipment units across 4 categories (*Cardio, Strength, Combat, Rowing*), 8 postal delivery service areas, and 50+ historical work requests on initial boot.
* **📊 Network-Level KPI Reporting Dashboard (`NetworkReportingJPanel.java`):** Aggregates real-time metrics across all 3 enterprises:
  1. Rental volume by equipment category & franchisee order volume by equipment model.
  2. Equipment utilization rates by franchisee ($\text{Utilization Rate} = \frac{\text{Rented Days}}{\text{Total Available Days}}$).
  3. Gross rental revenue & calculated franchisee revenue share across GoodLife clubs.
  4. Delivery and pickup delay averages by delivery partner service area.
  5. Wellness subsidy & equipment damage claim approval ratios.
* **🛡️ Non-Destructive Soft-Deletion for Referential Integrity:** Following the FlexGear database specification, deleting customers, equipment units, or orders with transaction histories performs a status transition (`Inactive`, `Completed`, or `Cancelled`) rather than removing object references, preserving historical audit accuracy.
* **✅ Strict Form Validations & Diverse Primitive Data Types (`AppValidator.java`):** Prevents `null` or empty submissions and validates regex formatting (emails, postal codes, serial numbers) alongside at least four primitive data types:
  * `int`: Customer age ($16\text{--}100$), rental duration days, delivery delay hours.
  * `double`: Monthly subscription price, daily rental rate, repair cost estimate, approved claim payout.
  * `float`: Equipment utilization rate ($0.0\text{--}1.0$), discount/subsidy percentage.
  * `boolean`: `isSafetyPassed`, `isAvailable`, `isPolicyVerified`, `isClaimApproved`.
* **📧 Advanced Bonus Features:** Includes automated **JavaMail** email dispatch notifications upon cross-enterprise rental order or insurance subsidy approval, plus postal-prefix service area partner matching.

---

## 🚀 Usage Instructions & End-to-End Demo Walkthrough

1. **Step 1 – Member Onboarding & Subsidy Request (`advisor1`):**
   * Log in as `advisor1` (`Pass@123`). Register a new member with validated email, age, and subscription plan.
   * Click **Request Wellness Subsidy (WR6)** to send a cross-enterprise insurance verification to Enterprise 3, and click **Send Fitness Assessment (WR1)** to route a cross-organization evaluation to the Personal Trainer in Org 2.
2. **Step 2 – Fitness Prescription & Franchise Equipment Order (`trainer1` & `clubmgr1`):**
   * Log in as `trainer1` to complete `WR1`, recommending a switch from a punching bag to a rowing machine.
   * Log in as `clubmgr1` and submit an `EquipmentRentalOrderWorkRequest` (**WR2**) across enterprises to FlexGear (`Org 3`).
3. **Step 3 – Pre-Rental Mechanical Safety Inspection (`rentalcoord1` & `tech1`):**
   * Log in as `rentalcoord1` to review `WR2` and dispatch an `EquipmentInspectionWorkRequest` (**WR3**) to Org 4.
   * Log in as `tech1`, inspect the serialized unit (`SN-ROW-8821`), mark condition as `Excellent`, and set `isSafetyPassed = true`.
4. **Step 4 – Inventory Allocation & Courier Scheduling (`inventory1` & `delivery1`):**
   * Log in as `inventory1`, lock the inspected unit to the order, and send a cross-enterprise `DeliveryAppointmentWorkRequest` (**WR4**) to Enterprise 3 (`Org 5`).
   * Log in as `delivery1`, assign the regional delivery partner by postal prefix, and mark the appointment `Delivered`.
5. **Step 5 – Return Pickup Damage Claim & Insurance Settlement (`delivery1` & `claims1`):**
   * When a returned punching bag exhibits mount damage during pickup, `delivery1` files a cross-organization `EquipmentDamageClaimWorkRequest` (**WR5**) to `Org 6`.
   * Log in as `claims1` to audit and approve both the damage claim (**WR5**) and the member's corporate wellness subsidy (**WR6**).
6. **Step 6 – Network Analytics Review (`sysadmin`):**
   * Log in as `sysadmin` and open the **Network Reporting & Analytics** dashboard to inspect updated utilization rates, franchise revenue shares, and claim settlement metrics.

---

## 🧪 Testing Guide

| Test Case ID | Feature Tested | Test Action / Input | Expected System Result |
| :--- | :--- | :--- | :--- |
| **TC-01** | Role-Based Access Control | Log in with `advisor1` vs. `tech1` vs. `claims1` | Each account routes strictly to its isolated `CardLayout` work area panel with zero unauthorized button access. |
| **TC-02** | Form Input & Primitive Validation | Submit customer form with invalid email `abc`, age `-5`, or empty name | `AppValidator` blocks submission and displays a descriptive `JOptionPane.ERROR_MESSAGE` dialog. |
| **TC-03** | Soft-Delete Integrity | Select an active customer or rental order with history and click **Deactivate / Cancel** | Status updates to `Inactive` or `Cancelled` in the `JTable`; historical `WorkRequest` references remain intact without `NullPointerException`. |
| **TC-04** | Cross-Enterprise Queue Routing | Submit `WR2` from `FranchiseClubManager` (`Ent 1`) | Request immediately appears in `RentalOrderCoordinator` (`Ent 2`) organization work queue and sender's outbound history. |
| **TC-05** | DB4O Persistence & Faker Seeding | Create a new rental request, click **Logout**, and restart the app | `DataBank.db4o` reloads all 100+ Faker records plus the newly created request in its exact status state. |

---

## 🛠️ Challenges & Solutions

1. **Preventing Git Merge Conflicts Across 3 Time Zones (EST, CET, PST):**
   * *Challenge:* Simultaneous edits to shared NetBeans `.form` files and `EcoSystem` classes can trigger XML merge conflicts.
   * *Solution:* We partitioned the codebase strictly by Enterprise sub-packages (`ui.goodlife.*`, `ui.flexgear.*`, `ui.logistics.*`) and established a locked shared `WorkRequest` interface on `main` during Phase 1.
2. **Preserving Referential Integrity When Deleting Entities:**
   * *Challenge:* Physically removing a `CustomerProfile` or `EquipmentUnit` from an `ArrayList` broke historical `WorkRequest` rows and revenue reports.
   * *Solution:* Implemented non-destructive soft-deletes (`status = "Inactive"` or `"Cancelled"`), filtering active records in combo boxes while retaining historical references for analytics.

---

## 🔮 Future Enhancements

* **IoT Smart-Equipment Telemetry:** Stream real-time rowing machine and treadmill usage hours directly into `FlexGearEquipmentEnterprise` to trigger automated preventive maintenance (`WR3`) after every $250\text{ hours}$ of operation.
* **Stripe Payment Gateway Integration:** Process recurring monthly subscription charges and automated franchisee revenue-share payouts via REST API.
* **Interactive Map View:** Embed OpenStreetMap tiles in the `DeliveryCoordinatorWorkAreaJPanel` to visualize courier routes across Canadian and US postal codes.

---

## 📊 Contribution Breakdown

| Team Member | Code & Package Contributions | Documentation & Presentation Deliverables |
| :--- | :--- | :--- |
| **Kinder Izzo Celemin** | • `EcoSystem`, `Network`, Admin CRUD JPanels<br>• `ConfigureASystem.java` + Java Faker generator<br>• `GoodLifeFitnessEnterprise`, `Org 1` & `Org 2` WorkAreas<br>• `WR1` (`FitnessAssessment`) & `WR2` (`EquipmentRentalOrder`) | • Project Proposal Document (`.docx`)<br>• Presentation Slides & Problem Statement<br>• GitHub Repository Setup & Branch Management |
| **Astrid Noizillier** | • `FlexGearEquipmentEnterprise`, `EquipmentCatalog`, `EquipmentModel`, `EquipmentUnit`<br>• `Org 3` & `Org 4` WorkAreas (Rental, Inventory, Maintenance)<br>• `WR3` (`EquipmentInspection`) & `WR4` (`DeliveryAppointment`)<br>• `NetworkReportingJPanel` & Utilization/Revenue Math | • Detailed UML Class Diagram (`.pdf`)<br>• FlexGear Domain Specification & Soft-Delete Design<br>• Reporting Module Demo & Q&A Prep |
| **Mayu Rocha Yamada** | • `LogisticsAndInsuranceEnterprise`, `DeliveryServiceArea`<br>• `Org 5` & `Org 6` WorkAreas (Delivery Dispatch & Claims)<br>• `WR5` (`EquipmentDamageClaim`) & `WR6` (`WellnessSubsidy`)<br>• `AppValidator.java` & `EmailNotificationService.java` | • High-Level Component Diagram (`.pdf`)<br>• README Testing Guide & Validation Documentation<br>• Bonus Feature & End-to-End Demo Flow |

---

## 📦 Canvas & GitHub Submission Checklist

- [x] **Project Proposal** (`INFO5100_Final_Project_Proposal_GoodLife_FlexGear.docx`)
- [x] **Presentation Slides** (`GoodLife_FlexGear_Final_Presentation.pptx` / `.pdf`)
- [x] **High-Level Component Diagram** (`High_Level_Component_Diagram.pdf`)
- [x] **UML Class Diagram with Attributes, Methods & Relationships** (`UML_Class_Diagram.pdf`)
- [x] **Complete Runnable Java Swing Project Folder** (with Java Faker & `DataBank.db4o`)
