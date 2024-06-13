package kwoter.CollingwoodCourier.entity;

import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name = "quotes")
public class Quotes {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, updatable = false)
    private Integer id;

    @Column(name = "company_id", nullable = false)
    private Integer companyId;

    @Column(name = "lead_id", nullable = false)
    private Integer leadId;

    @Column(name = "insurer_id", nullable = false)
    private Integer insurerId;

    @Column(name = "quote_id", length = 255, columnDefinition = "varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci")
    private String quoteId;

    @Column(name = "request_id")
    private Integer requestId;

    @Column(name = "seller_id")
    private Integer sellerId;

    @Column(name = "origin", nullable = false)
    private Byte origin;

    @Column(name = "status", nullable = false)
    private Integer status;

    @Column(name = "premium", precision = 10, scale = 2)
    private Double premium;

    @Column(name = "ipt", precision = 10, scale = 2, nullable = false, columnDefinition = "double(10,2) DEFAULT '0.00'")
    private Double ipt;

    @Column(name = "fee_amount", precision = 10, scale = 2)
    private Double feeAmount;

    @Column(name = "deposit", precision = 10, scale = 2)
    private Double deposit;

    @Column(name = "interest_rate_percent", precision = 10, scale = 2)
    private Double interestRatePercent;

    @Column(name = "instalments")
    private Integer instalments;

    @Column(name = "excess", precision = 10, scale = 2)
    private Double excess;

    @Column(name = "error", length = 255, columnDefinition = "varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci")
    private String error;

    @Column(name = "note", length = 255, columnDefinition = "varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci")
    private String note;

    @Column(name = "income", precision = 10, scale = 2)
    private Double income;

    @Column(name = "response", columnDefinition = "text CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci")
    private String response;

    @Column(name = "created_by", nullable = false)
    private Integer createdBy;

    @Column(name = "created_at", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;

    @Column(name = "updated_by")
    private Integer updatedBy;

    @Column(name = "updated_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date updatedAt;

    @Column(name = "deleted_by")
    private Integer deletedBy;

    @Column(name = "deleted_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date deletedAt;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Integer companyId) {
        this.companyId = companyId;
    }

    public Integer getLeadId() {
        return leadId;
    }

    public void setLeadId(Integer leadId) {
        this.leadId = leadId;
    }

    public Integer getInsurerId() {
        return insurerId;
    }

    public void setInsurerId(Integer insurerId) {
        this.insurerId = insurerId;
    }

    public String getQuoteId() {
        return quoteId;
    }

    public void setQuoteId(String quoteId) {
        this.quoteId = quoteId;
    }

    public Integer getRequestId() {
        return requestId;
    }

    public void setRequestId(Integer requestId) {
        this.requestId = requestId;
    }

    public Integer getSellerId() {
        return sellerId;
    }

    public void setSellerId(Integer sellerId) {
        this.sellerId = sellerId;
    }

    public Byte getOrigin() {
        return origin;
    }

    public void setOrigin(Byte origin) {
        this.origin = origin;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Double getPremium() {
        return premium;
    }

    public void setPremium(Double premium) {
        this.premium = premium;
    }

    public Double getIpt() {
        return ipt;
    }

    public void setIpt(Double ipt) {
        this.ipt = ipt;
    }

    public Double getFeeAmount() {
        return feeAmount;
    }

    public void setFeeAmount(Double feeAmount) {
        this.feeAmount = feeAmount;
    }

    public Double getDeposit() {
        return deposit;
    }

    public void setDeposit(Double deposit) {
        this.deposit = deposit;
    }

    public Double getInterestRatePercent() {
        return interestRatePercent;
    }

    public void setInterestRatePercent(Double interestRatePercent) {
        this.interestRatePercent = interestRatePercent;
    }

    public Integer getInstalments() {
        return instalments;
    }

    public void setInstalments(Integer instalments) {
        this.instalments = instalments;
    }

    public Double getExcess() {
        return excess;
    }

    public void setExcess(Double excess) {
        this.excess = excess;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public Double getIncome() {
        return income;
    }

    public void setIncome(Double income) {
        this.income = income;
    }

    public String getResponse() {
        return response;
    }

    public void setResponse(String response) {
        this.response = response;
    }

    public Integer getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(Integer createdBy) {
        this.createdBy = createdBy;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Integer getUpdatedBy() {
        return updatedBy;
    }

    public void setUpdatedBy(Integer updatedBy) {
        this.updatedBy = updatedBy;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    public Integer getDeletedBy() {
        return deletedBy;
    }

    public void setDeletedBy(Integer deletedBy) {
        this.deletedBy = deletedBy;
    }

    public Date getDeletedAt() {
        return deletedAt;
    }

    public void setDeletedAt(Date deletedAt) {
        this.deletedAt = deletedAt;
    }
}
