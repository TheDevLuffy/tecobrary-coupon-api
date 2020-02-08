package dev.milzipmoza.coupon.exceptions;

public class AlreadySoftDeletedException extends RuntimeException {

    public AlreadySoftDeletedException() {
        super("이미 삭제된 데이터 입니다.");
    }

    public AlreadySoftDeletedException(final String message) {
        super(message);
    }

    public AlreadySoftDeletedException(final String message, final Throwable cause) {
        super(message, cause);
    }

    public AlreadySoftDeletedException(final Throwable cause) {
        super(cause);
    }

    public AlreadySoftDeletedException(final String message, final Throwable cause, final boolean enableSuppression, final boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
