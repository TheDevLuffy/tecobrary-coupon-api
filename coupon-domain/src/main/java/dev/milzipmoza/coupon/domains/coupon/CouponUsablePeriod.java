package dev.milzipmoza.coupon.domains.coupon;

import dev.milzipmoza.coupon.exceptions.InvalidCouponUsablePeriodException;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.time.LocalDateTime;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
@Embeddable
@Getter
class CouponUsablePeriod {

    private static final String START_TIME_EXCEPTION_MESSAGE = "사용 가능 시작 시간은 현재 시간보다 빠를 수 없습니다.";
    private static final String END_TIME_EXCEPTION_MESSAGE = "사용 가능 종료 시간은 현재 시간보다 빠를 수 없습니다.";
    private static final String PERIOD_EXCEPTION_MESSAGE = "사용 가능 종료 시간은 사용 가능 시작 시간보다 빠를 수 없습니다.";

    @Column(name = "coupon_usable_start_time")
    private LocalDateTime usableStartTime;

    @Column(name = "coupon_usable_end_time")
    private LocalDateTime usableEndTime;

    CouponUsablePeriod(final LocalDateTime usableStartTime,
                       final LocalDateTime usableEndTime) {
        checkStartTime(usableStartTime);
        checkPeriod(usableStartTime, usableEndTime);
        this.usableStartTime = usableStartTime;
        this.usableEndTime = usableEndTime;
    }

    private void checkStartTime(final LocalDateTime usableStartTime) {
        if (usableStartTime.isBefore(LocalDateTime.now())) {
            throw new InvalidCouponUsablePeriodException(START_TIME_EXCEPTION_MESSAGE);
        }
    }

    private void checkPeriod(final LocalDateTime usableStartTime, final LocalDateTime usableEndTime) {
        if (usableEndTime.isBefore(usableStartTime)) {
            throw new InvalidCouponUsablePeriodException(PERIOD_EXCEPTION_MESSAGE);
        }
    }
}
