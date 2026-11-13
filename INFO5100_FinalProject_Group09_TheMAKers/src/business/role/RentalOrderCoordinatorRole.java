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
import ui.RentalOrderCoordinatorWorkAreaJPanel;
/**
 *
 * @author Kinder Izzo Celemin
 */
public class RentalOrderCoordinatorRole extends Role {
    @Override
    public JPanel createWorkArea(JPanel c, UserAccount a, Organization o, Enterprise e, EcoSystem s) {
        return new RentalOrderCoordinatorWorkAreaJPanel(c, a, o, e, s);
    }
}
