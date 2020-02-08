package dev.milzipmoza.coupon.coupon.application;

public class NotFoundCouponException extends RuntimeException {

    public NotFoundCouponException() {
        super("존재하지 않는 쿠폰입니다");
    }
}
