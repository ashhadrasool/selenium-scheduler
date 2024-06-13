package kwoter.CollingwoodCourier.enums;

public enum QuotesStatusEnum {
    SUCCESS(1),

    FAIL(2);


    private final int code;

    QuotesStatusEnum(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }

    public static QuotesStatusEnum fromCode(int code) {
        for (QuotesStatusEnum quotesQueueStatusEnum : QuotesStatusEnum.values()) {
            if (quotesQueueStatusEnum.getCode() == code) {
                return quotesQueueStatusEnum;
            }
        }
        throw new IllegalArgumentException("Unknown status code: " + code);
    }
}
