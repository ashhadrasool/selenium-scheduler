package kwoter.CollingwoodCourier.entity;

import jakarta.persistence.Entity;

import jakarta.persistence.*;
import java.util.Date;
@Entity
@Table(name = "request_logs")
public class RequestLog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, updatable = false)
    private Integer id;

    @Column(name = "company_id")
    private Integer companyId;

    @Column(name = "object_id")
    private Integer objectId;

    @Column(name = "success", nullable = false)
    private Boolean success;

    @Column(name = "object_type", nullable = false)
    private Short objectType;

    @Column(name = "webservice_id")
    private Integer webserviceId;

    @Column(name = "request_type", nullable = false)
    private Integer requestType;

    @Column(name = "error_type")
    private Integer errorType;

    @Column(name = "target_type")
    private Integer targetType;

    @Column(name = "target_id")
    private Integer targetId;

    @Column(name = "created_at", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;

    // Getters and Setters
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

    public Integer getObjectId() {
        return objectId;
    }

    public void setObjectId(Integer objectId) {
        this.objectId = objectId;
    }

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public Short getObjectType() {
        return objectType;
    }

    public void setObjectType(Short objectType) {
        this.objectType = objectType;
    }

    public Integer getWebserviceId() {
        return webserviceId;
    }

    public void setWebserviceId(Integer webserviceId) {
        this.webserviceId = webserviceId;
    }

    public Integer getRequestType() {
        return requestType;
    }

    public void setRequestType(Integer requestType) {
        this.requestType = requestType;
    }

    public Integer getErrorType() {
        return errorType;
    }

    public void setErrorType(Integer errorType) {
        this.errorType = errorType;
    }

    public Integer getTargetType() {
        return targetType;
    }

    public void setTargetType(Integer targetType) {
        this.targetType = targetType;
    }

    public Integer getTargetId() {
        return targetId;
    }

    public void setTargetId(Integer targetId) {
        this.targetId = targetId;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }
}
