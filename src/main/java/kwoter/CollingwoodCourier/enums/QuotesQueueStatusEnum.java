package kwoter.CollingwoodCourier.enums;

public enum QuotesQueueStatusEnum {
    PENDING(0),
    PROCESSING(1),
    FAIL(2),
    SUCCESS(9);


    private final int code;

    QuotesQueueStatusEnum(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }

    public static QuotesQueueStatusEnum fromCode(int code) {
        for (QuotesQueueStatusEnum quotesQueueStatusEnum : QuotesQueueStatusEnum.values()) {
            if (quotesQueueStatusEnum.getCode() == code) {
                return quotesQueueStatusEnum;
            }
        }
        throw new IllegalArgumentException("Unknown status code: " + code);
    }
}
