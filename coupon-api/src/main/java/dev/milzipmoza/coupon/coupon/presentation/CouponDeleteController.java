package dev.milzipmoza.coupon.coupon.presentation;

import dev.milzipmoza.coupon.common.ApiResponse;
import dev.milzipmoza.coupon.coupon.application.CouponCRUDModule;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import reactor.core.publisher.Mono;

@Slf4j
@Controller("/v1/coupon")
@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public class CouponDeleteController {

    private static final String REQUEST_HEADER_USER_ID = "Tecobrary-User-Id";
    private static final String REQUEST_HEADER_USER_NAME = "Tecobrary-User-Name";

    private final CouponCRUDModule couponCRUDModule;

    @DeleteMapping
    public Mono<ApiResponse> deleteCoupon(
            @RequestHeader(name = REQUEST_HEADER_USER_ID) Long userId,
            @RequestHeader(name = REQUEST_HEADER_USER_NAME) String userName,
            @RequestParam Long couponNo
    ) {
        log.info("[쿠폰삭제] user_id - {}, user_name - {}, request - {}", userId, userName, couponNo);
        return Mono.just(couponCRUDModule.delete(userId, couponNo));
    }
}
