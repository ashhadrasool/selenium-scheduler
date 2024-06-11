package kwoter.CollingwoodCourier.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class DriverConvictionData {
    @JsonProperty("DriverConvictionCode")
    private String convictionCode;

    @JsonProperty("DriverConvictionDate")
    private String convictionDate;

    @JsonProperty("DriverConvictionPenalty")
    private String convictionPenalty;

    @JsonProperty("DriverConvictionMonthBan")
    private String convictionMonthBan;

    @JsonProperty("DriverConvictionPending")
    private boolean convictionPending;

    @JsonProperty("DriverConvictionFineAmount")
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
