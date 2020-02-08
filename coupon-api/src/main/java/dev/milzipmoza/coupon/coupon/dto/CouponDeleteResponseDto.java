package dev.milzipmoza.coupon.coupon.dto;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class CouponDeleteResponseDto {

    private String name;

    @Builder
    public CouponDeleteResponseDto(final String name) {
        this.name = name;
    }
}
