package dev.milzipmoza.coupon.coupon.presentation;

import dev.milzipmoza.coupon.common.ApiResponse;
import dev.milzipmoza.coupon.coupon.application.CouponCRUDModule;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@Slf4j
@RestController
@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public class CouponReadController {

    private static final String REQUEST_HEADER_USER_ID = "Tecobrary-User-Id";
    private static final String REQUEST_HEADER_USER_NAME = "Tecobrary-User-Name";

    private final CouponCRUDModule couponCRUDModule;

    @GetMapping("/v1/coupons")
    public Mono<ApiResponse> readUserCoupon(
            @RequestHeader(name = REQUEST_HEADER_USER_ID) Long userId,
            @RequestHeader(name = REQUEST_HEADER_USER_NAME) String userName
    ) {
        log.info("[쿠폰조회] user_id - {}, user_name - {}", userId, userName);
        return Mono.just(couponCRUDModule.readByUserInfo(userId, userName));
    }
}
