package kwoter.CollingwoodCourier.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;
import java.util.List;

public class InsuranceData {

    @JsonProperty("Username")
    private String username;

    @JsonProperty("Password")
    private String password;

    @JsonProperty("FirstName")
    private String firstName;

    @JsonProperty("LastName")
    private String lastName;

    @JsonProperty("Dob")
    private String dob;

    @JsonProperty("PolicyHolder")
    private String policyHolder;

    @JsonProperty("CompanyName")
    private String companyName;

    @JsonProperty("CompanyRegistrationNumber")
    private String companyRegistrationNumber;

    @JsonProperty("CoverType")
    private String coverType;

    @JsonProperty("ClassOfUse")
    private String classOfUse;

    @JsonProperty("BusinessType")
    private String businessType;

    @JsonProperty("TelephoneNumber")
    private String telephoneNumber;

    @JsonProperty("MobileNumber")
    private String mobileNumber;

    @JsonProperty("Email")
    private String email;

    @JsonProperty("Occupation")
    private String occupation;

    @JsonProperty("EmploymentStatus")
    private String employmentStatus;

    @JsonProperty("SecondaryOccupation")
    private String secondaryOccupation;

    @JsonProperty("VatRegistration")
    private String vatRegistration;

    @JsonProperty("IsSetProposerPermanentAddress")
    private String isSetProposerPermanentAddress;

    @JsonProperty("ProposerBuildingNumber")
    private String proposerBuildingNumber;

    @JsonProperty("ProposerPostcode")
    private String proposerPostcode;

    @JsonProperty("Title")
    private String title;

    @JsonProperty("Address1")
    private String address1;

    @JsonProperty("Address2")
    private String address2;

    @JsonProperty("Town")
    private String town;

    @JsonProperty("County")
    private String county;

    @JsonProperty("Postcode")
    private String postcode;

    @JsonProperty("ProposerLicenseType")
    private String proposerLicenseType;

    @JsonProperty("ProposerDrivingLicenseNo")
    private String proposerDrivingLicenseNo;

    @JsonProperty("ProposerDateTestPassed")
    private String proposerDateTestPassed;

    @JsonProperty("ProposerUkResidentFrom")
    private String proposerUkResidentFrom;

    @JsonProperty("HasProposerConditionDisqualified")
    private String hasProposerConditionDisqualified;

    @JsonProperty("HasProposerDeclined")
    private String hasProposerDeclined;

    @JsonProperty("HasProposerDisqualified")
    private String hasProposerDisqualified;

    @JsonProperty("HasProposerClaims")
    private boolean hasProposerClaims;

    @JsonProperty("ProposerAdditionalClaims")
    private List<ClaimData> proposerAdditionalClaims;

    @JsonProperty("HasProposerConvictions")
    private boolean hasProposerConvictions;

    @JsonProperty("ProposerAdditionalConvictions")
    private List<ConvictionData> proposerAdditionalConvictions;

    @JsonProperty("hasAdditionalDrivers")
    private Boolean hasAdditionalDrivers;

    @JsonProperty("AdditionalDrivers")
    private List<AdditionalDriverData> additionalDrivers;

    @JsonProperty("VehicleRegistration")
    private String vehicleRegistration;

    @JsonProperty("VehicleOvernightGaraging")
    private String vehicleOvernightGaraging;

    @JsonProperty("VehicleCarriageBasic")
    private String vehicleCarriageBasic;

    @JsonProperty("VehicleWorkRadius")
    private String vehicleWorkRadius;

    @JsonProperty("VehicleHazardous")
    private String vehicleHazardous;

    @JsonProperty("VehicleValue")
    private String vehicleValue;

    @JsonProperty("VehicleModified")
    private String vehicleModified;

    @JsonProperty("VehicleGaragingPostcode")
    private String vehicleGaragingPostcode;

    @JsonProperty("VehicleDrops")
    private String vehicleDrops;

    @JsonProperty("VehicleRegular")
    private String vehicleRegular;

    @JsonProperty("VehicleHaveSignage")
    private String vehicleHaveSignage;

