package dev.milzipmoza.coupon.coupon.presentation;

import dev.milzipmoza.coupon.common.ApiResponse;
import dev.milzipmoza.coupon.coupon.application.CouponModule;
import dev.milzipmoza.coupon.coupon.dto.CouponCreateRequestDto;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@Slf4j
@Controller("/v1/coupon")
@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public class CouponCRUDController {

    private static final String REQUEST_HEADER_USER_ID = "Tecobrary-User-Id";
    private static final String REQUEST_HEADER_USER_NAME = "Tecobrary-User-Name";

    private final CouponModule couponModule;

    @GetMapping
    public Mono<ApiResponse> readUserCoupon(
            @RequestHeader(name = REQUEST_HEADER_USER_ID) Long userId,
            @RequestHeader(name = REQUEST_HEADER_USER_NAME) String userName
    ) {
        log.info("[쿠폰조회] user_id - {}, user_name - {}", userId, userName);
        return Mono.just(couponModule.readByUserInfo(userId, userName));
    }

    @PostMapping
    public Mono<ApiResponse> createCoupon(
            @RequestHeader(name = REQUEST_HEADER_USER_ID) Long userId,
            @RequestHeader(name = REQUEST_HEADER_USER_NAME) String userName,
            @RequestBody CouponCreateRequestDto requestDto
    ) {
        log.info("[쿠폰생성] user_id - {}, user_name - {}, request - {}", userId, userName, requestDto);
        return Mono.just(couponModule.create(userId, userName, requestDto));
    }

    @DeleteMapping
    public Mono<ApiResponse> deleteCoupon(
            @RequestHeader(name = REQUEST_HEADER_USER_ID) Long userId,
            @RequestHeader(name = REQUEST_HEADER_USER_NAME) String userName,
            @RequestParam Long couponNo
    ) {
        log.info("[쿠폰삭제] user_id - {}, user_name - {}, request - {}", userId, userName, couponNo);
        return Mono.just(couponModule.delete(userId, couponNo));
    }
}
