package dev.milzipmoza.coupon.domains.coupon;

public class FailedIdentifyCreateUserException extends RuntimeException {

    private static final String FAILED_IDENTITY_USER_EXCEPTION = "쿠폰을 생성한 유저와 일치하지 않는 유저입니다.";

    public FailedIdentifyCreateUserException() {
        super(FAILED_IDENTITY_USER_EXCEPTION);
    }
}
