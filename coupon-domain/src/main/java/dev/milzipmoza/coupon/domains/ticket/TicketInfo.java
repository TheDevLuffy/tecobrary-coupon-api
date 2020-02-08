package dev.milzipmoza.coupon.domains.ticket;

import dev.milzipmoza.coupon.exceptions.IllegalTicketInfoException;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
@Embeddable
@Getter
public class TicketInfo {

    private static final String TICKET_COUPON_NAME_EXCEPTION_MESSAGE = "쿠폰 이름은 30자를 초과할 수 없습니다.";

    @Column(name = "ticket_coupon_no",
            nullable = false,
            updatable = false)
    private Long couponNo;

    @Column(name = "ticket_coupon_name",
            nullable = false,
            updatable = false,
            length = 30)
    private String couponName;

    @Builder
    public TicketInfo(final Long couponNo,
                      final String couponName) {
        checkNoRange(couponNo);
        checkNameLength(couponName);
        this.couponNo = couponNo;
        this.couponName = couponName;
    }

    private void checkNoRange(final Long couponNo) {
        if (couponNo < 1) {
            throw new IllegalArgumentException("쿠폰 넘버는 1미만이 될 수 없습니다.");
        }
    }

    private void checkNameLength(final String couponName) {
        if (couponName.length() > 30 || couponName.length() == 0) {
            throw new IllegalTicketInfoException(TICKET_COUPON_NAME_EXCEPTION_MESSAGE);
        }
    }
}
