package dev.milzipmoza.coupon.coupon.dto;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class CouponCreateResponseDto {

    private String name;
    private String description;
    private LocalDateTime usableStartTime;
    private LocalDateTime usableEndTime;

    @Builder
    public CouponCreateResponseDto(final String name,
                                   final String description,
                                   final LocalDateTime usableStartTime,
                                   final LocalDateTime usableEndTime) {
        this.name = name;
        this.description = description;
        this.usableStartTime = usableStartTime;
        this.usableEndTime = usableEndTime;
    }
}
