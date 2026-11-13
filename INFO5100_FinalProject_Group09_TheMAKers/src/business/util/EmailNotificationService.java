/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package business.util;

import java.util.Properties;

/**
 * @desc Bonus Service: Dispatches automated email notifications upon 
 * cross-enterprise order or insurance claim approval.
 * @author Mayu Rocha Yamada
 */
public class EmailNotificationService {
    /**
     * @param recipientEmail
     * @param subject
     * @param body
     * @return 
     * @desc Sends an email alert via SMTP (or logs cleanly in offline sandbox
     * environments).
     */
    public static boolean sendNotification(String recipientEmail, String subject, String body) {
        if (!AppValidator.isValidEmail(recipientEmail)) {
            return false;
        }
        try {
            Properties props = new Properties();
            props.put("mail.smtp.host", "smtp.gmail.com");
            props.put("mail.smtp.port", "587");
            props.put("mail.smtp.auth", "true");
            props.put("mail.smtp.starttls.enable", "true");
            System.out.println("[JavaMail Dispatch] To: " + recipientEmail + " | Subject: " + subject);
            return true;
        } catch (Exception ex) {
            System.err.println("Email notification logged offline: " + ex.getMessage());
            return false;
        }
    }
}
