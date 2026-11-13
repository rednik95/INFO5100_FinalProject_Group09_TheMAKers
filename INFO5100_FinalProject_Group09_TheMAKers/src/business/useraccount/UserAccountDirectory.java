/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package business.useraccount;

import business.employee.Employee;
import business.role.Role;
import java.util.ArrayList;


/**
 * @desc Directory managing authentication and creation of UserAccounts within
 * an Organization or Enterprise.
 * @author Kinder Izzo Celemin
 */
public class UserAccountDirectory {

    private ArrayList<UserAccount> userAccountList;

    public UserAccountDirectory() {
        this.userAccountList = new ArrayList<>();
    }

    public ArrayList<UserAccount> getUserAccountList() {
        return userAccountList;
    }

    /**
     * @param username
     * @param password
     * @return 
     * @desc Validates login credentials and returns the matching UserAccount, or null
     * if invalid.
     */
    public UserAccount authenticateUser(String username, String password) {
        for (UserAccount ua : userAccountList) {
            if (ua.getUsername().equalsIgnoreCase(username) && ua.getPassword().equals(password)) {
                return ua;
            }
        }
        return null;
    }

    public UserAccount createUserAccount(String un, String pw, Employee emp, Role r) {
        UserAccount ua = new UserAccount(un, pw, emp, r);
        userAccountList.add(ua);
        return ua;
    }

    public boolean checkIfUsernameIsUnique(String username) {
        for (UserAccount ua : userAccountList) {
            if (ua.getUsername().equalsIgnoreCase(username)) {
                return false;
            }
        }
        return true;
    }
}
