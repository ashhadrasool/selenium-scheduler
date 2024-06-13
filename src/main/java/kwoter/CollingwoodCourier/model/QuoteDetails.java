package kwoter.CollingwoodCourier.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class QuoteDetails {
    @JsonProperty("CustomerID")
    private String customerID;

    @JsonProperty("quoteNumber")
    private String quoteNumber;

    @JsonProperty("broker_commission")
    private String brokerCommission;

    @JsonProperty("premium")
    private String premium;

    @JsonProperty("IPT")
    private String ipt;

    @JsonProperty("total")
    private String total;

    @JsonProperty("quote")
    private String quote;

    // Constructors
    public QuoteDetails() {
    }

    public QuoteDetails(String customerID, String quoteNumber, String brokerCommission, String premium, String ipt, String total, String quote) {
        this.customerID = customerID;
        this.quoteNumber = quoteNumber;
        this.brokerCommission = brokerCommission;
        this.premium = premium;
        this.ipt = ipt;
        this.total = total;
        this.quote = quote;
    }

    // Getters and Setters
    public String getCustomerID() {
        return customerID;
    }

    public void setCustomerID(String customerID) {
        this.customerID = customerID;
    }

    public String getQuoteNumber() {
        return quoteNumber;
    }

    public void setQuoteNumber(String quoteNumber) {
        this.quoteNumber = quoteNumber;
    }

    public String getBrokerCommission() {
        return brokerCommission;
    }

    public void setBrokerCommission(String brokerCommission) {
        this.brokerCommission = brokerCommission;
    }

    public String getPremium() {
        return premium;
    }

    public void setPremium(String premium) {
        this.premium = premium;
    }

    public String getIpt() {
        return ipt;
    }

    public void setIpt(String ipt) {
        this.ipt = ipt;
    }

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }

    public String getQuote() {
        return quote;
    }

    public void setQuote(String quote) {
        this.quote = quote;
    }

}
