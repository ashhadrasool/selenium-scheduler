package kwoter.CollingwoodCourier.model;

import java.util.Date;

public class ConvictionData {
    private String proposerConvictionCode;
    private Date proposerConvictionDate;
    private String proposerConvictionPenalty;
    private int proposerConvictionMonthBan;
    private boolean proposerConvictionPending;
    private String proposerConvictionFineAmount;

    public String getProposerConvictionCode() {
        return proposerConvictionCode;
    }

    public void setProposerConvictionCode(String proposerConvictionCode) {
        this.proposerConvictionCode = proposerConvictionCode;
    }

    public Date getProposerConvictionDate() {
        return proposerConvictionDate;
    }

    public void setProposerConvictionDate(Date proposerConvictionDate) {
        this.proposerConvictionDate = proposerConvictionDate;
    }

    public String getProposerConvictionPenalty() {
        return proposerConvictionPenalty;
    }

    public void setProposerConvictionPenalty(String proposerConvictionPenalty) {
        this.proposerConvictionPenalty = proposerConvictionPenalty;
    }

    public int getProposerConvictionMonthBan() {
        return proposerConvictionMonthBan;
    }

    public void setProposerConvictionMonthBan(int proposerConvictionMonthBan) {
        this.proposerConvictionMonthBan = proposerConvictionMonthBan;
    }

    public boolean isProposerConvictionPending() {
        return proposerConvictionPending;
    }

    public void setProposerConvictionPending(boolean proposerConvictionPending) {
        this.proposerConvictionPending = proposerConvictionPending;
    }

    public String getProposerConvictionFineAmount() {
        return proposerConvictionFineAmount;
    }

    public void setProposerConvictionFineAmount(String proposerConvictionFineAmount) {
        this.proposerConvictionFineAmount = proposerConvictionFineAmount;
    }

    // Getters and setters
}
