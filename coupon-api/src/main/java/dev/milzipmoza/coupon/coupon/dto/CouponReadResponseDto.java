package dev.milzipmoza.coupon.coupon.dto;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class CouponReadResponseDto {

    private Long no;
    private String name;

    @Builder
    public CouponReadResponseDto(final Long no, final String name) {
        this.no = no;
        this.name = name;
    }
}
