package dev.milzipmoza.coupon.coupon.presentation;

import dev.milzipmoza.coupon.common.ApiResponse;
import dev.milzipmoza.coupon.coupon.application.CouponCRUDModule;
import dev.milzipmoza.coupon.coupon.dto.CouponCreateRequestDto;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import reactor.core.publisher.Mono;

@Slf4j
@Controller("/v1/coupon")
@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public class CouponCreateController {

    private static final String REQUEST_HEADER_USER_ID = "Tecobrary-User-Id";
    private static final String REQUEST_HEADER_USER_NAME = "Tecobrary-User-Name";

    private final CouponCRUDModule couponCRUDModule;

    @PostMapping
    public Mono<ApiResponse> createCoupon(
            @RequestHeader(name = REQUEST_HEADER_USER_ID) Long userId,
            @RequestHeader(name = REQUEST_HEADER_USER_NAME) String userName,
            @RequestBody CouponCreateRequestDto requestDto
    ) {
        log.info("[쿠폰생성] user_id - {}, user_name - {}, request - {}", userId, userName, requestDto);
        return Mono.just(couponCRUDModule.create(userId, userName, requestDto));
    }
}
