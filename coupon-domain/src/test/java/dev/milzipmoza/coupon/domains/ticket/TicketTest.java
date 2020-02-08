package dev.milzipmoza.coupon.domains.ticket;

import dev.milzipmoza.coupon.exceptions.IllegalTicketInfoException;
import dev.milzipmoza.coupon.exceptions.InvalidUserNameException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TicketTest {

    private static final long VALID_ID = 1L;
    private static final String VALID_USER_NAME = "루피";
    private static final String VALID_COUPON_NAME = "루피의 커피 쿠폰";

    private static final long INVALID_ID = 0L;
    private static final String INVALID_NAME = "";

    @Test
    @DisplayName("티켓 생성")
    void 티켓_생성() {
        assertDoesNotThrow(() -> Ticket.builder()
                .userId(VALID_ID)
                .userName(VALID_USER_NAME)
                .couponNo(VALID_ID)
                .couponName(VALID_COUPON_NAME)
                .build());
    }

    @Test
    @DisplayName("티켓 생성 실패 유저 아이디")
    void 티켓_생성_실패_유저_아이디() {
        assertThrows(IllegalArgumentException.class, () -> Ticket.builder()
                .userId(INVALID_ID)
                .userName(VALID_USER_NAME)
                .couponNo(VALID_ID)
                .couponName(VALID_COUPON_NAME)
                .build());
    }

    @Test
    @DisplayName("티켓 생성 실패 유저 이름")
    void 티켓_생성_실패_유저_네임() {
        assertThrows(InvalidUserNameException.class, () -> Ticket.builder()
                .userId(VALID_ID)
                .userName(INVALID_NAME)
                .couponNo(VALID_ID)
                .couponName(VALID_COUPON_NAME)
                .build());
    }

    @Test
    @DisplayName("티켓 생성 실패 쿠폰 번호")
    void 티켓_생성_실패_쿠폰_넘버() {
        assertThrows(IllegalArgumentException.class, () -> Ticket.builder()
                .userId(VALID_ID)
                .userName(VALID_USER_NAME)
                .couponNo(INVALID_ID)
                .couponName(VALID_COUPON_NAME)
                .build());
    }

    @Test
    @DisplayName("티켓 생성 실패 쿠폰 이름")
    void 티켓_생성_실패_쿠폰_이름() {
        assertThrows(IllegalTicketInfoException.class, () -> Ticket.builder()
                .userId(VALID_ID)
                .userName(VALID_USER_NAME)
                .couponNo(VALID_ID)
                .couponName(INVALID_NAME)
                .build());
    }
}