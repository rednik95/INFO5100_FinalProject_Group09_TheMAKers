/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package business.workqueue;

import business.useraccount.UserAccount;
import java.util.Date;
/**
 * @desc Abstract superclass for all 6 cross-organization and cross-enterprise
 * workflows. Auto-generates unique request IDs (e.g., WR-2026-001) and tracks
 * lifecycle timestamps.
 * 
 * @author Kinder Izzo Celemin
 */
public abstract class WorkRequest {

    private String requestId;
    private String message;
    private UserAccount sender;
    private UserAccount receiver;
    private String status;
    private Date requestDate;
    private Date resolveDate;
    private static int counter = 1;

    public WorkRequest() {
        this.requestId = String.format("WR-2026-%03d", counter++);
        this.requestDate = new Date();
        this.status = "Requested";
    }

    public String getRequestId() {
        return requestId;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public UserAccount getSender() {
        return sender;
    }

    public void setSender(UserAccount sender) {
        this.sender = sender;
    }

    public UserAccount getReceiver() {
        return receiver;
    }

    public void setReceiver(UserAccount receiver) {
        this.receiver = receiver;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getRequestDate() {
        return requestDate;
    }

    public Date getResolveDate() {
        return resolveDate;
    }

    public void setResolveDate(Date resolveDate) {
        this.resolveDate = resolveDate;
    }

    @Override
    public String toString() {
        return requestId;
    }
}
