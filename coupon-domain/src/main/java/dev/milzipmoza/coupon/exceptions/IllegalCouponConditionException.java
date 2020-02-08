package dev.milzipmoza.coupon.exceptions;

public class IllegalCouponConditionException extends RuntimeException {
    public IllegalCouponConditionException() {
        super();
    }

    public IllegalCouponConditionException(final String message) {
        super(message);
    }

    public IllegalCouponConditionException(final String message, final Throwable cause) {
        super(message, cause);
    }

    public IllegalCouponConditionException(final Throwable cause) {
        super(cause);
    }

    protected IllegalCouponConditionException(final String message, final Throwable cause, final boolean enableSuppression, final boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
