package dev.milzipmoza.coupon.domains.coupon;

import dev.milzipmoza.coupon.common.DeletableEntity;
import dev.milzipmoza.coupon.enums.CouponStatus;
import dev.milzipmoza.coupon.exceptions.IllegalCouponConditionException;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;


@NoArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
@EqualsAndHashCode(of = "couponNo", callSuper = false)
@Table(name = "COUPON")
@Entity
public class Coupon extends DeletableEntity {

    private static final int COUPON_NAME_LENGTH = 30;
    private static final int COUPON_DESC_LENGTH = 100;
    private static final String COUPON_NAME_EXCEPTION_MESSAGE = "쿠폰 이름은 최대 30자 입니다.";
    private static final String COUPON_DESC_EXCEPTION_MESSAGE = "쿠폰 정보는 최대 100자 입니다.";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "coupon_no")
    private Long couponNo;

    @Column(name = "coupon_name",
            length = 30)
    private String name;

    @Column(name = "coupon_description",
            length = 100)
    private String description;

    @Embedded
    private CouponUsablePeriod usablePeriod;

    @Embedded
    private CouponInfo info;

    @Enumerated(EnumType.STRING)
    @Column(name = "coupon_status")
    private CouponStatus status;

    @Builder
    public Coupon(final String name,
                  final String description,
                  final LocalDateTime usableStartTime,
                  final LocalDateTime usableEndTime,
                  final CouponInfo info) {
        checkName(name);
        checkDescription(description);
        this.name = name;
        this.description = description;
        this.usablePeriod = new CouponUsablePeriod(usableStartTime, usableEndTime);
        this.info = info;
        this.status = CouponStatus.CREATED;
    }

    private void checkName(final String name) {
        if (name.length() > COUPON_NAME_LENGTH) {
            throw new IllegalCouponConditionException(COUPON_NAME_EXCEPTION_MESSAGE);
        }
    }

    private void checkDescription(final String description) {
        if (description.length() > COUPON_DESC_LENGTH) {
            throw new IllegalCouponConditionException(COUPON_DESC_EXCEPTION_MESSAGE);
        }
    }
}
