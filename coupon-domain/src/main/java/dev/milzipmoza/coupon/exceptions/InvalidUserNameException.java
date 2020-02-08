package dev.milzipmoza.coupon.exceptions;

public class InvalidUserNameException extends RuntimeException {
    public InvalidUserNameException() {
    }

    public InvalidUserNameException(final String message) {
        super(message);
    }

    public InvalidUserNameException(final String message, final Throwable cause) {
        super(message, cause);
    }

    public InvalidUserNameException(final Throwable cause) {
        super(cause);
    }

    public InvalidUserNameException(final String message, final Throwable cause, final boolean enableSuppression, final boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
