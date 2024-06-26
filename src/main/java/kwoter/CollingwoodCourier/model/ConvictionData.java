package kwoter.CollingwoodCourier.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ConvictionData {
    @JsonProperty("ProposerConvictionCode")
    private String convictionCode;

    @JsonProperty("ProposerConvictionDate")
    private String convictionDate;

    @JsonProperty("ProposerConvictionPenalty")
    private String convictionPenalty;

    @JsonProperty("ProposerConvictionMonthBan")
    private String convictionMonthBan;

    @JsonProperty("ProposerConvictionPending")
    private boolean convictionPending;

    @JsonProperty("ProposerConvictionFineAmount")
    private String convictionFineAmount;

    public String getConvictionCode() {
        return convictionCode;
    }

    public void setConvictionCode(String convictionCode) {
        this.convictionCode = convictionCode;
    }

    public String getConvictionDate() {
        return convictionDate;
    }

    public void setConvictionDate(String convictionDate) {
        this.convictionDate = convictionDate;
    }

    public String getConvictionPenalty() {
        return convictionPenalty;
    }

    public void setConvictionPenalty(String convictionPenalty) {
        this.convictionPenalty = convictionPenalty;
    }

    public String getConvictionMonthBan() {
        return convictionMonthBan;
    }

    public void setConvictionMonthBan(String convictionMonthBan) {
        this.convictionMonthBan = convictionMonthBan;
    }

    public boolean isConvictionPending() {
        return convictionPending;
    }

    public void setConvictionPending(boolean convictionPending) {
        this.convictionPending = convictionPending;
    }

    public String getConvictionFineAmount() {
        return convictionFineAmount;
    }

    public void setConvictionFineAmount(String convictionFineAmount) {
        this.convictionFineAmount = convictionFineAmount;
    }
}
