/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package business.enterprise;

import java.util.ArrayList;

/**
 * @desc Factory and directory for creating and storing the 3 Enterprises within
 * a Network.
 * 
 * @author Kinder Izzo Celemin
 */
public class EnterpriseDirectory {
    private ArrayList<Enterprise> enterpriseList;
    
    public ArrayList<Enterprise> getEnterpriseList() {
        return enterpriseList;
    }
    
    /**
     * @param name
     * @param type
     * @return 
     * @desc Instantiates the appropriate Enterprise subclass based on EnterpriseType.
     */
    public Enterprise createAndAddEnterprise(String name, Enterprise.EnterpriseType type) {
        Enterprise enterprise = null;
        if (null != type) switch (type) {
            case GoodLifeFitness:
                enterprise = new GoodLifeFitnessEnterprise(name);
                break;
            case FlexGearEquipment:
                enterprise = new FlexGearEquipmentEnterprise(name);
                break;
            case LogisticsAndInsurance:
                enterprise = new LogisticsAndInsuranceEnterprise(name);
                break;
            default:
                break;
        }
        if (enterprise != null) {
            enterpriseList.add(enterprise);
        }
        return enterprise;
    }
    
}