    @JsonProperty("VehicleMaxValue")
    private String vehicleMaxValue;

    @JsonProperty("VehicleVisitSites")
    private String vehicleVisitSites;

    @JsonProperty("VehicleOutsideUK")
    private String vehicleOutsideUK;

    @JsonProperty("InsuranceInsurer")
    private String insuranceInsurer;

    @JsonProperty("InsurancePolicyNo")
    private String insurancePolicyNo;

    @JsonProperty("InsuranceRegistrationNo")
    private String insuranceRegistrationNo;

    @JsonProperty("InsuranceExpiryDate")
    private String insuranceExpiryDate;

    @JsonProperty("InsuranceNCD")
    private String insuranceNCD;

    @JsonProperty("InsuranceProfNCD")
    private String insuranceProfNCD;

    @JsonProperty("InsuranceDateNCD")
    private String insuranceDateNCD;

    @JsonProperty("QuoteStartDate")
    private String quoteStartDate;

    @JsonProperty("QuoteStartTime")
    private String quoteStartTime;

    @JsonProperty("QuotePolicyDuration")
    private String quotePolicyDuration;
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getPolicyHolder() {
        return policyHolder;
    }

    public void setPolicyHolder(String policyHolder) {
        this.policyHolder = policyHolder;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getCompanyRegistrationNumber() {
        return companyRegistrationNumber;
    }

    public void setCompanyRegistrationNumber(String companyRegistrationNumber) {
        this.companyRegistrationNumber = companyRegistrationNumber;
    }

    public String getCoverType() {
        return coverType;
    }

    public void setCoverType(String coverType) {
        this.coverType = coverType;
    }

    public String getClassOfUse() {
        return classOfUse;
    }

    public void setClassOfUse(String classOfUse) {
        this.classOfUse = classOfUse;
    }

    public String getBusinessType() {
        return businessType;
    }

    public void setBusinessType(String businessType) {
        this.businessType = businessType;
    }

    public String getTelephoneNumber() {
        return telephoneNumber;
    }

    public void setTelephoneNumber(String telephoneNumber) {
        this.telephoneNumber = telephoneNumber;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getOccupation() {
        return occupation;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }

    public String getEmploymentStatus() {
        return employmentStatus;
    }

    public void setEmploymentStatus(String employmentStatus) {
        this.employmentStatus = employmentStatus;
    }

    public String getSecondaryOccupation() {
        return secondaryOccupation;
    }

    public void setSecondaryOccupation(String secondaryOccupation) {
        this.secondaryOccupation = secondaryOccupation;
    }

    public String getVatRegistration() {
        return vatRegistration;
    }

    public void setVatRegistration(String vatRegistration) {
        this.vatRegistration = vatRegistration;
    }

    public String getIsSetProposerPermanentAddress() {
        return isSetProposerPermanentAddress;
    }

    public void setIsSetProposerPermanentAddress(String isSetProposerPermanentAddress) {
        this.isSetProposerPermanentAddress = isSetProposerPermanentAddress;
    }

    public String getProposerBuildingNumber() {
        return proposerBuildingNumber;
    }

    public void setProposerBuildingNumber(String proposerBuildingNumber) {
        this.proposerBuildingNumber = proposerBuildingNumber;
    }

    public String getProposerPostcode() {
        return proposerPostcode;
    }

    public void setProposerPostcode(String proposerPostcode) {
        this.proposerPostcode = proposerPostcode;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAddress1() {
        return address1;
    }

    public void setAddress1(String address1) {
        this.address1 = address1;
    }

    public String getAddress2() {
        return address2;
    }

    public void setAddress2(String address2) {
        this.address2 = address2;
    }

    public String getTown() {
        return town;
    }

    public void setTown(String town) {
        this.town = town;
    }

    public String getCounty() {
        return county;
    }

    public void setCounty(String county) {
        this.county = county;
    }

    public String getPostcode() {
        return postcode;
    }

    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }

    public String getProposerLicenseType() {
        return proposerLicenseType;
    }

    public void setProposerLicenseType(String proposerLicenseType) {
        this.proposerLicenseType = proposerLicenseType;
    }

    public String getProposerDrivingLicenseNo() {
        return proposerDrivingLicenseNo;
    }

    public void setProposerDrivingLicenseNo(String proposerDrivingLicenseNo) {
        this.proposerDrivingLicenseNo = proposerDrivingLicenseNo;
    }

    public String getProposerDateTestPassed() {
        return proposerDateTestPassed;
    }

    public void setProposerDateTestPassed(String proposerDateTestPassed) {
        this.proposerDateTestPassed = proposerDateTestPassed;
    }

    public String getProposerUkResidentFrom() {
        return proposerUkResidentFrom;
    }

    public void setProposerUkResidentFrom(String proposerUkResidentFrom) {
        this.proposerUkResidentFrom = proposerUkResidentFrom;
    }

    public String getHasProposerConditionDisqualified() {
        return hasProposerConditionDisqualified;
    }

    public void setHasProposerConditionDisqualified(String hasProposerConditionDisqualified) {
        this.hasProposerConditionDisqualified = hasProposerConditionDisqualified;
    }

    public String getHasProposerDeclined() {
        return hasProposerDeclined;
    }

    public void setHasProposerDeclined(String hasProposerDeclined) {
        this.hasProposerDeclined = hasProposerDeclined;
    }

    public String getHasProposerDisqualified() {
        return hasProposerDisqualified;
    }

    public void setHasProposerDisqualified(String hasProposerDisqualified) {
        this.hasProposerDisqualified = hasProposerDisqualified;
    }

    public boolean isHasProposerClaims() {
        return hasProposerClaims;
    }

    public void setHasProposerClaims(boolean hasProposerClaims) {
        this.hasProposerClaims = hasProposerClaims;
    }

    public List<ClaimData> getProposerAdditionalClaims() {
        return proposerAdditionalClaims;
    }

    public void setProposerAdditionalClaims(List<ClaimData> proposerAdditionalClaims) {
        this.proposerAdditionalClaims = proposerAdditionalClaims;
    }

    public boolean isHasProposerConvictions() {
        return hasProposerConvictions;
    }

    public void setHasProposerConvictions(boolean hasProposerConvictions) {
        this.hasProposerConvictions = hasProposerConvictions;
    }

    public List<ConvictionData> getProposerAdditionalConvictions() {
        return proposerAdditionalConvictions;
    }

    public void setProposerAdditionalConvictions(List<ConvictionData> proposerAdditionalConvictions) {
        this.proposerAdditionalConvictions = proposerAdditionalConvictions;
    }

    public Boolean getHasAdditionalDrivers() {
        return hasAdditionalDrivers;
    }

    public void setHasAdditionalDrivers(Boolean hasAdditionalDrivers) {
        this.hasAdditionalDrivers = hasAdditionalDrivers;
    }

    public List<AdditionalDriverData> getAdditionalDrivers() {
        return additionalDrivers;
    }

    public void setAdditionalDrivers(List<AdditionalDriverData> additionalDrivers) {
        this.additionalDrivers = additionalDrivers;
    }

    public String getVehicleRegistration() {
        return vehicleRegistration;
    }

    public void setVehicleRegistration(String vehicleRegistration) {
        this.vehicleRegistration = vehicleRegistration;
    }

    public String getVehicleOvernightGaraging() {
        return vehicleOvernightGaraging;
    }

    public void setVehicleOvernightGaraging(String vehicleOvernightGaraging) {
        this.vehicleOvernightGaraging = vehicleOvernightGaraging;
    }

    public String getVehicleCarriageBasic() {
        return vehicleCarriageBasic;
    }

    public void setVehicleCarriageBasic(String vehicleCarriageBasic) {
        this.vehicleCarriageBasic = vehicleCarriageBasic;
    }

    public String getVehicleWorkRadius() {
        return vehicleWorkRadius;
    }

    public void setVehicleWorkRadius(String vehicleWorkRadius) {
        this.vehicleWorkRadius = vehicleWorkRadius;
    }

    public String getVehicleHazardous() {
        return vehicleHazardous;
    }

    public void setVehicleHazardous(String vehicleHazardous) {
        this.vehicleHazardous = vehicleHazardous;
    }

    public String getVehicleValue() {
        return vehicleValue;
    }

    public void setVehicleValue(String vehicleValue) {
        this.vehicleValue = vehicleValue;
    }

    public String getVehicleModified() {
        return vehicleModified;
    }

    public void setVehicleModified(String vehicleModified) {
        this.vehicleModified = vehicleModified;
    }

    public String getVehicleGaragingPostcode() {
        return vehicleGaragingPostcode;
    }

    public void setVehicleGaragingPostcode(String vehicleGaragingPostcode) {
        this.vehicleGaragingPostcode = vehicleGaragingPostcode;
    }

    public String getVehicleDrops() {
        return vehicleDrops;
    }

    public void setVehicleDrops(String vehicleDrops) {
        this.vehicleDrops = vehicleDrops;
    }

    public String getVehicleRegular() {
        return vehicleRegular;
    }

    public void setVehicleRegular(String vehicleRegular) {
        this.vehicleRegular = vehicleRegular;
    }

    public String getVehicleHaveSignage() {
        return vehicleHaveSignage;
    }

    public void setVehicleHaveSignage(String vehicleHaveSignage) {
        this.vehicleHaveSignage = vehicleHaveSignage;
    }

    public String getVehicleMaxValue() {
        return vehicleMaxValue;
    }

    public void setVehicleMaxValue(String vehicleMaxValue) {
        this.vehicleMaxValue = vehicleMaxValue;
    }

    public String getVehicleVisitSites() {
        return vehicleVisitSites;
    }

    public void setVehicleVisitSites(String vehicleVisitSites) {
        this.vehicleVisitSites = vehicleVisitSites;
    }

    public String getVehicleOutsideUK() {
        return vehicleOutsideUK;
    }

    public void setVehicleOutsideUK(String vehicleOutsideUK) {
        this.vehicleOutsideUK = vehicleOutsideUK;
    }

    public String getInsuranceInsurer() {
        return insuranceInsurer;
    }

    public void setInsuranceInsurer(String insuranceInsurer) {
        this.insuranceInsurer = insuranceInsurer;
    }

    public String getInsurancePolicyNo() {
        return insurancePolicyNo;
    }

    public void setInsurancePolicyNo(String insurancePolicyNo) {
        this.insurancePolicyNo = insurancePolicyNo;
    }

    public String getInsuranceRegistrationNo() {
        return insuranceRegistrationNo;
    }

    public void setInsuranceRegistrationNo(String insuranceRegistrationNo) {
        this.insuranceRegistrationNo = insuranceRegistrationNo;
    }

    public String getInsuranceExpiryDate() {
        return insuranceExpiryDate;
    }

    public void setInsuranceExpiryDate(String insuranceExpiryDate) {
        this.insuranceExpiryDate = insuranceExpiryDate;
    }

    public String getInsuranceNCD() {
        return insuranceNCD;
    }

    public void setInsuranceNCD(String insuranceNCD) {
        this.insuranceNCD = insuranceNCD;
    }

    public String getInsuranceProfNCD() {
        return insuranceProfNCD;
    }

    public void setInsuranceProfNCD(String insuranceProfNCD) {
        this.insuranceProfNCD = insuranceProfNCD;
    }

    public String getInsuranceDateNCD() {
        return insuranceDateNCD;
    }

    public void setInsuranceDateNCD(String insuranceDateNCD) {
        this.insuranceDateNCD = insuranceDateNCD;
    }

    public String getQuoteStartDate() {
        return quoteStartDate;
    }

    public void setQuoteStartDate(String quoteStartDate) {
        this.quoteStartDate = quoteStartDate;
    }

    public String getQuoteStartTime() {
        return quoteStartTime;
    }

    public void setQuoteStartTime(String quoteStartTime) {
        this.quoteStartTime = quoteStartTime;
    }

    public String getQuotePolicyDuration() {
        return quotePolicyDuration;
    }

    public void setQuotePolicyDuration(String quotePolicyDuration) {
        this.quotePolicyDuration = quotePolicyDuration;
    }
}
