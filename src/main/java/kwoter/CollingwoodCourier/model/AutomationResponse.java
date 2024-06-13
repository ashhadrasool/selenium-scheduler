package kwoter.CollingwoodCourier.model;

public class AutomationResponse {
    private QuoteDetails quoteDetails;
    private ErrorDetails errorDetails;

    public QuoteDetails getQuoteDetails() {
        return quoteDetails;
    }

    public void setQuoteDetails(QuoteDetails quoteDetails) {
        this.quoteDetails = quoteDetails;
    }

    public ErrorDetails getErrorDetails() {
        return errorDetails;
    }

    public void setErrorDetails(ErrorDetails errorDetails) {
        this.errorDetails = errorDetails;
    }
}
