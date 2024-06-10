package kwoter.CollingwoodCourier.model;

import java.util.Date;
import java.util.List;

public class AdditionalDriverData {
    private String driverTitle;
    private String driverFirstName;
    private String driverLastName;
    private String driverDob;
    private String driverLicenseType;
    private String driverDrivingLicenseNo;
    private String driverDateTestPassed;
    private String driverUkResidentFrom;
    private String driverOccupation;
    private String driverBusinessType;
    private String driverEmploymentStatus;
    private String driverRelationship;
    private String driverSecondaryOccupation;
    private String hasDriverConditionDisqualified;
    private String hasDriverDeclined;
    private String hasDriverDisqualified;
    private String additionalDriverHasClaims;
    private List<ClaimData> driverAdditionalClaims;
    private boolean additionalDriverHasConvictions;
    private List<ConvictionData> driverAdditionalConvictions;

    public String getDriverTitle() {
        return driverTitle;
    }

    public void setDriverTitle(String driverTitle) {
        this.driverTitle = driverTitle;
    }

    public String getDriverFirstName() {
        return driverFirstName;
    }

    public void setDriverFirstName(String driverFirstName) {
        this.driverFirstName = driverFirstName;
    }

    public String getDriverLastName() {
        return driverLastName;
    }

    public void setDriverLastName(String driverLastName) {
        this.driverLastName = driverLastName;
    }

    public String getDriverDob() {
        return driverDob;
    }

    public void setDriverDob(String driverDob) {
        this.driverDob = driverDob;
    }

    public String getDriverLicenseType() {
        return driverLicenseType;
    }

    public void setDriverLicenseType(String driverLicenseType) {
        this.driverLicenseType = driverLicenseType;
    }

    public String getDriverDrivingLicenseNo() {
        return driverDrivingLicenseNo;
    }

    public void setDriverDrivingLicenseNo(String driverDrivingLicenseNo) {
        this.driverDrivingLicenseNo = driverDrivingLicenseNo;
    }

    public String getDriverDateTestPassed() {
        return driverDateTestPassed;
    }

    public void setDriverDateTestPassed(String driverDateTestPassed) {
        this.driverDateTestPassed = driverDateTestPassed;
    }

    public String getDriverUkResidentFrom() {
        return driverUkResidentFrom;
    }

    public void setDriverUkResidentFrom(String driverUkResidentFrom) {
        this.driverUkResidentFrom = driverUkResidentFrom;
    }

    public String getDriverOccupation() {
        return driverOccupation;
    }

    public void setDriverOccupation(String driverOccupation) {
        this.driverOccupation = driverOccupation;
    }

    public String getDriverBusinessType() {
        return driverBusinessType;
    }

    public void setDriverBusinessType(String driverBusinessType) {
        this.driverBusinessType = driverBusinessType;
    }

    public String getDriverEmploymentStatus() {
        return driverEmploymentStatus;
    }

    public void setDriverEmploymentStatus(String driverEmploymentStatus) {
        this.driverEmploymentStatus = driverEmploymentStatus;
    }

    public String getDriverRelationship() {
        return driverRelationship;
    }

    public void setDriverRelationship(String driverRelationship) {
        this.driverRelationship = driverRelationship;
    }

    public String getDriverSecondaryOccupation() {
        return driverSecondaryOccupation;
    }

    public void setDriverSecondaryOccupation(String driverSecondaryOccupation) {
        this.driverSecondaryOccupation = driverSecondaryOccupation;
    }

    public String getHasDriverConditionDisqualified() {
        return hasDriverConditionDisqualified;
    }

    public void setHasDriverConditionDisqualified(String hasDriverConditionDisqualified) {
        this.hasDriverConditionDisqualified = hasDriverConditionDisqualified;
    }

    public String getHasDriverDeclined() {
        return hasDriverDeclined;
    }

    public void setHasDriverDeclined(String hasDriverDeclined) {
        this.hasDriverDeclined = hasDriverDeclined;
    }

    public String getHasDriverDisqualified() {
        return hasDriverDisqualified;
    }

    public void setHasDriverDisqualified(String hasDriverDisqualified) {
        this.hasDriverDisqualified = hasDriverDisqualified;
    }

    public String getAdditionalDriverHasClaims() {
        return additionalDriverHasClaims;
    }

    public void setAdditionalDriverHasClaims(String additionalDriverHasClaims) {
        this.additionalDriverHasClaims = additionalDriverHasClaims;
    }

    public List<ClaimData> getDriverAdditionalClaims() {
        return driverAdditionalClaims;
    }

    public void setDriverAdditionalClaims(List<ClaimData> driverAdditionalClaims) {
        this.driverAdditionalClaims = driverAdditionalClaims;
    }

    public boolean isAdditionalDriverHasConvictions() {
        return additionalDriverHasConvictions;
    }

    public void setAdditionalDriverHasConvictions(boolean additionalDriverHasConvictions) {
        this.additionalDriverHasConvictions = additionalDriverHasConvictions;
    }

    public List<ConvictionData> getDriverAdditionalConvictions() {
        return driverAdditionalConvictions;
    }

    public void setDriverAdditionalConvictions(List<ConvictionData> driverAdditionalConvictions) {
        this.driverAdditionalConvictions = driverAdditionalConvictions;
    }
}
