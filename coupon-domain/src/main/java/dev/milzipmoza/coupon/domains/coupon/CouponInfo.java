package dev.milzipmoza.coupon.domains.coupon;

import dev.milzipmoza.coupon.exceptions.InvalidUserNameException;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
@Embeddable
@Getter
public class CouponInfo {

    public static final String CHECK_NAME_EXCEPTION_MESSAGE = "닉네임 확인이 필요합니다";
    @Column(name = "create_user_id",
            nullable = false,
            updatable = false)
    private Long createUserId;

    @Column(name = "create_user_name",
            nullable = false,
            updatable = false)
    private String createUserName;

    @Builder
    public CouponInfo(final Long createUserId,
                      final String createUserName) {
        checkName(createUserName);
        this.createUserId = createUserId;
        this.createUserName = createUserName;
    }

    private void checkName(final String createUserName) {
        if (createUserName.length() == 0) {
            throw new InvalidUserNameException(CHECK_NAME_EXCEPTION_MESSAGE);
        }
    }
}
