package kwoter.CollingwoodCourier.entity;

import jakarta.persistence.*;
import java.sql.Timestamp;
@Entity
@Table(name = "request_log_data")
public class RequestLogData {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, updatable = false)
    private Integer id;

    @Column(name = "request_log_id", nullable = false)
    private Integer requestLogId;

    @Column(name = "error_message")
    private String errorMessage;

    @Column(name = "headers")
    private String headers;

    @Column(name = "input")
    private String input;

    @Column(name = "input_schema")
    private String inputSchema;

    @Column(name = "output")
    private String output;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getRequestLogId() {
        return requestLogId;
    }

    public void setRequestLogId(Integer requestLogId) {
        this.requestLogId = requestLogId;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getHeaders() {
        return headers;
    }

    public void setHeaders(String headers) {
        this.headers = headers;
    }

    public String getInput() {
        return input;
    }

    public void setInput(String input) {
        this.input = input;
    }

    public String getInputSchema() {
        return inputSchema;
    }

    public void setInputSchema(String inputSchema) {
        this.inputSchema = inputSchema;
    }

    public String getOutput() {
        return output;
    }

    public void setOutput(String output) {
        this.output = output;
    }
}
