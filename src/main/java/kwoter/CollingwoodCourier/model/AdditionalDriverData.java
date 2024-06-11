package kwoter.CollingwoodCourier.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;
import java.util.List;

public class AdditionalDriverData {
    @JsonProperty("DriverTitle")
    private String driverTitle;

    @JsonProperty("DriverFirstName")
    private String driverFirstName;

    @JsonProperty("DriverLastName")
    private String driverLastName;

    @JsonProperty("DriverDob")
    private String driverDob;

    @JsonProperty("DriverLicenseType")
    private String driverLicenseType;

    @JsonProperty("DriverDrivingLicenseNo")
    private String driverDrivingLicenseNo;

    @JsonProperty("DriverDateTestPassed")
    private String driverDateTestPassed;

    @JsonProperty("DriverUkResidentFrom")
    private String driverUkResidentFrom;

    @JsonProperty("DriverOccupation")
    private String driverOccupation;

    @JsonProperty("DriverBusinessType")
    private String driverBusinessType;

    @JsonProperty("DriverEmploymentStatus")
    private String driverEmploymentStatus;

    @JsonProperty("DriverRelationship")
    private String driverRelationship;

    @JsonProperty("DriverSecondaryOccupation")
    private String driverSecondaryOccupation;

    @JsonProperty("HasDriverConditionDisqualified")
    private String hasDriverConditionDisqualified;

    @JsonProperty("HasDriverDeclined")
    private String hasDriverDeclined;

    @JsonProperty("HasDriverDisqualified")
    private String hasDriverDisqualified;

    @JsonProperty("AdditionalDriverHasClaims")
    private String additionalDriverHasClaims;

    @JsonProperty("DriverAdditionalClaims")
    private List<DriverClaimData> driverAdditionalClaims;

    @JsonProperty("AdditionalDriverHasConvictions")
    private boolean additionalDriverHasConvictions;

    @JsonProperty("DriverAdditionalConvictions")
    private List<DriverConvictionData> driverAdditionalConvictions;

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

    public List<DriverClaimData> getDriverAdditionalClaims() {
        return driverAdditionalClaims;
    }

    public void setDriverAdditionalClaims(List<DriverClaimData> driverAdditionalClaims) {
        this.driverAdditionalClaims = driverAdditionalClaims;
    }

    public boolean isAdditionalDriverHasConvictions() {
        return additionalDriverHasConvictions;
    }

    public void setAdditionalDriverHasConvictions(boolean additionalDriverHasConvictions) {
        this.additionalDriverHasConvictions = additionalDriverHasConvictions;
    }

    public List<DriverConvictionData> getDriverAdditionalConvictions() {
        return driverAdditionalConvictions;
    }

    public void setDriverAdditionalConvictions(List<DriverConvictionData> driverAdditionalConvictions) {
        this.driverAdditionalConvictions = driverAdditionalConvictions;
    }
}
