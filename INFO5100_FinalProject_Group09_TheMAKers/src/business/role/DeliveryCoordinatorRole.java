/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package business.role;

import business.EcoSystem;
import business.enterprise.Enterprise;
import business.organization.Organization;
import business.useraccount.UserAccount;
import javax.swing.JPanel;
import ui.DeliveryCoordinatorWorkAreaJPanel;
/**
 *
 * @author Kinder Izzo Celemin
 */
public class DeliveryCoordinatorRole extends Role {
    @Override
    public JPanel createWorkArea(JPanel c, UserAccount a, Organization o, Enterprise e, EcoSystem s) {
        return new DeliveryCoordinatorWorkAreaJPanel(c, a, o, e, s);
    }
}