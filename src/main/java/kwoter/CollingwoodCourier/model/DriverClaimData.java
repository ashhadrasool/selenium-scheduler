package kwoter.CollingwoodCourier.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class DriverClaimData {
    @JsonProperty("DriverClaimDescription")
    private String claimDescription;

    @JsonProperty("DriverClaimDate")
    private String claimDate;

    @JsonProperty("DriverClaimCost")
    private String claimCost;

    public String getClaimDescription() {
        return claimDescription;
    }

    public void setClaimDescription(String claimDescription) {
        this.claimDescription = claimDescription;
    }

    public String getClaimDate() {
        return claimDate;
    }

    public void setClaimDate(String claimDate) {
        this.claimDate = claimDate;
    }

    public String getClaimCost() {
        return claimCost;
    }

    public void setClaimCost(String claimCost) {
        this.claimCost = claimCost;
    }
}
