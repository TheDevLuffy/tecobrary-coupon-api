package dev.milzipmoza.coupon.exceptions;

public class InvalidCouponUsablePeriodException extends RuntimeException {
    public InvalidCouponUsablePeriodException() {
    }

    public InvalidCouponUsablePeriodException(final String message) {
        super(message);
    }

    public InvalidCouponUsablePeriodException(final String message, final Throwable cause) {
        super(message, cause);
    }

    public InvalidCouponUsablePeriodException(final Throwable cause) {
        super(cause);
    }

    public InvalidCouponUsablePeriodException(final String message, final Throwable cause, final boolean enableSuppression, final boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
