package dev.milzipmoza.coupon.exceptions;

public class IllegalTicketInfoException extends RuntimeException {
    public IllegalTicketInfoException() {
    }

    public IllegalTicketInfoException(final String message) {
        super(message);
    }

    public IllegalTicketInfoException(final String message, final Throwable cause) {
        super(message, cause);
    }

    public IllegalTicketInfoException(final Throwable cause) {
        super(cause);
    }

    public IllegalTicketInfoException(final String message, final Throwable cause, final boolean enableSuppression, final boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
