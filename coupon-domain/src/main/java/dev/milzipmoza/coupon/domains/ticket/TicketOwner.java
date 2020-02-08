package dev.milzipmoza.coupon.domains.ticket;

import dev.milzipmoza.coupon.exceptions.InvalidUserNameException;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
@Embeddable
class TicketOwner {

    private static final String USER_ID_RANGE_EXCEPTION_MESSAGE = "유저 id 는 1미만이 될 수 없습니다";
    private static final String NAME_LENGTH_EXCEPTION_MESSAGE = "닉네임을 확인해주세요";

    @Column(name = "ticket_owner_user_id",
            updatable = false,
            nullable = false)
    private Long userId;

    @Column(name = "ticket_owner_user_name",
            updatable = false,
            nullable = false)
    private String userName;

    @Builder
    public TicketOwner(final Long userId, final String userName) {
        checkIdRange(userId);
        checkNameLength(userName);
        this.userId = userId;
        this.userName = userName;
    }

    private void checkIdRange(final Long userId) {
        if (userId < 1) {
            throw new IllegalArgumentException(USER_ID_RANGE_EXCEPTION_MESSAGE);
        }
    }

    private void checkNameLength(final String userName) {
        if (userName.length() == 0) {
            throw new InvalidUserNameException(NAME_LENGTH_EXCEPTION_MESSAGE);
        }
    }
}
