package dev.milzipmoza.coupon.coupon.application;

import dev.milzipmoza.coupon.common.ApiResponse;
import dev.milzipmoza.coupon.coupon.dto.CouponCreateRequestDto;
import dev.milzipmoza.coupon.coupon.dto.CouponCreateResponseDto;
import dev.milzipmoza.coupon.coupon.dto.CouponDeleteResponseDto;
import dev.milzipmoza.coupon.coupon.dto.CouponReadResponseDto;
import dev.milzipmoza.coupon.domains.coupon.Coupon;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public class CouponModule {

    private static final String READ_SUCCESS_MESSAGE = "쿠폰 조회 성공";
    private static final String CREATE_SUCCESS_MESSAGE = "쿠폰 생성 성공";
    private static final String DELETE_SUCCESS_MESSAGE = "쿠폰 삭제 성공";

    private final CouponService couponService;

    public ApiResponse readByUserInfo(final Long userId,
                                      final String userName) {
        List<CouponReadResponseDto> response = couponService.readByUserInfo(userId, userName)
                .stream()
                .map(coupon -> CouponReadResponseDto.builder()
                        .no(coupon.getCouponNo())
                        .name(coupon.getName())
                        .build())
                .collect(Collectors.toList());
        return ApiResponse.ok(
                READ_SUCCESS_MESSAGE,
                new HashMap<>().put("coupons", response)
        );
    }

    public ApiResponse create(final Long userId,
                              final String userName,
                              final CouponCreateRequestDto requestDto) {
        Coupon savedCoupon = couponService.create(userId, userName, requestDto);
        CouponCreateResponseDto response = CouponCreateResponseDto.builder()
                .name(savedCoupon.getName())
                .description(savedCoupon.getDescription())
                .usableStartTime(savedCoupon.getUsableStartTime())
                .usableEndTime(savedCoupon.getUsableEndTime())
                .build();
        return ApiResponse.ok(
                CREATE_SUCCESS_MESSAGE,
                new HashMap<>().put("coupon", response)
        );
    }

    public ApiResponse delete(final Long userId,
                                          final Long couponNo) {
        Coupon deletedCoupon = couponService.delete(userId, couponNo);
        CouponDeleteResponseDto response = CouponDeleteResponseDto.builder()
                .name(deletedCoupon.getName())
                .build();
        return ApiResponse.ok(
                DELETE_SUCCESS_MESSAGE,
                new HashMap<>().put("delete", response)
        );
    }
}
