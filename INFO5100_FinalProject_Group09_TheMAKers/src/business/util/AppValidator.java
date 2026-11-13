/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package business.util;

import java.util.regex.Pattern;
/**
 * @desc Centralized form input validation utility
 * Enforces non-null checks, Regex pattern matching, and bounds across int,
 * double, float, and Boolean.
 * 
 * @author Mayu Rocha Yamada
 */
public class AppValidator {

    private static final Pattern EMAIL_PATTERN = Pattern.compile("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,6}$");
    private static final Pattern SERIAL_PATTERN = Pattern.compile("^SN-[A-Z]{3}-\\d{4}$");
    private static final Pattern POSTAL_PATTERN = Pattern.compile("^[A-Za-z0-9\\s-]{3,10}$");

    public static boolean isNotEmpty(String input) {
        return input != null && !input.trim().isEmpty();
    }

    public static boolean isValidEmail(String email) {
        return isNotEmpty(email) && EMAIL_PATTERN.matcher(email.trim()).matches();
    }

    public static boolean isValidSerialNumber(String serial) {
        return isNotEmpty(serial) && SERIAL_PATTERN.matcher(serial.trim()).matches();
    }

    public static boolean isValidPostalCode(String postal) {
        return isNotEmpty(postal) && POSTAL_PATTERN.matcher(postal.trim()).matches();
    }

    public static boolean isValidAge(int age) {
        return age >= 16 && age <= 100;
    }

    public static boolean isPositiveDouble(double value) {
        return value > 0.0;
    }

    public static boolean isValidRateFloat(float rate) {
        return rate >= 0.0f && rate <= 1.0f;
    }
}
