package dev.milzipmoza.coupon.coupon.dto;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@ToString
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class CouponCreateRequestDto {

    private String name;
    private String description;
    private LocalDateTime usableStartTime;
    private LocalDateTime usableEndTime;
    private Long createUserId;
    private String createUserName;

    @Builder
    public CouponCreateRequestDto(final String name,
                                   final String description,
                                   final LocalDateTime usableStartTime,
                                   final LocalDateTime usableEndTime,
                                   final Long createUserId,
                                   final String createUserName) {
        this.name = name;
        this.description = description;
        this.usableStartTime = usableStartTime;
        this.usableEndTime = usableEndTime;
        this.createUserId = createUserId;
        this.createUserName = createUserName;
    }
}
