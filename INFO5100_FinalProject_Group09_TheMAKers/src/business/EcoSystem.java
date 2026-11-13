/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package business;

import business.enterprise.Enterprise;
import business.network.Network;
import business.organization.Organization;
import business.role.Role;
import business.role.SystemAdminRole;
import java.util.ArrayList;

/**
 * @desc Singleton root node of the Composite hierarchy. Inherits Organization
 * capabilities (UserAccountDirectory, EmployeeDirectory, WorkQueue) while
 * managing all regional Networks.
 * 
 * @author Kinder Izzo Celemin
 */
public class EcoSystem extends Organization {

    private static EcoSystem business;
    private ArrayList<Network> networkList;

    private EcoSystem() {
        super("GoodLife-FlexGear Global EcoSystem");
        this.networkList = new ArrayList<>();
    }

    public static EcoSystem getInstance() {
        if (business == null) {
            business = new EcoSystem();
        }
        return business;
    }

    public Network createAndAddNetwork(String name) {
        Network network = new Network(name);
        networkList.add(network);
        return network;
    }

    public ArrayList<Network> getNetworkList() {
        return networkList;
    }

    public boolean checkIfUserIsUnique(String username) {
        if (!this.getUserAccountDirectory().checkIfUsernameIsUnique(username)) {
            return false;
        }
        for (Network network : networkList) {
            for (Enterprise enterprise : network.getEnterpriseDirectory().getEnterpriseList()) {
                if (!enterprise.getUserAccountDirectory().checkIfUsernameIsUnique(username)) {
                    return false;
                }
                for (Organization org : enterprise.getOrganizationDirectory().getOrganizationList()) {
                    if (!org.getUserAccountDirectory().checkIfUsernameIsUnique(username)) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    @Override
    public ArrayList<Role> getSupportedRole() {
        ArrayList<Role> roleList = new ArrayList<>();
        roleList.add(new SystemAdminRole());
        return roleList;
    }
}