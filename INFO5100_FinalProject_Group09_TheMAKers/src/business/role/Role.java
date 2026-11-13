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

/**
 * @desc Abstract Role class defining the  createWorkArea method for
 * CardLayout routing. Concrete Role subclasses connect authenticated sessions
 * to their dedicated WorkArea JPanels.
 * 
 * @author Kinder Izzo Celemin
 */
public abstract class Role {

    public abstract JPanel createWorkArea(
            JPanel container,
            UserAccount acc,
            Organization org,
            Enterprise ent,
            EcoSystem sys
    );

    @Override
    public String toString() {
        return this.getClass().getSimpleName();
    }
}
