/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package business.domain;

/**
 * @desc Represents a regional freight courier service area mapped by
 * Canadian/US postal prefix.
 *
 * @author Kinder Izzo Celemin
 */
public class DeliveryServiceArea {
    private String areaId;
    private String partnerName;
    private String regionName;
    private String postalPrefix;
    private int averageDelayHours;
    private static int counter = 1;

    public DeliveryServiceArea(String partnerName, String regionName, String postalPrefix, int averageDelayHours) {
        this.areaId = "AREA-0" + (counter++);
        this.partnerName = partnerName;
        this.regionName = regionName;
        this.postalPrefix = postalPrefix;
        this.averageDelayHours = averageDelayHours;
    }

    public String getAreaId() {
        return areaId;
    }

    public String getPartnerName() {
        return partnerName;
    }

    public String getRegionName() {
        return regionName;
    }

    public String getPostalPrefix() {
        return postalPrefix;
    }

    public int getAverageDelayHours() {
        return averageDelayHours;
    }

    public void setAverageDelayHours(int hours) {
        this.averageDelayHours = hours;
    }

    @Override
    public String toString() {
        return regionName + " (" + partnerName + " - Prefix: " + postalPrefix + ")";
    }
}
