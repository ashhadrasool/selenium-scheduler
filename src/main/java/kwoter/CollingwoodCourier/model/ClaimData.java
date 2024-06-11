package kwoter.CollingwoodCourier.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ClaimData {
    @JsonProperty("ProposerClaimDescription")
    private String proposerClaimDescription;

    @JsonProperty("ProposerClaimDate")
    private String proposerClaimDate;

    @JsonProperty("ProposerClaimCost")
    private String proposerClaimCost;

    public String getProposerClaimDescription() {
        return proposerClaimDescription;
    }

    public void setProposerClaimDescription(String proposerClaimDescription) {
        this.proposerClaimDescription = proposerClaimDescription;
    }

    public String getProposerClaimDate() {
        return proposerClaimDate;
    }

    public void setProposerClaimDate(String proposerClaimDate) {
        this.proposerClaimDate = proposerClaimDate;
    }

    public String getProposerClaimCost() {
        return proposerClaimCost;
    }

    public void setProposerClaimCost(String proposerClaimCost) {
        this.proposerClaimCost = proposerClaimCost;
    }
}
