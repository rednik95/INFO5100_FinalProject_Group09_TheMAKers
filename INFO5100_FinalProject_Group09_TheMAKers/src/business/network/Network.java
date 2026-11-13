/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package business.network;

import business.enterprise.EnterpriseDirectory;

/**
 * @desc Represents a geographical network corridor (e.g., North American
 * GoodLife-FlexGear Fitness Network) that holds an EnterpriseDirectory of
 * participating enterprises.
 * 
 * @author Kinder Izzo Celemin
 */
public class Network {
    private String name;
    private final EnterpriseDirectory enterpriseDirectory;
    
    public Network(String name) {
        this.name = name;
        this.enterpriseDirectory = new EnterpriseDirectory();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    public EnterpriseDirectory getEnterpriseDirectory() {
        return enterpriseDirectory;
    }

    @Override
    public String toString() {
        return name;
    }
    
}
