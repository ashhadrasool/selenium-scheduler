package kwoter.CollingwoodCourier.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import kwoter.CollingwoodCourier.model.*;
import kwoter.CollingwoodCourier.pages.DriversPage;
import kwoter.CollingwoodCourier.pages.*;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;

import java.util.*;

public class Automation extends Base {
    public String runAutomation(String json) {

        String response = "{}";

        goHome();

        String queue = System.getProperty("queue");
        String domain = System.getProperty("domain");
        String httpSchema = System.getProperty("httpSchema", "http");

        try {
            ObjectMapper objectMapper = new ObjectMapper();
            InsuranceData insuranceData = objectMapper.readValue(json.trim(), InsuranceData.class);

            if (insuranceData.getUsername() == null || insuranceData.getPassword() == null) {
                throw new InterruptedException("Username and password cannot be empty");
            }

            String username = insuranceData.getUsername();
            String password = insuranceData.getPassword();

            HomePage homePage = loginPage.clickHomePage(username, password);

            /**
             * HOME PAGE
             */

            String firstName = insuranceData.getFirstName();
            String lastName = insuranceData.getLastName();
            String DOB = insuranceData.getDob();

            homePage.setSearchClient(firstName);
            homePage.clickViewClient();
            homePage.selectListCustomer(firstName, lastName, DOB);

            ProposerPage proposerPage = homePage.clickProposerPage();

            /**
             * Proposer PAGE
             */

            //Check how many drivers we have.
            // If drivers length = 0 policyType = Insured Only Driving (I.O.D)
            // If drivers length = 1 policyType = I.O.D. plus 1
            // If drivers length >= 2 policyType = I.O.D. plus 2

            String policyType = "Insured Only Driving (I.O.D)";
            boolean hasAdditionalDrivers = insuranceData.getHasAdditionalDrivers();
            int getLengthAdditionalDrivers = 0;

            if (hasAdditionalDrivers) {
                getLengthAdditionalDrivers = insuranceData.getAdditionalDrivers().size();

                if (getLengthAdditionalDrivers == 1) {
                    policyType = "I.O.D. plus 1";
                }

                if (getLengthAdditionalDrivers > 1) {
                    policyType = "I.O.D. plus 2";
                }
            }

            String coverType = insuranceData.getCoverType();
            String classOfUse = insuranceData.getClassOfUse();
            String businessType = insuranceData.getBusinessType();
            String telephoneNumber = insuranceData.getTelephoneNumber();
            String mobileNumber = insuranceData.getMobileNumber();
            String email = insuranceData.getEmail();
            String occupation = insuranceData.getOccupation();
            String employmentStatus = insuranceData.getEmploymentStatus();
            String secondaryOccupation = insuranceData.getSecondaryOccupation();
            String vatRegistration = insuranceData.getVatRegistration();
            String IsSetProposerPermanentAddress = insuranceData.getIsSetProposerPermanentAddress();
            String title = insuranceData.getTitle();
            String address1 = insuranceData.getAddress1();
            String address2 = insuranceData.getAddress2();
            String town = insuranceData.getTown();
            String county = insuranceData.getCounty();
            String postcode = insuranceData.getPostcode();

            String PolicyHolder = insuranceData.getPolicyHolder();

            if (Objects.equals(PolicyHolder, "1")) {
                String companyName = insuranceData.getCompanyName();
                String companyRegistrationNumber = insuranceData.getCompanyRegistrationNumber();

                proposerPage.setPolicyLimitedCompany(PolicyHolder); //true or false
                proposerPage.setCompantyName(companyName, PolicyHolder);
                proposerPage.setCompanyRegistrationNumber(companyRegistrationNumber, PolicyHolder);
            }

            proposerPage.setPolicyType(policyType);
            proposerPage.setCoverType(coverType);
            proposerPage.setClassOfUse(classOfUse);
            proposerPage.setBusinessType(businessType);
            proposerPage.setVatRegistration(vatRegistration);
            proposerPage.setTelephoneNumber(telephoneNumber);
            proposerPage.setMobileNumber(mobileNumber);
            proposerPage.setEmail(email);
            proposerPage.setOccupation(occupation.toUpperCase());
            proposerPage.setEmploymentStatus(employmentStatus);
//            proposerPage.setSecondaryOccupation(secondaryOccupation); //todo enable
            proposerPage.setDOBday(this.dateSplit(DOB).get("day"));
            proposerPage.setDOBmonth(this.dateSplit(DOB).get("month"));
            proposerPage.setDOByear(this.dateSplit(DOB).get("year"));
            proposerPage.setTitle(title.toUpperCase());
            proposerPage.setFirstName(firstName);
            proposerPage.setLastName(lastName);

            if (IsSetProposerPermanentAddress.contains("Yes")) {
                String proposerBuildingNumber = insuranceData.getProposerBuildingNumber();
                String proposerPostcode = insuranceData.getProposerPostcode();
                proposerPage.setProposerBuildingNumber(proposerBuildingNumber);
                proposerPage.setProposePostcode(proposerPostcode);
            }

            proposerPage.setAddress1(address1);
            proposerPage.setAddress2(address2);
            proposerPage.setTown(town);
            proposerPage.setCounty(county);
            proposerPage.setPostcode(postcode);
            Thread.sleep(2000);

            DriversPage driversPage = proposerPage.clickDriversPage();

            if (proposerPage.hasErrors()) {
                reportError(proposerPage.getErrors(), httpSchema, domain, queue);
                System.out.println(proposerPage.getErrors());
            }

            /**
             * DRIVERS PAGE
             */

            String ProposerLicenseType = insuranceData.getProposerLicenseType();
            String ProposerDrivingLicenseNo = insuranceData.getProposerDrivingLicenseNo();
            String ProposerDateTestPassed = insuranceData.getProposerDateTestPassed();
            String ProposerUkResidentFrom = insuranceData.getProposerUkResidentFrom();

            driversPage.setProposerLicenseType(ProposerLicenseType.toUpperCase());
            driversPage.setProposerDrivingLicenseNo(ProposerDrivingLicenseNo);
            driversPage.setProposerdateTestPassedDay(this.dateSplit(ProposerDateTestPassed).get("day"));
            driversPage.setProposerdateTestPassedMonth(this.dateSplit(ProposerDateTestPassed).get("month"));
            driversPage.setProposerdateTestPassedYear(this.dateSplit(ProposerDateTestPassed).get("year"));
            driversPage.setProposerUKResidentFromDay(this.dateSplit(ProposerUkResidentFrom).get("day"));
            driversPage.setProposerUKResidentFromMonth(this.dateSplit(ProposerUkResidentFrom).get("month"));
            driversPage.setProposerUKResidentFromYear(this.dateSplit(ProposerUkResidentFrom).get("year"));

            //Even if we feed many drivers, Conlinwood only works with a
            // proposer and two drivers. For this we only take the purses
            // of the proposer and the first 2 drivers
            AdditionalDriverData firstDriver = null;
            AdditionalDriverData secondDriver = null;

            if (hasAdditionalDrivers) {
                try {
                    firstDriver = insuranceData.getAdditionalDrivers().get(0);
                } catch (Exception e) {
                }

                try {
                    secondDriver = insuranceData.getAdditionalDrivers().get(0);
                } catch (Exception e) {
                }

                if (firstDriver != null) {
                    driversPage.setFirstDriverTitle(firstDriver.getDriverTitle().toUpperCase());
                    driversPage.setFirstDriverFirstName(firstDriver.getDriverFirstName());
                    driversPage.setFirstDriverLastName(firstDriver.getDriverLastName());
                    driversPage.setFirstDriverDobDay(this.dateSplit(firstDriver.getDriverDob()).get("day"));
                    driversPage.setFirstDriverDobMonth(this.dateSplit(firstDriver.getDriverDob()).get("month"));
                    driversPage.setFirstDriverDobYear(this.dateSplit(firstDriver.getDriverDob()).get("year"));
                    driversPage.setFirstDriverLicenseType(firstDriver.getDriverLicenseType().toUpperCase());
                    driversPage.setFirstDriverDrivingLicenseNo(firstDriver.getDriverDrivingLicenseNo());
                    driversPage.setFirstDriverDateTestPassedDay(this.dateSplit(firstDriver.getDriverDateTestPassed()).get("day"));
                    driversPage.setFirstDriverDateTestPassedMonth(this.dateSplit(firstDriver.getDriverDateTestPassed()).get("month"));
                    driversPage.setFirstDriverDateTestPassedYear(this.dateSplit(firstDriver.getDriverDateTestPassed()).get("year"));
                    driversPage.setFirstDriverUkResidentFromDay(this.dateSplit(firstDriver.getDriverUkResidentFrom()).get("day"));
                    driversPage.setFirstDriverUkResidentFromMonth(this.dateSplit(firstDriver.getDriverUkResidentFrom()).get("month"));
                    driversPage.setFirstDriverUkResidentFromYear(this.dateSplit(firstDriver.getDriverUkResidentFrom()).get("year"));
                    driversPage.setFirstDriverOccupationDrivers(firstDriver.getDriverOccupation().toUpperCase());
                    driversPage.setFirstDriverBusinessType(firstDriver.getDriverBusinessType());
                    driversPage.setFirstDriverEmploymentStatus(firstDriver.getDriverEmploymentStatus());
                    driversPage.setFirstDriverRelationship(firstDriver.getDriverRelationship());
                    driversPage.setFirstDriverSecOccupationDrivers(firstDriver.getDriverSecondaryOccupation());
                }

                if (secondDriver != null) {
                    driversPage.setSecondDriverTitle(secondDriver.getDriverTitle().toUpperCase());
                    driversPage.setSecondDriverFirstName(secondDriver.getDriverFirstName());
                    driversPage.setSecondDriverLastName(secondDriver.getDriverLastName());
                    driversPage.setSecondDriverDobDay(this.dateSplit(secondDriver.getDriverDob()).get("day"));
                    driversPage.setSecondDriverDobMonth(this.dateSplit(secondDriver.getDriverDob()).get("month"));
                    driversPage.setSecondDriverDobYear(this.dateSplit(secondDriver.getDriverDob()).get("year"));
                    driversPage.setSecondDriverLicenseType(secondDriver.getDriverLicenseType().toUpperCase());
                    driversPage.setSecondDriverDrivingLicenseNo(secondDriver.getDriverDrivingLicenseNo());
                    driversPage.setSecondDriverDateTestPassedDay(this.dateSplit(secondDriver.getDriverDateTestPassed()).get("day"));
                    driversPage.setSecondDriverDateTestPassedMonth(this.dateSplit(secondDriver.getDriverDateTestPassed()).get("month"));
                    driversPage.setSecondDriverDateTestPassedYear(this.dateSplit(secondDriver.getDriverDateTestPassed()).get("year"));
                    driversPage.setSecondDriverUkResidentFromDay(this.dateSplit(secondDriver.getDriverUkResidentFrom()).get("day"));
                    driversPage.setSecondDriverUkResidentFromMonth(this.dateSplit(secondDriver.getDriverUkResidentFrom()).get("month"));
                    driversPage.setSecondDriverUkResidentFromYear(this.dateSplit(secondDriver.getDriverUkResidentFrom()).get("year"));
                    driversPage.setSecondDriverOccupationDrivers(secondDriver.getDriverOccupation().toUpperCase());
                    driversPage.setSecondDriverBusinessType(secondDriver.getDriverBusinessType());
                    driversPage.setSecondDriverEmploymentStatus(secondDriver.getDriverEmploymentStatus());
                    driversPage.setSecondDriverRelationship(secondDriver.getDriverRelationship());
                    driversPage.setSecondDriverSecOccupationDrivers(secondDriver.getDriverSecondaryOccupation());
                }

            }

            Thread.sleep(1000);
            QuestionsPage questionsPage = driversPage.clickQuestionsPage();
            if (driversPage.hasErrors()) {
                reportError(driversPage.getErrors(), httpSchema, domain, queue);
                System.out.println(driversPage.getErrors());
            }


            /**
             * QUESTIONS PAGE
             */

            questionsPage.setHasProposerConditionDisqualified(insuranceData.getHasProposerConditionDisqualified());
            questionsPage.setHasProposerDeclined(insuranceData.getHasProposerDeclined());
            questionsPage.setHasProposerDisqualified(insuranceData.getHasProposerDisqualified());

            if (firstDriver != null) {
                questionsPage.setHasFirstDriverConditionDisqualified(firstDriver.getHasDriverConditionDisqualified());
                questionsPage.setHasFirstDriverDeclined(firstDriver.getHasDriverDeclined());
                questionsPage.setFirstDriverHasFirstDriverDisqualified(firstDriver.getHasDriverDisqualified());
            }

            if (secondDriver != null) {
                questionsPage.setHasSecondDriverConditionDisqualified(secondDriver.getHasDriverConditionDisqualified());
                questionsPage.setHasSecondDriverDeclined(secondDriver.getHasDriverDeclined());
                questionsPage.setHasSecondDriverDisqualified(secondDriver.getHasDriverDisqualified());
            }
            AccidentPage accidentPage = questionsPage.clickAccidentPage();
            if (questionsPage.hasErrors()) {
                reportError(questionsPage.getErrors(), httpSchema, domain, queue);
                System.out.println(questionsPage.getErrors());
            }
            /**
             * ACCIDENT/CONVICTION PAGE
             */

            // Set no claim initially
            String haveClaim = "No";
            boolean proposerHasClaims = insuranceData.isHasProposerClaims();
            accidentPage.setNoClaim();

            // Proposer Claims
            if (proposerHasClaims) {
                List<ClaimData> proposerAdditionalClaims = insuranceData.getProposerAdditionalClaims();
                int proposerAdditionalClaimsIndex = 0;

                while (proposerAdditionalClaimsIndex < proposerAdditionalClaims.size()) {
                    ClaimData claimData = proposerAdditionalClaims.get(proposerAdditionalClaimsIndex);

                    String claimProposerDescription = claimData.getProposerClaimDescription();
                    String claimProposerDateDay = this.dateSplit(claimData.getProposerClaimDate()).get("day");
                    String claimProposerDateMonth = this.dateSplit(claimData.getProposerClaimDate()).get("month");
                    String claimProposerDateYear = this.dateSplit(claimData.getProposerClaimDate()).get("year");
                    String claimProposerCost = claimData.getProposerClaimCost();
                    String claimProposerName = insuranceData.getFirstName() + " " + insuranceData.getLastName();

                    // Set claim details on the accident page
                    accidentPage.setNoClaim(); // First set No, after that Yes to auto open add claim windows
                    accidentPage.setHaveClaim("Yes");
                    accidentPage.setDescriptionClaim(claimProposerDescription);
                    accidentPage.setDateDayClaim(claimProposerDateDay);
                    accidentPage.setDateMonthClaim(claimProposerDateMonth);
                    accidentPage.setDateyearClaim(claimProposerDateYear);
                    accidentPage.setCostClaim(claimProposerCost);
                    accidentPage.setDriverClaim(claimProposerName.toUpperCase());
                    accidentPage.clickSaveClaim();

                    proposerAdditionalClaimsIndex++;

                    if (accidentPage.hasErrors()) {
                        reportError(accidentPage.getErrors(), httpSchema, domain, queue);
                        System.out.println(accidentPage.getErrors());
                    }
                }
            }


            //First Driver Claims
            boolean additionalFirstDriverHasClaims = false;
            try {
                additionalFirstDriverHasClaims = Boolean.parseBoolean(firstDriver.getAdditionalDriverHasClaims());
            } catch (Exception e) {
                // e.printStackTrace();
            }

            // Assuming `firstDriver` is already defined as an AdditionalDriverData object

            if (additionalFirstDriverHasClaims) {
                List<DriverClaimData> firstDriverClaims = firstDriver.getDriverAdditionalClaims();

                for (DriverClaimData claim : firstDriverClaims) {
                    String claimFirstDriverDescription = claim.getClaimDescription();
                    Map<String, String> claimFirstDriverDate = this.dateSplit(claim.getClaimDate());
                    String claimFirstDriverDateDay = claimFirstDriverDate.get("day");
                    String claimFirstDriverDateMonth = claimFirstDriverDate.get("month");
                    String claimFirstDriverDateYear = claimFirstDriverDate.get("year");
                    String claimFirstDriverCost = claim.getClaimCost();
                    String claimFirstDriverName = firstDriver.getDriverFirstName() + " " + firstDriver.getDriverLastName();

                    accidentPage.setNoClaim(); // First set No after that Yes to auto open add claim windows
                    accidentPage.setHaveClaim("Yes");
                    accidentPage.setDescriptionClaim(claimFirstDriverDescription);
                    accidentPage.setDateDayClaim(claimFirstDriverDateDay);
                    accidentPage.setDateMonthClaim(claimFirstDriverDateMonth);
                    accidentPage.setDateyearClaim(claimFirstDriverDateYear);
                    accidentPage.setCostClaim(claimFirstDriverCost);
                    accidentPage.setDriverClaim(claimFirstDriverName.toUpperCase());
                    accidentPage.clickSaveClaim();

                    if (accidentPage.hasErrors()) {
                        reportError(accidentPage.getErrors(), httpSchema, domain, queue);
                        System.out.println(accidentPage.getErrors());
                    }
                }
            }


            //Second Driver Claims
            Boolean additionalSecondDriverHasClaims = false;

            try {
                additionalSecondDriverHasClaims = Boolean.parseBoolean(secondDriver.getAdditionalDriverHasClaims());
            } catch (Exception e) {
                // e.printStackTrace();
            }

            if(additionalSecondDriverHasClaims) {
                List<DriverClaimData> secondDriverClaims = secondDriver.getDriverAdditionalClaims();

                for (DriverClaimData claim : secondDriverClaims) {
                    String claimSecondDriverDescription = claim.getClaimDescription();
                    Map<String, String> claimSecondDriverDate = this.dateSplit(claim.getClaimDate());
                    String claimSecondDriverDateDay = claimSecondDriverDate.get("day");
                    String claimSecondDriverDateMonth = claimSecondDriverDate.get("month");
                    String claimSecondDriverDateYear = claimSecondDriverDate.get("year");
                    String claimSecondDriverCost = claim.getClaimCost();
                    String claimSecondDriverName = secondDriver.getDriverFirstName() + " " + secondDriver.getDriverLastName();

                    accidentPage.setNoClaim(); // First set No after that Yes to auto open add claim windows
                    accidentPage.setHaveClaim("Yes");
                    accidentPage.setDescriptionClaim(claimSecondDriverDescription);
                    accidentPage.setDateDayClaim(claimSecondDriverDateDay);
                    accidentPage.setDateMonthClaim(claimSecondDriverDateMonth);
                    accidentPage.setDateyearClaim(claimSecondDriverDateYear);
                    accidentPage.setCostClaim(claimSecondDriverCost);
                    accidentPage.setDriverClaim(claimSecondDriverName.toUpperCase());
                    accidentPage.clickSaveClaim();

                    if (accidentPage.hasErrors()) {
                        reportError(accidentPage.getErrors(), httpSchema, domain, queue);
                        System.out.println(accidentPage.getErrors());
                    }
                }
            }

            //Convictions
            String haveConvictions = "No";
            boolean proposerHasConvictions = false;

            try {
                proposerHasConvictions = insuranceData.isHasProposerConvictions();
            } catch (Exception e) {
                // e.printStackTrace();
            }

            accidentPage.setNoConvictions();

            //Proposer convictions
            if (proposerHasConvictions) {
                List<ConvictionData> proposerConvictions = insuranceData.getProposerAdditionalConvictions();

                for (ConvictionData conviction : proposerConvictions) {
                    String convictionProposerCode = conviction.getConvictionCode();
                    Map<String, String> convictionProposerDate = this.dateSplit(conviction.getConvictionDate());
                    String convictionProposerDateDay = convictionProposerDate.get("day");
                    String convictionProposerDateMonth = convictionProposerDate.get("month");
                    String convictionProposerDateYear = convictionProposerDate.get("year");
                    String convictionProposerPenalty = conviction.getConvictionPenalty();
                    String convictionProposerMonthBan = conviction.getConvictionMonthBan();
                    boolean convictionProposerPending = conviction.isConvictionPending();
                    String convictionProposerFineAmount = conviction.getConvictionFineAmount();
                    String convictionProposerName = insuranceData.getFirstName() + " " + insuranceData.getLastName();

                    accidentPage.setHaveConviction("Yes");
                    accidentPage.setConvictionCode(convictionProposerCode);
                    accidentPage.setConvictionDateDay(convictionProposerDateDay);
                    accidentPage.setConvictionDateMonth(convictionProposerDateMonth);
                    accidentPage.setConvictionDateYear(convictionProposerDateYear);
                    accidentPage.setConvictionPenalty(convictionProposerPenalty);
                    accidentPage.setConvictionMonthBan(convictionProposerMonthBan);
                    accidentPage.setConvictionPending(convictionProposerPending);
                    accidentPage.setConvictionFineAmount(convictionProposerFineAmount);
                    accidentPage.setConvictionName(convictionProposerName.toUpperCase());
                    accidentPage.clickSaveConviction();

                    if (accidentPage.hasErrors()) {
                        reportError(accidentPage.getErrors(), httpSchema, domain, queue);
                        System.out.println(accidentPage.getErrors());
                    }
                }
            }

            //First Driver convictions

            boolean additionalFirstDriverHasConvictions = false;
            try {
                additionalFirstDriverHasConvictions = firstDriver.isAdditionalDriverHasConvictions();
            } catch (Exception e) {
                // e.printStackTrace();
            }

            if(additionalFirstDriverHasConvictions) {
                List<DriverConvictionData> firstDriverConvictions = firstDriver.getDriverAdditionalConvictions();

                for (DriverConvictionData conviction : firstDriverConvictions) {
                    String convictionFirstDriverCode = conviction.getConvictionCode();
                    String convictionFirstDriverDateDay = this.dateSplit(conviction.getConvictionDate()).get("day");
                    String convictionFirstDriverDateMonth = this.dateSplit(conviction.getConvictionDate()).get("month");
                    String convictionFirstDriverDateYear = this.dateSplit(conviction.getConvictionDate()).get("year");
                    String convictionFirstDriverPenalty = conviction.getConvictionPenalty();
                    String convictionFirstDriverMonthBan = conviction.getConvictionMonthBan();
                    boolean convictionFirstDriverPending = conviction.isConvictionPending();
                    String convictionFirstDriverFineAmount = conviction.getConvictionFineAmount();
                    String convictionFirstDriverName = firstDriver.getDriverFirstName() + " "
                            + firstDriver.getDriverLastName();

                    accidentPage.setNoConvictions();//set first "No" to open automatic add Conv popup
                    accidentPage.setHaveConviction("Yes");
                    //            accidentPage.clickAddConv();
                    accidentPage.setConvictionCode(convictionFirstDriverCode);
                    accidentPage.setConvictionDateDay(convictionFirstDriverDateDay);
                    accidentPage.setConvictionDateMonth(convictionFirstDriverDateMonth);
                    accidentPage.setConvictionDateYear(convictionFirstDriverDateYear);
                    accidentPage.setConvictionPenalty(convictionFirstDriverPenalty);
                    accidentPage.setConvictionMonthBan(convictionFirstDriverMonthBan);
                    accidentPage.setConvictionPending(convictionFirstDriverPending);
                    accidentPage.setConvictionFineAmount(convictionFirstDriverFineAmount);
                    accidentPage.setConvictionName(convictionFirstDriverName.toUpperCase());
                    accidentPage.clickSaveConviction();

                    if (accidentPage.hasErrors()) {
                        reportError(accidentPage.getErrors(), httpSchema, domain, queue);
                        System.out.println(accidentPage.getErrors());
                    }
                }
            }

            //Second Driver convictions

            boolean additionalSecondDriverHasConvictions = false;
            try {
                additionalSecondDriverHasConvictions = secondDriver.isAdditionalDriverHasConvictions();
            } catch (Exception e) {
                // e.printStackTrace();
            }

            if (additionalSecondDriverHasConvictions) {
                List<DriverConvictionData> secondDriverConvictions = secondDriver.getDriverAdditionalConvictions();

                for (DriverConvictionData conviction : secondDriverConvictions) {
                    String convictionSecondDriverCode = conviction.getConvictionCode();
                    String convictionSecondDriverDateDay = this.dateSplit(conviction.getConvictionDate()).get("day");
                    String convictionSecondDriverDateMonth = this.dateSplit(conviction.getConvictionDate()).get("month");
                    String convictionSecondDriverDateYear = this.dateSplit(conviction.getConvictionDate()).get("year");
                    String convictionSecondDriverPenalty = conviction.getConvictionPenalty();
                    String convictionSecondDriverMonthBan = conviction.getConvictionMonthBan();
                    boolean convictionSecondDriverPending = conviction.isConvictionPending();
                    String convictionSecondDriverFineAmount = conviction.getConvictionFineAmount();
                    String convictionSecondDriverName = secondDriver.getDriverFirstName() + " "
                            + secondDriver.getDriverLastName();

                    accidentPage.setNoConvictions();//set first "No" to open automatic add Conv popup
                    accidentPage.setHaveConviction("Yes");
                    //            accidentPage.clickAddConv();
                    accidentPage.setConvictionCode(convictionSecondDriverCode);
                    accidentPage.setConvictionDateDay(convictionSecondDriverDateDay);
                    accidentPage.setConvictionDateMonth(convictionSecondDriverDateMonth);
                    accidentPage.setConvictionDateYear(convictionSecondDriverDateYear);
                    accidentPage.setConvictionPenalty(convictionSecondDriverPenalty);
                    accidentPage.setConvictionMonthBan(convictionSecondDriverMonthBan);
                    accidentPage.setConvictionPending(convictionSecondDriverPending);
                    accidentPage.setConvictionFineAmount(convictionSecondDriverFineAmount);
                    accidentPage.setConvictionName(convictionSecondDriverName.toUpperCase());
                    accidentPage.clickSaveConviction();

                    if (accidentPage.hasErrors()) {
                        reportError(accidentPage.getErrors(), httpSchema, domain, queue);
                        System.out.println(accidentPage.getErrors());
                    }
                }
            }


            VehiclePage vehiclePage = accidentPage.clickVehiclePage();

            if(accidentPage.hasErrors()){
                reportError(accidentPage.getErrors(), httpSchema, domain, queue);
                System.out.println(accidentPage.getErrors());
            }

            /**
             * VEHICLE PAGE
             */
            String vehicleRegistration = insuranceData.getVehicleRegistration();
            String vehicleOvernightGaraging = insuranceData.getVehicleOvernightGaraging();
            String vehicleCarriageBasic = insuranceData.getVehicleCarriageBasic();
            String vehicleWorkRadius = insuranceData.getVehicleWorkRadius();
            String vehicleHazardous = insuranceData.getVehicleHazardous();
            String vehicleValue = insuranceData.getVehicleValue();
            String vehicleModified = insuranceData.getVehicleModified();
            String vehicleGaragingPostcode = insuranceData.getVehicleGaragingPostcode();
            String vehicleDrops = insuranceData.getVehicleDrops();
            String vehicleRegular = insuranceData.getVehicleRegular();
            String vehicleHaveSignage = insuranceData.getVehicleHaveSignage();
            String vehicleMaxValue = insuranceData.getVehicleMaxValue();
            String vehicleVisitSites = insuranceData.getVehicleVisitSites();
            String vehicleOutsideUK = insuranceData.getVehicleOutsideUK();


            vehiclePage.setVehicleRegistration(vehicleRegistration);
            Thread.sleep(2000);

            if(vehiclePage.hasErrors()){
                reportError(vehiclePage.getErrors(), httpSchema, domain, queue);
                System.out.println(vehiclePage.getErrors());
            }
            vehiclePage.setVehicleOvernightGaraging(vehicleOvernightGaraging);

            //skip initially
            vehiclePage.setVehicleCarriageBasic(vehicleCarriageBasic);
            vehiclePage.setVehicleWorkRadius(vehicleWorkRadius);
            vehiclePage.setVehicleHazardous(vehicleHazardous);


            vehiclePage.setVehicleValue(vehicleValue);
            vehiclePage.setVehicleModifieds(vehicleModified);
            vehiclePage.setVehicleGaragingPostcode(vehicleGaragingPostcode);
            vehiclePage.setVehicleDrops(vehicleDrops);
            vehiclePage.setVehicleRegular(vehicleRegular);
            vehiclePage.setVehicleHaveSignage(vehicleHaveSignage);
            vehiclePage.setVehicleMaxValue(vehicleMaxValue);
//            vehiclePage.setVehiclevisitSites(vehicleVisitSites); //todo: ebable
            vehiclePage.setVehicleOutsideUK(vehicleOutsideUK);

            Thread.sleep(1000);

            if(vehiclePage.hasErrors()){
                reportError(vehiclePage.getErrors(), httpSchema, domain, queue);
                System.out.println(vehiclePage.getErrors());
            }

            InsurancePage insurancePage = vehiclePage.clickInsurancePage();

            String insuranceInsurer = insuranceData.getInsuranceInsurer();
            String insurancePolicyNo = insuranceData.getInsurancePolicyNo();
            String insuranceRegistrationNo = insuranceData.getInsuranceRegistrationNo();
            String insuranceExpiryDate = insuranceData.getInsuranceExpiryDate();
            String insuranceNcd = insuranceData.getInsuranceNCD();
            String insuranceProfNcd = insuranceData.getInsuranceProfNCD();
            String insuranceDateNcd = insuranceData.getInsuranceDateNCD();

//            insurancePage.setInsuranceInsurer(insuranceInsurer); //todo: enable
            insurancePage.setInsurancePolicyNo(insurancePolicyNo);
            insurancePage.setInsuranceRegistrationNo(insuranceRegistrationNo);
            insurancePage.setInsuranceExpiryDater(insuranceExpiryDate);
            insurancePage.setInsuranceNcd(insuranceNcd);

            if ("Yes".equals(insuranceProfNcd)) {
                insurancePage.setInsuranceProfNcd(insuranceProfNcd);
                insurancePage.setInsuranceDateNcd(insuranceDateNcd);
            }

            QuotePage quotePage = insurancePage.clickQuotePage();

            if(insurancePage.hasErrors()){
                reportError(insurancePage.getErrors(), httpSchema, domain, queue);
                System.out.println(insurancePage.getErrors());
            }


            /**
             * QUOTE PAGE
             */

            String quoteStartDateDay  = this.dateSplit(insuranceData.getQuoteStartDate()).get("day");
            String quoteStartDateMonth  = this.dateSplit(insuranceData.getQuoteStartDate()).get("month");
            String quoteStartDateYear  = this.dateSplit(insuranceData.getQuoteStartDate()).get("year");
            String quoteStartTime  = insuranceData.getQuoteStartTime();
            String quotePolicyDuration  = insuranceData.getQuotePolicyDuration();

            quotePage.setQuoteStartDateDay(quoteStartDateDay);
            quotePage.setQuoteStartDateMonth(quoteStartDateMonth);
            quotePage.setQuoteStartDateYear(quoteStartDateYear);
            quotePage.setQuoteStartTime(quoteStartTime);
            quotePage.setQuotePolicyDuration(quotePolicyDuration);

            quotePage.clickCalculate();

            Thread.sleep(2000);
            //first check if the page has an error message
            if(!quotePage.hasErrors()){
                quotePage.clickCalculateSave();
                quotePage.clickAlert();

                List<NameValuePair> results = new ArrayList<NameValuePair>();
                results.add(new BasicNameValuePair("CustomerID", quotePage.getCustomerIDinfo()));
                results.add(new BasicNameValuePair("quoteNumber", quotePage.getQuoteRef()));
                results.add(new BasicNameValuePair("broker_commission", quotePage.getBrokerageIncluded()));
                results.add(new BasicNameValuePair("premium", quotePage.getPremium()));
                results.add(new BasicNameValuePair("IPT", quotePage.getIpt()));
                results.add(new BasicNameValuePair("total", quotePage.getTotalClientPayable()));
                results.add(new BasicNameValuePair("quote", queue));

                reportResults(results, httpSchema, domain);

                System.out.println(results);
            }else{
                reportError(quotePage.getErrors(), httpSchema, domain, queue);
                System.out.println(quotePage.getErrors());
            }
        } catch (Exception e) {
            e.printStackTrace();
            reportError(e.getMessage(), httpSchema, domain, queue);
            System.err.println("exception thrown: " + e.getMessage());
        }
        return response;
    }

    private Map<String, String> dateSplit(String date) {

        String strDate[] = date.split("/");
        int day = Integer.parseInt(strDate[0]);
        int month = Integer.parseInt(strDate[1]);
        int year = Integer.parseInt(strDate[2]);

        Map<String, String> dateMap = new HashMap<String, String>();

        if (String.valueOf(day).length() == 1) {
            dateMap.put("day", String.valueOf("0" + day));
        } else {
            dateMap.put("day", String.valueOf(day));
        }

        if (String.valueOf(month).length() == 1) {
            dateMap.put("month", String.valueOf("0" + month));
        } else {
            dateMap.put("month", String.valueOf(month));
        }

        dateMap.put("year", String.valueOf(year));

        return dateMap;
    }
}
