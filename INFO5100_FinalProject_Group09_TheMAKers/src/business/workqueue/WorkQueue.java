/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package business.workqueue;

import java.util.ArrayList;

/**
 * @desc Holds a list of polymorphic WorkRequest objects for an Organization or
 * UserAccount.
 * @author Kinder Izzo Celemin
 */
public class WorkQueue {

    private ArrayList<WorkRequest> workRequestList;

    public WorkQueue() {
        this.workRequestList = new ArrayList<>();
    }

    public ArrayList<WorkRequest> getWorkRequestList() {
        return workRequestList;
    }
}
